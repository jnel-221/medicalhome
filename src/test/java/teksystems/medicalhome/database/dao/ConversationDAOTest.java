package teksystems.medicalhome.database.dao;



import org.junit.jupiter.api.*;
import org.assertj.core.api.Assertions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;
import teksystems.medicalhome.database.entity.Conversation;
import teksystems.medicalhome.database.entity.Message;
import teksystems.medicalhome.database.entity.User;

import java.util.Optional;

@DataJpaTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class ConversationDAOTest {

    @Autowired
    MessageDAO messageDAO;

    @Autowired
    UserDAO userDAO;

    @Autowired
    ConversationDAO conversationDAO;

    //create message
    @Test
    @Order(1)
    @Rollback(value = false)
    public void createMessageTest(){
        User user = User.builder().firstName("Jen").lastName("Bob").email("jen@bob.com").build();
        userDAO.save(user);

        Conversation conversation = Conversation.builder().subject("Stuff").build();
        conversationDAO.save(conversation);

        Message message = Message.builder().user(user).conversation(conversation).message("Hello Jello").build();
        messageDAO.save(message);

        Assertions.assertThat(message.getId() > 0);
    }

    //read message
    @Test
    @Order(2)
    public void getMessageTest(){
        Message message = messageDAO.findById(1);
        Assertions.assertThat(message.getId() == 1);
    }

    //update message
    @Test
    @Order(3)
    @Rollback(value = false)
    public void updateMessageTest(){
        Message message = messageDAO.findById(1);
        message.setMessage("Goodbye Jello");
        Assertions.assertThat(messageDAO.findById(1).getMessage().equals(message.getMessage()));
    }

    //delete message
    @Test
    @Order(4)
    @Rollback(value = false)
    public void deleteMessageTest(){
        Message message = messageDAO.findById(1);
        messageDAO.delete(message);

        Optional<Message> optionalMessage = Optional.ofNullable((messageDAO.findById(message.getId())));

        Message tempMessage = null;

        if(optionalMessage == null){
            tempMessage = optionalMessage.get();
        }

        Assertions.assertThat(tempMessage).isNull();
    }

}
