package main.com.project.smartofficefacility.ui;

//import main.com.project.smartofficefacility.config.OfficeConfiguration;
//
//import java.util.Scanner;
//
//public class SmartOffice {
//    public static void main(String[] args) {
//        //OfficeConfiguration officeConfigurationObj = new OfficeConfiguration();
//        OfficeConfiguration office = OfficeConfiguration.getInstance();
//        Scanner scan= new Scanner(System.in);
//
//        //configuration of office
//        configureOffice(office, scan);
//
//        //setting up the display menu
//        SmartOfficeMenu menu = new SmartOfficeMenu(office,scan);
//        menu.displayMenu();
//
//        scan.close();
//
//        System.out.println("Thank you for using Smart Office");
//    }
//
//    public static void  configureOffice(OfficeConfiguration office,Scanner scanner){
//        System.out.println("Enter the number of meeting rooms: ");
//        int roomCount=scanner.nextInt();
//        scanner.nextLine();
//        for(int i=1; i<=roomCount; i++){
//            System.out.print("Enter the maximum capacity for room "+i+": ");
//            int capacity=scanner.nextInt();
//            scanner.nextLine();
//            office.configureRoom(i,capacity);
//        }
//        System.out.println("Office configured with "+roomCount+" meeting rooms");
//    }
//}
//
//


import main.com.project.smartofficefacility.config.OfficeConfiguration;
import java.util.Scanner;

public class SmartOffice{
    public static void main(String[] args) {
        OfficeConfiguration office = OfficeConfiguration.getInstance();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to the Smart Office Facility!");

        // Step 1: Configure the office
        configureOffice(office, scanner);

        // Step 2: Display menu
        SmartOfficeMenu menu = new SmartOfficeMenu(office, scanner);
        menu.displayMenu();

        scanner.close();
        System.out.println("Thank you for using the Smart Office Facility");
    }

    private static void configureOffice(OfficeConfiguration office, Scanner scanner) {
        System.out.print("Enter the number of meeting rooms: ");
        int roomCount = scanner.nextInt();
        scanner.nextLine(); // consume newline

        for (int i = 1; i <= roomCount; i++) {
            System.out.print("Enter the maximum capacity for Room " + i + ": ");
            int capacity = scanner.nextInt();

        }}}
