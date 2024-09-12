package src.main.java.model;

public class LookupRow {
    private String dstPort;
    private String protocol;
    private String tag;

    public String getDstPort() {
        return dstPort;
    }

    public void setDstPort(String dstPort) {
        this.dstPort = dstPort;
    }

    public String getProtocol() {
        return protocol;
    }

    public void setProtocol(String protocol) {
        this.protocol = protocol;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }
}
