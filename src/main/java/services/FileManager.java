package services;

import java.io.*;
import java.util.ArrayList;
import java.util.Random;

public class FileManager {
    static String filePath = "D:\\TMP\\files";
    static String fileName;
    static String randomString() {
        int leftLimit = 97; // letter 'a'
        int rightLimit = 122; // letter 'z'
        int targetStringLength = 5;
        Random random = new Random();
        return random.ints(leftLimit, rightLimit + 1)
                .limit(targetStringLength)
                .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                .toString();
    }
    public static ArrayList<File> createAndWrite(int quantity) throws IOException {
        ArrayList<File> tmp=new ArrayList<>();
        for(int i=1; i<=quantity; i++){
            fileName = randomString()+".txt";
            File file = new File(filePath, fileName);
            FileWriter fileWriter = new FileWriter(fileName);
            PrintWriter printWriter = new PrintWriter(fileWriter);
            printWriter.println("The first line");
            printWriter.close();
            tmp.add(file);
            System.out.println("Has file created:"+file.createNewFile());
        }
        return tmp;
    }
}
