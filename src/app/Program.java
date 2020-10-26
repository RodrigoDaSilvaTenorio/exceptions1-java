package app;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import Exceptions.DomainException;
import entities.Reservation;

public class Program {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		try {

			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

			System.out.print("Room number: ");
			int roomNumber = sc.nextInt();

			System.out.print("Check-in date (DD/MM/YYYY): ");
			Date checkin = sdf.parse(sc.next());

			System.out.print("Check-out date (DD/MM/YYYY): ");
			Date checkout = sdf.parse(sc.next());

			Reservation res = new Reservation(roomNumber, checkin, checkout);
			System.out.println("Reservation: " + res);

			System.out.println();

			System.out.println("Enter data to update the reservation: ");

			System.out.print("Check-in date (DD/MM/YYYY): ");
			checkin = sdf.parse(sc.next());
			System.out.print("Check-out date (DD/MM/YYYY): ");
			checkout = sdf.parse(sc.next());

			res.updateDates(checkin, checkout);

			System.out.println("Reservation: " + res);
		} catch (ParseException e) {
			System.out.println("Format date incorrect!!");
		} catch (DomainException e) {
			System.out.println("Reservation error: " + e.getMessage());
		} catch (RuntimeException e) {
			System.out.println("Unexpected error!");
		}
		sc.close();

	}

}
