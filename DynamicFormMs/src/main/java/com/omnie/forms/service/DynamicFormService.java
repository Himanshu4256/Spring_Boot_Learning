package com.omnie.forms.service;

import com.omnie.forms.model.FormComponent;

public interface DynamicFormService {

	FormComponent getFormComponent(String clientId);

	FormComponent addFormComponent(String clientId, FormComponent formComponent);

}
