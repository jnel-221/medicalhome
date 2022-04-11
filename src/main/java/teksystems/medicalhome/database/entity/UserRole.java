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
@Table(name = "user_roles")

public class UserRole {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "user_role")
    private String userRole;

    @Column(name = "user_id")
    private Integer userId;

    @EqualsAndHashCode.Exclude //exclude date from Equals and Hash methods
    @ToString.Exclude //exclude date from toString method
    @Column(name = "create_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createDate;
}
