package com.omnie.forms.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.omnie.forms.json.FormMetaDataFactory;
import com.omnie.forms.model.FormComponent;
import com.omnie.forms.repo.FormComponentRepository;

@Service
public class DynamicFormServiceimpl implements DynamicFormService {
	
	@Autowired
	private FormComponentRepository formComponentRepository;

	@Override
	public FormComponent getFormComponent(String clientId) {
		return FormMetaDataFactory.getInstance().findByid(clientId);
	}

	@Override
	public FormComponent addFormComponent(String clientId, FormComponent formComponent) {
		formComponentRepository.save(formComponent);
		return formComponent;
	}

}
