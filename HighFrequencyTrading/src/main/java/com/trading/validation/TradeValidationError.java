package com.trading.validation;

public class TradeValidationError {

	private String field;

	private String errorMessageKey;
	
	private Boolean errorfieldStatus;
	
	public TradeValidationError() {
	}

	public TradeValidationError(
			final String field, final String messageKey) {
		this.field = field;
		this.errorMessageKey = messageKey;
	}

	public String getField() {
		return field;
	}

	public void setField(String field) {
		this.field = field;
	}

	public String getErrorMessageKey() {
		return errorMessageKey;
	}

	public void setErrorMessageKey(String errorMessageKey) {
		this.errorMessageKey = errorMessageKey;
	}

	public Boolean getFieldStatus() {
		return errorfieldStatus;
	}

	public void setFieldStatus(Boolean fieldStatus) {
		this.errorfieldStatus = fieldStatus;
	}
}