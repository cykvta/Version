package cykuta.etheriacore.lang;

public enum LangError {
    USAGE("error-usage"),
    NO_PLAYER("error-no-player"),
    AUTO_TARGET("error-auto-target"),
    TELEPORT_NO_REQUEST("error-no-request"),
    PLAYER_COMMAND("error-player-command"),
    WEATHER_WORLD("error-weather-world");

    public final String value;
    LangError(String path) {
        String prefix = LangManager.getString("error-prefix");
        this.value = prefix + LangManager.getString(path);
    }
}
