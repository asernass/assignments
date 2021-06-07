package assignment;

public class AssignLambdas1 {

    public static boolean isNumber(PerformOperation p, int a) {
        return p.isMath(a);
    }

    public static PerformOperation isOdd() {
        return n -> (n % 2) == 1;
    }

    public static PerformOperation isPrime() {
        return n -> {
            for (int i = 2; i * i < n; i++) {
                if (n % i == 0) {
                    return false;
                }
            }
            return true;
        };
    }

    public static PerformOperation isPalindrome() {
        return n -> {
            StringBuilder ans = new StringBuilder(n.toString());
            return ans.toString().equals(ans.reverse().toString());
        };
    }
}
