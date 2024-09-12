package src.main.java;

import java.util.List;
import java.util.Scanner;

import src.main.java.model.FlowLog;
import src.main.java.parser.FlowLogParser;
import src.main.java.parser.LookupTableParser;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter absolute path to file name");

        String fileName = scanner.nextLine();
        scanner.close();
        FlowLogParser flowLogParser = new FlowLogParser(fileName);
        LookupTableParser lookupTableParser = new LookupTableParser("src/main/resources/lookupTable.csv");
        List<FlowLog> flowLogs = flowLogParser.parseLog();
        lookupTableParser.parseLookupTable();
        // System.out.println(lookupTableParser.toString());
        // System.out.println(flowLogs);
    }
}
