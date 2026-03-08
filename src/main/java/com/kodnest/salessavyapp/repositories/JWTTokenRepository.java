package com.kodnest.salessavyapp.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.kodnest.salessavyapp.entities.JWTToken;

import jakarta.transaction.Transactional;

public interface JWTTokenRepository extends JpaRepository<JWTToken, Integer>{

	
	Optional<JWTToken> findByToken(String token);
	
	@Query("SELECT t FROM JWTToken t WHERE t.user.userId = :userId")
	JWTToken findByUserId (@Param("userId") int userId);
	
	@Modifying
    @Transactional
    @Query("DELETE FROM JWTToken t WHERE t.user.userId = :userId")
	void deleteByUserId(@Param("userId") int userId);
}
