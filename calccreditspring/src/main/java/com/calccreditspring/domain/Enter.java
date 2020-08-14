package com.calccreditspring.domain;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;


public class Enter
{
    private List<String> exitData = new ArrayList<>();//сохраняем все расчитанные данные сюда

    private List<Enter> dao=new ArrayList<Enter>();//05/07



    //**************************************************
    private SimpleDateFormat dt = new SimpleDateFormat("dd.MM.yyyy");//дата
    private SimpleDateFormat dtTwo = new SimpleDateFormat("dd.MM.yyyy");
    private Date parsingDate = null;
    private String dateFinall;



    //**************************************************

    private Double sizeCredit;//размер кредита
    private Double sizePayment;//размер первоначального взноса
    private Double creditPeriod;//в месяцах, срок кредитования
    private Integer paymentType;//тип платежа 0-аннуитентный, 1-дифференцированный
    private String startDate;//срок начала платежа, дата
    private Double rate;//ставка,% по кредиту

    //**************************************************
    private double countNumber = 0;
    private double paymentA;//ануитентный платеж
    private double paymentD;//дифф.платеж
    private double paymentPersent;//погашение по процентам
    private double bodyCredit;//погашение тела кредита
    private double summ = 0;//общая сумма, по погашению основной задолжности
    private double debit;
    private double remains;//остаток
    private GregorianCalendar finall = new GregorianCalendar(Calendar.DAY_OF_MONTH, Calendar.MONTH, Calendar.YEAR);

    //**************************************************


    public List<String> getExitData() {
        return exitData;
    }

    public void setExitData(List<String> exitData) {
        this.exitData = exitData;
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

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public Double getRate() {
        return rate;
    }

    public void setRate(Double rate) {
        this.rate = rate;
    }

    //**************************************************


    public Enter(List<String> exitData) {
        this.exitData = exitData;
    }

    //**************************************************

    public Enter(Double sizeCredit, Double sizePayment, Double creditPeriod, Integer paymentType, String startDate, Double rate)
    {
        this.sizeCredit = sizeCredit;
        this.sizePayment = sizePayment;
        this.creditPeriod = creditPeriod;
        this.paymentType = paymentType;
        this.startDate = startDate;
        this.rate = rate;
    }

    public Enter()
    {

    }

    public Enter(double countNumber, String dateFinall, double paymentA, double bodyCredit,double paymentPersent, double debit) {
        this.countNumber = countNumber;
        this.paymentA = paymentA;
        this.paymentPersent = paymentPersent;
        this.bodyCredit = bodyCredit;
        this.debit = debit;
        this.dateFinall = dateFinall;
    }



    //**************************************************



    public List<Enter> Count()
    {
        try {
            parsingDate = dt.parse(startDate);//срок начала платежа, месяц
            finall.setTime(parsingDate);


            if (paymentType == 0) {
                double x = rate / 100 / 12;
                for (int i = 0; i < creditPeriod; i++) {
                    if (i == 0) {
                        sizeCredit = sizeCredit - sizePayment;
                    }

                    remains = sizeCredit - summ;

                    paymentA = sizeCredit * (x + (x / (Math.pow((1 + x), creditPeriod) - 1)));
                    paymentPersent = x * remains;
                    bodyCredit = paymentA - paymentPersent;
                    debit = remains - bodyCredit;
                    if (debit < 0) {
                        debit = 0;
                    }
                    summ = summ + bodyCredit;
                    countNumber++;
                    if (i != 0) {
                        finall.add(Calendar.MONTH, 1);
                    }

                    //exitData.add(String.valueOf(countNumber + ";" + (dtTwo.format(finall.getTime())) + ";" + paymentA + ";" + bodyCredit + ";" + paymentPersent + ";" + debit));
                    dateFinall=dtTwo.format(finall.getTime());
                    Enter daoX=new Enter(countNumber,dateFinall,paymentA,bodyCredit,paymentPersent,debit);
                    dao.add(daoX);


                }
            }

            //**************************************************

            if (paymentType == 1) {
                sizeCredit = sizeCredit - sizePayment;
                bodyCredit = sizeCredit / creditPeriod;
                double x = rate / 100 / 12;
                for (int i = 0; i < creditPeriod; i++) {

                    remains = sizeCredit - summ;
                    paymentPersent = x * remains;
                    summ = summ + bodyCredit;
                    paymentD = bodyCredit + paymentPersent;
                    debit = remains - bodyCredit;
                    if (debit < 0) {
                        debit = 0;
                    }
                    countNumber++;
                    if (i == 0) {
                        dtTwo.format(finall.getTime());
                    } else {
                        finall.add(Calendar.MONTH, 1);
                        dtTwo.format(finall.getTime());
                    }
                    //exitData.add(String.valueOf(countNumber + ";" + (dtTwo.format(finall.getTime())) + ";" + paymentD + ";" + bodyCredit + ";" + paymentPersent + ";" + debit));
                    dateFinall=dtTwo.format(finall.getTime());
                    Enter daoX=new Enter(countNumber,dateFinall,paymentD,bodyCredit,paymentPersent,debit);
                    dao.add(daoX);


                }
            }

        } catch (ParseException x) {

        }
        //**************************************************

        return dao;
    }

    }
