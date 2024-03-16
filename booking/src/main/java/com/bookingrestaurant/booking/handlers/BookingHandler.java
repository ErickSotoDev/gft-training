package com.bookingrestaurant.booking.handlers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.bookingrestaurant.booking.models.Booking;
import io.muserver.MuRequest;
import io.muserver.MuResponse;
import io.muserver.RouteHandler;


public class BookingHandler implements RouteHandler    {
    private static List<Booking> bookings;

    public BookingHandler() {
        BookingHandler.bookings = new ArrayList<>();
    }

    @Override
    public void handle(MuRequest request, MuResponse response, Map<String, String> pathParams)  {
        System.out.println("Recieved " + request + " from " + request.remoteAddress());
        System.out.println("****************************************************");

        
            String requestBody;
            try {
                
                requestBody = request.readBodyAsString();
                System.out.println(requestBody);
                ObjectMapper objectMapper = new ObjectMapper();
                Booking booking = objectMapper.readValue(requestBody, Booking.class);
                if (isBookingExists(booking)) {
                response.status(400);
                response.write("there is a booking for that date occupied");
                return;
            }
                

                bookings.add(booking);                
                response.write("Booking created successfully");
                
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            


        
        
    }
    public List<Booking> getBookings() {
        return bookings;
    }
    
    private boolean isBookingExists(Booking newBooking) {
        for (Booking existingBooking : bookings) {
            
            if (existingBooking.getDate().equals(newBooking.getDate()) &&
                existingBooking.getTime().equals(newBooking.getTime())) {
                return true; 
            }
        }
        return false;
    }
}