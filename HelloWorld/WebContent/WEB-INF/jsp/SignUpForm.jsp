
<head>
<title>Sign up</title>
</head>


<body>
	<p>Welcome! Please sign up here:</p>

	<form onsubmit = "return check()"action="signup" method="post">
		<table>
			<tr>
				<td align="right">User Name:</td>
				<td align="left"><input type="text" name="name" /></td>
			</tr>
			<tr>
				<td align="right">Password:</td>
				<td align="left"><input type="password" name="password"
					id="password" onkeyup='check();'/> </td>
			</tr>
			<tr>
				<td align="right">Confirm password:</td>
				<td align="left"><input type="password" id="confirmed"
					onkeyup='check();' /></td>
				<td align="left"><span id='message'></span>
			</tr>
		</table>
		<input type="submit" value="Sign up" />
	</form>
</body>

<script>
	var check = function(evt) {
		if (document.getElementById('confirmed').value == "") {
			evt.preventDefault();
			return false;
		}
		if (document.getElementById('password').value == document
				.getElementById('confirmed').value) {
			document.getElementById('message').style.color = 'green';
			document.getElementById('message').innerHTML = 'matching';
			return true;
		} else {
			document.getElementById('message').style.color = 'red';
			document.getElementById('message').innerHTML = 'not matching';
			evt.preventDefault();
			return false;
		}
	}
</script>

