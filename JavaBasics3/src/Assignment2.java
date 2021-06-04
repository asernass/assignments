import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Assignment2 {
    public static void appendFile(String path, String append) throws IOException {
        FileWriter fw = new FileWriter(path, true);
        BufferedWriter writer = new BufferedWriter(fw);
        System.out.println(append);
        writer.write(append);
        writer.close();
    }

    public static void main(String[] args) {
        try {
            String path = "src\\testFiles\\hello.txt";
            appendFile(path, " World!");
        } catch (Exception e) {
            System.out.println("file not found");
        }
    }
}
