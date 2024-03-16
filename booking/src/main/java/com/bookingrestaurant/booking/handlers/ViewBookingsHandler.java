package com.bookingrestaurant.booking.handlers;


import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.bookingrestaurant.booking.models.Booking;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.muserver.MuRequest;
import io.muserver.MuResponse;
import io.muserver.RouteHandler;

public class ViewBookingsHandler implements RouteHandler {
    private final List<Booking> bookings;

public ViewBookingsHandler() {
    this.bookings = null;
        
    }
    public ViewBookingsHandler(List<Booking> bookings) {
        this.bookings = bookings;
    }

    @Override
    public void handle(MuRequest request, MuResponse response, Map<String, String> pathParams)  {
        System.out.println("Recieved " + request + " from " + request.remoteAddress());
        System.out.println("****************************************************");

        String date = request.query().get("date");

            
            List<Booking> filteredBookings = new ArrayList<>();
            for (Booking booking : bookings) {
                if (booking.getDate().equals(date)) {
                    filteredBookings.add(booking);
                }
            }

            
            ObjectMapper objectMapper = new ObjectMapper();
            try {
                String json = objectMapper.writeValueAsString(filteredBookings);
                response.contentType("application/json");
                response.write(json);

            } catch (JsonProcessingException e) {
                
                e.printStackTrace();
            }
        
        
    }
}
