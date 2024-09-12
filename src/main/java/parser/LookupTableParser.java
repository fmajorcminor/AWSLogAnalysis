package src.main.java.parser;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.HashMap;
import java.util.Map;

import src.main.java.model.LookupRow;

public class LookupTableParser extends FileParser {

    public LookupTableParser(String fileName) {
        super(fileName);
    }

    @Override
    public Map<Map<String, String>, String> parse() throws Exception {
        Map<Map<String, String>, String> lookupFields = new HashMap<Map<String, String>, String>();
        try (BufferedReader br = new BufferedReader(new FileReader(this.fileName))) {
            String line;

            while ((line = br.readLine()) != null) {
                String[] parts = line.split(",");

                LookupRow lookupRow = new LookupRow();
                lookupRow.setDstPort(parts[0].strip());
                lookupRow.setProtocol(parts[1].strip().toLowerCase());
                lookupRow.setTag(parts[2].strip().toLowerCase());

                lookupFields.put(Map.of(lookupRow.getDstPort(), lookupRow.getProtocol()), lookupRow.getTag());
            }
        } catch (Exception e) {
            throw new Exception(e);
        }
        return lookupFields;
    }

}
