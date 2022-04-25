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
            <p>By providing centralized, coordinated, and accessible communication, throughout the pre-natal and peri-natal periods.</p>
            <a href="/login/login">
                <button>Start a Conversation</button>
            </a>
        </div>
    </div>
    <!-- End hero section-->
    <%--    Begin main content --%>
    <div class="container mx-auto mt-5">
    <div class="row justify-content-center">
        <div class="col-md-4">
            <div class="card landing-card" style="width: 18rem;">
                    <%--<a href="https://www.flaticon.com/free-icons/care" title="care icons">Care icons created by Freepik - Flaticon</a>--%>
                <div class="card-icon-cap text-center"><img src="/pub/images/healthcare.png"
                                                            alt="hands holding heart icon" class="mt-4"></div>
                <div class="card-body">
                    <h5 class="card-title text-center">Centralized Care</h5>
                    <h6 class="card-subtitle mb-2 text-muted text-center">Have questions for more than one provider on your team?</h6>
                    <p class="card-text text-center">Access the entire care team managing your case.</p>
                </div>
            </div>
        </div>
        <div class="col-md-4">
            <div class="card landing-card" style="width: 18rem;">
                    <%--<a href="https://www.flaticon.com/free-icons/care" title="care icons">Care icons created by Freepik - Flaticon</a>--%>
                <div class="card-icon-cap text-center"><img src="/pub/images/group.png" alt="group-chat icon" class="mt-4"></div>
                <div class="card-body">
                    <h5 class="card-title text-center">Coordinated Care</h5>
                    <h6 class="card-subtitle mb-2 text-muted text-center">Start a conversation, or two, or three.</h6>
                    <p class="card-text text-center">Engage in one-on-one or group chats with your care team.</p>

                </div>
            </div>
        </div>

        <div class="col-md-4">
            <div class="card landing-card" style="width: 18rem;">
                    <%--<a href="https://www.flaticon.com/free-icons/care" title="care icons">Care icons created by Freepik - Flaticon</a>--%>
                <div class="card-icon-cap text-center"><img src="/pub/images/hands.png" alt="big hand holding little hand icon" class="mt-4"></div>
                <div class="card-body">
                    <h5 class="card-title text-center">360&deg Care</h5>
                    <h6 class="card-subtitle mb-2 text-muted text-center">Postpartum questions? We're here for them.</h6>
                    <p class="card-text text-center">Receive support through the postpartum period</p>
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
            <p>To get started, create a conversation.  Your conversation history will be saved below.</p>
            <a href="/user/conversation">
                <button>Create a Conversation</button>
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
                <div class="card w-75" id="convCard">
                    <div class="card-body">
                        <h3 class="card-title text-center" id="ucSubject">${uc.subject}</h3>
                        <p class="card-text text-center"><fmt:formatDate type="date" value="${uc.create_date}"/></p>
                        <button type="submit" class="btn float-end" id="sButton button-addon2">Continue Conversation</button>
                    </div>
                </div>
            </form>
        </c:forEach>
    </div>
</sec:authorize>
<%--End conversation history section--%>
<jsp:include page="include/footer.jsp"/>