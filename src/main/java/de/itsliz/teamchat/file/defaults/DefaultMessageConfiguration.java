package de.itsliz.teamchat.file.defaults;

import de.itsliz.teamchat.file.MessageConfiguration;

/**
 * @author kleinLisaa
 * @created 27.10.2021
 * <p>
 * Do not edit without permission.
 */
public class DefaultMessageConfiguration {

    public static MessageConfiguration get() {
        return new MessageConfiguration(
                "§8[§c§lTeamChat§8]",
                "%prefix% §c§lDazu hast du keine Rechte!",
                "%prefix% §b%user% §8» §b%message%",
                "§8§m┃------------------------------§r§8┃\n",
                "%prefix% §b%user% §8» §b%server%",
                "\n§8§m┃------------------------------§r§8┃",
                "%prefix% §b%user% §7hat sich §aeingeloggt§8.",
                "%prefix% §b%user% §7hat sich §causgeloggt§8.");
    }
}
