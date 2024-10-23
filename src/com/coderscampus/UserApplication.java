package com.coderscampus;

import java.util.Scanner;

public class UserApplication {
    public static void main(String[] args) {
        UserService us = new UserService();
        String fileName = "data.txt";
        User usersList[] = us.readFile(fileName);
        Boolean userMatchFound = false;
        int attempts = 0;

        while (attempts < 5) {
            Scanner sc = new Scanner(System.in);
            User userConsole = us.readConsoleData(sc);
            for (int j = 0; j < usersList.length; j++) {
                if (userConsole.getUserEmail().equalsIgnoreCase(usersList[j].getUserEmail())) {
                    if (userConsole.getUserPassword().equals(usersList[j].getUserPassword())) {
                        System.out.println("Welcome: " + usersList[j].getUserName());
                        userMatchFound = true;
                        break;
                    }
                }
            }
            attempts++;

            if (userMatchFound)
                break;
            else
                System.out.println("Invalid login, please try again");
        }
        if (attempts > 5)
            System.out.println("Too many failed login attempts, you are now locked out.");
    }
}