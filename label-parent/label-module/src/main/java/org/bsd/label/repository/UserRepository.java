package org.bsd.label.repository;

import java.util.List;

import org.bsd.label.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{

	public List<User> findByLoginNameAndPassWord(String userName,String passWord);
}
