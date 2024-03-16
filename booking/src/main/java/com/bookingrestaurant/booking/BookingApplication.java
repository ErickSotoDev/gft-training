package com.bookingrestaurant.booking;





import com.bookingrestaurant.booking.handlers.BookingHandler;
import com.bookingrestaurant.booking.handlers.ViewBookingsHandler;

import io.muserver.Method;
import io.muserver.MuServer;
import io.muserver.MuServerBuilder;

public class BookingApplication {

    public static void main(String[] args) {
		BookingHandler bookingHandler = new BookingHandler();
        MuServer server = MuServerBuilder.httpServer()
            .addHandler(Method.POST, "/booking", new BookingHandler())
			.addHandler(Method.GET, "/bookings", new ViewBookingsHandler(bookingHandler.getBookings()))
            .start();  
            
        System.out.println("Server started at " + server.uri());
    }
}
