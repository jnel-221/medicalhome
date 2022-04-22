package teksystems.medicalhome.database.dao;

import org.junit.jupiter.api.*;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;
import teksystems.medicalhome.database.entity.User;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@DataJpaTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class UserDAOTest {

    @Autowired
    UserDAO userDAO;



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
        testUser1.setAcctType("provider");
        testUser1.setSpecialty("Obstetrics & Gynecology");
        testUser1.setCredential("NP");
        testUser1.setEmail("sujata@bob.com");
        testUser1.setPassword("password");
        testUser1.setCreateDate(new Date());
        userDAO.save(testUser1);

    }

//    @Test
//    @Order(1)
//    public void createUser(){
//        User user = User.builder().user
//
//    }



    @ParameterizedTest
    @Order(1)
    @ValueSource(strings = {"jenB@bob.com", "sujata@bob.com"})
    public void findUserTest(String email){
        User user = userDAO.findByEmail(email);
        assertNotNull(user);
    }


    @Test
    @Order(2)
    public void getListOfUsers(){
        List<User> users = userDAO.findAll();
        Assertions.assertThat(users.size() > 0);
    }

    @Test
    @Order(3)
    @Rollback(value = false)
    public void updateUserTest(){
        User user = userDAO.findByEmail("jenB@bob.com");

        user.setSpecialty("Perinatal/Maternal & Fetal Medicine");
        Assertions.assertThat(userDAO.findById(2).getSpecialty().equals(user.getSpecialty()));
    }

    @Test
    @Order(4)
    @Rollback(value = false)
    public void deleteUserTest(){
        User user = userDAO.findByEmail("sujata@bob.com");
        userDAO.delete(user);

        Optional<User> optionalUser = Optional.ofNullable((userDAO.findByEmail(user.getEmail())));

        User tempUser = null;
        if(optionalUser == null){
            tempUser = optionalUser.get();
        }

        Assertions.assertThat(tempUser).isNull();
    }

}
