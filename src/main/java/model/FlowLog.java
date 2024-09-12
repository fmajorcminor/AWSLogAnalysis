package src.main.java.model;

public class FlowLog {
    private static final int VERSION = 2;
    private String accountId;
    private String interfaceId;
    private String srcAddr;
    private String dstAddr;
    private String srcPort;
    private String dstPort;
    private String protocol;
    private String packets;
    private String bytes;
    private String start;
    private String end;
    private String action;
    private String logStatus;

    public FlowLog() {
    }

    public static int getVersion() {
        return VERSION;
    }

    public String getAccountId() {
        return accountId;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }

    public String getInterfaceId() {
        return interfaceId;
    }

    public void setInterfaceId(String interfaceId) {
        this.interfaceId = interfaceId;
    }

    public String getSrcAddr() {
        return srcAddr;
    }

    public void setSrcAddr(String srcAddr) {
        this.srcAddr = srcAddr;
    }

    public String getDstAddr() {
        return dstAddr;
    }

    public void setDstAddr(String dstAddr) {
        this.dstAddr = dstAddr;
    }

    public String getSrcPort() {
        return srcPort;
    }

    public void setSrcPort(String srcPort) {
        this.srcPort = srcPort;
    }

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

    public String getPackets() {
        return packets;
    }

    public void setPackets(String packets) {
        this.packets = packets;
    }

    public String getBytes() {
        return bytes;
    }

    public void setBytes(String bytes) {
        this.bytes = bytes;
    }

    public String getStart() {
        return start;
    }

    public void setStart(String start) {
        this.start = start;
    }

    public String getEnd() {
        return end;
    }

    public void setEnd(String end) {
        this.end = end;
    }

    public String getAtion() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public String getLogStatus() {
        return logStatus;
    }

    public void setLogStatus(String logStatus) {
        this.logStatus = logStatus;
    }

    @Override
    public String toString() {
        return "FlowLog [accountId=" + accountId + ", interfaceId=" + interfaceId + ", srcAddr=" + srcAddr
                + ", dstAddr=" + dstAddr + ", srcPort=" + srcPort + ", dstPort=" + dstPort + ", protocol=" + protocol
                + ", packets=" + packets + ", bytes=" + bytes + ", start=" + start + ", end=" + end + ", action="
                + action + ", logStatus=" + logStatus + "]";
    }

}