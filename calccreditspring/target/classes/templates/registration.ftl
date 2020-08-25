<#import "parts/common.ftl" as c>
<#import "parts/login.ftl" as l>
<@c.page>

<p class="text-primary">Новый пользователь добавлен</p>
${usr!""}

<@l.login "/registration"/>
</@c.page>