package com.omnie.forms.model;

import java.util.Map;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(value = Include.NON_NULL)
public class FormProperty {

	@JsonProperty("default")
	public String mydefault;

	@JsonProperty("type")
	public String type;
	
	@JsonProperty("ui:title")
	public String title;

	@JsonProperty("ui:autofocus")
	public String autofocus;

	@JsonProperty("ui:emptyValue")
	public String emptyValue;

	@JsonProperty("ui:placeholder")
	public String placeholder;

	@JsonProperty("ui:autocomplete")
	public String autocomplete;

	@JsonProperty("ui:enableMarkdownInDescription")
	public boolean enableMarkdownInDescription;

	@JsonProperty("ui:description")
	public String description;

	@JsonProperty("ui:widget")
	public String widget;

	@JsonProperty("ui:help")
	public String help;

	@JsonProperty("ui:options")
	public Map<String, String> options;
		
	@JsonProperty("minLength")
	public String minLength;

}
