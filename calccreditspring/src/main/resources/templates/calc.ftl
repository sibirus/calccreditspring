<#import "parts/common.ftl" as c>
<@c.page>

    <tbody>
    <div>
        <h4>
            <p class="text-primary">График платежей</p>
        </h4>

    </div>


    <table class="table table-hover">


    <thead class="thead-light">
        <tr>
            <th scope="col">№</th>
            <th scope="col">Дата платежа</th>
            <th scope="col">Платеж в месяц</th>
            <th scope="col">Сумма в тело кредита</th>
            <th scope="col">Сумма в % кредита</th>
            <th scope="col">Остаток</th>
        </tr>
    </thead>
        <tbody>

        <#list exit as ex>
        <tr>
            <td>${ex.countNumber}</td>
            <td>${ex.dateFinall}</td>
            <td>${ex.paymentA}</td>
            <td>${ex.bodyCredit}</td>
            <td>${ex.paymentPersent}</td>
            <td>${ex.debit}</td>


        </tr>
        </#list>

    </table>



    <input type="button" class="btn btn-outline-primary" onclick="history.back();" value="Назад"/>



    </tbody>
</@c.page>