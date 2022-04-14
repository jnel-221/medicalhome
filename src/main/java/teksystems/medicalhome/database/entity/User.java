package teksystems.medicalhome.database.entity;

import lombok.*;

import javax.persistence.*;
import java.util.Date;
import java.util.List;
import java.util.Set;


@Getter
@Setter
@ToString
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY)
    private Set<UserConversation> userConversations;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "email")
    private String email;

    @Column(name = "img_url")
    private String imgUrl;

    @Column(name = "specialty")
    private String specialty;

    @Column(name = "credential")
    private String credential;

    @Column(name = "password") 
    private String password;

    @EqualsAndHashCode.Exclude //exclude date from Equals and Hash methods
    @ToString.Exclude //exclude date from toString method
    @Column(name = "create_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createDate;

}
