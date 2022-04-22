
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<jsp:include page="../include/header.jsp"/>

<main class="row" id="bg-msg">
    <section class="col-3 my-3">
        <h4>Participants</h4>
        <section class="card mb-3" style="max-width: 540px;">
            <c:forEach var="user" items="${users}">
            <div class="row g-0">
                <div class="col-md-4">
                    <c:choose>
                        <c:when test="${user.imgUrl != null}">
                        <img src="${user.imgUrl}" class="ms-4 mt-4" style="border-radius: 50%" alt="${user.firstName} ${user.lastName}">
                        </c:when>
                        <c:otherwise>
<%--                            <div> Icons made by <a href="https://www.flaticon.com/authors/phoenix-group" title="Phoenix Group"> Phoenix Group </a> from <a href="https://www.flaticon.com/" title="Flaticon">www.flaticon.com'</a></div>--%>
                            <img src="/pub/images/userIcon.png" class="ms-4 mt-4" alt="${user.firstName} ${user.lastName}">
                        </c:otherwise>
                    </c:choose>
                </div>
                <div class="col-md-8">
                    <div class="card-body">
                        <h5 class="card-title">${user.firstName} ${user.lastName}</h5>
                        <p class="card-text">${user.specialty}</p>
                        <p class="card-text"><small class="text-muted">${user.credential}</small></p>
                    </div>
                </div>
                </c:forEach>
            </div>
        </section>
<%--    will put participant info in this section--%>
    <div class="col-9 my-3">
        <div class="row">
            <div class="col-12">
                <header class="p-2 text-light text-center" id="bg-msg-header"><h1>${conversation.subject}</h1></header>
                <%--        add text box for main chat field--%>
                <%--        add text-box for input field w/button for submitting--%>
                <ul id="messages">
                    <%--            may style this w/css and add each message as an li w/no bullet?--%>
                    <c:forEach var="message" items="${messages}">
                        <li>${message.message}</li>
                    </c:forEach>
                </ul>
                <form id="form" var="conversation" action="/user/message/${conversation.id}" method="post">
                    <input type="hidden" name="convId" value=${conversation.id}>
                    <textarea id="message" class="form-control" data-convId=${conversation.id} autocomplete="on" name="message"></textarea>
                    <button type="submit" class="btn" id="sButton button-addon2">Send</button>
                </form>
            </div>
        </div>
    </div>

</main>
<jsp:include page="../include/footer.jsp"/>