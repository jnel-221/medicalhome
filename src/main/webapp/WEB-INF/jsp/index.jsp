<jsp:include page="include/header.jsp"/>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!-- home-page main content, different display for authenticated/non-authenticated users -->
<%--Begin display for non-authenticated users--%>
<sec:authorize access="!isAuthenticated()">
    <%--Hero secton--%>
    <div class="hero-image">
        <div class="hero-text">
            <h1 style="font-size: 50px">Improving Outcomes for Moms and Babies</h1>
            <p>Big dang heroes</p>
            <a href="/login/login">
                <button style="background-color: #f46d25">Login</button>
            </a>

        </div>
    </div>
    <!-- End hero section-->
    <%--    Begin main content --%>
    <div class="container mx-auto mt-5">
    <div class="row">
        <div class="col-md-4">
            <div class="card landing-card" style="width: 18rem;">
                    <%--<a href="https://www.flaticon.com/free-icons/care" title="care icons">Care icons created by Freepik - Flaticon</a>--%>
                <div class="card-icon-cap text-center"><img src="/pub/images/healthcare.png" alt="hands holding heart icon" class="mt-4"></div>
                <div class="card-body">
                    <h5 class="card-title">Create an Account</h5>
                    <h6 class="card-subtitle mb-2 text-muted">Card subtitle</h6>
                    <p class="card-text">Some quick example text to build on the card title and make up the bulk of the
                        card's content.</p>
                </div>
            </div>
        </div>
        <div class="col-md-4">
            <div class="card landing-card" style="width: 18rem;">
                    <%--                <img src="https://i.imgur.com/ZTkt4I5.jpg" class="card-img-top" alt="...">--%>
                <div class="card-icon-cap text-center"><img src="/pub/images/group.png" alt="group-chat icon" class="mt-4"></div>
                <div class="card-body">
                    <h5 class="card-title">Assemble a Care Team</h5>
                    <h6 class="card-subtitle mb-2 text-muted">Card subtitle</h6>
                    <p class="card-text">Some quick example text to build on the card title and make up the bulk of the
                        card's content.</p>

                </div>
            </div>
        </div>

        <div class="col-md-4">
            <div class="card landing-card" style="width: 18rem;">
                    <%--<a href="https://www.flaticon.com/free-icons/care" title="care icons">Care icons created by Freepik - Flaticon</a>--%>
                <div class="card-icon-cap text-center"><img src="/pub/images/hands.png" alt="big hand holding little hand icon" class="mt-4"></div>
                <div class="card-body">
                    <h5 class="card-title">Get Your Questions Answered</h5>
                    <h6 class="card-subtitle mb-2 text-muted">Card subtitle</h6>
                    <p class="card-text">Some quick example text to build on the card title and make up the bulk of the
                        card's content.</p>
                </div>
            </div>
        </div>
    </div>
    <%--    End main content--%>
</sec:authorize>
<%--End display for non-authenticated user--%>


<%--Begin display for authenticated user--%>
<sec:authorize access="isAuthenticated()">
    <%--Begin hero section--%>
    <div class="hero-image">
        <div class="hero-text">
            <h1 style="font-size: 50px">Welcome ${user.firstName}</h1>
            <p>Big dang heroes</p>
            <a href="/user/conversation">
                <button style="background-color: #f46d25"> + New</button>
            </a>
        </div>
    </div>
    <!-- End hero section-->
    <%--Begin conversation history section--%>
    <div class="container mx-auto mt-5">
    <div class="row">
        <c:forEach var="uc" items="${userConversations}">
            <form class="my-2" action="/user/message/${uc.id}" method="post">
                <input type="hidden" name="convId">
                <div class="card w-75">
                    <div class="card-body">
                        <h5 class="card-title">${uc.subject}</h5>
                        <p class="card-text"><fmt:formatDate type="date" value="${uc.create_date}"/></p>
                        <button type="submit" class="btn" id="sButton button-addon2">View</button>
                    </div>
                </div>
            </form>
        </c:forEach>
    </div>
</sec:authorize>
<%--End conversation history section--%>
<jsp:include page="include/footer.jsp"/>