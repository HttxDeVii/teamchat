package de.itsliz.teamchat.file;

/**
 * @author kleinLisaa
 * @created 27.10.2021
 * <p>
 * Do not edit without permission.
 */
public class PermissionConfiguration {

    private final String teamChatPermission;

    public PermissionConfiguration(String teamChatPermission) {
        this.teamChatPermission = teamChatPermission;
    }

    public String getTeamChatPermission() {
        return teamChatPermission;
    }
}
