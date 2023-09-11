package BusTicketReservation;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class Booking {
	String passengerName;
	int busNo;
	Date date;

	public Booking() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter your name : ");
		passengerName = scanner.nextLine();
		System.out.println("Enter your Bus no : ");
		busNo = scanner.nextInt();
		System.out.println("Enter date dd-mm-yyyy");
		String dateInput = scanner.next();
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
		try {
			date = dateFormat.parse(dateInput);
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}

	public boolean isAvailable(ArrayList<Booking> bookings, ArrayList<Bus> buses) {
		int capacity = 0;
		int booked = 0;
		for(Bus bus : buses) {
			if(bus.getBusNo() == busNo) {
				capacity = bus.getCapacity();
			}
			for(Booking b : bookings) {
				if(b.busNo == busNo && b.date.equals(date)) {
					booked++;
				}
			}
		}
		return booked<capacity?true:false;
	}
}
