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

        // Obtener los datos de la solicitud
            String requestBody;
            try {
                
                requestBody = request.readBodyAsString();
                System.out.println(requestBody);
                ObjectMapper objectMapper = new ObjectMapper();
                Booking booking = objectMapper.readValue(requestBody, Booking.class);

                

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
}