package com.report.model;

import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "candidates")
@Data
public class Candidate {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
     
    private String email;
     
    private String password;
     
    @Column(name = "full_name")
    private String fullName;
     
//    @ManyToMany(cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
//    @JoinTable(
//            name = "candidates_roles",
//            joinColumns = @JoinColumn(name = "candidate_id"),
//            inverseJoinColumns = @JoinColumn(name = "role_id")
//            )
//    private Set<Roles> roles = new HashSet<>();
}