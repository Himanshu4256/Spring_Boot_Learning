package com.omnie.forms.repo;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.omnie.forms.model.FormComponent; 
  
public interface FormComponentRepository extends MongoRepository<FormComponent,String>{ 
  
}