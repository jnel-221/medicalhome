package teksystems.medicalhome.database.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import teksystems.medicalhome.database.entity.Conversation;



@Repository
public interface ConversationDAO extends JpaRepository<Conversation, Long> {
    public Conversation findById(@Param("id") Integer id);

}
