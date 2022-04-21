package teksystems.medicalhome.database.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import teksystems.medicalhome.database.entity.Conversation;
import teksystems.medicalhome.database.entity.User;
import teksystems.medicalhome.database.entity.UserConversation;

import java.util.List;
import java.util.Map;


@Repository
public interface UserConversationDAO extends JpaRepository<UserConversation, Long> {

    @Query(value = "SELECT c.*" +
            "FROM user u, user_conversation uc, conversation c "+
            "WHERE u.id = uc.user_id AND c.id = uc.conv_id AND u.id = :userId "+
            "ORDER BY c.create_date DESC", nativeQuery = true)
    public List<Map<String, Object>> findAllConversationsByUserId(@Param("userId") Integer userId);

    public List<UserConversation> findByConversation(@Param("conversation") Conversation conversation);

}
