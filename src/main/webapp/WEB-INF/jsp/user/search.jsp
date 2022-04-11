<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<jsp:include page="../include/header.jsp"/>
<form>
<div class="mb-3 reveal-if-active" id="provider_reg_field1">
    <label class="form-check-label" for="specialty">Specialty</label>
    <select class="form-select" aria-label="Default select example" name="specialty" id="specialty">
        <option selected></option>
        <option value="Obstetrics & Gynecology">Obstetrics & Gynecology</option>
        <option value="Perinatal/Maternal & Fetal Medicine">Perinatal/Maternal & Fetal Medicine</option>
        <option value="Endocrinology, Diabetes & Metabolism">Endocrinology, Diabetes & Metabolism</option>
        <option value="Dietary & Nutritional Service">Dietary & Nutritional Service</option>
    </select>
</div>
</form>
<div class="bg">
    <div class="row">
        <div class="class col-sm-12">
            <h1 class="text-center">Hello Jello</h1>
        </div>
    </div>
    <div class="row">
        <div class="col-sm-10 m-auto">
            <table class="table" id="tbl-background">
                <thead>
                <tr>
                    <th></th>
                    <th>Name</th>
                    <th>Specialty</th>
                    <th>Credential</th>
                </tr>
                </thead>
                <tbody class="table_content">
                <!-- additional rows and data added programmatically -->

                </tbody>
            </table>
        </div>
    </div>
</div>
<jsp:include page="../include/footer.jsp"/>