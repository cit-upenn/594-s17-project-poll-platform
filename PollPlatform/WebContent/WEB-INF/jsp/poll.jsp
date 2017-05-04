<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


<style type="text/css">
html, 
body {
height: 100%;
}
body {
background-image: url(http://pic1.win4000.com/wallpaper/f/586358d1b5e53.jpg);
background-repeat: no-repeat;
background-size: 100% 100%;
	font-family:Monospace
}
</style>

<body style="background-color:#CEF9F1;">
</body>
<p style = "text-align: right">${name}|<a href="UserHomePage?name=${name}" target="_self">Homepage</a></p>
<p><font size = "5">Hi ${name}</font></p>
<p>Here is "${poll.getPollTitle()}":</p>
<p>${poll.pollContent}:</p>
<p>tag: ${poll.tag}</p>
<form action="submitRating" method="post">
<input type="radio" name="rating" value="1"> 1
<input type="radio" name="rating" value="2"> 2
<input type="radio" name="rating" value="3"> 3
<input type="radio" name="rating" value="4"> 4
<input type="radio" name="rating" value="5"> 5
	<input type="submit"/>	
	<input type="hidden" name = "user" value="${name}" />
	<input type="hidden" name = "pollId" value="${poll.pollId}" />
</form>

