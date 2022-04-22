package teksystems.medicalhome.database.entity;

import lombok.*;


import javax.persistence.*;
import java.util.Date;

@Builder
@Getter
@Setter
@ToString
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "message")
public class Message {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    //many to one rel w/User
    @ToString.Exclude
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name= "user_id",nullable = false)
    private User user;

    //many to one rel w/Conversation
    @ToString.Exclude
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "conv_id", nullable = false)
    private Conversation conversation;

    @Column(name="message", columnDefinition = "TEXT")
    private String message;

   @EqualsAndHashCode.Exclude
   @ToString.Exclude
   @Column(name = "create_date")
   @Temporal(TemporalType.TIMESTAMP)
   private Date createDate;


}
