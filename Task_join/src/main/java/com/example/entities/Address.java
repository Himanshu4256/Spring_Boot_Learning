//package com.example.entities;
//
//import org.hibernate.annotations.GenericGenerator;
//
//import jakarta.persistence.Column;
//import jakarta.persistence.Entity;
//import jakarta.persistence.GeneratedValue;
//import jakarta.persistence.GenerationType;
//import jakarta.persistence.Id;
//import jakarta.persistence.JoinColumn;
//import jakarta.persistence.ManyToOne;
//import jakarta.persistence.Table;
//import lombok.Data;
//
//@Entity
//@Table(name = "address")
//@Data
//public class Address {
//
//	@Id
//	@GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
//	@GenericGenerator(strategy = "native", name = "native")
//	@Column(name = "address_id")
//	private int id;
//	private String state;
//	private String city;
//	private String village;
//	private String country;
//	private String pinCode;
//
//	@ManyToOne
//	@JoinColumn(name = "employee_id")
//	private Employee employee;
//
//}
