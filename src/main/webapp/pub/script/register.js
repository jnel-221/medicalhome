//get input fields by id; store in global variables
let inputFirstName = $("#firstName");
let inputLastName = $("#lastName");
let inputEmail = $("#email");
let inputPass = $("#password");
let inputConfirmPass = $("#confirmPass");
let sButton = $("sButton");

//event listener to remove hidden class after provider radio input checked
$("#provider").click(function (e) {
   // e.preventDefault();
    //alert("I've been clicked");
    $("#provider_reg_field1").removeClass("reveal-if-active");
    $("#provider_reg_field2").removeClass("reveal-if-active");
});

//event listener to add hidden class after patient radio input checked
$("#patient").click(function (e) {
   // e.preventDefault();
    //alert("I've been clicked");
    $("#provider_reg_field1").addClass("reveal-if-active");
    $("#provider_reg_field2").addClass("reveal-if-active");
});

//event listener calls to validation functions, if form is valid, will alert field values and redirect to provider page.
// $("#sButton").click(function (e) {
//     e.preventDefault();
//
//     validateFirstName();
//     validateLastName();
//     validateEmail();
//     validatePassword();
//     confirmPassword();
//
// });

//validate first name
function validateFirstName() {
    let firstName = inputFirstName.val();
    let regexNum = /\d/; //regex to find numbers in name;
    let regexAlpha = /^[A-Za-z]+$/; //regex to include all letters and ensure no space

    let result = true;
    if (firstName == "") {
        inputFirstName.addClass("inputError");
        $("#firstNameError")
            .html("First name cannot be blank.")
            .addClass("errorText");
        result = false;
    } else if (firstName.match(regexNum)) {
        console.log("you entered numbers");
        inputFirstName.addClass("inputError");
        $("#firstNameError")
            .html("First name cannot contain a number")
            .addClass("errorText");
        result = false;
    } else if (firstName.match(regexAlpha)) {
        inputFirstName.removeClass("inputError");
        $("#firstNameError").html("").removeClass("errorText");
        result = true;
    }
    return result;
}

//validate last name
function validateLastName() {
    let lastName = inputLastName.val();
    let exNum = /\d/; //regex to find numbers in name;
    let exAlpha = /^[A-Za-z]+$/; //regex to include all letters and ensure no space
    let result = true;

    if (lastName == "") {
        inputLastName.addClass("inputError");
        $("#lastNameError")
            .html("Last name cannot be blank.")
            .addClass("errorText");
        result = false;
    } else if (lastName.match(exNum)) {
        inputLastName.addClass("inputError");
        $("#lastNameError")
            .html("Last name cannot contain a number")
            .addClass("errorText");
        result = false;
    } else if (lastName.match(exAlpha)) {
        inputLastName.removeClass("inputError");
        $("#lastNameError").html("").removeClass("errorText");
        result = true;
    }
    return result;
}

//validate email
function validateEmail() {
    // console.log("email is: " + email);
    let email = inputEmail.val();
    let ex = /^([a-zA-Z0-9_\-\.]+)@([a-zA-Z0-9_\-\.]+)\.([a-zA-Z]{2,5})$/; //regex to validate email address
    let result = true;

    if (email == "") {
        inputEmail.addClass("inputError");
        $("#emailError").html("Email cannot be blank.").addClass("errorText");
        result = false;
    } else if (!email.match(ex)) {
        inputEmail.addClass("inputError");
        $("#emailError")
            .html("Please enter a valid email address.")
            .addClass("errorText");
        result = false;
    } else {
        inputEmail.removeClass("inputError");
        $("#emailError").html("").removeClass("errorText");
        console.log(email);
        result = true;
    }

    return result;
}

function validatePassword() {
    let password = inputPass.val();
    let lower = /[a-z]/; //regex for lower case
    let upper = /[A-Z]/; //regex for upper case
    let num = /\d/; //regex for numbers
    let special = /[@$!%*#?&]/; //regex for special characters
    let result = true;

    if (password == "") {
        inputPass.addClass("inputError");
        $("#passwordError").html("Password cannot be blank.").addClass("errorText");
        result = false;
    } else if (password.length < 8 || password.length > 20) {
        inputPass.addClass("inputError");
        $("#passwordError").html("Password must be between 8-20 characters long").addClass("errorText");
        result = false;
    } else if (!password.match(lower)) {
        inputPass.addClass("inputError");
        $("#passwordError").html("Password must contain at least one lower-case letter").addClass("errorText");
        result = false;
    } else if (!password.match(upper)) {
        inputPass.addClass("inputError");
        $("#passwordError").html("Password must contain at least one upper-case letter").addClass("errorText");
        result = false;
    } else if (!password.match(num)) {
        inputPass.addClass("inputError");
        $("#passwordError").html("Password must contain at least one number").addClass("errorText");
        result = false;
    } else if (!password.match(special)) {
        inputPass.addClass("inputError");
        $("#passwordError").html("Password must contain at least one special character (@$!%*#?&)").addClass("errorText");
        result = false;
    } else {
        inputPass.removeClass("inputError");
        $("#passwordError").html("").removeClass("errorText");
        result = true;
    }
    return result;
}

//confirm password
function confirmPassword() {
    let password = inputPass.val();
    let confirmPass = inputConfirmPass.val();
    let result = true;

    if (confirmPass == "") {
        inputConfirmPass.addClass("inputError");
        $("#confirmPassError").html("Please confirm your password.").addClass("errorText");
        result = false;
    } else if (password != confirmPass) {
        inputConfirmPass.addClass("inputError");
        $("#confirmPassError").html("Passwords do not match.").addClass("errorText");
        result = false;
    } else {
        inputConfirmPass.removeClass("inputError");
        console.log(confirmPass + " " + password)
        $("#confirmPassError").html("").removeClass("errorText");
        result = true;
    }
    return result;
}

