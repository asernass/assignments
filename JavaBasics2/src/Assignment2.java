import java.util.Arrays;
import java.util.Random;

public class Assignment2 {
    /**
     * Finds the max value and position of the number
     * 
     * @param data a 2D array to find max number
     */
    public static void findMax2D(int[][] data) {
        if (data.length == 0) {
            System.out.println("the array is empty");
        } else {
            int max = data[0][0], row = 0, column = 0;
            for (int i = 0; i < data.length; i++) {
                for (int j = 0; j < data[i].length; j++) {
                    if (max < data[i][j]) {
                        max = data[i][j];
                        row = i;
                        column = j;
                    }
                }
            }
            System.out.println("The max Value is " + max + " with positon row: " + row + " column " + column);
        }
    }

    /**
     * Generates a random 2d array with max row of 15 and max column of 15
     * 
     * @return returns random 2d Array
     */
    public static int[][] genInt2DArray() {
        Random gen = new Random();
        int maxRow = gen.nextInt(15) + 1, maxCol = gen.nextInt(15) + 1;
        int array2D[][] = new int[maxRow][maxCol];
        for (int i = 0; i < array2D.length; i++) {
            for (int j = 0; j < array2D[i].length; j++) {
                array2D[i][j] = gen.nextInt(101);
            }
        }
        return array2D;
    }

    public static void main(String[] args) {
        // int test1[][] = { { 1, 3, 5 }, { 10, 15, 16 }, { 20, -1, 5 } };
        // findMax2D(test1); should print position row: 2 coulum 0
        int randomArray[][] = genInt2DArray();
        // prints entire array
        // for (int[] is : randomArray) {
        // System.out.println(Arrays.toString(is));
        // }
        findMax2D(randomArray);
    }

}
