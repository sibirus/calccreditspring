package com.calccreditspring;


import domain.Enter;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.GregorianCalendar;
import java.util.List;
import java.util.Map;

@Controller
public class GreetingController
{
    @GetMapping("/greeting")

    public String greeting()
    {
        return "greeting";
    }
    @PostMapping("calc")
    public String calc (
            @RequestParam Double sizeCredit,
            @RequestParam Double sizePayment,
            @RequestParam Double creditPeriod,
            @RequestParam Integer paymentType,
            @RequestParam String startDate,
            @RequestParam Double rate,


            Map<String, Object> model )
    {
        Enter enter = new Enter(sizeCredit, sizePayment, creditPeriod, paymentType, startDate, rate);
        List<String> exit = enter.Count();
        model.put("exit", exit);
        return "calc";
    }

}
