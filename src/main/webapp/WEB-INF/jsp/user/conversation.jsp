<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<jsp:include page="../include/header.jsp"/>
<%--Hero secton--%>
<div class="hero-image">
    <div class="hero-text">
        <h1 style="font-size: 50px" class="mt-5">Working Title</h1>
        <p>maybe something else here, like Welcome So & So....</p>
    </div>
</div>
<!-- end hero section-->
<div class="bg">
    <div class="row">
        <div class="col-sm-6 m-auto card-container">
            <div class="card" id="regCard">
                <div class="card-body">
                    <h2 class="text-center mt-4">New Conversation</h2>
                    <form action="/user/conversationSubmit" method="post">
                        <input type="hidden" name="id" value="${user.id}">
                        <div class="mb-3">
                            <label for="subject" class="form-label">Subject</label>
                            <input type="text" id="subject" class="form-control" placeholder="subject" name="subject"/>
                            <c:forEach items="${bindingResult.getFieldErrors('subject')}" var="error">
                                <p id="subjectError" class="errorText">${error.getDefaultMessage()}</p>
                            </c:forEach>
                        </div>

                        <div class="mb-3">
                            <label class="form-check-label" for="specialty">Specialty</label>
                            <select class="form-select" aria-label="Default select example" name="userId" id="specialty" multiple>
                                <option selected></option>
                                <c:forEach items="${usersMenu}" var="user">
                                <option value="${user.id}" data-name="${user.firstName}">${user.firstName} ${user.lastName},  ${user.specialty} </option>
                                </c:forEach>
                            </select>
                        </div>

                        <div style="text-align: center;">
                            <button type="submit" class="btn" id="sButton">
                                Create Account
                            </button>
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </div>
</div>


<jsp:include page="../include/footer.jsp"/>