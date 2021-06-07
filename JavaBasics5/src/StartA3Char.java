import java.util.List;
import java.util.stream.Collectors;

public class StartA3Char {

    public static List<String> getStrings(List<String> input) {
        return input.stream().filter(s -> s.charAt(0) == 'a' && s.length() == 3).collect(Collectors.toList());
    }

}
