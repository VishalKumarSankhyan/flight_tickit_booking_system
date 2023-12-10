package com.flighttickitbooking;

import java.util.Scanner;
import static com.flighttickitbooking.AllOperation.*;

// ==========
public class MainOperation {
	private static Scanner sc = new Scanner(System.in);

	public static void mainOperation() {
		int input = 0;
		boolean active = true;
		while(active) {
			System.out.println("================================================================================");
			System.out.println("========================[ Flight Tickit Booking System ]========================");
			System.out.println("================================================================================");
			System.out.println("1. Passenger Details");
			System.out.println("2. Flight Details");
			System.out.println("3. Booking Details");
			System.out.println("4. Exit");
			System.out.print("Enter Choice -> ");
			input = sc.nextInt();
			
			switch(input) {
				case 1:
					passengerOperation();
					break;
				case 2:
					flightOperation();
					break;
				case 3:
					bookingOperation();
					break;
				case 4:
//					active = false;
					System.exit(0);
					break;
				default:
					System.out.println("Invalid Input");
			}
			
			System.out.println("================================================================================");
			
		}
	}

	public static void main(String args[]) {
		mainOperation();
	}
}
