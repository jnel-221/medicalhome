<%@ taglib prefix="c" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8"/>
    <meta http-equiv="X-UA-Compatible" content="IE=edge"/>
    <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
    <title>Document</title>
    <%--Bootstrap Stylesheet CDN--%>
    <link
            href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"
            rel="stylesheet"
            integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC"
            crossorigin="anonymous"
    />
    <%--External/Custom Stylesheet--%>
    <link href="<c:url value="/pub/css/style.css"/>" rel="stylesheet" type="text/css"/>
    <%--Bootstrap JS CDN--%>
    <script
            src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
            integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM"
            crossorigin="anonymous"
    ></script>
    <%--Font Awesome Kit CDN--%>
    <script
            src="https://kit.fontawesome.com/ae53138fc4.js"
            crossorigin="anonymous"
    ></script>
    <%--jQuery CDN--%>
    <script
            src="https://code.jquery.com/jquery-3.6.0.js"
            integrity="sha256-H+K7U5CnXl1h5ywQfKtSj8PCmoN9aaq30gDh27Xc0jk="
            crossorigin="anonymous"
    ></script>
    <%--External js file, commented out for usercontroller method-testing--%>
    <script src="<c:url value="/pub/script/register.js"/>" defer></script>
    <%--Internal stylesheet for hero-image on landing page--%>
    <style>
        .hero-image {
            background-image: linear-gradient(
                    rgba(0, 0, 0, 0.5),
                    rgba(0, 0, 0, 0.5)
            ),
            url("/pub/images/karim-ben-van-mKk2nnZ1EQk-unsplash.jpg");
            height: 50%;
            background-position: center;
            background-repeat: no-repeat;
            background-size: cover;
            position: relative;
        }

        .hero-text {
            text-align: center;
            position: absolute;
            top: 50%;
            left: 50%;
            transform: translate(-50%, -50%);
            color: white;
        }

        .hero-text button {
            border: none;
            outline: 0;
            display: inline-block;
            padding: 10px 25px;
            color: black;
            background-color: #ddd;
            text-align: center;
            cursor: pointer;
        }

        .hero-text button:hover {
            background-color: #555;
            color: white;
        }
    </style>
</head>
<body>
<!-- navbar -->
<section id="header">
    <!-- removed navbar-light and bg-light fixed-top -->
    <nav class="navbar navbar-expand-lg fixed-top nav-style">
        <div class="container-fluid">
            <a class="navbar-brand" href="#"><!--img--></a>
            <button
                    class="navbar-toggler"
                    type="button"
                    data-bs-toggle="collapse"
                    data-bs-target="#navbarNavAltMarkup"
                    aria-controls="navbarNavAltMarkup"
                    aria-expanded="false"
                    aria-label="Toggle navigation"
            >
                <span><i class="fas fa-solid fa-bars"></i></span>
            </button>
            <div class="collapse navbar-collapse" id="navbarNavAltMarkup">
                <div class="navbar-nav mx-auto">
                    <a class="nav-link active" aria-current="page" href="/index"
                    >Home</a
                    >
                    <a class="nav-link" href="./views/providers.html">Providers</a>

                    <sec:authorize access="isAuthenticated()">
                    <a class="nav-link" href="../user/search">Search</a>
                    </sec:authorize>

                    <sec:authorize access="isAuthenticated()">
                    <a class="nav-link" href="../user/conversation">My Case</a>
                    </sec:authorize>
                    <sec:authorize access="!isAuthenticated()">
                    <a class="nav-link" href="../user/register">Create Account</a>
                    </sec:authorize>
                    <sec:authorize access="!isAuthenticated()">
                    <a class="nav-link" href="/login/login">Log In</a>
                    </sec:authorize>

                    <sec:authorize access="isAuthenticated()">
                    <a class="nav-link" href="/login/logout">Logout</a>
                    </sec:authorize>
                </div>
            </div>
        </div>
    </nav>
</section>
<!-- end navbar -->

