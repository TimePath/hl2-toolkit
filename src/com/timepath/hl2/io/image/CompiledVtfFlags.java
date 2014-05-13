package com.timepath.hl2.io.image;

import com.timepath.EnumFlag;

/**
 * https://github.com/ValveSoftware/source-sdk-2013/blob/master/mp/src/public/vtf/vtf.h
 * https://developer.valvesoftware.com/wiki/Valve_Texture_Format#Image_flags
 */
public enum CompiledVtfFlags implements EnumFlag {
    // Flags from the *.txt config file
    TEXTUREFLAGS_POINTSAMPLE(0x00000001, "Point Sample"),
    TEXTUREFLAGS_TRILINEAR(0x00000002, "Trilinear"),
    TEXTUREFLAGS_CLAMPS(0x00000004, "Clamp S"),
    TEXTUREFLAGS_CLAMPT(0x00000008, "Clamp T"),
    TEXTUREFLAGS_ANISOTROPIC(0x00000010, "Anisotropic"),
    TEXTUREFLAGS_HINT_DXT5(0x00000020, "Hint DXT5"),
    TEXTUREFLAGS_PWL_CORRECTED(0x00000040, "SRGB"),
    TEXTUREFLAGS_NORMAL(0x00000080, "Normal Map"),
    TEXTUREFLAGS_NOMIP(0x00000100, "No Mipmap"),
    TEXTUREFLAGS_NOLOD(0x00000200, "No Level Of Detail"),
    TEXTUREFLAGS_ALL_MIPS(0x00000400, "No Minimum Mipmap"),
    TEXTUREFLAGS_PROCEDURAL(0x00000800, "Procedural"),
    /**
     * Automatically generated by vtex from the texture data.
     */
    TEXTUREFLAGS_ONEBITALPHA(0x00001000, "One Bit Alpha (Format Specified)"),
    /**
     * Automatically generated by vtex from the texture data.
     */
    TEXTUREFLAGS_EIGHTBITALPHA(0x00002000, "Eight Bit Alpha (Format Specified)"),
    TEXTUREFLAGS_ENVMAP(0x00004000, "Environment Map (Format Specified)"),
    TEXTUREFLAGS_RENDERTARGET(0x00008000, "Render Target"),
    TEXTUREFLAGS_DEPTHRENDERTARGET(0x00010000, "Depth Render Target"),
    TEXTUREFLAGS_NODEBUGOVERRIDE(0x00020000, "No Debug Override"),
    TEXTUREFLAGS_SINGLECOPY(0x00040000, "Single Copy"),
    TEXTUREFLAGS_PRE_SRGB(0x00080000),
    TEXTUREFLAGS_UNUSED_00100000(0x00100000),
    TEXTUREFLAGS_UNUSED_00200000(0x00200000),
    TEXTUREFLAGS_UNUSED_00400000(0x00400000),
    TEXTUREFLAGS_NODEPTHBUFFER(0x00800000, "No Depth Buffer"),
    TEXTUREFLAGS_UNUSED_01000000(0x01000000),
    TEXTUREFLAGS_CLAMPU(0x02000000, "Clamp U"),
    /**
     * Usable as a vertex texture
     */
    TEXTUREFLAGS_VERTEXTEXTURE(0x04000000, "Vertex Texture"),
    TEXTUREFLAGS_SSBUMP(0x08000000, "SSBump"),
    TEXTUREFLAGS_UNUSED_10000000(0x10000000),
    /**
     * Clamp to border color on all texture coordinates
     */
    TEXTUREFLAGS_BORDER(0x20000000, "Clamp All"),
    TEXTUREFLAGS_UNUSED_40000000(0x40000000),
    TEXTUREFLAGS_UNUSED_80000000(0x80000000);
    private final int    mask;
    private final String title;

    CompiledVtfFlags(int mask) {
        this(mask, "Unused");
    }

    CompiledVtfFlags(int mask, String name) {
        this.mask = mask;
        title = name;
    }

    public static CompiledVtfFlags getEnumForMask(int mask) {
        CompiledVtfFlags[] values = CompiledVtfFlags.values();
        for(CompiledVtfFlags eachValue : values) {
            if(eachValue.mask == mask) {
                return eachValue;
            }
        }
        return null;
    }

    int getMask() {
        return mask;
    }

    @Override
    public int getId() {
        return mask;
    }

    @Override
    public String toString() {
        return title;
    }
}
