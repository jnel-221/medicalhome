package teksystems.medicalhome.database.dao;

import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import teksystems.medicalhome.database.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

@Repository
public interface UserDAO extends JpaRepository<User, Long> {
    public User findById(@Param("id") Integer id);
    public List<User> findByFirstNameIgnoreCaseContaining(@Param("firstName")String name);
    public User findByEmail(@Param("email") String email);
    public List<User> findByFirstName(@Param("firstName") String firstName);
    public List<User> findAll();
    public List<User> findBySpecialty(@Param("specialty") String specialty);
    public List<User> findByFirstNameAndLastName(@Param("firstName") String firstName, @Param("lastName") String lastName);
    public List<User> findByAcctType(@Param("acctType") String acctType);


}
