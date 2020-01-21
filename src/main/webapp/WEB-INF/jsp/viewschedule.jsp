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
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
<style type="text/css">
div.container {
	margin: 4px, 4px;
	padding: 4px;
	height: 550px;
	overflow: scroll;
	text-align: justify;
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
		<h3 style="text-align: center; color: #B2B356;">Schedule Ration
			Detail</h3>
		<h4 style="color: #E4324C;">
			Number of days you can survive with current inventory : <span
				style="color: #E4324C;">${listsize} </span>
		</h4>
		<table class="table">
			<tr>
				<td style="font: bold; color: #3b4483;">Packet Id</td>
				<td style="font: bold; color: #3b4483;">Packet Type</td>
				<td style="font: bold; color: #3b4483;">Packet Content</td>
				<td style="font: bold; color: #3b4483;">Calories</td>
				<td style="font: bold; color: #3b4483;">Expiry Date</td>
				<td style="font: bold; color: #3b4483;">Quantity In Litres</td>
			</tr>

			<c:forEach items="${inventoryList}" var="inventorydata">
				<tr>
					<td style="color: #E4324C;">Schedule Date</td>
					<td style="color: #FC7233;">${inventorydata.date}</td>
					<c:forEach items="${inventorydata.rationList}" var="rationdata">
						<tr>
							<td>${rationdata.packetId}</td>
							<td>${rationdata.packetType}</td>
							<td>${rationdata.packetContent}</td>
							<td>${rationdata.calories}</td>
							<td>${rationdata.expiryDate}</td>
							<td>-</td>
						</tr>
					</c:forEach>
					<c:forEach items="${inventorydata.waterList}" var="waterdata">
						<tr>
							<td>${waterdata.packetId}</td>
							<td>${waterdata.packetType}</td>
							<td>-</td>
							<td>-</td>
							<td>-</td>
							<td>${waterdata.quantityInLitres}</td>
						</tr>
					</c:forEach>
				</tr>
			</c:forEach>
		</table>
	</div>
</body>
</html>