<%@ page contentType="text/html;charset=UTF-8" language="java"%>

<%@ taglib prefix="c" uri="jakarta.tags.core"%>

<!DOCTYPE html>
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

<title>Save Ticket</title>
</head>

<body>

  <div class="container">

    <h3>New Ticket Creation</h3>
    <hr>

    <p class="h4 mb-4">Ticket Details</p>

    <c:url var="saveUrl" value="/tickets/save" />

    <form action="${saveUrl}" method="POST">

      <!-- Add hidden form field to handle update -->
      <input type="hidden" name="id" value="${ticket.id}" />

      <div class="form-inline">
        <input type="text" name="Ticket Title" value="${ticket.ticketTitle}"
          class="form-control mb-4 col-4" placeholder="ticket_title" />
      </div>

      <div class="form-inline">

        <input type="text" name="Ticket Short Description" value="${ticket.tshortdes}"
          class="form-control mb-4 col-4" placeholder="ticket_short_description" />
      </div>

      <div class="form-inline">

        <input type="text" name="Ticket Created On" value="${ticket.creationDate}"
          class="form-control mb-4 col-4" placeholder="ticket_created_on" />

      </div>
      
            <div class="form-inline">

        <input type="text" name="Detailed Issue" value="${ticket.detailedIssue}"
          class="form-control mb-4 col-4" placeholder="detailed_issue" />

      </div>

      <button type="submit" class="btn btn-info col-2">Save</button>

    </form>

    <hr>
    <c:url var="listUrl" value="/tickets/list" />

    <a href="${listUrl}">Back to Tickets List</a>

  </div>
</body>

</html>          