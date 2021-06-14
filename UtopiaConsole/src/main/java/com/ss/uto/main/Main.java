package com.ss.uto.main;

import com.ss.uto.dao.user.UserDAO;
import com.ss.uto.entity.user.User;
import com.ss.uto.service.ConnectionUtil;

import java.sql.Connection;
import java.util.Scanner;

public class Main {

    private static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("Welcome to the Utopia Airlines Management System.");
        mainMenu();
    }

    public static void mainMenu() {
        System.out.println("Which user are you:\n");
        System.out.println("1) Employee");
        System.out.println("2) Administrator");
        System.out.println("3) Traveler");
        System.out.println("4) Quit\n");
        Integer choice = UtilParse.getIntChoice(input.nextLine(), 4);

        if (choice < 0) {
            mainMenu();
            return;
        }
        switch (choice) {
            case 1:
                System.out.println("Employee not implemented try again");
                mainMenu();
                break;
            case 2:
                AdminMain.mainMenu();
                break;
            case 3:
                TravelerMain.mainMenu();
                break;
            case 4:
                input.close();
                return;

            default:
                System.out.println("Invalid Choice try again");
                mainMenu();
                break;

        }


    }
}
