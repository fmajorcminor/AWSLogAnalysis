package src.main.java;

import java.util.List;
import java.util.Map;

import src.main.java.generator.TagCountGenerator;
import src.main.java.model.FlowLog;
import src.main.java.parser.FlowLogParser;
import src.main.java.parser.LookupTableParser;
import src.main.java.parser.ProtocolNumbersParser;

public class Main {

    public static final String PROTOCOL_NUMBERS_FILE = "src/main/resources/protocol-numbers.csv";

    public static void main(String[] args) throws Exception {
        FlowLogParser flowLogParser = new FlowLogParser("src/main/resources/testFlowLogs.txt");
        LookupTableParser lookupTableParser = new LookupTableParser("src/main/resources/lookupTable.csv");
        ProtocolNumbersParser protocolNumbersParser = new ProtocolNumbersParser(PROTOCOL_NUMBERS_FILE);

        List<FlowLog> flowLogs = flowLogParser.parse();
        Map<Map<String, String>, String> lookupFields = lookupTableParser.parse();
        Map<Integer, String> protocolMapping = protocolNumbersParser.parse();

        TagCountGenerator generator = new TagCountGenerator(flowLogs, lookupFields, protocolMapping);

        generator.generate();
    }
}
