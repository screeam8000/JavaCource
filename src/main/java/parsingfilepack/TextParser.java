package parsingfilepack;


import java.io.*;
import java.util.*;

public class TextParser {

    public static Collection<String> textparser(String filePath) /*throws FileNotFoundException, IOException*/ {
        Collection<String> stringCollection = new ArrayList<>();

        try {
            FileInputStream fstream = new FileInputStream(filePath);
            BufferedReader br = new BufferedReader(new InputStreamReader(fstream));
            String strLine;
            Map<String, String> map = new HashMap<String, String>();

            while ((strLine = br.readLine()) != null) {

                String[] temp = strLine.split(" ", 2);
                map.put(temp[0], temp[1]);
            }
            for (Map.Entry<String, String> currentNode : map.entrySet()) {
                stringCollection.add(currentNode.getValue());


                System.out.println(currentNode.getKey() + " " + currentNode.getValue());
            }
            System.out.println();
        } catch (IOException e) {
            System.out.println("Ошибка");
        }

        return stringCollection;
    }

}
