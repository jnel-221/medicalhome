package teksystems.medicalhome.formbean;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import teksystems.medicalhome.database.entity.User;

import java.util.List;

@Getter
@Setter
@ToString
public class SearchFormBean {

   private String search;

   private List<User> searchResults;

}
