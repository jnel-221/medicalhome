package teksystems.medicalhome.database.dao;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import teksystems.medicalhome.database.entity.User;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@DataJpaTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class UserDAOTest {

    @Autowired
    UserDAO userDAO;

 //create
    @BeforeEach
    public void saveUserTest(){
        User testUser = new User();
        testUser.setFirstName("Jen");
        testUser.setLastName("Bob");
        testUser.setAcctType("patient");
        testUser.setEmail("jenB@bob.com");
        testUser.setPassword("password");
        testUser.setCreateDate(new Date());
        userDAO.save(testUser);

        User testUser1 = new User();
        testUser1.setFirstName("Sujata");
        testUser1.setLastName("Bob");
        testUser1.setAcctType("patient");
        testUser1.setEmail("sujata@bob.com");
        testUser1.setPassword("password");
        testUser1.setCreateDate(new Date());
        userDAO.save(testUser1);

    }

 //read
    @Test
    @Order(1)
    public void createUser(){

        User testUser = userDAO.findByEmail("jen@bob.com");
        assertNotNull(testUser);
    }
  //update

    @Order(1)
    @ParameterizedTest
    @ValueSource(strings = {"jenB@bob.com", "sujata@bob.com"})
    public void findUserTest(String email){
        User findUser = userDAO.findByEmail(email);
        assertNotNull(findUser);
    }
 //delete
}
