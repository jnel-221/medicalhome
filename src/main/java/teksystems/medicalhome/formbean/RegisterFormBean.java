package teksystems.medicalhome.formbean;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

@Getter
@Setter
@ToString
public class RegisterFormBean {
    //variables in bean match name field on forms
    private Integer id;

    //need to decide if I'll convert the JavaScript form validation to Spring form validation

    @NotBlank(message = "Email is Required.")
    @Pattern(regexp="^[a-z0-9]+@[a-z]+\\.[a-z]{2,3}",message="Email format is invalid.")
    private String email;

    @NotBlank(message = "First name is required.")
    private String firstName;

    @NotBlank(message = "Last name is required.")
    private String lastName;

    @Length(min = 3 , max = 15, message = "Password must be between 3 and 15 characters.")
    @NotBlank(message = "Password is required.")
    private String password;

    @NotBlank(message = "Confirm password is required.")
    private String confirmPass;
}