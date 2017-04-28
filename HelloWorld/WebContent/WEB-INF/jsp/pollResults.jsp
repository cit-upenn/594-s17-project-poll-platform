<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<head>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/2.1.4/Chart.min.js"></script>
<title>Result for ${poll.getPollTitle()}</title>
</head>
<body>

	<p>Hi ${name}!</p>"WebContent/WEB-INF/jsp/pollResults.jsp"
	<p>Here is the results for ${poll.getPollTitle()}:</p>
	<p>Number of people voted: ${numberOfPeopleVoted}</p>
	<p>Average score: ${average}</p>
	<div style="width: 400px; height: 400px">
		<canvas id="myChart"></canvas>
		<script>
			var x = [];
			x[0] = "${poll.getPollResults()[0]}";
			x[1] = "${poll.getPollResults()[1]}";
			x[2] = "${poll.getPollResults()[2]}";
			x[3] = "${poll.getPollResults()[3]}";
			x[4] = "${poll.getPollResults()[4]}";
			var ctx = document.getElementById("myChart");
			var myChart = new Chart(ctx, {
				type : 'bar',
				data : {
					labels : [ "1", "2", "3", "4", "5" ],
					datasets : [ {
						label : '# of Votes',
						data : x,
						backgroundColor : [ 'rgba(255, 99, 132, 0.2)' ],
						borderColor : [ 'rgba(255,99,132,1)' ],
						borderWidth : 1
					} ]
				},
				options : {
					scales : {
						yAxes : [ {
							ticks : {
								beginAtZero : true
							}
						} ]
					}
				}
			});
		</script>
	</div>
</body>
