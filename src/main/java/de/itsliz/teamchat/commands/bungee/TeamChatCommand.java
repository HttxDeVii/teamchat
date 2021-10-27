package de.itsliz.teamchat.commands.bungee;

import de.itsliz.teamchat.TeamChatAPI;
import de.itsliz.teamchat.file.MessageConfiguration;
import net.md_5.bungee.api.CommandSender;
import net.md_5.bungee.api.ProxyServer;
import net.md_5.bungee.api.connection.ProxiedPlayer;
import net.md_5.bungee.api.plugin.Command;

/**
 * @author kleinLisaa
 * @created 27.10.2021
 * <p>
 * Do not edit without permission.
 */
public class TeamChatCommand extends Command {

    private final MessageConfiguration messageConfiguration = TeamChatAPI.getInstance().getMessageConfiguration();
    private final String permission = TeamChatAPI.getInstance().getPermissionConfiguration().getTeamChatPermission();

    public TeamChatCommand(String name) {
        super(name);
    }

    @Override
    public void execute(CommandSender commandSender, String[] strings) {
        if(!(commandSender instanceof ProxiedPlayer)){
            commandSender.sendMessage("§c§lDo not use this command in console.");
            return;
        }
        ProxiedPlayer player = (ProxiedPlayer) commandSender;
        if(!player.hasPermission(permission)){
            player.sendMessage(messageConfiguration.getNoPermissionMessage());
            return;
        }

        if (strings.length == 0) {
            for (ProxiedPlayer all : ProxyServer.getInstance().getPlayers()) {
                if (all.hasPermission(permission)) {
                    player.sendMessage(messageConfiguration.getMessageHeader());
                    player.sendMessage(messageConfiguration.getUserListMessage().replace("%user%", all.getName()).replace("%server%", all.getServer().getInfo().getName()));
                    player.sendMessage(messageConfiguration.getMessageFooter());
                }
            }
        } else {
            StringBuilder message = new StringBuilder();
            String finalMessage = "";

            for (String string : strings) {
                message.append(string).append(" ");
                finalMessage = messageConfiguration.getChatMessage().replace("%user%", player.getName()).replace("%message%", message.toString());
            }
            for (ProxiedPlayer all : ProxyServer.getInstance().getPlayers()) {
                if (all.hasPermission(permission)) {
                    all.sendMessage(finalMessage);
                }
            }
        }

    }
}
