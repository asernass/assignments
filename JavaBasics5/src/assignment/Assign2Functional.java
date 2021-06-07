package assignment;

import java.util.List;
import java.util.stream.Collectors;

public class Assign2Functional {

    public static List<Integer> getRight(List<Integer> list) {
        return list.stream().map(i -> i % 10).collect(Collectors.toList());
    }

    public static List<Integer> doubling(List<Integer> list) {
        return list.stream().map(i -> i * 2).collect(Collectors.toList());
    }

    public static List<String> noX(List<String> list) {
        return list.stream().map(i -> i.replaceAll("x", "")).collect(Collectors.toList());
    }

    public static boolean groupSumClump(int[] nums, int start, int target) {
        if (start >= nums.length) {
            return target == 0;
        }

        int sum = 0;
        int i = start;
        for (; i < nums.length && nums[start] == nums[i]; i++) {
            sum += nums[i];
        }

        if (groupSumClump(nums, i, target - sum))
            return true;

        if (groupSumClump(nums, i, target))
            return true;

        return false;
    }
}
