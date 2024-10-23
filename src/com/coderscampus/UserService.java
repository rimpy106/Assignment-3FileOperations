package com.coderscampus;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class UserService {
    public static User[] readFile(String fileName) {
        String line = "";
        User[] users = new User[4];
        int i = 0;
        try {
            BufferedReader br = new BufferedReader(new FileReader(fileName));
            while ((line = br.readLine()) != null) {
                String lineArray[] = line.split(",");
                users[i] = new User(lineArray[0], lineArray[1], lineArray[2]);
                i++;
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found exception");
        } catch (IOException e) {
            System.out.println("IO Exception");
        }
        return users;
    }

    public static User readConsoleData(Scanner sc){
        System.out.println("Enter user email");
        String userEmail=sc.nextLine();

        System.out.println("Enter user password");
        String userPassword=sc.nextLine();

        /*System.out.println("Enter user name");
        String userName=sc.nextLine();*/

        User user=new User(userEmail,userPassword);

        return user;

    }


}
