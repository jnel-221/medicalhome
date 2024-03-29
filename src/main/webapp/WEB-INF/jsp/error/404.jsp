<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<head>
    <link href="https://fonts.googleapis.com/css2?family=Nunito+Sans:wght@600;900&display=swap" rel="stylesheet">
    <link href="<c:url value="/pub/css/errorpage.css"/>" rel="stylesheet" type="text/css"/>
    <script src="https://kit.fontawesome.com/4b9ba14b0f.js" crossorigin="anonymous"></script>
</head>
<body>
<div class="mainbox">
    <div class="err">4</div>
    <i class="far fa-question-circle fa-spin"></i>
    <div class="err2">4</div>
    <sec:authorize access="!isAuthenticated()">
    <div class="msg">Maybe this page moved? Got deleted? Is hiding out in quarantine? Never existed in the first place?<p>Let's go <a href="/index">home</a> and try from there.</p></div>
    </sec:authorize>

    <sec:authorize access="isAuthenticated()">
        <div class="msg">Maybe this page moved? Got deleted? Is hiding out in quarantine? Never existed in the first place?<p>Let's go <a href="/home">home</a> and try from there.</p></div>
    </sec:authorize>
</div>

<%--https://freefrontend.com/html-css-404-page-templates/--%>








