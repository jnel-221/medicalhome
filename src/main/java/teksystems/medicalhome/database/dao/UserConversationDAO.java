package teksystems.medicalhome.database.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;
import teksystems.medicalhome.database.entity.UserConversation;



@Repository
public interface UserConversationDAO extends JpaRepository<UserConversation, Long> {

}
