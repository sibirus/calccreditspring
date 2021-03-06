package com.calccreditspring.controller;


import com.calccreditspring.domain.BazaSQL;
import com.calccreditspring.domain.Enter;
import com.calccreditspring.repository.Repo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.*;


@Controller
public class GreetingController
{

    @Autowired
    private Repo repo;
    /*
    Autowired получает бин из репозитория, который генерируется spring
     */
    @GetMapping("baza")
    public String mainBaza ( Map<String, Object> model)
    {
        Iterable <BazaSQL> baza=repo.findAll();
        model.put("baza",baza);
        return "mainBaza";
    }
    @GetMapping("/")
    public String main(Map<String, Object> model)
    {
        return "main";
    }


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
        /*Отправляем данные в нашу базу*/
        BazaSQL bazaSQL=new BazaSQL(sizeCredit, sizePayment, creditPeriod, paymentType, rate);
        repo.save(bazaSQL);



        /*Выполняем логику для отображения графика*/
        Enter enter = new Enter(sizeCredit, sizePayment, creditPeriod, paymentType, startDate, rate);
        List<Enter> exit = enter.Count();
        model.put("exit", exit);


        return "calc";
    }

    /*Обработаем фильтр*/
    @PostMapping("filter")
    public String filter (@RequestParam Integer filter, Map<String, Object> model )
    {
        Iterable <BazaSQL> baza;
        /*Если ввод не пустой, то ищем по фильтру, иначе выводим все*/
        if(filter!=null)
        {
            baza = repo.findByPaymentType(filter);
        }
        else
        {
            baza=repo.findAll();
        }
        model.put("baza", baza);

        return "mainBaza";
    }


}
