package src.main.java.generator;

import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import src.main.java.model.FlowLog;

public class TagCountGenerator {

    private final List<FlowLog> flowLogs;
    private final Map<Map<String, String>, String> lookupFields;
    private final Map<Integer, String> protocolMapping;
    private Map<String, Integer> tagCounts = new HashMap<String, Integer>();
    private Map<String, Integer> portCounts = new HashMap<String, Integer>();
    private Map<String, String> portToProtocol = new HashMap<String, String>();

    public TagCountGenerator(List<FlowLog> flowLogs, Map<Map<String, String>, String> lookupFields,
            Map<Integer, String> protocolmapping) {
        this.flowLogs = flowLogs;
        this.lookupFields = lookupFields;
        this.protocolMapping = protocolmapping;
    }

    public void generate() {
        this.tagCounts = this.computeCounts();
        this.generateFullFile();
    }

    private Map<String, Integer> computeCounts() {

        this.flowLogs.forEach(log -> {
            String dstPort = log.getDstPort();
            Integer protocolNumber = !log.getProtocol().equals("-") ? Integer.parseInt(log.getProtocol()) : -1;
            String protocol = protocolMapping.getOrDefault(protocolNumber, "unassigned").toLowerCase();
            String tag = lookupFields.getOrDefault(Map.of(dstPort, protocol), "Untagged");
            tagCounts.merge(tag, 1, Integer::sum);
            if (!dstPort.equals("-")) {
                portCounts.merge(dstPort, 1, Integer::sum);
                portToProtocol.put(dstPort, protocol);
            }
        });

        return tagCounts;
    }

    private void generateFullFile() {
        String tagCountsPortion = this.generateTagCounts();
        String portComboPortion = this.generatePortProtocolComboCounts();

        try (FileWriter fileWriter = new FileWriter("src/main/resources/outputFile.txt")) {
            fileWriter.write(tagCountsPortion);
            fileWriter.write(portComboPortion);
        } catch (IOException e) {
            System.out.println(String.format("Error writing to file due to %s", e));
        }
    }

    private String generateTagCounts() {
        String textFile = "Tag Counts:" + "\n\n" + "Tag,Count" + "\n";

        for (var entry : this.tagCounts.entrySet()) {
            textFile = textFile + entry.getKey() + "," + entry.getValue() + "\n";
        }
        textFile += "\n\n";
        return textFile;
    }

    private String generatePortProtocolComboCounts() {
        String textFile = "Port/Protocol Combinationt Counts:" + "\n\n" + "Port,Protocol,Count" + "\n";

        for (var entry : this.portCounts.entrySet()) {
            String protocol = this.portToProtocol.get(entry.getKey());
            textFile = textFile + entry.getKey() + "," + protocol + "," + entry.getValue() + "\n";
        }
        return textFile;
    }

}
