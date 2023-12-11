package com.flighttickitbooking;

import static com.flighttickitbooking.MainOperation.mainOperation;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import com.flighttickitbooking.entity.Address;
import com.flighttickitbooking.entity.Booking;
import com.flighttickitbooking.entity.Flight;
import com.flighttickitbooking.entity.Name;
import com.flighttickitbooking.entity.Passenger;
import com.flighttickitbooking.entity.Payment;
import com.flighttickitbooking.entity.Seat;
import com.flighttickitbooking.service.BookingService;
import com.flighttickitbooking.service.FlightService;
import com.flighttickitbooking.service.PassengerService;
import com.flighttickitbooking.service.PaymentService;
import com.flighttickitbooking.service.SeatService;
import com.flighttickitbooking.serviceimpl.BookingServiceImpl;
import com.flighttickitbooking.serviceimpl.FlightServiceImpl;
import com.flighttickitbooking.serviceimpl.PassengerServiceImpl;
import com.flighttickitbooking.serviceimpl.PaymentServiceImpl;
import com.flighttickitbooking.serviceimpl.SeatServiceImpl;

public class AllOperation {
	private static Scanner sc = new Scanner(System.in);
	private static PassengerService passengerService = new PassengerServiceImpl();  
	private static FlightService flightService = new FlightServiceImpl();
	private static BookingService bookingService = new BookingServiceImpl();
	private static PaymentService paymentService = new PaymentServiceImpl();
	private static SeatService seatService = new SeatServiceImpl();
	
	
	public static Date parseStringToDate(String date) {
		Calendar cal = Calendar.getInstance();
		String [] dateArr  = date.split("/");
		cal.set(Calendar.DAY_OF_MONTH, Integer.parseInt(dateArr[0]));
		cal.set(Calendar.MONTH, Integer.parseInt(dateArr[1]) - 1);
		cal.set(Calendar.YEAR, Integer.parseInt(dateArr[2]));
		return cal.getTime();
	}
	
