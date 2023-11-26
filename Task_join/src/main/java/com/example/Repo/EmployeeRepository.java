package com.example.Repo;

import java.util.List;

import org.springframework.data.annotation.QueryAnnotation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.repository.query.Param;

import com.example.entities.Employee;
@EnableJpaRepositories
public interface EmployeeRepository extends JpaRepository<Employee, Long>{
	
	 @Query(value = "SELECT MAX(salary) FROM Employee", nativeQuery = true)
	    double findHighestSalary();

	    @Query(value = "SELECT MIN(salary) FROM Employee", nativeQuery = true)
	    double findLowestSalary();

	    @Query(value = "SELECT AVG(salary) FROM Employee", nativeQuery = true)
	    double findAverageSalary();
	  //average age of employee working
	    @Query(value = "SELECT AVG(age) FROM employee", nativeQuery = true)
	    Double calculateAverageAge();
	    //for birthday
	    @Query(value = "SELECT * FROM employee WHERE MONTH(birth_date) = 9", nativeQuery = true)
	    List<Employee> findEmployeesWithSeptemberBirthdays();
	    
	    @Query(value = "SELECT e.city, YEAR(CURDATE()) - YEAR(e.date_of_birth) AS age " +
	            "FROM employee e " +
	            "WHERE e.salary < 40000 " +
	            "AND e.hire_date <= DATE_SUB(CURDATE(), INTERVAL 2 YEAR) " +
	            "AND YEAR(CURDATE()) - YEAR(e.date_of_birth) > 50", nativeQuery = true)
	    List<Object[]> findEmployeesToGiveSalaryHike();
	
//	@Query(value="select * from employee",nativeQuery =true)
//	 public List<Employee>getEmployee();

//	 @Query(value = "SELECT e.name, a.city FROM Employee e " +
//             "INNER JOIN Address a ON e.address_id = a.id " +
//             "WHERE e.age > 45 " +
//             "AND e.salary IN (40000, 50000, 90000, 75000)", nativeQuery = true)
//	 List<Object[]> findEmployeesWithCityByAgeAndSalary();
////	 
////	 @Query("SELECT v.name, c.name FROM Village v " +
////	           "JOIN v.district d " +
////	           "JOIN d.city c " +
////	           "WHERE d.pinCode IN ('276203', '110090', '400072', '400074')")
////	    List<Object[]> findCityAndVillageNamesByPinCodes();
//	 @Query("SELECT DISTINCT l.city, l.village FROM Location l JOIN Address a ON l.village = a.village WHERE a.pinCode IN :pinCodes")
//	    List<Object[]> findCityAndVillageByPinCodes(@Param("pinCodes") List<String> pinCodes);
	
//	@Query("select * FROM employee")
//	public List<Employee>getAllEmployees();
	}


