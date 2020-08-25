<#import "parts/common.ftl" as c>
<#import "parts/login.ftl" as l>
<@c.page>

<p class="text-primary">Страница входа</p>
<@l.login "/login"/>

<a href="/registration" class="badge badge-primary">Добавить нового пользователя</a>
</@c.page>
