package xyz.quosty.world.util;

import org.bukkit.ChatColor;

public class ChatUtil
{
    public static String colored(final String string) {
        return ChatColor.translateAlternateColorCodes('&', string);
    }
}
