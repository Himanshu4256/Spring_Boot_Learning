package com.spring.jdbc;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

import com.spring.jdbc.dao.StudentDao;
import com.spring.jdbc.entities.Student;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println("Program started...");
        //ApplicationContext con =  new ClassPathXmlApplicationContext("com/spring/jdbc/config.xml");
        
        ApplicationContext con = new AnnotationConfigApplicationContext(JavaConfig.class);
        
        
        
        
        // [1] Normal way to insert data using SpringJDBC es way mai [Dao Classes] se koi mtlv nahi hai.
        //create the object of JdbcTemplate
       // JdbcTemplate template = con.getBean("jdbcTemplatee",JdbcTemplate.class);
        
        //INSERT QUERY
       // String query = "insert into student(id,name,city) values(?,?,?)";
        
        //fire query here no need to close connection,statement like- normal JDBC.
//        int result = template.update(query,45,"Vishal","Gurugram");
//        System.out.println("number of record inserted :"+result);
        
        StudentDao sd = con.getBean("studentDao",StudentDao.class);
        
        // [2] Standard way to insert data eske liye alg packages bnae hai Dao wagera k. 
        //INSERT DATA [data insert krne k liye ese simple uncomment kro]
        
//        Student s = new Student();
//        s.setId(46);
//        s.setName("John");
//        s.setCity("Delhi"); 
//        int r = sd.insert(s);
//        System.out.println("Student Added"+r);
        
        //UPDATE DATA
        Student sd2 = new Student();
        sd2.setId(45);
        sd2.setName("Piyush");
        sd2.setCity("Delhi");
        int result = sd.update(sd2);
        System.out.println("data changed"+result);
        
        //DELETE DATA
        int result1 = sd.delete(46);
        System.out.println("Deleted"+result1);
        
        
        //SELECT/FETCH DATA
        System.out.println("-----------------------------Sigle Row fetching using RowMapper-----------------------------.");
        Student student = sd.fetchStudent(1);
        System.out.println(student);
        
        System.out.println("-----------------------------All Rows fetching using RowMapper-----------------------------");
        List<Student> students = sd.fetchAllStudent();
        for (Student student2 : students) {
			System.out.println(student2);
		}
        
        
        
    }
}