package teksystems.medicalhome.database.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import teksystems.medicalhome.database.entity.Conversation;
import teksystems.medicalhome.database.entity.User;
import teksystems.medicalhome.database.entity.UserConversation;

import java.util.List;


@Repository
public interface UserConversationDAO extends JpaRepository<UserConversation, Long> {

//    @Query(value="SELECT u.first_name, u.last_name, u.img_url, u.specialty, u.credential, c.* " +
//            "FROM user u, user_conversation uc, conversation c " +
//            "WHERE u.id = uc.user_id AND c.id = uc.conv_id AND c.id = :id",
//    nativeQuery = true)
//    @Query(value="SELECT u.firstName, u.lastName, u.imgUrl, u.specialty, u.credential, c " +
//            "FROM User u, UserConversation uc, Conversation c " +
//            "WHERE u.id = uc.user.id AND c.id = uc.conversation.id AND c.id = :id")
//    public List<UserConversation> findById(@Param("id") Integer id);

    public List<UserConversation> findByUserIdAndConversationId(@Param("user_id") Integer userId, @Param("conv_id") Integer convId);
    public List<UserConversation> findByConversation(@Param("conversation") Conversation conversation);

}
