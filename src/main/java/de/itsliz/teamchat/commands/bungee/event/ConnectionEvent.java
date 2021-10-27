package de.itsliz.teamchat.commands.bungee.event;

import de.itsliz.teamchat.TeamChatAPI;
import de.itsliz.teamchat.file.MessageConfiguration;
import net.md_5.bungee.api.ProxyServer;
import net.md_5.bungee.api.connection.ProxiedPlayer;
import net.md_5.bungee.api.event.ServerConnectEvent;
import net.md_5.bungee.api.event.ServerDisconnectEvent;
import net.md_5.bungee.api.plugin.Listener;
import net.md_5.bungee.api.plugin.Plugin;
import net.md_5.bungee.event.EventHandler;

/**
 * @author kleinLisaa
 * @created 27.10.2021
 * <p>
 * Do not edit without permission.
 */
public class ConnectionEvent implements Listener {

    private final MessageConfiguration messageConfiguration = TeamChatAPI.getInstance().getMessageConfiguration();
    private final String permission = TeamChatAPI.getInstance().getPermissionConfiguration().getTeamChatPermission();

    @EventHandler
    public void handle(ServerConnectEvent event){
        ProxiedPlayer player = event.getPlayer();

        if(player.hasPermission(permission)){
            for(ProxiedPlayer all : ProxyServer.getInstance().getPlayers()){
                all.sendMessage(messageConfiguration.getLogInMessage().replace("%user%", player.getName()));
            }
        }
    }

    @EventHandler
    public void handle(ServerDisconnectEvent event){
        ProxiedPlayer player = event.getPlayer();

        if(player.hasPermission(permission)){
            for(ProxiedPlayer all : ProxyServer.getInstance().getPlayers()){
                all.sendMessage(messageConfiguration.getLogOutMessage().replace("%user%", player.getName()));
            }
        }
    }
}
