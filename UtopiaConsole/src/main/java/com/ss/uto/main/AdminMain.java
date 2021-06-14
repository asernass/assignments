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
        printPromptRecords("What would you like to view");
        Integer choice = UtilParse.getIntChoice(input.nextLine(), 7);
        if (choice < 0) {
            mainMenu();
            return;
        }
        switch (choice) {
            case 1: //flight
                UtilParse.printList(service.getAllFlights());
                mainMenu();
                return;
            case 2: // plane
                UtilParse.printList(service.getAllAirplanes());
                mainMenu();
                return;
            case 3: // passenger
                UtilParse.printList(service.getAllPassengers());
                mainMenu();
                return;
            case 4: // airport
                UtilParse.printList(service.getAllAirports());
                mainMenu();
                return;
            case 5:
                UtilParse.printList(service.getAllBookings());
                mainMenu();
                return;
            case 6:
                UtilParse.printList(service.getAllTravelers());
                mainMenu();
                return;
            default:
                mainMenu();
                return;
        }

    }

    public static void adminAddRecords() {
        printPromptRecords("What would you like to add");
    }

    public static void adminRemoveRecords() {
        printPromptRecords("What would you like to remove");
    }

    private static void printPromptRecords(String prompt) {
        System.out.println(prompt);
        System.out.println("1) flight record");
        System.out.println("2) plane record");
        System.out.println("3) passenger record");
        System.out.println("4) airport record");
        System.out.println("5) booking record");
        System.out.println("6) traveler record");
        System.out.println("7) Previous menu");
    }

}
