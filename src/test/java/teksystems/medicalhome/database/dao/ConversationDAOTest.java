package teksystems.medicalhome.database.dao;


import org.junit.jupiter.api.*;
import org.assertj.core.api.Assertions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;
import teksystems.medicalhome.database.entity.Conversation;

@DataJpaTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class ConversationDAOTest {

    @Autowired
    ConversationDAO conversationDAO;

//create conversation
@Test
@Order(1)
@Rollback(value = false)
public void createConversationTest(){
    Conversation conv = Conversation.builder().subject("Hello Jello.").build();
    conversationDAO.save(conv);

    Assertions.assertThat(conv.getId() > 0);
}

//read conversation
@Test
@Order(2)
public void getConversationTest(){

}

//update conversation
@Test
@Order(3)
@Rollback(value = false)
public void updateConversationTest(){

}

//delete Conversation
@Test
@Order(4)
@Rollback(value = false)
public void deleteConversationTest(){

}

}
