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

<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<link rel="stylesheet"
	href="https://fonts.googleapis.com/css?family=Allerta+Stencil">

<style>
.w3-allerta {
	font-family: "Allerta Stencil", Sans-serif;
}
</style>
<style>
.myForm {
	margin: 65px auto;
	width: 400px;
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
	<div class="myForm">
		<form class="form-horizontal" action="/updatewaterdetail"
			method="POST">
			<fieldset>
				<div id="legend">
					<legend style="margin-top: 10px; font-size: 30px; color: #B2B356;">Update
						Water Detail</legend>
				</div>
				<div hidden="hidden" class="control-group">
					<label class="control-label" for="packetid">Water Id :</label> <input
						type="text" class="form-control" id="id" name="id"
						value="${water.id}" required="required"
						placeholder="Enter Packet Id" />
				</div>
				<div class="control-group">
					<label class="control-label" for="packetId">Packet Id :</label> <input
						type="text" class="form-control" id="packetId"
						value="${water.packetId}" name="packetId" required="required"
						placeholder="Enter Packet Id" disabled="disabled" />
				</div>
				<div class="control-group">
					<label class="control-label" for="packettype">Packet Type:</label>
					<input type="text" class="form-control" id="packetType"
						name="packetType" value="${water.packetType}" required="required"
						placeholder="Enter Packet Type" readonly="readonly">
				</div>
				<div class="control-group">
					<label class="control-label" for="calories">Quantity :</label> <select
						name="quantityInLitres" class="form-control" required="required">
						<option selected value="${water.quantityInLitres}">${water.quantityInLitres}</option>
						<option value="1">1</option>
						<option value="2">2</option>
					</select>
				</div>

				<div class="control-group">
					<!-- Button -->
					<div class="controls">
						<button type="submit"
							style="background-color: rgb(98, 172, 181); margin-top: 10px; border: 0px"
							class="btn btn-success">Update</button>
						<a href="/viewration" class="btn btn-lg btn-link"
							style="font-size: 15px; margin-top: 10px;">Cancel</a>
					</div>
				</div>
			</fieldset>
		</form>
	</div>
</body>
</html>