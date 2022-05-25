package cykuta.etheriacore.lang;

public enum LangSuccess {
    TELEPORT_SEND("teleport-send"),
    TELEPORT_REQUEST("teleport-request"),
    TELEPORT_ACTIONS("teleport-actions"),
    TELEPORT_ACCEPT("teleport-accept"),
    TELEPORT_ACCEPTED("teleport-accepted"),
    TELEPORT_REJECT("teleport-reject"),
    TELEPORT_REJECTED("teleport-rejected"),
    TELEPORT_EXPIRED("teleport-expired");

    public final String value;
    LangSuccess(String value) {
        String prefix = LangManager.getString("main-prefix");
        this.value = prefix + LangManager.getString(value);
    }
}
