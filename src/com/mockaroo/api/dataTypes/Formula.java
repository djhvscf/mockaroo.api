/**
 * 
 */
package com.mockaroo.api.dataTypes;

import org.json.JSONObject;

import com.mockaroo.api.enums.MockarooType;
import com.mockaroo.api.exceptions.MockarooExceptionFormula;
import com.mockaroo.api.exceptions.MockarooExceptionName;

/**
 * Formula mockaroo object
 * @author Dennis Hernández Vargas
 * @version 2.0.0 - 26/07/2014
 * @since 2.0.0
 */
public class Formula implements IMockarooObject {

	private static Formula instance = null;
	private String columnName;
	private String formula;

	/**
	 * Constructor
	 * @param columnName Column name
	 */
	private Formula(String columnName, String formula) {
		this.setColumnName(columnName);
		this.setFormula(formula);
	}

	/**
	 * Get the {@link Formula} object
	 * @param columnName Column name
	 * @return {@link Formula} object
	 * @throws MockarooExceptionName 
	 * @throws MockarooExceptionFormula 
	 */
	public static Formula getInstance(String columnName, String formula)
			throws MockarooExceptionName, MockarooExceptionFormula {
		VALIDATOR.validateColumnName(columnName, messageExceptionName);
		if(formula.isEmpty())
		{
			throw new MockarooExceptionFormula(messageExceptionFormula);
		}
		
		if (instance == null) {
			instance = new Formula(columnName, formula);
		}

		return instance;
	}

	/**
	 * Get the columnName
	 * @return the columnName
	 */
	private String getColumnName() {
		return columnName;
	}

	/**
	 * Set the columnName
	 * @param columnName the columnName to set
	 */
	private void setColumnName(String columnName) {
		this.columnName = columnName;
	}

	/**
	 * Get the formula
	 * @return the formula
	 */
	private String getFormula() {
		return formula;
	}

	/**
	 * Set the formula
	 * @param formula the formula to set
	 */
	private void setFormula(String formula) {
		this.formula = formula;
	}

	/* (non-Javadoc)
	 * @see com.mockaroo.api.dataTypes.IMockarooObject#getJSONObject()
	 */
	@Override
	public JSONObject getJSONObject() {		
		JSONObject jsonObject = new JSONObject();
		jsonObject.put(NAME, this.getColumnName());
		jsonObject.put(TYPE, this.getType());
		jsonObject.put(FORMULA, this.getFormula());
		
		return jsonObject;
	}

	/* (non-Javadoc)
	 * @see com.mockaroo.api.dataTypes.IMockarooObject#getType()
	 */
	@Override
	public String getType() {
		return MockarooType.Formula.toString();
	}
}