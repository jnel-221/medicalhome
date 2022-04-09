<%@ taglib prefix="c" uri="http://www.springframework.org/tags" %>

<jsp:include page="../include/header.jsp"/>
<div class="bg">
    <div class="row">
        <div class="col-sm-6 m-auto card-container">
            <div class="card" id="regCard">
                <div class="card-body">
                    <h2 class="text-center mt-4">Create Account</h2>
                    <form id="regForm" class="m-5" action="/user/register">

                        <div class="mb-3">
                            <label for="firstName" class="form-label">First Name</label>
                            <input
                                    type="text"
                                    id="firstName"
                                    class="form-control"
                                    placeholder=""
                                    name="firstName"
                            />
                            <p id="firstNameError"></p>
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
                            <p id="lastNameError"></p>
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

                        <div class="mb-3 reveal-if-active" id="provider_reg_field1">
                            <select class="form-select" aria-label="Default select example">
                                <option selected>Select Specialty</option>
                                <option value="1">Obstetrics & Gynecology</option>
                                <option value="2">Perinatal/Maternal & Fetal Medicine</option>
                                <option value="3">Endocrinology, Diabetes & Metabolism</option>
                                <option value="4">Dietary & Nutritional Service</option>
                            </select>
                        </div>
                        <div class="mb-3 reveal-if-active" id="provider_reg_field2">
                            <select class="form-select" aria-label="Default select example">
                                <option selected>Select Credential</option>
                                <option value="1">MD/DO</option>
                                <option value="2">NP</option>
                                <option value="3">CNS</option>
                                <option value="4">RD</option>
                            </select>
                        </div>

<%--                        <div class="mb-3 reveal-if-active">--%>
<%--                           --%>
<%--                        </div>--%>


                        <div class="mb-3">
                            <label for="email" class="form-label">Email address</label>
                            <input
                                    type="email"
                                    class="form-control"
                                    id="email"
                                    aria-describedby="emailHelp"
                                    name="email"
                            />
                            <p id="emailError"></p>
                        </div>
                        <div class="mb-3">
                            <label for="password" class="form-label">Password</label>
                            <input type="password" class="form-control" id="password" name="password"/>
                            <p id="passwordError"></p>
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