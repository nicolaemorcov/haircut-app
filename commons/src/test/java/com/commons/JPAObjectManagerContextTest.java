package com.commons;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.ParseException;
import java.util.List;
import java.util.Properties;import javax.persistence.Query;

import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import com.commons.entities.Booking;
import com.commons.entities.Customer;
import com.commons.entities.User;
import com.commons.manager.ApplicationManagerContext;
import com.commons.manager.objectmanagers.DBObjectManager;
import com.commons.manager.objectmanagers.DataAccessObject;
import com.commons.manager.objectmanagers.ObjectManagerContext;
import com.commons.service.BookingService;
import com.commons.service.UserService;

public class JPAObjectManagerContextTest {

	ApplicationManagerContext appManager;
	DBObjectManager dbManager;
	ObjectManagerContext objectManager;
	UserService us;
	


	@Before
	public void setUp() throws Exception {
		System.out.println("testing...");
		appManager = new ApplicationManagerContext();
		dbManager = new DBObjectManager(appManager);
		objectManager = new DataAccessObject(appManager, dbManager);
		dbManager.createMasterDBFactory();
	}

	@After
	public void tearDown() throws Exception {
		appManager = null;
		dbManager = null;
		objectManager = null;
	}
//	@Test
//	@Ignore
//	public void deleteBooking() {
//		BookingService bs = new BookingService(objectManager);
//		List<Booking> bookings = bs.getAllBookings();
//		for(int i = 0 ;i < bookings.size(); i++) {
//			Booking b = bookings.get(i);
//			objectManager.delete(b);
//		}
		
		
//	}
	
	
//	
	@Test
	@Ignore
	public void deleteUserByEmailTest() {
		UserService service = new UserService(objectManager);
		User user = service.findUserByEmail("ionrovcom@gmail.com");
		service.deleteUser(user);
		System.out.println("User deleted");
	}
	
	@Test
	@Ignore
	public void deleteBookingByCustId() {
		BookingService bs = new BookingService(objectManager);
		List<Booking> bookings = bs.findAllBookingsById(19);
		
		for (int i = 0; i < bookings.size(); i++) {
			Booking b = bookings.get(i);
			bs.deleteBooking(b);
		}
		System.out.println("Booking deleted");
	}
	
	
	
	@Test
	@Ignore
	public void findUserByEmailTest() {
		UserService us = new UserService(objectManager);
		
		System.out.println("searching for user");
		User user = us.findUserByEmail("galea88@gmail.com");
		System.out.println(user.getEmail() + ",  " + user.getFirstName());
	}
	
	//===========Kolia=============
	@Test
	@Ignore
	public void findBookingByIdTest() {
		BookingService bs = new BookingService(objectManager);
		
		System.out.println("searching for booking");
		List<Booking> bookings = bs.findAllBookingsById(20);
		for (int i = 0; i < bookings.size(); i++) {
			Booking b = bookings.get(i);
			System.out.println(b.getCustomerId() + ", " + b.getDateDue() + ", " + b.getBookingPrice());
			
		}
	}
	
//	=============KOLIA===============================
	@Test
	@Ignore
	public void findUserByIdTest() {
		UserService service = new UserService(objectManager);
		System.out.println("searching for user");
		User user = service.findUserById(13);
		System.out.println(user.getFirstName() + ", " + user.getLastName());
	
	}
	
	@Test
	@Ignore
	public void createCustomerTest()  {
		User c1;
		try {
			System.out.println("saving the object");
			c1 = new User("Jklm", "iokkk999", "Jimmy", "Todesky", "jt@rmk.com", "12/6/1982");

			dbManager.createMasterDBFactory();
			objectManager.persist(c1);
			System.out.println("saved to db...");
		} catch (ParseException e) {
			System.out.println(e);
		}
	}
	
//	=============Kolia==========================
	@Test
	@Ignore
	public void createBookingTest() {
		Booking b1;
		try {
			System.out.println("saving the object");
			b1 = new Booking(112, 22, "30/03/2018", "12:00", 13.00);
			dbManager.createMasterDBFactory();
			objectManager.persist(b1);
			System.out.println("booking saved to db...");
		}catch (ParseException e) {
			System.out.println(e);
		}
	}
	
	@Ignore
	@Test
	public void readPropertiesFile() {
		Properties kwMappingProperties = new Properties();
		
		try {
			kwMappingProperties.load(new FileInputStream("src/main/resources/kw_mapping.properties"));
			System.out.println(
					kwMappingProperties.getProperty("46B6488DD72C62D1E10000000A1553F7"));
			
		} catch (FileNotFoundException e) {
			System.out.println(e);
		} catch (IOException e) {
			System.out.println(e);
		}
		System.out.println("temp test");
	}
	
	
	@Test
	@Ignore
	public void updateUserFirstNameTest() {
		UserService service = new UserService(objectManager);
		System.out.println("searching for user");
		User user = service.findUserByEmail("jt@rmk.com");
		user.setFirstName("Jimmy");
		service.updateFirstName(user);
		System.out.println("User updated....");
	} 
	
	@Test
//	@Ignore
	public void changeDateTimeTest() {
		BookingService bs = new BookingService(objectManager);
		try {
			System.out.println("searching for booking");
			Booking booking = bs.findBookingById(22);
			booking.setDateDue("3/04/2018");
			booking.setBookingTime("15:40");
			bs.changeDateTime(booking);
		}catch (ParseException e) {
			System.out.println(e);
		}
	} 
	
	
//	@Test
//	public void tempTest() {
//		 String url = "http://www.%20test.com/home/user/";
//		    String decoded;
//			try {
//				decoded = URLDecoder.decode(url, "UTF-8");
//				
//				System.out.println(decoded);
//			} catch (UnsupportedEncodingException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//		    
//	}

}
