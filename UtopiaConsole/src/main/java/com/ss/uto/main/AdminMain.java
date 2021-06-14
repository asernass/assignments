package com.ss.uto.main;

import com.ss.uto.service.AdminService;

import java.util.Scanner;

public class AdminMain {
    private static AdminService service = new AdminService();
    private static Scanner input = new Scanner(System.in);

    public static void mainMenu() {
        System.out.println();
        System.out.println("Welcome Admin\n");
        System.out.println("Please choose from the Following");
        System.out.println("1) View records");
        System.out.println("2) Add to records");
        System.out.println("3) remove records");
        System.out.println("4) Quit to Previous");
        Integer choice = UtilParse.getIntChoice(input.nextLine(), 4);
        if (choice < 0) {
            mainMenu();
            return;
        }
        switch (choice) {
            case 1:
                adminViewRecords();
                return;
            case 2:
                adminAddRecords();
                return;
            case 3:
                adminRemoveRecords();
                return;
            case 4:
                Main.mainMenu();
                return;
            default:
                mainMenu();
                return;
        }


    }

    public static void adminViewRecords() {

    }

    public static void adminAddRecords() {

    }

    public static void adminRemoveRecords() {

    }
}
