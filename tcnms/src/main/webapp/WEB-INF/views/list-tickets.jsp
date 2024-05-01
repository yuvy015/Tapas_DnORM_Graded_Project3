<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
<!-- Required meta tags -->
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">

<!-- Bootstrap CSS -->
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.2.1/css/bootstrap.min.css"
	integrity="sha384-GJzZqFGwb1QTTN6wy59ffF1BuGJpLSa9DkKMp0DgiMDm4iYMj70gZWKYbI706tWS"
	crossorigin="anonymous">

<title>Tickets Directory</title>
</head>

<body>

	<div class="container">

		<h3>Tickets Directory</h3>
		<hr>

		<!-- Add Button Support -->
		<c:url var="addUrl" value="/tickets/displayTicketForm" />
		<a href="${addUrl}" class="btn btn-primary btn-sm mb-3"> Add
			Ticket </a>

		<c:url var="searchUrl" value="/tickets/search" />
		<form action="${searchUrl}" class="form-inline">

			<input type="search" name="Ticket Title" placeholder="ticket_title"
				class="form-control-sm mr-2 mb-3" /> <input type="search"
				name="Ticket Short Description" placeholder="ticket_short_description"
				class="form-control-sm mr-2 mb-3" />

			<button type="submit" class="btn btn-success btn-sm mb-3">
				Search</button>
		</form>

		<table class="table table-bordered table-striped">
			<thead class="thead-dark">
				<tr>
					<th>TICKET TITLE</th>
					<th>TICKET SHORT DESCRIPTION</th>
					<th>TICKET CREATED ON</th>
					<th>ACTION</th>
				</tr>
			</thead>

			<tbody>
				<c:forEach items="${tickets}" var="ticketObj">
					<tr>
						<td><c:out value="${ticketObj.ticketTitle}" /></td>
						<td><c:out value="${ticketObj.tshortdes}" /></td>
						<td><c:out value="${ticketObj.creationDate}" /></td>
						<td>
							<!-- Add "update" button/link --> <c:url var="updateUrl"
								value="/tickets/displayTicketForm_Update?ticketId=${ticketObj.id}" />
							<a href="${updateUrl}" class="btn btn-info btn-sm"> Update </a> 
							<!-- Add "delete" button/link -->
							<c:url var="deleteUrl"
								value="/tickets/delete?ticketId=${ticketObj.id}" /> <a
							href="${deleteUrl}" class="btn btn-danger btn-sm"
							onclick="if (!(confirm('Are you sure you want to delete this ticket?'))) return false">
								Delete </a>
							<!-- Add "view" button/link --> <c:url var="updateUrl"
								value="/tickets/displayTicketForm_View?ticketId=${ticketObj.id}" />
							<a href="${updateUrl}" class="btn btn-info btn-sm"> View </a>
						</td>
					</tr>
				</c:forEach>

			</tbody>
		</table>

	</div>

</body>

</html>