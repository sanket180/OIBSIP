package internship;

import java.util.Scanner;

public class AirlineReservationSystem {

	public static void main(String[] args) {
		// initialize variables
		int firstClassSeats = 5;
		int economyClassSeats = 5;
		boolean[] seats = new boolean[10];
		Scanner input = new Scanner(System.in);

		// display menu and prompt user for input
		while (true) {
			System.out.println("Welcome to the Airline Reservation System");
			System.out.println("1. First Class");
			System.out.println("2. Economy Class");
			System.out.println("3. Exit");
			System.out.print("Please enter your choice: ");
			int choice = input.nextInt();

			// book seat based on user choice
			switch (choice) {
			case 1:
				if (firstClassSeats > 0) {
					System.out.println("Your seat has been booked in first class.");
					firstClassSeats--;
					int seatNumber = assignSeat(seats);
					String ticket = generateTicket("First Class", seatNumber);
					System.out.println("Please enter your name: ");
					String name = input.next();
					System.out.println("Please enter your email address: ");
					String email = input.next();
					System.out.println(ticket);
					System.out.println("Passenger: " + name);
					System.out.println("Email: " + email);
				} else if (economyClassSeats > 0) {
					System.out.println("First class is full. Would you like to book a seat in economy class? (Y/N)");
					char option = input.next().charAt(0);
					if (option == 'Y' || option == 'y') {
						System.out.println("Your seat has been booked in economy class.");
						economyClassSeats--;
						int seatNumber = assignSeat(seats);
						String ticket = generateTicket("Economy Class", seatNumber);
						System.out.println("Please enter your name: ");
						String name = input.next();
						System.out.println("Please enter your email address: ");
						String email = input.next();
						System.out.println(ticket);
						System.out.println("Passenger: " + name);
						System.out.println("Email: " + email);
					} else {
						System.out.println("Next flight leaves in 3 hours.");
					}
				} else {
					System.out.println("Both first class and economy class are full. Next flight leaves in 3 hours.");
				}
				break;

			case 2:
				if (economyClassSeats > 0) {
					System.out.println("Your seat has been booked in economy class.");
					economyClassSeats--;
					int seatNumber = assignSeat(seats);
					String ticket = generateTicket("Economy Class", seatNumber);
					System.out.println("Please enter your name: ");
					String name = input.next();
					System.out.println("Please enter your email address: ");
					String email = input.next();
					System.out.println(ticket);
					System.out.println("Passenger: " + name);
					System.out.println("Email: " + email);
				} else if (firstClassSeats > 0) {
					System.out.println("Economy class is full. Would you like to book a seat in first class? (Y/N)");
					char option = input.next().charAt(0);
					if (option == 'Y' || option == 'y') {
						System.out.println("Your seat has been booked in first class.");
						firstClassSeats--;
						int seatNumber = assignSeat(seats);
						String ticket = generateTicket("First Class", seatNumber);
						System.out.println("Please enter your name: ");
						String name = input.next();
						System.out.println("Please enter your email address: ");
						String email = input.next();
						System.out.println(ticket);
						System.out.println("Passenger: " + name);
						System.out.println("Email: " + email);
					} else {
						System.out.println("Next flight leaves in 3 hours.");
					}
				} else {
					System.out.println("Both economy class and first class are full. Next flight leaves in 3 hours.");
				}
				break;
			case 3:
				System.out.println("Thank you for using the Airline Reservation System. Goodbye!");
				System.exit(0);
				break;

			default:
				System.out.println("Invalid input. Please try again.");
				break;
			}
		}
	}

	// assign seat
	public static int assignSeat(boolean[] seats) {
		for (int i = 0; i < seats.length; i++) {
			if (!seats[i]) {
				seats[i] = true;
				return i + 1;
			}
		}
		return -1;
	}

	// generate ticket
	public static String generateTicket(String seatType, int seatNumber) {
		String ticket = "------------------------\n";
		ticket += "Airline Reservation Ticket\n";
		ticket += "------------------------\n";
		ticket += "Seat Type: " + seatType + "\n";
		ticket += "Seat Number: " + seatNumber + "\n";
		ticket += "------------------------";
		return ticket;
	}
}
