package teksystems.medicalhome.database.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import teksystems.medicalhome.database.entity.Conversation;
import teksystems.medicalhome.database.entity.Message;

import java.util.List;

@Repository
public interface MessageDAO extends JpaRepository<Message, Long> {
    public List<Message> findMessageByConversation(@Param("convId") Conversation convId);

    public Message findById(@Param("id")Integer id);

}
