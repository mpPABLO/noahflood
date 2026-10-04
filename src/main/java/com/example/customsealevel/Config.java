package com.example.customsealevel;

import net.neoforged.neoforge.common.ModConfigSpec;

public class Config {
    private static final ModConfigSpec.Builder BUILDER = new ModConfigSpec.Builder();

    public static final ModConfigSpec.BooleanValue ENABLED = BUILDER
            .comment("enable?")
            .translation("customsealevel.configuration.enabled")
            .define("enabled", true);

    public static final ModConfigSpec.IntValue SEA_LEVEL = BUILDER
            .translation("customsealevel.configuration.seaLevel")
            .defineInRange("seaLevel", 63, -64, 8192);

    static final ModConfigSpec SPEC = BUILDER.build();
}