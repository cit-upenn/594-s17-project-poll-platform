<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<p>Hi ${name}!</p>
<p>Here is the results for ${poll.getPollTitle()}:</p>
<p>Number of people voted: ${numberOfPeopleVoted}</p>
<p>Average score: ${average}</p>

<!-- <head>
<script src="https://cdn.plot.ly/plotly-latest.min.js"></script>
</head>

<body>
	Plotly chart will be drawn inside this DIV
	<div id="myDiv"></div>
	<script>
      var y = [];
      for (var i = 0; i < 500; i++) {
          y[i] = Math.random();
      }

      var data = [
        {
          y: y,
          type: 'histogram',
           marker: {
          color: 'pink',
          },
        }
      ];
      Plotly.newPlot('myDiv', data);
     </script>
</body>
 -->