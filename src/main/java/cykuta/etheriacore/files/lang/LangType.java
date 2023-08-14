package cykuta.etheriacore.files.lang;

public enum LangType {
    SUCCESS("success"),
    ERROR("error"),
    GLOSSARY("glossary"),
    ;
    private final String path;

    LangType(String path) {
        this.path = path;
    }

    public String getPath() {
        return path + ".";
    }
}
