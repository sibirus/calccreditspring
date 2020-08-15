package com.calccreditspring.domain;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity//это не просто кусок когда, а сущность, которая говорит, что положить в базу
public class BazaSQL
{
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer id;
    /*поле ID у нас будет идентификатором, зачем нужен идентификатор,
    что бы различать две записи в одной таблице, @GeneratedValue говорит как будет
    генерироваться идентификатор*/

    private Double sizeCredit;//размер кредита
    private Double sizePayment;//размер первоначального взноса
    private Double creditPeriod;//в месяцах, срок кредитования
    private Integer paymentType;//тип платежа 0-аннуитентный, 1-дифференцированный
    private Double rate;//ставка,% по кредиту

    //Геттеры и сеттеры


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Double getSizeCredit() {
        return sizeCredit;
    }

    public void setSizeCredit(Double sizeCredit) {
        this.sizeCredit = sizeCredit;
    }

    public Double getSizePayment() {
        return sizePayment;
    }

    public void setSizePayment(Double sizePayment) {
        this.sizePayment = sizePayment;
    }

    public Double getCreditPeriod() {
        return creditPeriod;
    }

    public void setCreditPeriod(Double creditPeriod) {
        this.creditPeriod = creditPeriod;
    }

    public Integer getPaymentType() {
        return paymentType;
    }

    public void setPaymentType(Integer paymentType) {
        this.paymentType = paymentType;
    }





    public Double getRate() {
        return rate;
    }

    public void setRate(Double rate) {
        this.rate = rate;
    }

    // *******************************

    //Конструктор


    public BazaSQL(Double sizeCredit, Double sizePayment, Double creditPeriod, Integer paymentType, Double rate) {
        this.sizeCredit = sizeCredit;
        this.sizePayment = sizePayment;
        this.creditPeriod = creditPeriod;
        this.paymentType = paymentType;
        this.rate = rate;
    }

    public BazaSQL()
    {

    }
}



