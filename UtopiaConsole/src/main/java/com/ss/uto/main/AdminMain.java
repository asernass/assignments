package com.ss.uto.main;

import com.ss.uto.entity.flights.Airplane;
import com.ss.uto.entity.flights.Flight;
import com.ss.uto.entity.flights.Route;
import com.ss.uto.service.AdminService;

import java.sql.Timestamp;
import java.time.LocalDate;
import java.util.List;
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
        Integer choice = UtilParse.getIntChoice(input.nextLine(), 7);
        if (choice < 0) {
            mainMenu();
            return;
        }
        switch (choice) {
            case 1: //flight
                adminAddFlight();
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

    public static void adminRemoveRecords() {
        printPromptRecords("What would you like to remove");
    }

    public static void adminAddFlight() {
        System.out.println();
        System.out.println("Please enter a route by Id From list of routes");
        List<Route> allRoutes = service.getAllRoutes();
        if (allRoutes != null && allRoutes.isEmpty()) {
            System.out.println("No routes available");
            return;
        }
        UtilParse.printList(allRoutes);
        int lastIndex = allRoutes.size() + 1;
        System.out.println(lastIndex + ") Quit to previous");
        System.out.println("Please enter a route by Id From list of routes");
        Integer routeID = UtilParse.getIntChoice(input.nextLine(), lastIndex);
        if (routeID < 0) {
            adminAddFlight();
            return;
        } else if (routeID == lastIndex) {
            adminAddRecords();
            return;
        }
        System.out.println();
        System.out.println("Please enter a airPlane by Id From list of airplanes");
        List<Airplane> airplanes = service.getAllAirplanes();
        if (airplanes != null && airplanes.isEmpty()) {
            System.out.println("No airplanes available");
            return;
        }
        UtilParse.printList(airplanes);
        int airplaneIndex = airplanes.size() + 1;
        System.out.println(airplaneIndex + ") Quit to previous");
        System.out.println("Please enter a airPlane by Id From list of airplanes");
        Integer airPlaneId = UtilParse.getIntChoice(input.nextLine(), airplaneIndex);
        if (airPlaneId < 0) {
            adminAddFlight();
            return;
        } else if (airPlaneId == airplaneIndex) {
            adminAddRecords();
            return;
        }

        while (true) {
            try {
                System.out.println("Please enter a date in the following format (yyyy-mm-dd");
                String date = input.nextLine();
                System.out.println("Enter a time in the following format (hh:mm:ss)");
                String time = input.nextLine();
                Timestamp depature = Timestamp.valueOf(date + " " + time);
                System.out.println("What is the price of the seat");
                float price = Float.parseFloat(input.nextLine());
                Flight flight = new Flight(0, allRoutes.get(routeID - 1), airplanes.get(airPlaneId - 1),
                        depature.toLocalDateTime(), 0, price);
                service.addFlight(flight);
                System.out.println("added flight");
                break;
            } catch (Exception e) {
                System.out.println("please try again");
            }
        }


    }

    private static void getTime() {

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
