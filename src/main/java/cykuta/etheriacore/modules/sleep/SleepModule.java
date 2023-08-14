package cykuta.etheriacore.modules.sleep;

import cykuta.etheriacore.modules.CoreModule;
import cykuta.etheriacore.modules.sleep.events.PlayerSleep;

public class SleepModule extends CoreModule {

    @Override
    public void registerCommands() {

    }

    @Override
    public void registerEvents() {
        registerEvent(new PlayerSleep());
    }

    @Override
    public void registerOthers() {

    }
}
