package src.main.java.parser;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.HashMap;
import java.util.Map;

public class ProtocolNumbersParser extends FileParser {

    public ProtocolNumbersParser(String fileName) {
        super(fileName);
    }

    @Override
    public Map<Integer, String> parse() throws Exception {
        Map<Integer, String> protocolMap = new HashMap<Integer, String>();
        try (BufferedReader br = new BufferedReader(new FileReader(this.fileName))) {
            String line;

            while ((line = br.readLine()) != null) {
                String[] parts = line.split(",");
                Integer protocolNumber = Integer.parseInt(parts[0].strip());
                String protocol = parts[1].strip().toLowerCase();
                protocolMap.put(protocolNumber, protocol);
            }
        } catch (Exception e) {
            System.out.println(String.format("Error reading file due to %s", e));
            throw new Exception(e);
        }
        return protocolMap;
    }

}
