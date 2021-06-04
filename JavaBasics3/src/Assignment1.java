import java.io.File;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class Assignment1 {

    public static List<String> getAllFileNames(File file) {
        List<String> fileNames = new ArrayList<>();

        for (File f : file.listFiles()) {
            if (f.isFile()) {
                fileNames.add(f.getName());
            } else if (f.isDirectory()) {
                fileNames.add(f.getName());
                fileNames.addAll(getAllFileNames(f)); // recursion to get all files
            }
        }

        return fileNames;

    }

    public static void main(String[] args) {
        Assignment1 test = new Assignment1();
        URL path = test.getClass().getResource("testFiles");
        try {
            File testDir = new File(path.getPath());
            System.out.println(getAllFileNames(testDir));
        } catch (Exception e) {
            System.out.println("No file or directory name");
        }
    }
}
