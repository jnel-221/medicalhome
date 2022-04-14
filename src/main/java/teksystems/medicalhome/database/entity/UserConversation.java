package teksystems.medicalhome.database.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Inheritance(strategy= InheritanceType.JOINED)
@Table(name = "user_conversation")
public class UserConversation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Integer id;

    //many to one rel w/User
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name= "user_id",nullable = false)
    private User user;

    //many to one rel w/Conversation
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "conv_id", nullable = false)
    private Conversation conversation;

}
