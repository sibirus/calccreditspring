package domain;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;


public class Enter
{
    List<String> exitData = new ArrayList<>();//сохраняем все расчитанные данные сюда


    //**************************************************
    SimpleDateFormat dt = new SimpleDateFormat("dd.MM.yyyy");//дата
    SimpleDateFormat dtTwo = new SimpleDateFormat("dd.MM.yyyy");
    Date parsingDate = null;



    //**************************************************

    private Double sizeCredit;//размер кредита
    private Double sizePayment;//размер первоначального взноса
    private Double creditPeriod;//в месяцах, срок кредитования
    private Integer paymentType;//тип платежа 0-аннуитентный, 1-дифференцированный
    private String startDate;//срок начала платежа, дата
    private Double rate;//ставка,% по кредиту

    //**************************************************
    double countNumber = 0;
    double paymentA;//ануитентный платеж
    double paymentD;//дифф.платеж
    double paymentPersent;//погашение по процентам
    double bodyCredit;//погашение тела кредита
    double summ = 0;//общая сумма, по погашению основной задолжности
    double debit;
    double remains;//остаток
    GregorianCalendar finall = new GregorianCalendar(Calendar.DAY_OF_MONTH, Calendar.MONTH, Calendar.YEAR);

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

    //**************************************************

    public List<String> Count()
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

                    exitData.add(String.valueOf(countNumber + ";" + (dtTwo.format(finall.getTime())) + ";" + paymentA + ";" + bodyCredit + ";" + paymentPersent + ";" + debit));
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
                    exitData.add(String.valueOf(countNumber + ";" + (dtTwo.format(finall.getTime())) + ";" + paymentD + ";" + bodyCredit + ";" + paymentPersent + ";" + debit));
                }
            }

        } catch (ParseException x) {

        }
        return exitData;
    }

    }
