package teksystems.medicalhome.formbean;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@ToString
public class MessageFormBean {

    private Integer id;

    @NotBlank(message = "Please enter a message.")
    private String message;
}
