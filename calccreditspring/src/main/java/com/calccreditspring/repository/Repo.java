package com.calccreditspring.repository;

import com.calccreditspring.domain.BazaSQL;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface Repo extends CrudRepository<BazaSQL, Integer>
{
    /*репозиторий позволяет найти полный список полей, либо по идентификатору.*/
    /*Добавим метод findByPaymentType для создания фильтра по типу платежа,
    * необходимая инфа по ключевому слову find есть по адресу
     * https://docs.spring.io/spring-data/jpa/docs/1.5.0.RELEASE/reference/html/jpa.repositories.html#jpa.query-methods.query-creation*/
    List<BazaSQL>findByPaymentType(Integer paymentType);





}
