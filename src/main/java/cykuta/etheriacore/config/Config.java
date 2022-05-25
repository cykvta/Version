package cykuta.etheriacore.config;

public enum Config {
    TELEPORT_EXPIRE("teleport-expire"),
    JOIN_MSG("join-msg"),
    QUIT_MSG("quit-msg");

    private final String path;

    Config(String path){
        this.path = path;
    }
    public String getString(){
        return ConfigManager.getString(path);
    }
    public int getInt(){
        return ConfigManager.getInt(path);
    }
}
