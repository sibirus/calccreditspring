<#import "parts/common.ftl" as c>
<#import "parts/login.ftl" as l>
<@c.page>
<div>
    <@l.logout/>
</div>


<div>
    <h4>
        <p class="text-primary">Кредитный калькулятор</p>
    </h4>

</div>
<form method="post" action ="calc">
    <input type="hidden" name="_csrf" value="${_csrf.token}" />



<!---------------------------------->

    <div class="input-group input-group-sm mb-3">
        <div class="input-group-prepend">
            <span class="input-group-text" id="basic-addon1">Размер кредита</span>
        </div>
        <input type="number" step="0.001" name="sizeCredit" class="form-control" placeholder="введите данные" aria-label="введите данные" aria-describedby="basic-addon1">
    </div>
    <!---------------------------------->

    <div class="input-group input-group-sm mb-3">
        <div class="input-group-prepend">
            <span class="input-group-text" id="basic-addon1">Размер первоначального платежа</span>
        </div>
        <input type="number" step="0.001" name="sizePayment" class="form-control" placeholder="введите данные" aria-label="введите данные" aria-describedby="basic-addon1">
    </div>

    <!---------------------------------->

    <div class="input-group input-group-sm mb-3">
        <div class="input-group-prepend">
            <span class="input-group-text" id="basic-addon1">Срок кредитования</span>
        </div>
        <input type="number" step="0.001" name="creditPeriod" class="form-control" placeholder="месяцев" aria-label="месяцев" aria-describedby="basic-addon1">
    </div>

    <!---------------------------------->

    <div class="input-group input-group-sm mb-3">
        <div class="input-group-prepend">
            <span class="input-group-text" id="basic-addon1">Тип платежа</span>
        </div>
        <input type="number" step="0.001" name="paymentType" class="form-control" placeholder="Введи 0 или 1: 0 - аннуитетный, 1 - дифференцированный" aria-label="Введи 0 или 1: 0 - аннуитетный, 1 - дифференцированный" aria-describedby="basic-addon1">
    </div>

    <!---------------------------------->

    <div class="input-group input-group-sm mb-3">
        <div class="input-group-prepend">
            <span class="input-group-text" id="basic-addon1">Ставка</span>
        </div>
        <input type="number" step="0.001" name="rate" class="form-control" placeholder="%" aria-label="%" aria-describedby="basic-addon1">
    </div>

    <!---------------------------------->

    <div class="input-group input-group-sm mb-3">
        <div class="input-group-prepend">
            <span class="input-group-text" id="basic-addon1">Срок начала платежа</span>
        </div>
        <input type="text" name="startDate" class="form-control" placeholder="ДД.ММ.ГГ" aria-label="ДД.ММ.ГГ" aria-describedby="basic-addon1">
    </div>
    <!---------------------------------->

    <button type="submit" class="btn btn-outline-primary">Рассчитать</button>
    <p>&nbsp;</p>



</form>

<form method="GET" action ="baza">
    <input type="hidden" name="_csrf" value="${_csrf.token}" />
    <button type="submit" class="btn btn-outline-primary">История</button>

</form>
</@c.page>