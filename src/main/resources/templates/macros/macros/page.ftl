
<!-- страница для продавца  -->

<#macro seller>
    <!DOCTYPE html>
    <html lang="en">
    <head>
        <meta charset="UTF-8">
        <title>ДЛЯ ПРОДАВЦОВ </title>
    </head>
    <body>


    <form action="/adNotes" method="post">
        <div><label> Название товара : <input type="text" name="product" required/> </label></div>
        <div><label> Стоимость товара (ГРН) : <input type="text" name="price" required/> </label></div>
        <div><label> Описание товара: <input type="text" name="description" required/> </label></div>
        <div><input type="hidden" name="flag" value="seller"></div>
        <input type="submit" value="Выставить на продажу "/>
    </form>


    <#nested>
    </body>
    </html>
</#macro>


<!-- страница для клиента  -->

<#macro customer>
    <!DOCTYPE html>
    <html lang="en">
    <head>
        <meta charset="UTF-8">
        <title>ДЛЯ КЛИЕНТОВ </title>

    </head>
    <body>

    <h1>Мои открытые лоты </h1>

    <table>
        <tr>
            <td>ЛОТ № 1</td>
            <td>ЛОТ № 2</td>
            <td>ЛОТ № 3</td>
        </tr>
    </table>


    </body>
    </html>
</#macro>