<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<jsp:include page="include/header.jsp"/>

<div class="bg">
    <div class="row">
        <div class="class col-sm-12">
            <h1 class="text-center">Hello Jello</h1>
        </div>
    </div>
    <div class="row">
        <div class="col-sm-10 m-auto">
            <h1>Our Providers</h1>
            <table class="table" id="tbl-background">
                <thead>
                <tr scope="row">
                    <th></th>
                    <th>Name</th>
                    <th>Specialty</th>
                </tr>
                </thead>
                <tbody class="table_content">

                <tr scope="row">
                    <td><img src="${photo}" alt="Dr.${firstN} ${lastN}"></td>
                    <td>${firstN} ${lastN}</td>
                    <td>${streetNumber} ${streetName}</td>
                </tr>

                </tbody>
            </table>
        </div>
    </div>
</div>

<jsp:include page="include/footer.jsp"/>