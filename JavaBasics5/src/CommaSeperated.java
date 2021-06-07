import java.util.List;
import java.util.stream.Collectors;

public class CommaSeperated {

    public static String getCommaSeperated(List<Integer> array) {
        return array.stream().map(i -> i % 2 == 0 ? "e" + i : "o" + i).collect(Collectors.joining(","));
    }

}
