<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<jsp:include page="../include/header.jsp"/>
<div class="bg">
    <div class="row">
        <div class="col-sm-6 m-auto card-container">
            <div class="card" id="regCard">
                <div class="card-body">
                    <h2 class="text-center mt-4">Create Account</h2>
                    <form id="regForm" class="m-5" action="/user/registerSubmit" method="post">
                        <input type="hidden" name="id" value="${form.id}">
                        <div class="mb-3">
                            <label for="firstName" class="form-label">First Name</label>
                            <input
                                    type="text"
                                    id="firstName"
                                    class="form-control"
                                    placeholder=""
                                    name="firstName"
                            />
                            <c:forEach items="${bindingResult.getFieldErrors('firstName')}" var="error">
                            <p id="firstNameError" class="errorText">${error.getDefaultMessage()}</p>
                            </c:forEach>
                        </div>

                        <div class="mb-3">
                            <label for="lastName" class="form-label">Last Name</label>
                            <input
                                    type="text"
                                    id="lastName"
                                    class="form-control"
                                    placeholder=""
                                    name="lastName"
                            />
                            <c:forEach items="${bindingResult.getFieldErrors('lastName')}" var="error">
                            <p id="lastNameError" class="errorText">${error.getDefaultMessage()}</p>
                            </c:forEach>
                        </div>
                        <div class="mb-3">
                            <p>Account Type</p>
                            <div class="form-check form-check-inline">
                                <input class="form-check-input" type="radio" name="inlineRadioOptions" id="patient"
                                       value="patient">
                                <label class="form-check-label" for="patient">Patient</label>
                            </div>
                            <div class="form-check form-check-inline">
                                <input class="form-check-input" type="radio" name="inlineRadioOptions" id="provider"
                                       value="provider">
                                <label class="form-check-label" for="provider">Provider</label>
                            </div>
                        </div>
                        <%--reveal-if-active (add class back after testing complete)--%>
                        <div class="mb-3" id="provider_reg_field1">
                            <select class="form-select" aria-label="Default select example" name="specialty">
                                <option selected>Select Specialty</option>
                                <option value="OB/GYN">Obstetrics & Gynecology</option>
                                <option value="Perinatal">Perinatal/Maternal & Fetal Medicine</option>
                                <option value="Endocrine">Endocrinology, Diabetes & Metabolism</option>
                                <option value="Nutrition">Dietary & Nutritional Service</option>
                            </select>
                        </div>
                        <%--reveal-if-active (add class back after testing complete)--%>
                        <div class="mb-3 " id="provider_reg_field2">
                            <select class="form-select" aria-label="Default select example" name="credential">
                                <option selected>Select Credential</option>
                                <option value="MD/DO">MD/DO</option>
                                <option value="NP">NP</option>
                                <option value="CNS">CNS</option>
                                <option value="RD">RD</option>
                            </select>
                        </div>

                        <div class="mb-3">
                            <label for="email" class="form-label">Email address</label>
                            <input
                                    type="email"
                                    class="form-control"
                                    id="email"
                                    aria-describedby="emailHelp"
                                    name="email"
                            />
                            <c:forEach items="${bindingResult.getFieldErrors('email')}" var="error">
                            <p id="emailError" class="errorText">${error.getDefaultMessage()}</p>
                            </c:forEach>
                        </div>
                        <div class="mb-3">
                            <label for="password" class="form-label">Password</label>
                            <input type="password" class="form-control" id="password" name="password"/>
                            <c:forEach items="${bindingResult.getFieldErrors('password')}" var="error">
                            <p id="passwordError" class="errorText">${error.getDefaultMessage()}</p>
                            </c:forEach>
                        </div>
                        <div class="mb-3">
                            <label for="confirmPass" class="form-label"
                            >Confirm Password</label
                            >
                            <input
                                    type="password"
                                    class="form-control"
                                    id="confirmPass"
                                    name="confirmPass"
                            />
                            <p id="confirmPassError"></p>
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