
<jsp:include page="../include/header.jsp"/>
<div class="bg">
    <div class="row">
        <div class="col-sm-6 m-auto card-container">
            <div class="card" id="regCard">
                <div class="card-body">
                    <form id="regForm" class="m-5">
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
                            <input type="password" class="form-control" id="password" />
                            <p id="passwordError"></p>
                        </div>
                        <div style="text-align: center;">
                            <button type="submit" class="btn" id="sButton">Login</button>
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </div>
</div>
<jsp:include page="../include/footer.jsp"/>