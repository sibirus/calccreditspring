<#macro filter fil>
    <form action="${fil}" method="post">
        <input type="hidden" name="_csrf" value="${_csrf.token}" />
        <div class="input-group input-group-sm mb-3">
            <div class="input-group-prepend">
                <span class="input-group-text" id="basic-addon1">Фильтр по типу платежа</span>
            </div>
            <input type="number" name="filter" class="form-control" placeholder="Введи 0 или 1: 0 - аннуитетный, 1 - дифференцированный" aria-label="Введи 0 или 1: 0 - аннуитетный, 1 - дифференцированный" aria-describedby="basic-addon1">
        </div>

        <button type="submit" class="btn btn-outline-primary">Найти</button>
    </form>
</#macro>