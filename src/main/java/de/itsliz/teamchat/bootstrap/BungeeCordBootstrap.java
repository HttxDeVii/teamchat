package de.itsliz.teamchat.bootstrap;

import de.itsliz.teamchat.TeamChatAPI;
import de.itsliz.teamchat.commands.bungee.TeamChatCommand;
import de.itsliz.teamchat.commands.bungee.event.ConnectionEvent;
import net.md_5.bungee.api.ProxyServer;
import net.md_5.bungee.api.plugin.Plugin;

/**
 * @author kleinLisaa
 * @created 27.10.2021
 * <p>
 * Do not edit without permission.
 */
public class BungeeCordBootstrap extends Plugin {

    private static BungeeCordBootstrap instance;

    @Override
    public void onEnable() {
        instance = this;
        new TeamChatAPI();
        ProxyServer.getInstance().getPluginManager().registerCommand(this, new TeamChatCommand("tc"));
        ProxyServer.getInstance().getPluginManager().registerCommand(this, new TeamChatCommand("teamchat"));

        ProxyServer.getInstance().getPluginManager().registerListener(this, new ConnectionEvent());
    }

    @Override
    public void onDisable() {

    }

    public static BungeeCordBootstrap getInstance() {
        return instance;
    }
}
