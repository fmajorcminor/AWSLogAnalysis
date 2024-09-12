## **Overview**

This program reads 3 files form the src/main/resources folder and uses them to generate the final file requested: A file of tags and their counts as well as the ports, their protocols, and their counts detected in the log files provided.

If a user wishes to get a generated report from a new set of logs or lookup table, they should modify the files with the same naming convention that currently exists in the resources directory.

I've included the output file under src/main/resources and that's where the file will be generated each time the code is run.

## **How to Compile and Run**

The jar has been uploaded to the GitHub repository, so in the same directory as the jar, execute the following code in a bash terminal:

-   `java -jar LogAnalysis.jar`

If you would like to make changes to the code and then compile and run again, navigate to the base directory of the code and do the following:

-   `javac -d out/ -sourcepath src/main/java/ $(find src/main/java -name "*.java")`
-   `jar cfe LogAnalysis.jar src.main.java.Main -C out/ .`
-   `java -jar LogAnalysis.jar`

## **Assumptions Made**

-   Only ipv4 addresses were contained in the logs
-   The tags were arbitrary and case insensitive, meaning sv_p1 and SV_P1 were equivalent for example
-   No malformed logs are contained in the log file
-   The logs are always contained in a space-delimited .txt file
-   The lookup table is always a properly-formed .csv file
-   The final generated file is a txt file
-   The program only supports default version 2 log format

## **Testing**

The main testing that was done was in the files in the resources directory. I added a few more example logs and lookup table values in order to simulate a few more scenarios.Given the time constraint, no junit tests were written. Local integration testing was done.

With more time a proper testing suite would be set up.
