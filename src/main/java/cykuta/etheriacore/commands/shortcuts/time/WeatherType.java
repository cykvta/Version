package cykuta.etheriacore.commands.shortcuts.time;

import cykuta.etheriacore.files.lang.Lang;

public enum WeatherType {
    SUN(Lang.SUNNY),
    RAIN(Lang.RAINY),
    THUNDER(Lang.THUNDER);

    private final Lang lang;
    WeatherType(Lang lang){
        this.lang = lang;
    }
    public Lang getLang(){
        return lang;
    }
}
