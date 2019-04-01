<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: GlaDOS
  Date: 9 Mar 2019
  Time: 18:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>Welcome</title>

  <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
  <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.7.2/css/all.css">
  <link rel="stylesheet" href="${pageContext.request.contextPath}/css/styles.css"/>

</head>
<body class="d-flex flex-column h-100">

<jsp:include page="WEB-INF/views/header_nlogout.jsp"/>


<div class="container-fluid ">
  <%--<a href="${pageContext.request.contextPath}/app/registration">Registration</a><br>--%>

  <div class="row centered  vertical-align">
    <div class=" text-center col-lg-3 my-5  ml-5">

      <form action="${pageContext.request.contextPath}/app/login" method="post" class="form-signin">
        <div class="form-group">
          <input type="text" class="form-control" name="email" id="email" placeholder="Email" required autofocus>
        </div>

        <div class="form-group">
          <input type="password" class="form-control" name="password" id="password" placeholder="Password" required autofocus>
        </div>

        <div class="form-group">
          <input type="submit" class="form-control btn-submit" id="submitLogin" value="Login">
        </div>

        <a href="${pageContext.request.contextPath}/app/registration">Registration</a><br>
      </form>
    </div>

    <div class="container-fluid col-lg-7 col-lg-offset-5 mt-3 pb-2 text-center ">
      <h2>Upcoming events</h2>

      <table class="table my-5">

        <thead>
        <tr>
          <th scope="col">Id</th>
          <th scope="col">Name</th>
          <th scope="col">Date</th>
          <th scope="col">Location</th>
        </tr>
        </thead>

        <tbody>

        <c:forEach var="event" items="${events}">
          <tr>
            <td>${event.id}</td>
            <td>${event.name}</td>
            <td>${event.dateTime}</td>
            <td>${event.location}</td>
          </tr>
        </c:forEach>

        </tbody>
      </table>
    </div>

    </div>
  </div>
</div>

  <jsp:include page="WEB-INF/views/footer.jsp"/>

</body>
</html>
