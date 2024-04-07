package com.omnie.forms.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.omnie.forms.model.FormComponent;
import com.omnie.forms.service.DynamicFormService;

@RestController
@RequestMapping("api/client/form")
public class DynamicFormController {
	
	@Autowired
	private DynamicFormService dynamicFormService;
	
	@GetMapping
	public FormComponent getFormComponent(@RequestHeader String clientId) {
		return dynamicFormService.getFormComponent(clientId);
	}
	
	
	@PostMapping
	public FormComponent addFormComponent(@RequestHeader String clientId, @RequestBody FormComponent formComponent) {
		return dynamicFormService.addFormComponent(clientId, formComponent);
	}

}
