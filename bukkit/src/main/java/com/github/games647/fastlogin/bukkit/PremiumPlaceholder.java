package com.github.games647.fastlogin.bukkit;

import me.clip.placeholderapi.expansion.PlaceholderExpansion;

import org.bukkit.OfflinePlayer;

public class PremiumPlaceholder extends PlaceholderExpansion {

    private static final String PLACEHOLDER_VARIABLE = "status";

    private final FastLoginBukkit plugin;

    public PremiumPlaceholder(FastLoginBukkit plugin) {
        this.plugin = plugin;
    }

    @Override
    public String onRequest(OfflinePlayer player, String identifier) {
        // player is null if offline
        if (player != null && PLACEHOLDER_VARIABLE.equals(identifier)) {
            return plugin.getStatus(player.getUniqueId()).getReadableName();
        }

        return null;
    }

    @Override
    public String getIdentifier() {
        return plugin.getName();
    }

    @Override
    public String getRequiredPlugin() {
        return plugin.getName();
    }

    @Override
    public String getAuthor() {
        return String.join(", ", plugin.getDescription().getAuthors());
    }

    @Override
    public String getVersion() {
        return plugin.getDescription().getVersion();
    }
}
