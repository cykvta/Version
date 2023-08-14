package cykuta.etheriacore.modules.home;

import cykuta.etheriacore.modules.CoreModule;
import cykuta.etheriacore.modules.home.commands.DelHome;
import cykuta.etheriacore.modules.home.commands.Home;
import cykuta.etheriacore.modules.home.commands.SetHome;

public class HomeModule extends CoreModule {

    @Override
    public void registerCommands() {
        registerCommand(new Home(), "home", "core.home");
        registerCommand(new SetHome(), "sethome", "core.home");
        registerCommand(new DelHome(), "delhome", "core.home");
    }

    @Override
    public void registerEvents() {

    }

    @Override
    public void registerOthers() {

    }
}
