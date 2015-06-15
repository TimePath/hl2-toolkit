package com.timepath.hl2.io.bsp.lump

import com.timepath.hl2.io.bsp.Lump
import com.timepath.hl2.io.bsp.LumpHandler
import com.timepath.io.OrderedInputStream

import java.io.IOException
import java.util.logging.Logger

/**
 * @author TimePath
 */
class EntitiesHandler : LumpHandler<String> {

    throws(IOException::class)
    override fun handle(l: Lump, `in`: OrderedInputStream): String {
        return `in`.readString()
    }

    companion object {

        private val LOG = Logger.getLogger(javaClass<EntitiesHandler>().getName())
    }
}
