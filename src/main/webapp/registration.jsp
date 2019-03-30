<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
  <title>Registration</title>

  <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
  <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.7.2/css/all.css">
  <link rel="stylesheet" href="${pageContext.request.contextPath}/css/styles.css"/>

</head>
<body class="d-flex flex-column h-100">


<jsp:include page="views/header.jsp"/>


<div class="container">

  <div class="row ">

    <div class="col-md-12 mb-2 mt-4">
      <h4 class="mb-3">Registration</h4>

      <form action="${pageContext.request.contextPath}/app/registration" method="post" class="needs-validation" novalidate>
        <div class="row">
          <div class="col-md-6 mb-3">
            <label for="firstName">First name</label>
            <input type="text" class="form-control" name="firstName" id="firstName" placeholder="" value="" required>
            <div class="invalid-feedback">
              Valid first name is required.
            </div>
          </div>
          <div class="col-md-6 mb-3">
            <label for="lastName">Last name</label>
            <input type="text" class="form-control" name="lastName" id="lastName" placeholder="" value="" required>
            <div class="invalid-feedback">
              Valid last name is required.
            </div>
          </div>
        </div>

        <div class="mb-3">
          <label for="regLogin">Login</label>
          <div class="input-group">
            <div class="input-group-prepend">
              <span class="input-group-text">@</span>
            </div>
            <input type="text" class="form-control" name="regLogin" id="regLogin" placeholder="Login" required>
            <div class="invalid-feedback" style="width: 100%;">
              Your login is required.
            </div>
          </div>
        </div>

        <div class="mb-3">
          <label for="email">Email</label>
          <input type="email" class="form-control" name="email" id="email" placeholder="you@example.com" required>
          <div class="invalid-feedback">
            Please enter a valid email.
          </div>
        </div>

        <div class="mb-3">
          <label for="address">Address</label>
          <input type="text" class="form-control" name="address" id="address" placeholder="1234 Main St">
          <div class="invalid-feedback">
            Please enter your address.
          </div>
        </div>

        <div class="row">
          <div class="col-md-5 mb-3">
            <label for="country">Country</label>
            <select class="custom-select d-block w-100" name="country" id="country">
              <option value="">Choose...</option>
              <option>United States</option>
            </select>
            <div class="invalid-feedback">
              Please select a valid country.
            </div>
          </div>
          <div class="col-md-4 mb-3">
            <label for="state">State</label>
            <select class="custom-select d-block w-100" name="state" id="state">
              <option value="">Choose...</option>
              <option>California</option>
            </select>
            <div class="invalid-feedback">
              Please provide a valid state.
            </div>
          </div>
          <div class="col-md-3 mb-3">
            <label for="zip">Zip</label>
            <input type="text" class="form-control" name="zip" id="zip" placeholder="" required>
            <div class="invalid-feedback">
              Zip code required.
            </div>
          </div>
        </div>

        <hr class="mb-4">
        <input type="submit" class="form-control btn-submit" name="submitRegistration" value="Registration">
      </form>
    </div>
  </div>

  <%--<div class="my-5">
    <a href="${pageContext.request.contextPath}/app/home">Home</a>
  </div>--%>
</div>

<jsp:include page="views/footer.jsp"/>

</body>
</html>
