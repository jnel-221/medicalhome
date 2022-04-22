package teksystems.medicalhome.database.entity;

import lombok.*;

import javax.persistence.*;

import java.util.Date;
import java.util.Set;


@Builder
@Getter
@Setter
@ToString
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "conversation")
public class Conversation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @OneToMany(mappedBy = "conversation", fetch = FetchType.LAZY)
    private Set<UserConversation> userConversations;

    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @OneToMany(mappedBy = "message", fetch = FetchType.LAZY)
    private Set<Message> messages;

    @Column(name = "subject")
    private String subject;

    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    @Column(name = "create_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createDate;

}
