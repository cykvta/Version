package cykuta.etheriacore.lang;

import cykuta.etheriacore.EtheriaCore;

public enum LangSuccess {
    TELEPORT_SEND("teleport-send"),
    TELEPORT_REQUEST("teleport-request"),
    TELEPORT_ACTIONS("teleport-actions"),
    TELEPORT_ACCEPT("teleport-accept"),
    TELEPORT_ACCEPTED("teleport-accepted"),
    TELEPORT_REJECT("teleport-reject"),
    TELEPORT_REJECTED("teleport-rejected"),
    TELEPORT_EXPIRED("teleport-expired"),
    GAMEMODE("gamemode-change"),
    GAMEMODE_OTHER("gamemode-change-other"),
    TIME_SET("time-set"),
    WEATHER_SET("weather-set"),
    NEW_HOME("home-new"),
    REMOVE_HOME("home-removed"),
    TELEPORT_HOME("home-teleport");

    public final String value;
    LangSuccess(String path) {
        String prefix = EtheriaCore.getLangManager().getString("main-prefix");
        this.value = prefix + EtheriaCore.getLangManager().getString(path);
    }
}
