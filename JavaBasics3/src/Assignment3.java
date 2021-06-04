import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Scanner;
import java.util.stream.IntStream;

public class Assignment3 {

    public static Integer occurrences(String path, char find) throws IOException {
        String content = Files.readString(Path.of(path));
        Integer count = 0;
        count = (int) IntStream.range(0, content.length()).filter(c -> content.charAt(c) == find).count();
        return count;
    }

    public static void main(String[] args) {
        System.out.println("Please type a character to count all occurances that are case sensitive");

        try (Scanner reader = new Scanner(System.in)) {
            Character charac = reader.next().charAt(0);
            // String pathShort = "src\\testFiles\\hello.txt"; simple case
            String pathShort = "src\\testFiles\\findChar.txt";
            int count = occurrences(pathShort, charac);
            System.out.println("number of occurences of character " + charac + " is : " + count);
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("no Such file");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
