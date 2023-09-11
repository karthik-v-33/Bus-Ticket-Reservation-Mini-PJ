package BusTicketReservation;

import java.util.ArrayList;
import java.util.Scanner;

public class BusTicket {

	public static void main(String[] args) {

		ArrayList<Bus> buses = new ArrayList<Bus>();
		ArrayList<Booking> bookings = new ArrayList<Booking>();
		buses.add(new Bus(1, true, 45));
		buses.add(new Bus(2, false, 50));
		buses.add(new Bus(3, true, 45));

		for (Bus b : buses) {
			b.displayInfo();
		}
		int start = 1;
		Scanner scanner = new Scanner(System.in);
		while (start == 1) {
			System.out.println("Press 1 to Book and 2 to Exit");
			start = scanner.nextInt();
			if (start == 1) {
				Booking booking = new Booking();
				if (booking.isAvailable(bookings, buses)) {
					bookings.add(booking);
					System.out.println("Your Booking is Confirmed");
				}
				else
					System.out.println("Sorry. Bus is full, try another bus or date to continue");
			} else if (start == 2) {
				System.out.println("Thank You");
				break;
			} else
				System.out.println("Please enter vaild number");
		}
	}

}
