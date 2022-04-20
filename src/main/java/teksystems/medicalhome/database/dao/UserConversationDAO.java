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

    public List<UserConversation> findByUserIdAndConversationId(@Param("user_id") Integer userId, @Param("conv_id") Integer convId);
    public List<UserConversation> findByConversation(@Param("conversation") Conversation conversation);

}
