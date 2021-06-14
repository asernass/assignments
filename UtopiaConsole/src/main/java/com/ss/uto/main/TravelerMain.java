package com.ss.uto.main;

import com.ss.uto.entity.bookings.Booking;
import com.ss.uto.entity.flights.Flight;
import com.ss.uto.entity.user.User;
import com.ss.uto.service.AdminService;

import java.util.List;
import java.util.Scanner;

public class TravelerMain {
    private static AdminService service = new AdminService();
    private static Scanner input = new Scanner(System.in);

    public static void mainMenu() {
        System.out.println();
        System.out.println("Please Enter Membership Number");
        Integer membership = UtilParse.getIntChoice(input.nextLine(), Integer.MAX_VALUE);
        if (membership < 0) {
            mainMenu();
            return;
        }
        User user = service.validateTraveler(membership);

        if (user == null) {
            System.out.println("Not a Traveler. Please try again.");
            mainMenu();
            return;
        }
        trav1Menu(user);
    }

    public static void trav1Menu(User user) {
        System.out.println();
        System.out.println("1) Book a Ticket");
        System.out.println("2) Cancel an Upcoming Trip");
        System.out.println("3) Quit to Previous\n");
        Integer choice = UtilParse.getIntChoice(input.nextLine(), 3);
        if (choice < 0) {
            trav1Menu(user);
            return;
        }

        switch (choice) {
            case 1:
                trave1BookingMenu(user);
                return;
            case 2:
                cancelTrip(user);
                return;
            case 3:
                Main.mainMenu();
                return;
            default:
                trav1Menu(user);
                break;
        }
    }

    public static void trave1BookingMenu(User user) {
        System.out.println();
        List<Flight> flightList = service.flightsAvailable();
        if (flightList != null && flightList.isEmpty()) {
            System.out.println("No Flights Available going back");
            trav1Menu(user);
            return;
        }
        UtilParse.printList(flightList);
        int lastIndex = flightList.size() + 1;
        System.out.println(lastIndex + ") Quit to previous");
        System.out.println("Please select an Id on first Column");
        Integer id = UtilParse.getIntChoice(input.nextLine(), lastIndex);
        if (id < 0) {
            trave1BookingMenu(user);
            return;
        } else if (id == lastIndex) {
            trav1Menu(user);
            return;
        }
        System.out.println("Booking was added.");
        service.addBookingToUser(flightList.get(id - 1), user);
        trav1Menu(user);

    }

    public static void cancelTrip(User user) {
        System.out.println();
        System.out.println("Cancel Trip Menu");
        List<Booking> bookings = service.getBookingsOfUser(user);
        if (bookings != null && bookings.isEmpty()) {
            System.out.println("No bookings available.");
            trav1Menu(user);
            return;
        }
        UtilParse.printList(bookings);
        int lastIndex = bookings.size() + 1;
        System.out.println(lastIndex + ") Quit to previous");
        System.out.println("Please select an Id on first Column");
        Integer id = UtilParse.getIntChoice(input.nextLine(), lastIndex);
        if (id < 0) {
            cancelTrip(user);
            return;
        } else if (id == lastIndex) {
            trav1Menu(user);
            return;
        }
        System.out.println("Trip has been canceled");
        service.deleteBooking(bookings.get(id - 1));
        trav1Menu(user);
    }
}
