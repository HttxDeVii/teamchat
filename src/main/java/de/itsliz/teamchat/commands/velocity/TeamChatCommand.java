package de.itsliz.teamchat.commands.velocity;

import com.velocitypowered.api.command.CommandSource;
import com.velocitypowered.api.command.SimpleCommand;
import com.velocitypowered.api.proxy.Player;
import de.itsliz.teamchat.TeamChatAPI;
import de.itsliz.teamchat.bootstrap.VelocityBootstrap;
import de.itsliz.teamchat.file.MessageConfiguration;
import net.kyori.adventure.text.Component;
import net.md_5.bungee.api.ProxyServer;
import net.md_5.bungee.api.connection.ProxiedPlayer;

/**
 * @author kleinLisaa
 * @created 27.10.2021
 * <p>
 * Do not edit without permission.
 */
public class TeamChatCommand implements SimpleCommand {

    private final MessageConfiguration messageConfiguration = TeamChatAPI.getInstance().getMessageConfiguration();
    private final String permission = TeamChatAPI.getInstance().getPermissionConfiguration().getTeamChatPermission();


    @Override
    public void execute(Invocation invocation) {
        CommandSource commandSource = invocation.source();
        String[] args = invocation.arguments();

        if (!(commandSource instanceof Player)) {
            commandSource.sendMessage(Component.text("§c§lDo not use this command in console."));
            return;
        }
        Player player = (Player) commandSource;
        if (!player.hasPermission(permission)) {
            player.sendMessage(Component.text(messageConfiguration.getNoPermissionMessage()));
            return;
        }

        if (args.length == 0) {
            for (Player all : VelocityBootstrap.getInstance().getProxyServer().getAllPlayers()) {
                if (all.hasPermission(permission)) {
                    player.sendMessage(Component.text(messageConfiguration.getMessageHeader()));
                    player.sendMessage(Component.text(messageConfiguration.getUserListMessage().replace("%user%", all.getUsername()).replace("%server%", all.getCurrentServer().get().getServer().getServerInfo().getName())));
                    player.sendMessage(Component.text(messageConfiguration.getMessageFooter()));
                }
            }
        } else {
            StringBuilder message = new StringBuilder();
            String finalMessage = "";

            for (String string : args) {
                message.append(string).append(" ");
                finalMessage = messageConfiguration.getChatMessage().replace("%user%", player.getUsername()).replace("%message%", message.toString());
            }
            for (Player all : VelocityBootstrap.getInstance().getProxyServer().getAllPlayers()) {
                if (all.hasPermission(permission)) {
                    all.sendMessage(Component.text(finalMessage));
                }
            }
        }
    }
}
