<%@ taglib prefix="c" uri="jakarta.tags.core"%>

<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <h2>List of Marathons</h2>
</head>
<body>
<c:forEach items="${marathons}" var="marathons">
    <p>ID number: ${marathons.id}, Location: ${marathons.location}, Month:  ${marathons.month} <a href="/runners?marathon=${marathons.id}">[runners list]</a></p>
</c:forEach>
<a href="/newMarathon">[new marathon]</a>
</body>
</html>