package cykuta.etheriacore.files.lang;

import cykuta.etheriacore.EtheriaCore;

public enum LangError {
    USAGE("error-usage"),
    NO_PLAYER("error-no-player"),
    AUTO_TARGET("error-auto-target"),
    TELEPORT_NO_REQUEST("error-no-request"),
    PLAYER_COMMAND("error-player-command"),
    WEATHER_WORLD("error-weather-world"),
    DATABASE("error-database"),
    DATABASE_DISABLED("error-database-disabled"),
    NO_HOMES("error-no-homes"),
    MAX_HOMES("error-max-homes"),
    HOME_LOCATION("error-home-location"),
    TIME_SKIP_IN_PROGRESS("error-time-skip-in-progress"),
    ;

    public final String value;
    LangError(String path) {
        String prefix = EtheriaCore.getLangManager().getString("error-prefix");
        this.value = prefix + EtheriaCore.getLangManager().getString(path);
    }
}
