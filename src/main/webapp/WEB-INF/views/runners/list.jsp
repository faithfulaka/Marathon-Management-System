<%@ taglib prefix="c" uri="jakarta.tags.core"%>

<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <h2>List of Runners with ID ${marathonID}</h2>

</head>
<body>
<c:forEach var="runner" items="${runners}">
    <p>Name: ${runner.getName()}, Nationality:  ${runner.getNationality()}, Category:  ${runner.getCategory()}, Number:  ${runner.getNumber()} </a></p>
</c:forEach>
<a href="/newRunner?marathon= ${marathonID}">[add new runner]</a>
</body>
</html>