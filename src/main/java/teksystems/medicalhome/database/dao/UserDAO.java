package teksystems.medicalhome.database.dao;

import org.springframework.data.repository.query.Param;
import teksystems.medicalhome.database.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface UserDAO extends JpaRepository<User, Long> {
    public User findById(@Param("id") Integer id);
    public List<User> findByFirstNameIgnoreCaseContaining(@Param("firstName")String name);
    public User findByEmail(@Param("email") String email);
    public List<User> findByFirstName(@Param("firstName") String firstName);
    public List<User> findByFirstNameAndLastName(@Param("firstName") String firstName, @Param("lastName") String lastName);



}