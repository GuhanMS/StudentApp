<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<div>
		<form action="persistMessage" method=post>
			<textarea name="msg" cols="40" rows="2"></textarea>
			<br> <input type="submit" value="Save Message" />
		</form>
	</div>
	<div>
		<h2>Messages</h2>
		${sessionMessages}
	</div>
	<div>
		<form action="destroy" method="post">
			<input type="submit" value="Destroy Session" />
		</form>
	</div>
</body>
</html>