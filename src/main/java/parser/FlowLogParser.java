package src.main.java.parser;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

import src.main.java.model.FlowLog;

public class FlowLogParser {
    String fileName;

    public FlowLogParser(String fileName) {
        this.fileName = fileName;
    }

    public List<FlowLog> parseLog() {
        List<FlowLog> flowLogs = new ArrayList<FlowLog>();
        try (BufferedReader br = new BufferedReader(new FileReader(this.fileName))) {
            String line;

            while ((line = br.readLine()) != null) {
                String[] parts = line.split(" ");
                FlowLog flowLog = new FlowLog();
                flowLog.setAccountId(parts[1].trim());
                flowLog.setInterfaceId(parts[2].trim());
                flowLog.setSrcAddr(parts[3].trim());
                flowLog.setDstAddr(parts[4].trim());
                flowLog.setSrcPort(parts[5].trim());
                flowLog.setDstPort(parts[6].trim());
                flowLog.setProtocol(parts[7].trim());
                flowLog.setPackets(parts[8].trim());
                flowLog.setBytes(parts[9].trim());
                flowLog.setStart(parts[10].trim());
                flowLog.setEnd(parts[11].trim());
                flowLog.setAction(parts[12].trim());
                flowLog.setLogStatus(parts[13].trim());

                flowLogs.add(flowLog);
                // sb.append(line);
                // sb.append(System.lineSeparator());
            }
            return flowLogs;
        } catch (Exception e) {
            System.out.println(String.format("Error reading file due to %s", e));
            return null;
        }
    }

}
