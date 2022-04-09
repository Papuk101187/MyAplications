<!-- регистрация пользователя  -->

<#macro registration path>
<form action="${path}" method="post">
    <div><label> Login : <input type="text" name="login" required /> </label></div>
    <div><label> Password : <input type="password" name="password" required /> </label></div>
    <div><label><button name="type" value="customer"> Я продавец </button> </label></div>
    <div><label><button name="type" value="seller">Я покупатель </button> </label></div>
</form>
</#macro>



<!-- авторизация пользователя  -->
<#macro authorization>
    <form method="post">
        <div class="form-group">
            <label for="username">Username</label>
            <input type="text" class="form-control" id="username" placeholder="Username"
                   name="username">
        </div>
        <div class="form-group">
            <label for="password">Password</label>
            <input type="password" class="form-control" id="password" placeholder="Password"
                   name="password">
        </div>
        <button type="submit" class="btn btn-default">Log in</button>
    </form>
</#macro>

