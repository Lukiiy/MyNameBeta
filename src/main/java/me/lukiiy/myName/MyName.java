package me.lukiiy.myName;

import net.fabricmc.api.ClientModInitializer;
import net.minecraft.client.Minecraft;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MyName implements ClientModInitializer {
    public static final Logger LOGGER = LoggerFactory.getLogger("myname");
    public static Minecraft mc;

    @Override
    public void onInitializeClient() {}
}
