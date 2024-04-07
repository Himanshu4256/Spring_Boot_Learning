package com.omnie.forms.model;

import java.util.ArrayList;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(value = Include.NON_NULL)
public class FormSchema {

	private String title;
	private String description;
	private String type;
	private ArrayList<String> required;
	private Map<String, Map<String, String>> properties;

	@JsonProperty("title")
	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	@JsonProperty("description")
	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}


	@JsonProperty("type")
	public String getType() {
		return this.type;
	}

	public void setType(String type) {
		this.type = type;
	}

	@JsonProperty("required")
	public ArrayList<String> getRequired() {
		return this.required;
	}

	public void setRequired(ArrayList<String> required) {
		this.required = required;
	}

	@JsonProperty("properties")
	public Map<String, Map<String, String>> getProperties() {
		return this.properties;
	}

	public void setProperties(Map<String, Map<String, String>> properties) {
		this.properties = properties;
	}

}