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
<!-- Date picker -->
<link
	href="https://ajax.googleapis.com/ajax/libs/jqueryui/1.8.1/themes/base/jquery-ui.css"
	rel="stylesheet" />
<script type="text/javascript"
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.7.1/jquery.min.js"></script>
<script type="text/javascript"
	src="https://ajax.googleapis.com/ajax/libs/jqueryui/1.8.1/jquery-ui.min.js"></script>

<script>
	$(function() {
		$('.alert-success').delay(3000).show().fadeOut('slow');
	})

	$(function() {
		$('.alert-danger').delay(3000).show().fadeOut('slow');
	})
	
	$(function() {
    $( "#datepicker" ).datepicker({ minDate: '0', dateFormat: 'yy-mm-dd'});
   	});
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
		<div class="myForm">
			<form class="form-horizontal" action="/savewater" method="POST">
				<fieldset>
					<div id="legend">
						<legend style="margin-top: 10px; font-size: 30px; color: #B2B356;">Add
							Water Detail</legend>
					</div>
					<div class="control-group">
						<label class="control-label" for="packetId">Packet Id :</label> <input
							type="text" class="form-control" id="packetId" name="packetId"
							required="required" placeholder="Enter Packet Id" />
					</div>
					<div class="control-group">
						<label class="control-label" for="packettype">Packet Type:</label>
						<input type="text" class="form-control" id="packetType"
							name="packetType" required="required" value="Water"
							readonly="readonly" placeholder="Enter Packet Type">
					</div>
					<div class="control-group">
						<label class="control-label" for="calories">Quantity :</label> <select
							name="quantityInLitres" class="form-control" required="required">
							<option selected value="">Select Quantity in Liter</option>
							<option value="1">1</option>
							<option value="2">2</option>
						</select>
					</div>

					<div class="control-group">
						<!-- Button -->
						<div class="controls">
							<button type="submit"
								style="background-color: rgb(98, 172, 181); margin-top: 10px; border: 0px"
								class="btn btn-success">Add Water</button>
							<a href="/load/rationing-system" class="btn btn-lg btn-link"
								style="font-size: 15px; margin-top: 10px;">Cancel</a>
						</div>
					</div>
				</fieldset>
			</form>
		</div>
	</div>
</body>
</html>