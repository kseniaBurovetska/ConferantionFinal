<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
  <title>Registration</title>

  <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
  <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.7.2/css/all.css">
  <link rel="stylesheet" href="${pageContext.request.contextPath}/css/styles.css"/>

</head>
<body class="d-flex flex-column h-100">


<jsp:include page="WEB-INF/views/header_nlogout.jsp"/>


<div class="container">

  <div class="row ">

    <div class="col-md-12 mb-2 mt-4">
      <h4 class="mb-3">Registration</h4>

      <form action="${pageContext.request.contextPath}/app/registration" method="post" class="needs-validation">

        <div class="row">
          <div class="col-md-6 mb-3">
            <label for="firstName">First name</label>
            <input type="text" class="form-control" name="firstName" id="firstName" placeholder="" value="" required>
            <div class="invalid-feedback">
              Valid first name is required.
            </div>
          </div>

          <div class="col-md-6 mb-3">
            <label for="surName">Surname</label>
            <input type="text" class="form-control" name="surName" id="surName" placeholder="" value="" required>
            <div class="invalid-feedback">
              Valid last name is required.
            </div>
          </div>
        </div>

        <div class="mb-3">
          <select class="custom-select" name="role" id="role" required>
            <option value="">Choose role...</option>
            <option value="MODERATOR">Moderator</option>
            <option value="VISITOR">Visitor</option>
            <option value="SPEAKER">Speaker</option>
          </select>
          <div class="invalid-feedback">Example invalid custom select feedback</div>
        </div>

        <div class="mb-3">
          <label for="email">Email</label>
          <input type="email" class="form-control" name="email" id="email" placeholder="you@example.com" required>
          <div class="invalid-feedback">
            Email is invalid.
          </div>
        </div>

        <div class="mb-3">
          <label for="password">Password</label>
          <input type="password" class="form-control" name="password" id="password" required>
          <div class="invalid-feedback">
            Password is invalid.
          </div>
        </div>

        <div class="mb-3">
          <label for="phone">Phone</label>
          <input type="phone" class="form-control" name="phone" id="phone" required>
          <div class="invalid-feedback">
            Phone is invalid.
          </div>
        </div>

        <hr class="mb-4">
        <input type="submit" class="form-control btn-submit" name="submitRegistration" value="Registration">
      </form>
    </div>
  </div>

</div>

<jsp:include page="WEB-INF/views/footer.jsp"/>

</body>
</html>
