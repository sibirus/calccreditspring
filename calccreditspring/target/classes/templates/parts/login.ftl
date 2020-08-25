<!--Создали макрос, который называется логин и имеет параметр path-->
<#macro login path>
    <form action="${path}" method="post">
        <div class="form-group">
            <label for="Username">Username</label>
            <input type="text" name="username" class="form-control" id="Username" placeholder="Enter username">

        </div>
        <div class="form-group">
            <label for="Password1">Password</label>
            <input type="password" name="password" class="form-control" id="Password1" placeholder="Password">
        </div>
        <input type="hidden" name="_csrf" value="${_csrf.token}" />
        <button type="submit" class="btn btn-primary">Войти в систему</button>
    </form>
</#macro>



<!--Добавим макрос для Выхода из системы-->
<#macro logout>
    <form action="/logout" method="post">
        <button type="submit" class="btn btn-primary">Выйти из системы</button>
        <input type="hidden" name="_csrf" value="${_csrf.token}" />

    </form>
</#macro>