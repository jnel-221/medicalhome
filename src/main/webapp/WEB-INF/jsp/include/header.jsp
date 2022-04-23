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
                    rgba(0, 0, 0, 0.3),
                    rgba(0, 0, 0, 0.3)
            ),
            url("/pub/images/karim-ben-van-mKk2nnZ1EQk-unsplash.jpg");
            height: 55%;
            background-position: center;
            background-repeat: no-repeat;
            background-size: cover;
            position: relative;
        }

        .hero-text {
            padding-top: 5rem;
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
            padding: .7rem 2.188rem;
            color: white;
            background-color: #ddd;
            text-align: center;
            cursor: pointer;
        }

        .hero-text button:hover {
            background-color: #4b4b55;
            color: white;
        }
    </style>
</head>
<body>

<!-- navbar -->
<section id="header">
<%--    fixed-top  add back to nav-class after testing--%>
    <nav class="navbar navbar-expand-lg nav-style">
        <div class="container-fluid">
<%--            <div> Icons made by <a href="https://www.freepik.com" title="Freepik"> Freepik </a> from <a href="https://www.flaticon.com/" title="Flaticon">www.flaticon.com'</a></div>--%>
    <sec:authorize access="!isAuthenticated()">
        <a class="navbar-brand ms-5" href="/index"><img src="/pub/images/trillium.png"></a>
    </sec:authorize>
    <sec:authorize access="isAuthenticated()">
        <a class="navbar-brand ms-5" href="/home"><img src="/pub/images/trillium.png"></a>
     </sec:authorize>
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

                    <sec:authorize access="!isAuthenticated()">
                        <a class="nav-link active" aria-current="page" href="/index">Home</a>
                    </sec:authorize>
                    <sec:authorize access="isAuthenticated()">
                        <a class="nav-link active" aria-current="page" href="/home">Home</a>
                    </sec:authorize>
                    <a class="nav-link" href="/ourProviders">Providers</a>
                    <sec:authorize access="hasAnyAuthority('USER','ADMIN')">
                        <a class="nav-link" href="/user/message">Message</a>
                    </sec:authorize>
                    <sec:authorize access="hasAnyAuthority('USER','ADMIN')">
                        <a class="nav-link" href="/user/conversation">My Case</a>
                    </sec:authorize>
                    <sec:authorize access="!isAuthenticated()">
                        <a class="nav-link" href="/user/register">Create Account</a>
                    </sec:authorize>
                    <sec:authorize access="!isAuthenticated()">
                        <a class="nav-link" href="/login/login">Log In</a>
                    </sec:authorize>
                    <sec:authorize access="isAuthenticated()">
                        <a class="nav-link" href="/login/logout">Logout</a>
                    </sec:authorize>
                    <sec:authorize access="hasAuthority('ADMIN')">
                        <a class="nav-link" href="/upload">Upload</a>
                    </sec:authorize>
                </div>
            </div>
        </div>
    </nav>
</section>
<!-- end navbar -->

