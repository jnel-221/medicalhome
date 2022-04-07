<jsp:include page="../include/header.jsp"/>
<div class="bg">
    <div class="row">
        <div class="col-sm-6 m-auto card-container">
            <div class="card" id="regCard">
                <div class="card-body">
                    <form id="regForm" class="m-5" action="/user/register">
                        <div class="mb-3">
                            <label for="firstName" class="form-label">First Name</label>
                            <input
                                    type="text"
                                    id="firstName"
                                    class="form-control"
                                    placeholder="First Name"
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
                                    placeholder="Last Name"
                                    name="lastName"
                            />
                            <p id="lastNameError"></p>
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
                            <p id="emailError"></p>
                            <!-- <div id="emailHelp" class="form-text">
                              We'll never share your email with anyone else.
                            </div> -->
                        </div>
                        <div class="mb-3">
                            <label for="password" class="form-label">Password</label>
                            <input type="password" class="form-control" id="password" name="password" />
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