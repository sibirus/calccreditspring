<!--Что бы использовать макрос, нужно импортировать шаблон, присвоив ему переменную (as c)-
после можно подгружать макрос -@c.page--->
<#import "parts/common.ftl" as c>
<@c.page>
<div>
    <h4>
        <p class="text-primary">Кредитный калькулятор</p>
    </h4>
    <a href="/greeting" class="badge badge-primary">Главная страница</a>

</div>
</@c.page>