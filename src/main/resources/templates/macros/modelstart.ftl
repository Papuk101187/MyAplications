<#import "common.ftl" as c>

<@c.page>

    <form method="post">
        <input name="${_csrf.parameterName}" value="${_csrf.token}" type="hidden">
        <h3>Войти в аккаунт </h3>
        Логин: <input type="text" name="username"> <br>
        Пароль: <input type="password" name="password"> <br>
        <button type="submit" class="btn btn-default ">Отправить данные</button></p>
    </form>

    <form method="get" action="/main">
        <button type="submit"> Перейти к регистрации </button></p>
    </form>











</@c.page>