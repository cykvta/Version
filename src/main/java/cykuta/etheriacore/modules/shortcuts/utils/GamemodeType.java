package cykuta.etheriacore.modules.shortcuts.utils;

import cykuta.etheriacore.files.lang.Lang;
import org.bukkit.GameMode;

public enum GamemodeType {
    CREATIVE(GameMode.CREATIVE, Lang.CREATIVE),
    SURVIVAL(GameMode.SURVIVAL, Lang.SURVIVAL),
    ADVENTURE(GameMode.ADVENTURE, Lang.ADVENTURE),
    SPECTATOR(GameMode.SPECTATOR, Lang.SPECTATOR);

    private final Lang lang;
    private final GameMode gameMode;

    GamemodeType(GameMode gameMode, Lang lang) {
        this.gameMode = gameMode;
        this.lang = lang;
    }

    public Lang getLang() {
        return lang;
    }

    public GameMode getGameMode() {
        return gameMode;
    }
}
