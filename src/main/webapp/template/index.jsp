
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>

<html lang="en">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Форма для голосования</title>
    <link rel="stylesheet" href = "my.css">
    <style>
				.class {
		background-color: lightgreen;
		}
				.class1 {
		font-size: 30px;
		color: blue;
		}
				.class2 {
		font-size: 20px;
		color: red;
		}
				.class3 {
		border-radius: 10px;
		color: white;
		transition: .2s linear;
		background: #0B63F6;
		}

				.class3:hover  {
		box-shadow: 0 0 0 2px white, 0 0 0 4px #3C82F8;
		}
    </style>
</head>
<body>
	<form action="http://localhost:8080/Project1/vote" method="POST">

	<p class="class1">Выберите исполнителя:</p>
	<select class="class2" name="artist">
	<c:forEach items="${artists}" var="item">
         <option><c:out value="${item}"/></option>
    </c:forEach>
    </select>
    <br>
	<p class="class1">Выберите жанры:</p>
	<c:forEach items="${genres}" var="item">
         <option><c:out value="${item}"/></option><input type="checkbox" name="genre" value="<c:out value="${item}"/>"/><span>${item}</span></br>
    </c:forEach>
	<br>
	<p class="class1">О себе:</p>
	<textarea name="about"></textarea>

	<br><br><br>

	<input class="class3" type="submit" value="Результат голосования">

	</form>
 </body>
</html>