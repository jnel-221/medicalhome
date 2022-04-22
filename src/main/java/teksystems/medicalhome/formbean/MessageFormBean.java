package teksystems.medicalhome.formbean;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.validation.constraints.NotNull;

@Getter
@Setter
@ToString
public class MessageFormBean {

    private Integer id;

    @NotNull(message ="Add a message")
    private String message;
}
