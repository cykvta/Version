package cykuta.etheriacore.config;

import cykuta.etheriacore.EtheriaCore;

public enum Config {
    TELEPORT_EXPIRE("teleport-expire"),
    JOIN_MSG("join-msg"),
    QUIT_MSG("quit-msg"),
    DATABASE_IP("database.ip"),
    DATABASE_PORT("database.port"),
    DATABASE_USER("database.user"),
    DATABASE_PASSWORD("database.password"),
    DATABASE_DATABASE("database.database"),
    USE_MYSQL("use-mysql");


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
}
