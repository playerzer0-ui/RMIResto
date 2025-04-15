package client;

import common.IMenu;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Client {
    public static void main(String[] args) {
        try{
            IMenu menu = (IMenu) Naming.lookup("rmi://localhost:12345/resto");

            Scanner sc = new Scanner(System.in);
            System.out.println("Hello, welcome to the restaurant!");
            System.out.println("would you like pizza(1), taco(2) or....water(3)");
            String choice = sc.nextLine();

            switch (choice){
                case "1":
                    System.out.println(menu.getPizza());
                    break;
                case "2":
                    System.out.println(menu.getTaco());
                    break;
                case "3":
                    System.out.println(menu.getWater());
                    break;
                default:
                    System.out.println("error, enter a number on the menu next time...");
                    break;
            }
        } catch (NotBoundException | MalformedURLException | RemoteException ex) {
            Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}