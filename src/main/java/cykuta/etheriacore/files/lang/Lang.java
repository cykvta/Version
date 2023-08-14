package cykuta.etheriacore.files.lang;

import cykuta.etheriacore.EtheriaCore;

public enum Lang {
    TELEPORT_SEND("teleport-send", LangType.SUCCESS),
    TELEPORT_REQUEST("teleport-request", LangType.SUCCESS),
    TELEPORT_ACTIONS("teleport-actions", LangType.SUCCESS),
    TELEPORT_ACCEPT("teleport-accept", LangType.SUCCESS),
    TELEPORT_ACCEPTED("teleport-accepted", LangType.SUCCESS),
    TELEPORT_REJECT("teleport-reject", LangType.SUCCESS),
    TELEPORT_REJECTED("teleport-rejected", LangType.SUCCESS),
    TELEPORT_EXPIRED("teleport-expired", LangType.SUCCESS),
    GAMEMODE("gamemode-change", LangType.SUCCESS),
    GAMEMODE_OTHER("gamemode-change-other", LangType.SUCCESS),
    TIME_SET("time-set", LangType.SUCCESS),
    WEATHER_SET("weather-set", LangType.SUCCESS),
    NEW_HOME("home-new", LangType.SUCCESS),
    REMOVE_HOME("home-removed", LangType.SUCCESS),
    TELEPORT_HOME("home-teleport", LangType.SUCCESS),
    PLAYER_ENTER_BED("player-enter-bed", LangType.SUCCESS),
    PLAYER_LEAVE_BED("player-leave-bed", LangType.SUCCESS),
    NIGHT_SKIPPED("night-skipped", LangType.SUCCESS),
    NO_PERMISSION("no-permission", LangType.ERROR),
    USAGE("usage", LangType.ERROR),
    NO_PLAYER("no-player", LangType.ERROR),
    AUTO_TARGET("auto-target", LangType.ERROR),
    TELEPORT_NO_REQUEST("no-request", LangType.ERROR),
    PLAYER_COMMAND("player-command", LangType.ERROR),
    WEATHER_WORLD("weather-world", LangType.ERROR),
    DATABASE("database", LangType.ERROR),
    DATABASE_DISABLED("database-disabled", LangType.ERROR),
    NO_HOMES("no-homes", LangType.ERROR),
    MAX_HOMES("max-homes", LangType.ERROR),
    HOME_LOCATION("home-location", LangType.ERROR),
    TIME_SKIP_IN_PROGRESS("time-skip-in-progress", LangType.ERROR),
    SUNNY("sunny", LangType.GLOSSARY),
    RAINY("rainy", LangType.GLOSSARY),
    THUNDER("thunder", LangType.GLOSSARY),
    CREATIVE("creative", LangType.GLOSSARY),
    SURVIVAL("survival", LangType.GLOSSARY),
    ADVENTURE("adventure", LangType.GLOSSARY),
    SPECTATOR("spectator", LangType.GLOSSARY),
    ;

    private final String value;
    public final LangType type;

    Lang(String path, LangType type) {
        this.value = EtheriaCore.getLangManager().getString( type.getPath() + path);
        this.type = type;
    }

    public String get() {
        String prefix = "";

        switch (type) {
            case SUCCESS:
                prefix = EtheriaCore.getLangManager().getString("main-prefix");
                break;
            case ERROR:
                prefix = EtheriaCore.getLangManager().getString("error-prefix");
                break;
        }

        return prefix + value;
    }
}
