package src.main.java.parser;

public abstract class FileParser {
    protected String fileName;

    public FileParser(String fileName) {
        this.fileName = fileName;
    }

    public abstract Object parse() throws Exception;
}
