package teksystems.medicalhome.database.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import teksystems.medicalhome.database.entity.Conversation;

import java.util.List;

@Repository
public interface ConversationDAO extends JpaRepository<Conversation, Long> {
    public Conversation findById(@Param("id") Integer id);
    public List<Conversation> findBySubjectIgnoreCaseContaining(@Param("subject") String subject);


}
