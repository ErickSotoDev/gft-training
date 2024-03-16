package com.bookingrestaurant.booking;



import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import io.muserver.Method;
import io.muserver.MuServer;
import io.muserver.MuServerBuilder;

@SpringBootApplication
public class BookingApplication {

	public static void main(String[] args) {
		MuServer server = MuServerBuilder.httpServer()
            .addHandler(Method.GET, "/", (request, response, pathParams) -> {
                response.write("Hello, world");
            })
            .start();
        System.out.println("Started server at " + server.uri());

	}
}