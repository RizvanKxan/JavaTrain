<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Calculator</title>
</head>
<body>
<p>Задайте параметры:</p>
<form method="post" accept-charset="UTF-8">
    <label>Число 1
        <input type="text" name="number1"><br/></label>
    <label>Число 2
        <input type="text" name="number2"><br/></label>
    <p>Сделай выбор действия с числами: </p>
    <div>
        <input type="radio" name="operation" value="addition">Сложение<br/>
        <input type="radio" name="operation" value="subtraction">Вычитание<br/>
        <input type="radio" name="operation" value="multiplication">Умножение<br/>
        <input type="radio" name="operation" value="division">Деление<br/>
        <input type="radio" name="operation" value="exponentiation">Возведение в степень<br/>
        <input type="radio" name="operation" value="interest_calculation">Подсчёт процента<br/>
    </div>

    <button type="submit">Отправить</button>
</form>

<%
    if (request.getAttribute("result") != null) {
        String result = request.getAttribute("result").toString();
        out.println("<p>Result = " + result + "</p>");
    }
%>

</body>
</html>
