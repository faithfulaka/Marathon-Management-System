<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <h2>Add New Marathon</h2>
</head>
<body>
<form:form action="/addMarathon" modelAttribute="marathon">
    ID:
    <form:input path="id" />
    <form:errors path="id"/><br/>


    Location:
    <form:input path="location"/>
    <form:errors path="location"/><br/>

    Month:
    <form:input path="month"/>
    <form:errors path="month"/><br/>

    <input type="submit"/><form:errors/>
</form:form>
</body>
</html>