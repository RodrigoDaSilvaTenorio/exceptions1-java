package entities;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Reservation {
	private Integer roomNumber;
	private Date checkin;
	private Date checkout;

	private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

	public Reservation(Integer room, Date checkin, Date checkout) {
		this.roomNumber = room;
		this.checkin = checkin;
		this.checkout = checkout;
	}

	public Integer getRoomNumber() {
		return roomNumber;
	}

	public void setRoomNumber(Integer roomNumber) {
		this.roomNumber = roomNumber;
	}

	public Date getCheckin() {
		return checkin;
	}

	public Date getCheckout() {
		return checkout;
	}

	// Calcula diferenca entre datas atraves de dias
	public long duration() {
		long diff = checkout.getTime() - checkin.getTime();
		return TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS);
	}

	public String updateDates(Date checkIn, Date checkOut) {
		Date now = new Date();
		
		if (checkIn.before(now) || checkOut.before(now)) {
			return "Only future dates, please!!";
		} 
		if (!checkOut.after(checkIn)) {
			return "Check-in DATE must be inferior a check-out DATE:";
			}
		
		this.checkin = checkIn;
		this.checkout = checkOut;

		return null;
	}

	@Override
	public String toString() {
		return "Room " + roomNumber 
				+ ", Check-In: " + sdf.format(checkin) 
				+ ", Check-Out: " + sdf.format(checkout)
				+ ", " + duration() + " night/s";
	}

}
