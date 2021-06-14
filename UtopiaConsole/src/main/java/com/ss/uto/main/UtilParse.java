package com.ss.uto.main;

import java.util.List;

public class UtilParse {

    public static Integer getIntChoice (String s, int count) {
        try {
            int i = Integer.parseInt(s);
            if(i <= 0 || i > count) {
                System.out.println("That is not a valid choice. Please try again.");
                return -1; // error code
            } else {
                return i;
            }
        } catch (NumberFormatException e) {
            System.out.println("That is not a valid integer. Please try again.");
            return -1; // error code
        }
    }
    public static void printList(List<?> list) {
        int index = 1;
        for (Object element:
             list) {
            System.out.print(index + ") ");
            System.out.println(element);
            index++;
        }
    }
}
