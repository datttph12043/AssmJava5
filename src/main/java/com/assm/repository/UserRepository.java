package com.assm.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.assm.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
	@Query("SELECT entity FROM User entity WHERE email =:email")
	public User finByEmail(@Param("email") String email);
	
	@Query("SELECT entity FROM User entity WHERE id =:id")
	public User finById(@Param("id") Integer id);

}
