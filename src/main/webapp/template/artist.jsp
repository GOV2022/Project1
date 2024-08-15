<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html>
<head>
    <title>Создай артиста</title>
    <meta charset="utf-8">
</head>
<body>
<form action="http://localhost:8080/Project1/artist" method="POST">
    <p>Выбери артиста: </p>
    <input type="text" name="artistName"/>
    <input type="submit" value="Отправить">
</form>
</body>
</html>