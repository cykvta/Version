package cykuta.etheriacore.modules.tpa;

import cykuta.etheriacore.modules.CoreModule;
import cykuta.etheriacore.modules.tpa.commands.Tpa;
import cykuta.etheriacore.modules.tpa.commands.Tpaccept;
import cykuta.etheriacore.modules.tpa.commands.Tpdeny;

public class TpaModule extends CoreModule {
    @Override
    public void registerCommands() {
        registerCommand(new Tpa(), "tpa", "core.tpa");
        registerCommand(new Tpaccept(), "tpaccept", "core.tpa");
        registerCommand(new Tpdeny(), "tpdeny", "core.tpa");
    }

    @Override
    public void registerEvents() {

    }

    @Override
    public void registerOthers() {

    }
}
