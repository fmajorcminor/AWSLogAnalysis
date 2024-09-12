package src.main.java.parser;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.HashMap;
import java.util.Map;

import src.main.java.model.LookupRow;

public class LookupTableParser {
    String fileName;
    Map<Map<String, String>, String> lookupFields = new HashMap<Map<String, String>, String>();

    public LookupTableParser(String fileName) {
        this.fileName = fileName;
    }

    public Map<Map<String, String>, String> getLookupFields() {
        return this.lookupFields;
    }

    public void parseLookupTable() {
        try (BufferedReader br = new BufferedReader(new FileReader(this.fileName))) {
            String line;

            while ((line = br.readLine()) != null) {
                String[] parts = line.split(",");

                LookupRow lookupRow = new LookupRow();
                lookupRow.setDstPort(parts[0].strip());
                lookupRow.setProtocol(parts[1].strip());
                lookupRow.setTag(parts[2].strip());

                lookupFields.put(Map.of(lookupRow.getDstPort(), lookupRow.getProtocol()), lookupRow.getTag());
            }
        } catch (Exception e) {
            System.out.println(String.format("Error reading file due to %s", e));
        }
    }

    @Override
    public String toString() {
        return "LookupTableParser [lookupFields=" + lookupFields + "]";
    }

}
