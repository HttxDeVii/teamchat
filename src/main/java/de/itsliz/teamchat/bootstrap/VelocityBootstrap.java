package de.itsliz.teamchat.bootstrap;

import com.google.inject.Inject;
import com.velocitypowered.api.event.Subscribe;
import com.velocitypowered.api.event.proxy.ProxyInitializeEvent;
import com.velocitypowered.api.plugin.Plugin;
import com.velocitypowered.api.proxy.ProxyServer;
import de.itsliz.teamchat.TeamChatAPI;
import de.itsliz.teamchat.commands.velocity.TeamChatCommand;
import de.itsliz.teamchat.commands.velocity.event.ConnectionEvent;

/**
 * @author kleinLisaa
 * @created 27.10.2021
 * <p>
 * Do not edit without permission.
 */
@Plugin(id = "teamchat", name = "teamchat", version = "1.0-SNAPSHOT", authors = "Liz")

public class VelocityBootstrap {

    private static VelocityBootstrap instance;
    private final ProxyServer proxyServer;

    @Inject

    public VelocityBootstrap(ProxyServer proxyServer) {
        instance = this;
        this.proxyServer = proxyServer;
        new TeamChatAPI();
    }

    @Subscribe
    public void handle(ProxyInitializeEvent event) {
        proxyServer.getCommandManager().register(proxyServer.getCommandManager().metaBuilder("tc").aliases("teamchat").build(), new TeamChatCommand());
        proxyServer.getEventManager().register(this, new ConnectionEvent());
    }

    public static VelocityBootstrap getInstance() {
        return instance;
    }

    public ProxyServer getProxyServer() {
        return proxyServer;
    }
}
