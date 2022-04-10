<jsp:include page="../include/header.jsp"/>

<%--Hero secton--%>
<div class="hero-image">
    <div class="hero-text">
        <h1 style="font-size: 50px">What's on your mind?</h1>
        <p>Our team is here to help you. Let us know what you'd like to discuss</p>
        <form>
            <label for="subject" class="form-label">Subject</label>
            <input type="text" id="subject" class="form-control" placeholder="subject" name="subject" required/>
            <button style="background-color: #f46d25">Discuss with your care-team</button>
        </form>
    </div>
</div>
<!-- end hero section-->


<jsp:include page="../include/footer.jsp"/>