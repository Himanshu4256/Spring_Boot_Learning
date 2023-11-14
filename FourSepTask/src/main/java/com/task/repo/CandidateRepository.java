package com.task.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.task.entities.Candidates;

@Repository
public interface CandidateRepository extends JpaRepository<Candidates, Integer> {

	@Query(value = "SELECT MAX(salary) FROM Candidates", nativeQuery = true)
	double findHighestSalary();

	@Query(value = "SELECT MIN(salary) FROM Candidates", nativeQuery = true)
	double findLowestSalary();

	@Query(value = "SELECT AVG(salary) FROM Candidates", nativeQuery = true)
	double findAverageSalary();

	@Query(value = "SELECT AVG(age) FROM Candidates", nativeQuery = true)
	double findaverageAge();

	@Query(value = "SELECT * FROM candidates where birthdate = 'September'", nativeQuery = true)
	String findBirthdate();
}
