<!DOCTYPE html>
<html lang="en">

<body>



<form method="post">
    <input name="${_csrf.parameterName}" value="${_csrf.token}" type="hidden">
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




</body>
</html>