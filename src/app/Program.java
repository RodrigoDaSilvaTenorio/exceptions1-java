package app;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import entities.Reservation;

public class Program {

	public static void main(String[] args) throws ParseException {
		Scanner sc = new Scanner(System.in);

		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		System.out.print("Room number: ");
		int roomNumber = sc.nextInt();

		System.out.print("Check-in date (DD/MM/YYYY): ");
		Date checkin = sdf.parse(sc.next());

		System.out.print("Check-out date (DD/MM/YYYY): ");
		Date checkout = sdf.parse(sc.next());

		if(!checkout.after(checkin)) {
			System.out.println("Error reservation ");
		}else {
			Reservation res = new Reservation(roomNumber, checkin, checkout);
			System.out.println("Reservation: " + res);

		System.out.println();

		System.out.println("Enter data to update the reservation: ");

		System.out.print("Check-in date (DD/MM/YYYY): ");
		checkin = sdf.parse(sc.next());
		System.out.print("Check-out date (DD/MM/YYYY): ");
		checkout = sdf.parse(sc.next());

		Date now = new Date();
		
		if(checkin.before(now) || checkout.before(now)) {
			res.updateDates(checkin, checkout);
		}else if (!checkout.after(checkin)){
			System.out.println("Error reservation ");
		}else {
			System.out.println("Reservation: " + res);
			sc.close();
		}


		}

	}
}
