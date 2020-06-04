package com.calccreditspring;

//import com.simplecalculiator.simplecalculiator.domain.Enter;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

@Controller
public class GreetingController
{
    @GetMapping("/greeting")

    public String greeting()
    {
        return "greeting";
    }






}
