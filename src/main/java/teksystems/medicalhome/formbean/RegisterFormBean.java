package teksystems.medicalhome.formbean;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.validator.constraints.Length;
import teksystems.medicalhome.validation.EmailUnique;

import javax.validation.constraints.AssertTrue;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

@Getter
@Setter
@ToString
public class RegisterFormBean {
    //variables in bean match name attribute on form tag
    private Integer id;


    @EmailUnique(message = "An account with this email already exists.")
    @NotBlank(message = "Email is Required.")
    @Pattern(regexp="^[a-z0-9]+@[a-z]+\\.[a-z]{2,3}",message="Email format is invalid.")
    private String email;

    @NotBlank(message = "First name is required.")
    private String firstName;

    @NotBlank(message = "Last name is required.")
    private String lastName;

    @NotNull(message = "Please select account type.")
    private String acctType;

    private String specialty;

    private String credential;


    @NotBlank(message = "Password is required.")
    @Length(min = 8 , max = 16, message = "Password must be between 8 and 16 characters.")
    private String password;

    @NotBlank(message = "Confirm password is required.")
    private String confirmPass;
}
