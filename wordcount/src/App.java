import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.File;
import java.util.Scanner;
import java.util.*;

public class App {

    public static Map<String, Integer> readMapFromFile(String fileName) {
        File file = new File(fileName + ".txt");
        try {
            Scanner scanner = new Scanner(file);
            Map<String, Integer> map = new HashMap<>();
            while (scanner.hasNextLine()){
                String str = scanner.nextLine();
                map.put(str, map.getOrDefault(str, 0) + 1);
            }
            scanner.close();
            return map;
        }catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void writeMapToFile(Map<String, Integer> map, String fileName) throws Exception{
        try{
            FileWriter fileWriter = new FileWriter(fileName);
            for (Map.Entry<String, Integer> entry : map.entrySet()){
                fileWriter.write(entry.getKey() + ": " + entry.getValue()+"\n"); 
            }
            fileWriter.close();
        }catch (IOException e) {
            System.out.println("IO problem!");
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws Exception {
        String fileName = args[0];
        Map<String, Integer> map = readMapFromFile(fileName);
        String outputFile = args[1];
        writeMapToFile(map, outputFile);
    }
}
