package teksystems.medicalhome.formbean;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.validation.constraints.NotBlank;

@Getter
@Setter
@ToString
public class ConversationFormBean {

    private Integer id;

    @NotBlank(message = "Please let us know what you'd like to discuss.")
    private String subject;
}
