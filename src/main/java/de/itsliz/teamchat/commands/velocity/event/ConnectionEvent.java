package de.itsliz.teamchat.commands.velocity.event;

import com.velocitypowered.api.event.Subscribe;
import com.velocitypowered.api.event.connection.DisconnectEvent;
import com.velocitypowered.api.event.connection.LoginEvent;
import com.velocitypowered.api.proxy.Player;
import de.itsliz.teamchat.TeamChatAPI;
import de.itsliz.teamchat.bootstrap.VelocityBootstrap;
import de.itsliz.teamchat.file.MessageConfiguration;
import net.kyori.adventure.text.Component;

/**
 * @author kleinLisaa
 * @created 27.10.2021
 * <p>
 * Do not edit without permission.
 */
public class ConnectionEvent {


    private final MessageConfiguration messageConfiguration = TeamChatAPI.getInstance().getMessageConfiguration();
    private final String permission = TeamChatAPI.getInstance().getPermissionConfiguration().getTeamChatPermission();

    @Subscribe
    public void handle(LoginEvent event){
        Player player = event.getPlayer();

        if (player.hasPermission(permission)) {
            for(Player all : VelocityBootstrap.getInstance().getProxyServer().getAllPlayers()){
                all.sendMessage(Component.text(messageConfiguration.getLogInMessage().replace("%user%", player.getUsername())));
            }
        }
    }

    @Subscribe
    public void handle(DisconnectEvent event){
        Player player = event.getPlayer();

        if (player.hasPermission(permission)) {
            for(Player all : VelocityBootstrap.getInstance().getProxyServer().getAllPlayers()){
                all.sendMessage(Component.text(messageConfiguration.getLogOutMessage().replace("%user%", player.getUsername())));
            }
        }
    }
}
