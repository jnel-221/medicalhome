<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>

<jsp:include page="../include/header.jsp"/>

<main class="row main-content ps-3" id="bg-msg">
    <section class="col-3 my-3 main_content_left">
        <h4 id="participant-header">Participants</h4>
        <div class="card mb-3" style="max-width: 540px;">
            <c:forEach var="user" items="${users}">
            <div class="row g-0">
                <div class="col-md-4">
                    <c:choose>
                        <c:when test="${user.imgUrl != null}">
                            <img src="${user.imgUrl}" class="ms-4 mt-4" style="border-radius: 50%"
                                 alt="${user.firstName} ${user.lastName}">
                        </c:when>
                        <c:otherwise>
                            <%--<div> Icons made by <a href="https://www.flaticon.com/authors/phoenix-group" title="Phoenix Group"> Phoenix Group </a> from <a href="https://www.flaticon.com/" title="Flaticon">www.flaticon.com'</a></div>--%>
                            <img src="/pub/images/userIcon.png" class="ms-4 mt-4"
                                 alt="${user.firstName} ${user.lastName}">
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
                <div class="d-grid gap-1">
                    <a href="/home" class="btn msg-link" role="button">Return to Home</a>
                    <a href="/user/conversation" class="btn msg-link" role="button">Start New Conversation</a>
                </div>
            </div>
        </div>
    </section>

    <div class="col-9">
        <div class="row main_content_right">
            <div class="col-12">
                <header class="text-center bg-secondary" id="bg-msg-header"><h1>${conversation.subject}</h1></header>
                <ul id="messages">
                    <c:forEach var="message" items="${messages}">
                        <li><p>${message.message}</p>
                            <p style="font-style: italic; text-align: right; margin: 0">-${message.user.firstName} ${message.user.lastName}</p>
                            <p style="font-size: x-small; text-align: right"><fmt:formatDate type = "both" value = "${message.createDate}" /></p>
                        </li>
                    </c:forEach>
                </ul>
                <div id="type-box">
                    <form id="form" var="conversation" action="/user/message/${conversation.id}" method="post">
                        <input type="hidden" name="id" value=${conversation.id}>
                        <textarea id="message" class="form-control" data-convId=${conversation.id} autocomplete="on"
                                  name="message"></textarea>
                        <button type="submit" class="btn" id="sButton button-addon2">Send</button>
                        <c:forEach items="${bindingResult.getFieldErrors('message')}" var="error">
                            <p id="acctTypeError" class="errorText">${error.getDefaultMessage()}</p>
                        </c:forEach>
                    </form>
                </div>

            </div>
        </div>
    </div>
</main>
<jsp:include page="../include/footer.jsp"/>