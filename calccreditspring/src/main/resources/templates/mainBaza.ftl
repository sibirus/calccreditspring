<#import "parts/common.ftl" as c>
<#import "parts/filter.ftl" as l>
<@c.page>

<tbody>
<div>
    <h4>
        <p class="text-primary">История ввода</p>
    </h4>
    <input type="button" class="btn btn-outline-primary" onclick="history.back();" value="Назад"/>
    <p>&nbsp;</p>

</div>

<!--Добавим фильтр-->
<@l.filter "/filter"/>

<!---------------------------------->

<table class="table table-hover">


    <thead class="thead-light">
    <tr>

        <th scope="col">Размер кредита</th>
        <th scope="col">Размер первоначального взноса</th>
        <th scope="col">Срок кредитования</th>
        <th scope="col">Тип платежа</th>
        <th scope="col">ставка,% по кредиту</th>
    </tr>
    </thead>
    <tbody>
    <#list baza as bz>
        <tr>



            <td>${bz.sizeCredit}</td>
            <td>${bz.sizePayment}</td>
            <td>${bz.creditPeriod}</td>
            <td>${bz.paymentType}</td>
            <td>${bz.rate}</td>
        </tr>
    </#list>

</table>
</tbody>
</@c.page>