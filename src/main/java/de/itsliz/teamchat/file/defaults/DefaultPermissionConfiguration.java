package de.itsliz.teamchat.file.defaults;

import de.itsliz.teamchat.file.PermissionConfiguration;

/**
 * @author kleinLisaa
 * @created 27.10.2021
 * <p>
 * Do not edit without permission.
 */
public class DefaultPermissionConfiguration {

    public static PermissionConfiguration get() {
        return new PermissionConfiguration(
                "teamchat.use"
        );
    }
}
