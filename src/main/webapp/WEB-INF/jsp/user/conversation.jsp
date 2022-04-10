<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<jsp:include page="../include/header.jsp"/>
<%--Hero secton--%>
<div class="hero-image">
    <div class="hero-text">
        <h1 style="font-size: 50px" class="mt-5">What's on your mind?</h1>
        <p>Our team is here to help you. Let us know what you'd like to discuss</p>
        <form action="/user/conversationSubmit" method="post">
<%--            <label for="subject" class="form-label">Subject</label>--%>
            <input type="text" id="subject" class="form-control" placeholder="subject" name="subject"/>
            <c:forEach items="${bindingResult.getFieldErrors('subject')}" var="error">
            <p id="subjectError" class="errorText">${error.getDefaultMessage()}</p>
            </c:forEach>
            <button style="background-color: #f46d25">Discuss with your care-team</button>
        </form>
    </div>
</div>
<!-- end hero section-->


<jsp:include page="../include/footer.jsp"/>