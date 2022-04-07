package teksystems.medicalhome.database.dao;

import org.springframework.data.repository.query.Param;
import teksystems.medicalhome.database.entity.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface PatientDAO extends JpaRepository<Patient, Long> {
    public Patient findById(@Param("id") Integer id);
    public List<Patient> findByFirstNameIgnoreCaseContaining(@Param("firstName")String name);
    public Patient findByEmail(@Param("email") String email);
    public List<Patient> findByFirstName(@Param("firstName") String firstName);
    public List<Patient> findByFirstNameAndLastName(@Param("firstName") String firstName, @Param("lastName") String lastName);



}
