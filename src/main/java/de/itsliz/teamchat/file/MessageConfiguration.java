package de.itsliz.teamchat.file;

/**
 * @author kleinLisaa
 * @created 27.10.2021
 * <p>
 * Do not edit without permission.
 */
public class MessageConfiguration {

    private final String prefix;
    private final String noPermissionMessage;
    private final String chatMessage;
    private final String messageHeader;
    private final String userListMessage;
    private final String messageFooter;
    private final String logInMessage;
    private final String logOutMessage;

    public MessageConfiguration(String prefix, String noPermissionMessage, String chatMessage, String messageHeader, String userListMessage, String messageFooter, String logInMessage, String logOutMessage) {
        this.prefix = prefix;
        this.noPermissionMessage = noPermissionMessage;
        this.chatMessage = chatMessage;
        this.messageHeader = messageHeader;
        this.userListMessage = userListMessage;
        this.messageFooter = messageFooter;
        this.logInMessage = logInMessage;
        this.logOutMessage = logOutMessage;
    }

    public String getPrefix() {
        return prefix;
    }

    public String getNoPermissionMessage() {
        return noPermissionMessage.replace("%prefix%", prefix);
    }

    public String getChatMessage() {
        return chatMessage.replace("%prefix%", prefix);
    }

    public String getMessageHeader() {
        return messageHeader.replace("%prefix%", prefix);
    }

    public String getUserListMessage() {
        return userListMessage.replace("%prefix%", prefix);
    }

    public String getMessageFooter() {
        return messageFooter.replace("%prefix%", prefix);
    }

    public String getLogInMessage() {
        return logInMessage.replace("%prefix%", prefix);
    }

    public String getLogOutMessage() {
        return logOutMessage.replace("%prefix%", prefix);
    }
}
