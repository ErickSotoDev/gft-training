package com.bookingrestaurant.booking.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class test {
@GetMapping("/index")
public String index(Model model) {
    return "index";
}


}
