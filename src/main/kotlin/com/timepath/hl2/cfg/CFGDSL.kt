package com.timepath.hl2.cfg

private object NameGen {
    private val m = linkedMapOf<String, Int>()
    fun get(prefix: String) = prefix + m.let {
        val r = it.getOrPut(prefix, { 0 })
        it[prefix] = it[prefix]!! + 1
        r
    }
}

class Payload(val id: String, val depends: List<Payload> = emptyList()) {
    private fun toString(indent: String, depth: String = "", sb: StringBuilder = StringBuilder()): StringBuilder {
        val doIndent = id.length() != 0
        if (id.length() != 0) {
            sb.append(depth + id + "\n")
        }
        if (depends.isNotEmpty()) {
            depends.forEach { it.toString(indent, depth + if (doIndent) indent else "", sb) }
        }
        return sb
    }

    override fun toString() = toString("\t").toString()
}

class Latch {
    private val id = "${NameGen["_h"]}"
    val states = hashSetOf<Any>()
    fun name(any: Any, suffix: String = "") = "${id}[${any}]${suffix}"
}

fun CFGContext.latch() = Latch()

abstract class CFGContext(val children: MutableList<CFGContext> = arrayListOf()) {
    abstract fun payload(): Payload
    fun Latch.invoke(any: Any) {
        states.add(any)
        children.add(object : Alias(name(any, suffix = "!!")) {
            override fun payload(): Payload {
                for (k in states) {
                    val match = k == any
                    val s = name(k)
                    alias("${s}?") { if (match) eval("${s}") }
                }
                return Payload(id, listOf(super.payload()))
            }
        })
    }

    fun Latch.invoke(any: Any, configure: CFGContext.() -> Unit): Unit {
        val s = name(any)
        alias(s, configure)
        eval("${s}?")
    }
}

class CFGDSL(configure: CFGDSL.() -> Unit) : CFGContext() {
    override fun payload() = Payload("", children.map { it.payload() })
    override fun toString() = payload().toString()

    init {
        configure()
    }
}

class Command(val id: String, vararg val args: String) : CFGContext() {
    override fun payload() = Payload(when {
        args.isEmpty() -> id
        else -> "${id} ${args.joinToString(" ")}"
    })
}

fun CFGContext.eval(cmd: String, vararg args: String) = children.add(Command(cmd, *args))

fun CFGContext.echo(text: String) = eval("echo", text)

open class Alias(val id: String, children: MutableList<CFGContext> = arrayListOf()) : CFGContext(children) {
    override fun payload(): Payload = when {
        children.isEmpty() -> Payload("alias ${id}")
        children.size() == 1 -> children.single().let {
            val p = it.payload()
            // Hack
            Payload("alias ${id} ${p.toString().split("\n").first()}", p.depends)
        }
        else -> children.map { Alias(NameGen["_t"], arrayListOf(it)) }.let {
            Payload("alias ${id} \"${it.map { it.id }.join("; ")}\"", it.map { it.payload() })
        }
    }
}

fun CFGContext.alias(name: String = NameGen["_a"], configure: Alias.() -> Unit) = Alias(name).let {
    it.configure()
    children.add(it)
    it
}

fun CFGContext.eval(alias: Alias) = children.add(Command(alias.id))

data class Bind(val id: String)

fun CFGContext.bind(key: String, press: Alias.(Bind) -> Unit) = bind(key, press, {})
fun CFGContext.bind(key: String, press: Alias.(Bind) -> Unit, release: Alias.(Bind) -> Unit) = NameGen["_b"].let {
    val bind = Bind(key)
    eval("bind", key, "+$it")
    alias("+$it", { press(bind) })
    alias("-$it", { release(bind) })
    bind
}

data class CyclicList(val exec: String, val next: String, val prev: String)

fun CFGContext.cyclicList(name: String, size: Int, begin: Int = 0, configure: Alias.(Int) -> Unit): CyclicList {
    val exec = "*${name}"
    val next = "${name}++"
    val prev = "${name}--"
    val list = CyclicList(exec, next, prev)
    fun idx(i: Int) = (size + i) % size
    fun action(i: Int) = "${name}[${idx(i)}]"
    fun iter(i: Int) = "${name}.i[${idx(i)}]"
    // Loop twice for nicer output
    for (i in size.indices) {
        alias(action(i)) { configure(i) }
    }
    for (i in size.indices) {
        alias(iter(i)) {
            alias(exec) { eval(action(i)) }
            alias(next) { eval(iter(i + 1)) }
            alias(prev) { eval(iter(i - 1)) }
        }
    }
    eval(iter(begin)) // Initialize
    return list
}
