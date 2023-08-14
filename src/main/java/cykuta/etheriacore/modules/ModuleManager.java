package cykuta.etheriacore.modules;

import java.util.ArrayList;

public class ModuleManager {
    private final ArrayList<CoreModule> modules = new ArrayList<>();

    public ArrayList<CoreModule> getList() {
        return modules;
    }

    public void registerModule(CoreModule module) {
        modules.add(module);
    }

    public void removeModule(CoreModule module) {
        modules.remove(module);
    }

    public void loadModules() {
        for (CoreModule module : modules) {
            if (!module.isEnabled()) continue;

            module.registerCommands();
            module.registerEvents();
            module.registerOthers();
        }
    }
}
