<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- Bootstrap and JQuery -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
<style type="text/css">
div.container {
	margin: 4px, 4px;
	padding: 4px;
	height: 600px;
	overflow: scroll;
	text-align: justify;
}

.headingbtn {
	margin-left: 950px;
}
</style>
<script>
	$(function() {
		$('.alert-success').delay(3000).show().fadeOut('slow');
	})

	$(function() {
		$('.alert-danger').delay(3000).show().fadeOut('slow');
	})
</script>
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<link rel="stylesheet"
	href="https://fonts.googleapis.com/css?family=Allerta+Stencil">

<style>
.w3-allerta {
	font-family: "Allerta Stencil", Sans-serif;
}
</style>
<style>
table, th, td {
	border: 1px solid black;
}
.headingbutton{
	display: flex;
	margin-left: 850px;
}
</style>
<title>Rationing System</title>
</head>
<body>
	<div class="w3-container "
		style="background-color: rgba(0, 0, 0, 0.18);">
		<div class="w3-container w3-left w3-allerta">
			<div class="navbar-header">
				<a class="navbar-brand" href="#">Martian Rationing System</a>
			</div>
		</div>
		<div class="w3-right">
			<ul class="nav navbar-nav">
				<li class="active"><a href="/load/rationing-system">Home</a></li>
				<li><a class="dropdown-toggle" data-toggle="dropdown">
						Ration </a>
					<ul class="dropdown-menu">
						<li><a href="/load/addration">Add-Ration Details</a></li>
						<li><a href="/load/addwater">Add-Water Details</a></li>
					</ul></li>
				<li><a href="/viewration">Inventory</a></li>
				<li><a href="/viewscheduleration">View-Schedule</a></li>
			</ul>
		</div>
	</div>
	<div class="container">
		<c:if test="${not empty status}">
			<c:if test="${status eq 'true'}">
				<div class="alert alert-success" role="alert" id="alertshow">
					${message}
					<button type="button" class="close" data-dismiss="alert"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
				</div>
			</c:if>
			<c:if test="${status eq 'false'}">
				<div class="alert alert-danger" role="alert" id="alertshow">
					${message}
					<button type="button" class="close" data-dismiss="alert"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
				</div>
			</c:if>
		</c:if>

		<div class="heading">
			<div class="headingtext">
				<h3 style="text-align: center; color: #B2B356;">Inventory
					Ration Detail</h3>
			</div>
		</div>
		<div class="headingbutton">
				<div>
					<a href="/scheduleinventory">
						<button style="background-color: #008080; border: 0px"
							class="btn btn-warning">Create-Schedule</button>
					</a>
				</div>
				<div style=" margin-left: 20px;">
					<a href="/resetschedule">
						<button style="background-color: #666699; border: 0px"
							class="btn btn-warning">Reset-Schedule</button>
					</a>
				</div>
		</div>
		<table class="table" style="margin-top: 20px;">
			<tr>
				<td style="font: bold; color: #3b4483;">Packet Id</td>
				<td style="font: bold; color: #3b4483;">Packet Type</td>
				<td style="font: bold; color: #3b4483;">Packet Content</td>
				<td style="font: bold; color: #3b4483;">Calories</td>
				<td style="font: bold; color: #3b4483;">Expiry Date</td>
				<td style="font: bold; color: #3b4483;">Quantity In Litres</td>
				<td style="font: bold; color: #3b4483;">Update</td>
				<td style="font: bold; color: #3b4483;">Delete</td>
			</tr>
			<c:forEach items="${rationlists}" var="ration">
				<tr>
					<td>${ration.packetId}</td>
					<td>${ration.packetType}</td>
					<td>${ration.packetContent}</td>
					<td>${ration.calories}</td>
					<td>${ration.expiryDate}</td>
					<td>-</td>
					<td><a href="/load/updateration?rationid=${ration.id}"><i
							class="fa fa-edit" style="color: #6D8203; font-size: 27px"></i></a></td>
					<td><a href="/deleteration?rationid=${ration.id}"
						onclick="return confirm('Do you want to Delete Ration ?')"><i
							class="fa fa-trash-o" style="color: red; font-size: 27px"></i></a></td>
				</tr>
			</c:forEach>
			<c:forEach items="${waterlists}" var="water">
				<tr>
					<td>${water.packetId}</td>
					<td>${water.packetType}</td>
					<td>-</td>
					<td>-</td>
					<td>-</td>
					<td>${water.quantityInLitres}</td>
					<td><a href="/load/updatewater?waterid=${water.id}"><i
							class="fa fa-edit" style="color: #6D8203; font-size: 27px"></i></a></td>
					<td><a href="/deletewater?waterid=${water.id}"
						onclick="return confirm('Do you want to Delete Water ?')"><i
							class="fa fa-trash-o" style="color: red; font-size: 27px"></i></a></td>
				</tr>
			</c:forEach>
		</table>
	</div>
</body>
</html>