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

<jsp:include page="views/header.jsp"/>


<div class="container-fluid">
  <%--<a href="${pageContext.request.contextPath}/app/registration">Registration</a><br>--%>

  <div class="row centered">
    <div class=" text-center col-lg-3 my-5">
      <form action="${pageContext.request.contextPath}/app/login" method="get" class="form-signin">
        <div class="form-group">
          <%--<label for="formGroupExampleInput">Example label</label>--%>
          <input type="text" class="form-control" name="login" id="login" placeholder="Login" required autofocus>
        </div>
        <div class="form-group">
          <input type="password" class="form-control" name="password" id="password" placeholder="Password" required
                 autofocus>
        </div>
        <div class="form-group">
          <input type="submit" class="form-control btn-submit" id="submitLogin" value="Login">
        </div>
        <a href="${pageContext.request.contextPath}/app/registration">Registration</a><br>
        <a href="${pageContext.request.contextPath}/app/viewAll">View All</a>
      </form>
    </div>

    <div class="col-lg-9 col-lg-offset-3 my-2 text-center ">
      <h2>Upcoming events</h2>
    </div>
  </div>
</div>

  <jsp:include page="views/footer.jsp"/>

</body>
</html>
