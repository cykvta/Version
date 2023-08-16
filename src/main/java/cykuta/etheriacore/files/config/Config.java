package cykuta.etheriacore.files.config;

import cykuta.etheriacore.EtheriaCore;

import java.util.List;

public enum Config {
    TELEPORT_EXPIRE("teleport-expire"),
    JOIN_MSG("join-msg"),
    QUIT_MSG("quit-msg"),
    DATABASE_IP("database.ip"),
    DATABASE_PORT("database.port"),
    DATABASE_USER("database.user"),
    DATABASE_PASSWORD("database.password"),
    DATABASE_DATABASE("database.database"),
    USE_MYSQL("use-mysql"),
    PERCENTAGE_TO_SKIP_NIGHT("percentage-to-skip-night"),
    CHAT_FORMAT("chat-format"),
    MIN_PASSWORD_LENGTH("min-password-length"),
    MAX_PASSWORD_LENGTH("max-password-length"),
    ALLOWED_CHARS("allowed-characters"),
    ALLOWED_CMDS("allowed-commands"),
    PASS_SALT("password-salt"),
    AUTH_TIMEOUT("auth-timeout"),
    ;


    private final String path;

    Config(String path){
        this.path = path;
    }
    public String getString(){
        return EtheriaCore.getConfigManager().getString(path);
    }
    public int getInt(){
        return EtheriaCore.getConfigManager().getInt(path);
    }
    public boolean getBoolean(){
        return EtheriaCore.getConfigManager().getBoolean(path);
    }
    public List<String> getStringList(){
        return EtheriaCore.getConfigManager().getStringList(path);
    }
    public void set(Object value){
        EtheriaCore.getConfigManager().set(path, value);
    }

    public static void reload(){
        EtheriaCore.getConfigManager().reloadConfig();
    }
}
