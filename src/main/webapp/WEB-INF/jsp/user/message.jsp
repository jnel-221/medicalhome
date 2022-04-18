<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<jsp:include page="../include/header.jsp"/>

<main class="container-fluid row" id="bg-msg">
    <section class="col-3 my-3">
        <h4>Participants</h4>

<%--        this is a mock-up for now, will eventually add users from here--%>
        <div class="card mb-3" style="max-width: 540px;">
            <div class="row g-0">
                <div class="col-md-4">
                    <img src="..." class="img-fluid rounded-start" alt="...">
                </div>
                <div class="col-md-8">
                    <div class="card-body">
                        <h5 class="card-title">Card title</h5>
                        <p class="card-text">This is a wider card with supporting text below as a natural lead-in to additional content. This content is a little bit longer.</p>
                        <p class="card-text"><small class="text-muted">Last updated 3 mins ago</small></p>
                    </div>
                </div>
            </div>

            <div class="row g-0">
                <div class="col-md-4">
                    <img src="..." class="img-fluid rounded-start" alt="...">
                </div>
                <div class="col-md-8">
                    <div class="card-body">
                        <h5 class="card-title">Card title</h5>
                        <p class="card-text">This is a wider card with supporting text below as a natural lead-in to additional content. This content is a little bit longer.</p>
                        <p class="card-text"><small class="text-muted">Last updated 3 mins ago</small></p>
                    </div>
                </div>
            </div>

            <div class="row g-0">
                <div class="col-md-4">
                    <img src="..." class="img-fluid rounded-start" alt="...">
                </div>
                <div class="col-md-8">
                    <div class="card-body">
                        <h5 class="card-title">Card title</h5>
                        <p class="card-text">This is a wider card with supporting text below as a natural lead-in to additional content. This content is a little bit longer.</p>
                        <p class="card-text"><small class="text-muted">Last updated 3 mins ago</small></p>
                    </div>
                </div>
            </div>
        </div>
    </section>
<%--    will put participant info in this section--%>
    <div class="col-9 my-3">
        <header class="p-2 text-light text-center" id="bg-msg-header"><h1>Hello World!</h1></header>
<%--        add text box for main chat field--%>
<%--        add text-box for input field w/button for submitting--%>
        <ul id="messages">
<%--            may style this w/css and add each message as an li w/no bullet?--%>
        </ul>
        <form id="form" action="">
            <textarea id="message" class="form-control" autocomplete="on" name="message"/></textarea>
            <button type="submit" class="btn"  id="sButton button-addon2">Send</button>
        </form>

    </div>
</main>











<jsp:include page="../include/footer.jsp"/>