	public static String parseDateToString(Date date) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		return cal.get(Calendar.DAY_OF_MONTH) + "/" + cal.get(Calendar.MONTH) + "/" + cal.get(Calendar.YEAR);
	}
	
	public static Date parseStringToTime(String time) {
		String timeArr[] = time.split("[: ]");

		int hour = Integer.parseInt(timeArr[0]);
		int minutes = Integer.parseInt(timeArr[1]);

		if (timeArr[2].equalsIgnoreCase("PM")) {
			hour = hour != 12 ? hour + 12 : hour;
		} else {
			hour = hour == 12 ? 0 : hour;
		}

		Date date = new Date();
		date.setHours(hour);
		date.setMinutes(minutes);
		date.setSeconds(0);
		return date;
	}

	public static String parseTimeToString(Date time) {
		int hour = time.getHours();
		int minute = time.getMinutes();
		String am_pm = null;
		if (hour == 0 || hour <= 11) {
			am_pm = "AM";
			hour = hour == 0 ? 12 : hour;
		} else {
			hour = hour == 12 ? hour : hour - 12;
			am_pm = "PM";
		}
		return (hour < 10 ? "0" + hour : hour) + ":" + (minute < 10 ? "0" + minute : minute) + " " + am_pm;
	}
	

	public static void passengerOperation() {
		int input = 0;
		boolean active = true;
		while (active) {
			System.out.println("================================================================================");
			System.out.println("==================================[ Passenger ]=================================");
			System.out.println("================================================================================");
			System.out.println("1. Create Passenger");
			System.out.println("2. Show Passenger");
			System.out.println("3. Update Passenger");
			System.out.println("4. Delete Passenger");
			System.out.println("5. To getback to the main menu");
			System.out.print("Enter Choice -> ");
			input = sc.nextInt();

			switch (input) {
			case 1:
				Passenger passenger = passengerInputs();
				Passenger savedEntity = passengerService.createPassenger(passenger);
				System.out.println(savedEntity);
				break;
			case 2:
				showPassenger();
				break;
			case 3:
				UpdatePassengerOperation();
				break;
			case 4:
				deletePassenger();
				break;
			case 5:
				mainOperation();
				break;
			default:
				System.out.println("Invalid Input");
			}

			System.out.println("================================================================================");
		}
	}
	
	public static Passenger passengerInputs() {
		Passenger passenger = new Passenger();
		Name name = new Name();
		Address address = new Address();
		
		sc.nextLine();
		System.out.println("================================================================================");
		System.out.print("Enter First Name -> ");
		name.setFirstName(sc.nextLine());
		System.out.print("Enter Middle Name -> ");
		name.setMiddleName(sc.nextLine());
		System.out.print("Enter Last Name -> ");
		name.setLastName(sc.nextLine());
		
		passenger.setName(name);

		System.out.print("Enter Email -> ");
		passenger.setEmail(sc.nextLine());

		System.out.print("Enter Phone Number -> ");
		passenger.setPhoneNumber(sc.nextLine());
		
		System.out.print("Enter Date Of Birth [DD/MM/YYYY] -> ");
		passenger.setDateOfBirth(parseStringToDate(sc.nextLine()));
		
		System.out.print("Enter Gender -> ");
		passenger.setGender(sc.nextLine());
		
		System.out.print("Enter House Number -> ");
		address.setHouseNumber(sc.nextLine());
		
		System.out.print("Enter City -> ");
		address.setCity(sc.nextLine());
		
		System.out.print("Enter State -> ");
		address.setState(sc.nextLine());
		
		System.out.print("Enter Country -> ");
		address.setCountry(sc.nextLine());
		
		System.out.print("Enter PIN Code -> ");
		address.setPincode(sc.nextInt());
		passenger.setAddress(address);
		System.out.println("================================================================================");
		return passenger;
	}
	
	public static void showPassenger() {
		System.out.print("Enter Passenger Id -> ");
		Passenger passenger = passengerService.getPassenger(sc.nextInt());
		
		if(passenger == null) {
			System.out.println("!Not Found");
			return;
		}
		printPassenger(passenger);
	}
	
	public static void printPassenger(Passenger passenger) {
		System.out.println("================================================================================");
		System.out.println("Id - " + passenger.getId());
		System.out.println("First Name - " + passenger.getName().getFirstName());
		System.out.println("Middle Name - " + passenger.getName().getMiddleName());
		System.out.println("Last Name - " + passenger.getName().getLastName());
		System.out.println("Email - " + passenger.getEmail());
		System.out.println("Phone Number - " + passenger.getPhoneNumber());
		System.out.println("DOB - " + parseDateToString(passenger.getDateOfBirth()));
		System.out.println("Gender - " + passenger.getGender());
		System.out.println("== Address");
		System.out.println("House No - " + passenger.getAddress().getHouseNumber());
		System.out.println("City - " + passenger.getAddress().getCity());
		System.out.println("State - " + passenger.getAddress().getState());
		System.out.println("Country - " + passenger.getAddress().getCountry());
		System.out.println("PIN Code - " + passenger.getAddress().getPincode());
		System.out.println("================================================================================");
	}
	
	public static void UpdatePassengerOperation() {
		System.out.print("Enter Passenger Id -> ");
		Passenger passenger = passengerService.getPassenger(sc.nextInt());
		
		if(passenger == null) {
			System.out.println("!Not Found");
			return;
		}
		
		int input = 0;
		boolean active = true;
		while (active) {
			System.out.println("================================================================================");
			System.out.println("1. Update Name");
			System.out.println("2. Update Email");
			System.out.println("3. Update Phone Number");
			System.out.println("4. Update DOB");
			System.out.println("5. Update Gender");
			System.out.println("6. Update Address");
			System.out.println("7. Save");
			System.out.println("8. Cancel");
			System.out.print("Enter Choice -> ");
			input = sc.nextInt();

			switch (input) {
			case 1:
				passenger.setName(updateName());
				break;
			case 2:
				passenger.setEmail(updateEmail());
				break;
			case 3:
				passenger.setPhoneNumber(updatePhoneNumber());
				break;
			case 4:
				passenger.setDateOfBirth(updateDOB());
				break;
			case 5:
				passenger.setGender(updateGender());
				break;
			case 6:
				passenger.setAddress(updateAddress());
				break;
			case 7:
				passengerService.updatePassenger(passenger);
				passengerOperation();
				break;
			case 8:
				passengerOperation();
				break;
			default:
				System.out.println("Invalid Input");
			}

			System.out.println("================================================================================");
		}
	}
	
	public static Name updateName() {
		Name name = new Name();
		sc.nextLine();
		System.out.println("================================================================================");
		System.out.print("Enter First Name -> ");
		name.setFirstName(sc.nextLine());
		System.out.print("Enter Middle Name -> ");
		name.setMiddleName(sc.nextLine());
		System.out.print("Enter Last Name -> ");
		name.setLastName(sc.nextLine());
		System.out.println("================================================================================");
		return name;
	}
	
	public static String updateEmail() {
		String email = null;
		sc.nextLine();
		System.out.println("================================================================================");
		System.out.print("Enter Email -> ");
		email = sc.nextLine();
		System.out.println("================================================================================");
		return email;
	}
	
	public static String updatePhoneNumber() {
		String phoneNumber = null;
		sc.nextLine();
		System.out.println("================================================================================");
		System.out.print("Enter Phone Number -> ");
		phoneNumber = sc.nextLine();
		System.out.println("================================================================================");
		return phoneNumber;
	}
	
	public static String updateGender() {
		String gender = null;
		sc.nextLine();
		System.out.println("================================================================================");
		System.out.print("Enter Gender -> ");
		gender = sc.nextLine();
		System.out.println("================================================================================");
		return gender;
	}
	
	public static Date updateDOB() {
		Date date = null;
		sc.nextLine();
		System.out.println("================================================================================");
		System.out.print("Enter Date Of Birth [DD/MM/YYYY] -> ");
		date = parseStringToDate(sc.nextLine());
		System.out.println("================================================================================");
		return date;
	}
	
	public static Address updateAddress() {
		Address address = new Address();
		sc.nextLine();
		System.out.println("================================================================================");
		System.out.print("Enter House Number -> ");
		address.setHouseNumber(sc.nextLine());
		
		System.out.print("Enter City -> ");
		address.setCity(sc.nextLine());
		
		System.out.print("Enter State -> ");
		address.setState(sc.nextLine());
		
		System.out.print("Enter Country -> ");
		address.setCountry(sc.nextLine());
		
		System.out.print("Enter PIN Code -> ");
		address.setPincode(sc.nextInt());
		System.out.println("================================================================================");
		return address;
	}
	
	
	public static void deletePassenger() {
		System.out.print("Enter Passenger Id -> ");
		Passenger passenger = passengerService.getPassenger(sc.nextInt());
		
		if(passenger == null) {
			System.out.println("!Not Found");
			return;
		}
		passengerService.deletePassenger(passenger);
	}
	
	
	public static void flightOperation() {
		int input = 0;
		boolean active = true;
		while (active) {
			System.out.println("================================================================================");
			System.out.println("===================================[ Flight ]===================================");
			System.out.println("================================================================================");
			System.out.println("1. Create Flight");
			System.out.println("2. Show Flight");
			System.out.println("3. Update Flight");
			System.out.println("4. Delete Flight");
			System.out.println("5. To getback to the main menu");
			System.out.print("Enter Choice -> ");
			input = sc.nextInt();

			switch (input) {
			case 1:
				Flight flight = flightInputs();
				Flight flightEntity = flightService.createFlight(flight);
				System.out.println(flightEntity);
				break;
			case 2:
				showFlight();
				break;
			case 3:
				UpdateFlightOperation();
				break;
			case 4:
				deleteFlight();
				break;
			case 5:
				mainOperation();
				break;
			default:
				System.out.println("Invalid Input");
			}

			System.out.println("================================================================================");
		}
	}
	
	
	public static Flight flightInputs() {
		Flight flight = new Flight();
		sc.nextLine();
		System.out.println("================================================================================");
		System.out.print("Enter Departure Airport -> ");
		flight.setDepartureAirport(sc.nextLine());
		System.out.print("Enter Arrival Airport -> ");
		flight.setArrivalAirport(sc.nextLine());
		
		System.out.print("Enter Departure Date [DD/MM/YYYY] -> ");
		flight.setArrivalDate(parseStringToDate(sc.nextLine()));
		System.out.print("Enter Arrival Date [DD/MM/YYYY] -> ");
		flight.setDepartureDate(parseStringToDate(sc.nextLine()));
		
		System.out.print("Enter Departure Time [HH:MM (AM/PM)] -> ");
		flight.setDepartureTime(parseStringToTime(sc.nextLine()));
		System.out.print("Enter Arrival Time [HH:MM (AM/PM)] -> ");
		flight.setArrivalTime(parseStringToTime(sc.nextLine()));
		
		System.out.print("Enter Total Number of Seats -> ");
		flight.setTotalSeat(sc.nextInt());
		
		System.out.print("Enter Base Fare -> ");
		flight.setBaseFare(sc.nextDouble());
		System.out.println("================================================================================");
		
		return flight;
	}
	
	public static void showFlight() {
		System.out.print("Enter Flight Id -> ");
		Flight flight = flightService.getFlight(sc.nextInt());
		
		if(flight == null) {
			System.out.println("!Not Found");
			return;
		}
		printFlight(flight);
	}
	
	public static void printFlight(Flight flight) {
		System.out.println("================================================================================");
		System.out.println("Id - " + flight.getId());
		System.out.println("Departure Airport - " + flight.getDepartureAirport());
		System.out.println("Arrival Airport - " + flight.getArrivalAirport());
		System.out.println("Departure Date - " + parseDateToString(flight.getDepartureDate()));
		System.out.println("Arrival Date - " + parseDateToString(flight.getArrivalDate()));
		System.out.println("Departure Time - " + parseTimeToString(flight.getDepartureTime()));
		System.out.println("Arrival Time - " + parseTimeToString(flight.getArrivalTime()));
		System.out.println("Total Number of Seats - " + flight.getTotalSeat());
		System.out.println("Allocated Number of Seats - " + flight.getAllocatedSeat());
		System.out.println("Base Fare - " + flight.getBaseFare());
		System.out.println("================================================================================");
	}
	
	public static void UpdateFlightOperation() {
		System.out.print("Enter Flight Id -> ");
		Flight flight = flightService.getFlight(sc.nextInt());
		
		if(flight == null) {
			System.out.println("!Not Found");
			return;
		}
		
		int input = 0;
		boolean active = true;
		while (active) {
			System.out.println("================================================================================");
			System.out.println("1. Update Departure Airport");
			System.out.println("2. Update Arrival Airport");
			System.out.println("3. Update Departure Date");
			System.out.println("4. Update Arrival Date");
			System.out.println("5. Update Departure Time");
			System.out.println("6. Update Arrival Time");
			System.out.println("7. Update Total Number of Seats");
			System.out.println("8. Update Available Number of Seats");
			System.out.println("9. Update Base Fare");
			System.out.println("10. Save");
			System.out.println("11. Cancel");
			System.out.print("Enter Choice -> ");
			input = sc.nextInt();

			switch (input) {
			case 1:
				flight.setDepartureAirport(updateDepartureAirport());
				break;
			case 2:
				flight.setArrivalAirport(updateArrivalAirport());
				break;
			case 3:
				flight.setDepartureDate(updateDepartureDate());
				break;
			case 4:
				flight.setArrivalDate(updateDepartureDate());
				break;
			case 5:
				flight.setDepartureTime(updateDepartureTime());
				break;
			case 6:
				flight.setArrivalTime(updateArrivalTime());
				break;
			case 7:
				flight.setTotalSeat(updateTotalSeats());
				break;
			case 8:
				flight.setAllocatedSeat(updateAllocatedSeats());
				break;
			case 9:
				flight.setBaseFare(updateBaseFare());
				break;
			case 10:
				flightService.updateFlight(flight);
				flightOperation();
				break;
			case 11:
				flightOperation();
				break;
			default:
				System.out.println("Invalid Input");
			}

			System.out.println("================================================================================");
		}
	}
	
	
	public static String updateDepartureAirport() {
		String departureAirport = null;
		sc.nextLine();
		System.out.println("================================================================================");
		System.out.print("Enter Departure Airport -> ");
		departureAirport = sc.nextLine();
		System.out.println("================================================================================");
		return departureAirport;
	}
	
	public static String updateArrivalAirport() {
		String arrivalAirport = null;
		sc.nextLine();
		System.out.println("================================================================================");
		System.out.print("Enter Arrival Airport -> ");
		arrivalAirport  = sc.nextLine();
		System.out.println("================================================================================");
		return arrivalAirport ;
	}
	
	public static Date updateDepartureDate() {
		Date departureDate = null;
		sc.nextLine();
		System.out.println("================================================================================");
		System.out.print("Enter Departure Date [DD/MM/YYYY] -> ");
		departureDate = parseStringToDate(sc.nextLine());
		System.out.println("================================================================================");
		return departureDate;
	}
	
	public static Date updateArrivalDate() {
		Date arrivalDate = null;
		sc.nextLine();
		System.out.println("================================================================================");
		System.out.print("Enter Arrival Date [DD/MM/YYYY] -> ");
		arrivalDate = parseStringToDate(sc.nextLine());
		System.out.println("================================================================================");
		return arrivalDate;
	}
	
	public static Date updateDepartureTime() {
		Date departureTime = null;
		sc.nextLine();
		System.out.println("================================================================================");
		System.out.print("Enter Departure Time [HH:MM (AM/PM)] -> ");
		departureTime = parseStringToTime(sc.nextLine());;
		System.out.println("================================================================================");
		return departureTime;
	}
	
	public static Date updateArrivalTime() {
		Date arrivalTime = null;
		sc.nextLine();
		System.out.println("================================================================================");
		System.out.print("Enter Arrival Time [HH:MM (AM/PM)] -> ");
		arrivalTime = parseStringToTime(sc.nextLine());;
		System.out.println("================================================================================");
		return arrivalTime;
	}
	
	public static int updateTotalSeats() {
		int totalSeat = 0;
		sc.nextLine();
		System.out.println("================================================================================");
		System.out.print("Enter Total Number of Seats -> ");
		totalSeat = sc.nextInt();
		System.out.println("================================================================================");
		return totalSeat;
	}
	
	public static int updateAllocatedSeats() {
		int allocatedSeat = 0;
		sc.nextLine();
		System.out.println("================================================================================");
		System.out.print("Enter Allocated Number of Seats -> ");
		allocatedSeat = sc.nextInt();
		System.out.println("================================================================================");
		return allocatedSeat;
	}
	
	public static double updateBaseFare() {
		double baseFare = 0;
		sc.nextLine();
		System.out.println("================================================================================");
		System.out.print("Enter Base Fare -> ");
		baseFare = sc.nextDouble();
		System.out.println("================================================================================");
		return baseFare;
	}
	
	
	public static void deleteFlight() {
		System.out.print("Enter Flight Id -> ");
		Flight flight = flightService.getFlight(sc.nextInt());
		
		if(flight == null) {
			System.out.println("!Not Found");
			return;
		}
		
		flightService.deleteFlight(flight);
	}
	
	
	public static void bookingOperation() { 
		int input = 0;
		boolean active = true;
		while (active) {
			System.out.println("================================================================================");
			System.out.println("===================================[ Booking ]==================================");
			System.out.println("================================================================================");
			System.out.println("1. Create Booking");
			System.out.println("2. Show Booking");
			System.out.println("3. Update Booking");
			System.out.println("4. Delete Booking");
			System.out.println("5. To getback to the main menu");
			System.out.print("Enter Choice -> ");
			input = sc.nextInt();

			switch (input) {
			case 1:
				createBooking();
				break;
			case 2:
				showBooking();
				break;
			case 3:
				updateBooking();
				break;
			case 4:
				deleteBooking();
				break;
			case 5:
				mainOperation();
				break;
			default:
				System.out.println("Invalid Input");
			}

			System.out.println("================================================================================");
		}
	}
	
	public static void createBooking() {
		System.out.println("================================================================================");
		System.out.print("Enter Passenger Id -> ");
		Passenger passenger = passengerService.getPassenger(sc.nextInt());
		
		if(passenger == null) {
			System.out.println("!Not Found");
			return;
		}
		
		Flight flight = searchFlight();
		
		if(flight == null) {
			System.out.println("!Not Found");
			return;
		}

		
		int seatsNumber = intInput(0, flight.getTotalSeat(), "Enter Number of Seats");
		int availableSeat = flight.getTotalSeat() - flight.getAllocatedSeat();
		double amount = 0;
		
		if(seatsNumber <= availableSeat) {
			Booking booking = new Booking();
			booking.setPassenger(passenger);
			booking.setFlight(flight);
			
			List<Seat> sList = new ArrayList<>();
			for(int i = 0; i < seatsNumber; i++) {
				sList.add(new Seat());
			}
			booking.setSeats(sList);
			
			Payment payment = new Payment();
			payment.setPaymentDate(new Date());
			
			amount = flight.getBaseFare() * seatsNumber;
			payment.setPaymentAmount(amount);
			sc.nextLine();
			System.out.println("Booking Amount - " + amount);
			System.out.print("Enter Payment Method [UPI, Cash, Credit Card, Debit Card] -> ");
			payment.setPaymentMethod(sc.nextLine());
			payment.setPayementStatus("Completed");
			payment.setBooking(booking);

			booking.setPayment(payment);
			booking.setBookingDate(new Date());
			
			System.out.print("Confirm Booking [yes, no] -> ");
			String choice = sc.nextLine();
			if(choice.equalsIgnoreCase("yes")) {
				bookingService.createBooking(booking);
				
				flight.setAllocatedSeat(flight.getAllocatedSeat() + seatsNumber);
				flightService.updateFlight(flight);
				
				System.out.println(booking);
				
				System.out.println("Booking Done");
			}else {
				System.out.println("Booking Cancelled");
			}
			
		}else {
			System.out.println(seatsNumber + " Seats are not Available");
		}
		System.out.println("================================================================================");
	}
	
	public static Flight searchFlight() {
		Flight flight = null;
		
		int input = 0;
		boolean active = true;
		while (active) {
			System.out.println("================================================================================");
			System.out.println("================================[ Search Flight ]===============================");
			System.out.println("================================================================================");
			
			System.out.println("1. Search By Id");
			System.out.println("2. Search By Departure Airport");
			System.out.println("3. Search By Arrival Airport");
			System.out.println("4. Search By Departure Airport And Arrival Airport");

			System.out.print("Enter Choice -> ");
			input = sc.nextInt();

			switch (input) {
				case 1:
					flight = searchFlightById();
					active = false;
					break;
				case 2:
					flight = searchFlightByDepartureAirport();
					active = false;
					break;
				case 3:
					flight = searchFlightByArrivalAirport();
					active = false;
					break;
				case 4:
					flight = searchFlightByDepartureAndArrivalAirport();
					active = false;
					break;
				default:
					System.out.println("Invalid Input");
			}

			System.out.println("================================================================================");
		}
		
		return flight;
	}
	
	public static Flight searchFlightById() {
		System.out.print("Enter Flight Id -> ");
		return flightService.getFlight(sc.nextInt());
	}
	
	public static Flight searchFlightByDepartureAirport() {
		sc.nextLine();
		System.out.print("Enter Departure Airport -> ");
		List<Flight> fList = flightService.getFlightsByDepartureAirport(sc.nextLine());
		return flightSelector(fList);
	}
	
	public static Flight searchFlightByArrivalAirport() {
		sc.nextLine();
		System.out.print("Enter Arrival Airport -> ");
		List<Flight> fList = flightService.getFlightsByArrivalAirport(sc.nextLine());
		return flightSelector(fList);
	}
	
	public static Flight searchFlightByDepartureAndArrivalAirport() {
		sc.nextLine();
		String departureAirport = null;
		String arrivalAirport = null;
		System.out.print("Enter Departure Airport -> ");
		departureAirport = sc.nextLine();
		System.out.print("Enter Arrival Airport -> ");
		arrivalAirport = sc.nextLine();
		List<Flight> fList = flightService.getFlightsByDepartureAndArrivalAirport(departureAirport, arrivalAirport);
		return flightSelector(fList);
	}
	
	public static int intInput(int minimum, int maximum, String placeholder) {
		System.out.print(placeholder + " -> ");
		int number = sc.nextInt();
		if(number > minimum && number < maximum) {
			return number;
		}else {
			System.out.println("!Not Valid");
			return intInput(minimum, maximum, placeholder);
		}
	}
	
	public static Flight flightSelector(List<Flight> fList) {
		if(fList.size() == 0) {
			return null;
		}
		
		for(int i = 0; i < fList.size(); i++) {
			System.out.println((i + 1) + " - "+fList.get(i));
		}
	
		int number = intInput(0, fList.size() + 1,"Enter Flight Number");
		
		return fList.get(number - 1);
	}
	
	public static void showBooking() {
		System.out.print("Enter Booking Id -> ");
		Booking booking = bookingService.getBooking(sc.nextInt());
		
		if(booking == null) {
			System.out.println("!Not Found");
			return;
		}
		
		System.out.println(booking);
		
		System.out.println("================================================================================");
		System.out.println("Booking Id - " + booking.getId());
		System.out.println("Booking Date - " + parseDateToString(booking.getBookingDate()));
		System.out.println("================================================================================");
		System.out.println("==== Passenger");
		printPassenger(booking.getPassenger());
		System.out.println("==== Flight");
		printFlight(booking.getFlight());
		System.out.println("==== Payment");
		printPayment(booking.getPayment());
		System.out.println("==== Seats");
		System.out.println(booking.getSeats());
		System.out.println("================================================================================");
	}
	
	public static void printPayment(Payment payment) {
		System.out.println("================================================================================");
		System.out.println("Id - " + payment.getId());
		System.out.println("Payment Amount - " + payment.getPaymentAmount());
		System.out.println("Payment Method - " + payment.getPaymentMethod());
		System.out.println("Payement Status - " + payment.getPayementStatus());
		System.out.println("Payment Date - " + parseDateToString(payment.getPaymentDate()));
		System.out.println("================================================================================");
	}
	
	public static void updateBooking() {
		System.out.print("Enter Booking Id -> ");
		Booking booking = bookingService.getBooking(sc.nextInt());
		
		if(booking == null) {
			System.out.println("!Not Found");
			return;
		}
		
		
		Flight flight = booking.getFlight();
		int seatsNumber = intInput(0, flight.getTotalSeat(), "Enter Number of Seats");
		int availableSeat = flight.getTotalSeat() - flight.getAllocatedSeat();
		int bookedSeat = booking.getSeats().size();
		double amount = 0;
		int seats = 0;
		if(seatsNumber == bookedSeat) {
			return;
		}
		
		Payment payment = booking.getPayment();
		List<Seat> sList = booking.getSeats();
		System.out.println(sList);
		if(seatsNumber < bookedSeat) {
			for(int i = 1; i <= (bookedSeat - seatsNumber); i++) {
				sList.remove(i);
			}
			seats = seatsNumber;
			booking.setSeats(sList);

			amount = seatsNumber * flight.getBaseFare();
			System.out.println("New Booking Amount - " + amount);
			payment.setPaymentAmount(amount);
			System.out.println("Left Booking Amount will be Return - " + (bookedSeat - seatsNumber) * flight.getBaseFare());
		}else {
			seatsNumber = seatsNumber - bookedSeat;
			if(seatsNumber <= availableSeat) {
				for(int i = 0; i < seatsNumber; i++) {
					sList.add(new Seat());
				}
				seats = flight.getAllocatedSeat() + seatsNumber;
			
				System.out.println("Previous Booking Amount - " + payment.getPaymentAmount());
				amount = (flight.getBaseFare() * seatsNumber) + payment.getPaymentAmount();
				System.out.println("New Booking Amount - " + amount);
				payment.setPaymentAmount(amount);
				System.out.print("Enter Payment Method [UPI, Cash, Credit Card, Debit Card] -> ");
				payment.setPaymentMethod(sc.nextLine());
			}
			else {
				System.out.println(seatsNumber + " Seats are not Available");
			}
		}
		booking.setSeats(sList);
		
		sc.nextLine();
		System.out.print("Confirm Booking [yes, no] -> ");
		String choice = sc.nextLine();
		
		if(choice.equalsIgnoreCase("yes")) {
			bookingService.updateBooking(booking);
			
			flight.setAllocatedSeat(seats);
			flightService.updateFlight(flight);
			
			System.out.println(booking);
			
			System.out.println("Booking Done");
		}else {
			System.out.println("Booking Cancelled");
		}
	}
	
	
	public static void deleteBooking() {
		System.out.print("Enter Booking Id -> ");
		Booking booking = bookingService.getBooking(sc.nextInt());
		
		if(booking == null) {
			System.out.println("!Not Found");
			return;
		}
		
		Flight flight = booking.getFlight();
		flight.setAllocatedSeat(flight.getAllocatedSeat() - booking.getSeats().size());
		
		flightService.updateFlight(flight);
		
		bookingService.deleteBooking(booking);
		System.out.println("Booking Deleted");
	}

}