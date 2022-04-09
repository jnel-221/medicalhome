package teksystems.medicalhome.database.entity;

import lombok.*;

import javax.persistence.*;
import java.util.Date;


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

    @Column(name = "password") // may need to change this based on DB structure.
    private String password;

    @EqualsAndHashCode.Exclude //exclude date from Equals and Hash methods
    @ToString.Exclude //exclude date from toString method
    @Column(name = "create_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createDate;

}
