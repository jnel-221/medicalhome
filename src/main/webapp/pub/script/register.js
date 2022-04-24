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


    // console.log("i'm ready!");
    // let subjects = [];
    // let subjectHeading = $("#ucSubject").html();
    // subjects.push(subjectHeading);
    // console.log(subjects);
    // subjectHeading = subjectHeading.toLowerCase().split(" ").map((s) => s.charAt(0).toUpperCase()+s.substring(1)).join(' ');
    //
    // console.log(subjectHeading);
    // $("#ucSubject").html(subjectHeading);





