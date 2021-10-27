package de.itsliz.teamchat;

import de.itsliz.teamchat.file.MessageConfiguration;
import de.itsliz.teamchat.file.PermissionConfiguration;
import de.itsliz.teamchat.file.defaults.DefaultMessageConfiguration;
import de.itsliz.teamchat.file.defaults.DefaultPermissionConfiguration;
import de.liz.json.lib.JsonLib;

import java.io.File;

/**
 * @author kleinLisaa
 * @created 27.10.2021
 * <p>
 * Do not edit without permission.
 */
public class TeamChatAPI {

    private static TeamChatAPI instance;
    protected File messageFile = new File("plugins/TeamChat", "messages.json");
    protected File permsFile = new File("plugins/TeamChat", "permissions.json");
    private MessageConfiguration messageConfiguration;
    private PermissionConfiguration permissionConfiguration;

    public TeamChatAPI() {
        instance = this;
        loadConfigurations();
    }

    protected void loadConfigurations() {
        if (!messageFile.exists()) {
            MessageConfiguration messageConfiguration = DefaultMessageConfiguration.get();
            JsonLib.fromObject(messageConfiguration).saveAsFile(messageFile);
            this.messageConfiguration = messageConfiguration;
        }
        if (!permsFile.exists()) {
            PermissionConfiguration permissionConfiguration = DefaultPermissionConfiguration.get();
            JsonLib.fromObject(permissionConfiguration).saveAsFile(permsFile);
            this.permissionConfiguration = permissionConfiguration;
        }
        this.permissionConfiguration = JsonLib.fromJsonFile(permsFile).getObject(PermissionConfiguration.class);
        this.messageConfiguration = JsonLib.fromJsonFile(messageFile).getObject(MessageConfiguration.class);
    }

    public static TeamChatAPI getInstance() {
        return instance;
    }

    public PermissionConfiguration getPermissionConfiguration() {
        return permissionConfiguration;
    }

    public MessageConfiguration getMessageConfiguration() {
        return messageConfiguration;
    }
}
