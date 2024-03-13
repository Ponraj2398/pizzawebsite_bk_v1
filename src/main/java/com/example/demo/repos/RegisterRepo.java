package com.example.demo.repos;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Register;

@Repository
public interface RegisterRepo extends JpaRepository<Register, Integer> {

//	List<Register> findByUsernameAndPassword(String username, String password);

//	List<Register> findByUsername(String username);

	Optional<Register> findByUsernameAndPassword(String username, String password);

	boolean existsByUsername(String username);

}
