package traceToKml;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by xsoroka on 4/20/2016.
 * Class for translating file with traces into array of Traces as objects
 */
public class ReadTraceFileHelper {

    public static List<Trace> readFileWithPointsToList (String traceFile)
    {
        List<Trace> listOfPointsVisited = new ArrayList<Trace>();
        List<String> pointsFromFile = readFileAsLines(traceFile);
        for (String point : pointsFromFile)
            listOfPointsVisited.add(new Trace (point));
        return listOfPointsVisited;
    }

    private static List<String> readFileAsLines(String filename) {
        FileReader fileReader;
        List<String> lines = new ArrayList<String>();
        try {
            fileReader = new FileReader(filename);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line = null;
            while ((line = bufferedReader.readLine()) != null) {
                lines.add(line);
            }
            bufferedReader.close();
        } catch (IOException e) {
            System.out.println("Trace file is not found or can't be read!");
            e.printStackTrace();
        }
        return lines;
    }

}
