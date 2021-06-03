public class Assignment1 {
    public static int sum(String[] data) {
        int sumData = 0;
        for (String string : data) {
            try {
                sumData += Integer.parseInt(string);
            } catch (Exception e) {
                continue;
            }
        }
        return sumData;
    }

    public static void main(String[] args) {
        if (args.length != 0) {
            System.out.println(sum(args));
        } else {
            System.out.println("Please add arguments to the program.");
        }
    }
}
