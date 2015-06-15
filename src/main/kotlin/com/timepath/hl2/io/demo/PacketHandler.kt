package com.timepath.hl2.io.demo

import com.timepath.io.BitBuffer

interface PacketHandler {

    public fun read(bb: BitBuffer, l: MutableList<Pair<Any, Any>>, demo: HL2DEM, lengthBits: Int = -1): Boolean = false
}
