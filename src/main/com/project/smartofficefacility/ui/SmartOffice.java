package main.com.project.smartofficefacility.ui;

import main.com.project.smartofficefacility.config.OfficeConfiguration;

import java.util.Scanner;

public class SmartOffice {
    public static void main(String[] args) {
        OfficeConfiguration officeConfigurationObj = new OfficeConfiguration();
        Scanner scanner= new Scanner(System.in);

        //configuration of office
        configureOffice(officeConfigurationObj, scanner);

        //setting up the display menu
        SmartOfficeMenu menu = new SmartOfficeMenu(officeConfigurationObj,scanner);
        menu.displayMenu();

        scanner.close();

        System.out.println("Thank you for using Smart Office");
    }

    public static void  configureOffice(OfficeConfiguration office,Scanner scanner){
        System.out.println("Enter the number of meeting rooms: ");
        int roomCount=scanner.nextInt();
        scanner.nextLine();
        for(int i=1;i<=roomCount;i++){
            System.out.print("Enter the maximum capacity for room "+i+": ");
            int capacity=scanner.nextInt();
            scanner.nextLine();
            office.configureRoom(i,capacity);
        }
        System.out.println("Office configured with "+roomCount+" meeting rooms");
    }
}


