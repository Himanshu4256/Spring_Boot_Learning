package com.omnie.forms.model;

import java.util.Map;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(value = Include.NON_NULL)
@Document
public class FormComponent {
	
	@Id
	private String id;

	private FormSchema formSchema;

	private Map<String, Object> formData;

	private Map<String, FormProperty> uiSchema;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public FormSchema getFormSchema() {
		return formSchema;
	}

	public void setFormSchema(FormSchema formSchema) {
		this.formSchema = formSchema;
	}

	public Map<String, Object> getFormData() {
		return formData;
	}

	public void setFormData(Map<String, Object> formData) {
		this.formData = formData;
	}

	public Map<String, FormProperty> getUiSchema() {
		return uiSchema;
	}

	public void setUiSchema(Map<String, FormProperty> uiSchema) {
		this.uiSchema = uiSchema;
	}

}
