package cykuta.etheriacore.modules.chat;

import cykuta.etheriacore.modules.CoreModule;
import cykuta.etheriacore.modules.chat.events.ChatFormatter;
import cykuta.etheriacore.modules.chat.events.JoinAnnounce;

public class ChatModule extends CoreModule {
    @Override
    public void registerCommands() {

    }

    @Override
    public void registerEvents() {
        registerEvent(new ChatFormatter());
        registerEvent(new JoinAnnounce());
    }

    @Override
    public void registerOthers() {

    }
}
