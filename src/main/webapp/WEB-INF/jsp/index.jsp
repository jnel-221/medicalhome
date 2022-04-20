<jsp:include page="include/header.jsp"/>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<!-- home-page main content, different display for authenticated/non-authenticated -->

<sec:authorize access="!isAuthenticated()">
<%--Hero secton--%>
<div class="hero-image">
    <div class="hero-text">
        <h1 style="font-size: 50px">I ARE HERO</h1>
        <p>Big dang heroes</p>
        <a href="/login/login"><button style="background-color: #f46d25">Login</button></a>

    </div>
</div>
<!-- end hero section-->
<div class="container mx-auto mt-5">
    <div class="row">
        <div class="col-md-4">
            <div class="card" style="width: 18rem;">
                <img src="https://i.imgur.com/ZTkt4I5.jpg" class="card-img-top" alt="...">
                <div class="card-body">
                    <h5 class="card-title">Card title</h5>
                    <h6 class="card-subtitle mb-2 text-muted">Card subtitle</h6>
                    <p class="card-text">Some quick example text to build on the card title and make up the bulk of the card's content.</p>
                </div>
            </div>
        </div>
        <div class="col-md-4">
            <div class="card" style="width: 18rem;">
                <img src="https://i.imgur.com/ZTkt4I5.jpg" class="card-img-top" alt="...">
                <div class="card-body">
                    <h5 class="card-title">Card title</h5>
                    <h6 class="card-subtitle mb-2 text-muted">Card subtitle</h6>
                    <p class="card-text">Some quick example text to build on the card title and make up the bulk of the card's content.</p>

                </div>
            </div>
        </div>

        <div class="col-md-4">
            <div class="card" style="width: 18rem;">
                <img src="https://i.imgur.com/ZTkt4I5.jpg" class="card-img-top" alt="...">
                <div class="card-body">
                    <h5 class="card-title">Card title</h5>
                    <h6 class="card-subtitle mb-2 text-muted">Card subtitle</h6>
                    <p class="card-text">Some quick example text to build on the card title and make up the bulk of the card's content.</p>
                </div>
            </div>
        </div>
    </div>
</sec:authorize>
<%--End display for non-authenticated user--%>
<%--Begin display for authenticated user--%>
<sec:authorize access="isAuthenticated()">
    <div class="hero-image">
        <div class="hero-text">
            <c:forEach var="user" items="${user}">
            <h1 style="font-size: 50px">Welcome ${user.firstName} </h1>
            </c:forEach>
            <p>Big dang heroes</p>
            <a href="/user/conversation"><button style="background-color: #f46d25"> + New</button></a>
        </div>
    </div>
    <!-- end hero section-->
   <%--begin conversation history section--%>
    <div class="container mx-auto mt-5">
        <div class="row">
            <div class="col-md-4">
                <div class="card" style="width: 18rem;">
                    <img src="https://i.imgur.com/ZTkt4I5.jpg" class="card-img-top" alt="...">
                    <div class="card-body">
                        <h5 class="card-title">Card title</h5>
                        <h6 class="card-subtitle mb-2 text-muted">Card subtitle</h6>
                        <p class="card-text">Some quick example text to build on the card title and make up the bulk of the card's content.</p>
                    </div>
                </div>
            </div>
        </div>
</sec:authorize>

<jsp:include page="include/footer.jsp"/>