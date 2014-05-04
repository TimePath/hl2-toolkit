package com.timepath.hl2.io.demo;

import com.timepath.Pair;
import com.timepath.io.BitBuffer;
import java.util.List;

/**
 *
 * @author TimePath
 */
public abstract class PacketHandler {

    boolean read(BitBuffer bb, List<Pair<Object, Object>> l, HL2DEM demo) {
        return false;
    }

}
