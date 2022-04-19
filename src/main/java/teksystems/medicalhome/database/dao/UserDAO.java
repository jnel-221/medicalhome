package teksystems.medicalhome.database.dao;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import teksystems.medicalhome.database.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

@Repository
public interface UserDAO extends JpaRepository<User, Long> {
    public User findById(@Param("id") Integer id);

    public User findByEmail(@Param("email") String email);

    @Query(value="SELECT u FROM User u ORDER BY u.specialty, u.lastName")
    public List<User> findAll();

    public List<User> findBySpecialty(@Param("specialty") String specialty);

    @Query(value="SELECT u FROM User u WHERE u.acctType = 'provider' ORDER BY u.specialty, u.lastName ")
    public List<User> findByAcctType(@Param("acctType") String acctType);




}
