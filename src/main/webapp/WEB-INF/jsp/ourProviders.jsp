<%@ page isELIgnored="false" %>
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
            <h1 class="text-center my-4">Our Providers</h1>
            <table class="table" id="tbl-background">
                <thead>
                <tr scope="row">
                    <th></th>
                    <th>Name</th>
                    <th>Specialty</th>
                </tr>
                </thead>
                <tbody class="table_content">
            <c:forEach var="user" items="${users}">
                <tr scope="row">
                    <td><img class="ms-5" style="border-radius: 50%" src="${user.imgUrl}" alt="Dr.${user.firstName} ${user.lastName}"></td>
                    <td>${user.firstName} ${user.lastName}</td>
                    <td>${user.specialty}, ${user.credential}</td>
                </tr>
            </c:forEach>
                </tbody>
            </table>
        </div>
    </div>
</div>

<jsp:include page="include/footer.jsp"/>