<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Greeting</title>
</head>
<body>

<h1> New runner for Marathon ID: ${marathonID} </h1>

<%--@elvariable id="runner" type=""--%>
<form:form action="/addRunner?marathon=${marathonID}" modelAttribute="runner">

    Name:
    <form:input path="name"/>
    <form:errors path="name"/><br/>

    Nationality:
    <form:input path="nationality"/>
    <form:errors path="nationality"/><br/>

    Category:
    <form:input path="category"/>
    <form:errors path="category"/><br/>

    Number of each runner:
    <form:input path="number"/>
    <form:errors path="number"/><br/>

    <input type="submit"/><form:errors/>
</form:form>
</body>

</html>