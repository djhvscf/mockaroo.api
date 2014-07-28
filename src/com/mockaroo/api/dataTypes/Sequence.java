/**
 * 
 */
package com.mockaroo.api.dataTypes;

import org.json.JSONObject;

import com.mockaroo.api.enums.MockarooType;
import com.mockaroo.api.exceptions.MockarooExceptionName;
import com.mockaroo.api.exceptions.MockarooExceptionNumber;

/**
 * Sequence mockaroo object
 * @author Dennis Hernández Vargas
 * @version 2.0.0 - 27/07/2014
 * @since 2.0.0
 */
public class Sequence implements IMockarooObject {

	private static Sequence instance = null;
	private String columnName;
	private int start;
	private int step;
	private int repeat;

	/**
	 * Constructor
	 * @param columnName Column name
	 * @param start The first number in the sequence
	 * @param step The number to add to each subsequent value
	 * @param repeat The number of times each value should occur before the step amount is added
	 */
	private Sequence(String columnName, int start, int step, int repeat) {
		this.setColumnName(columnName);
		this.setStart(start);
		this.setStep(step);
		this.setRepeat(repeat);
	}

	/**
	 * Get the {@link Sequence} object
	 * @param columnName Column name
	 * @param start The first number in the sequence
	 * @param step The number to add to each subsequent value
	 * @param repeat The number of times each value should occur before the step amount is added
	 * @return {@link Sequence} object
	 * @throws MockarooExceptionName 
	 * @throws MockarooExceptionNumber 
	 */
	public static Sequence getInstance(String columnName, int start, int step, int repeat)
			throws MockarooExceptionName, MockarooExceptionNumber {
		VALIDATOR.validateColumnName(columnName, messageExceptionName);
		VALIDATOR.validateNumber(start, 1, messageExceptionStartLess);
		VALIDATOR.validateNumber(step, 1, messageExceptionStepLess);
		VALIDATOR.validateNumber(repeat, 1, messageExceptionRepeatLess);
		
		if (instance == null) {
			instance = new Sequence(columnName, start, step, repeat);
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
	 * Get the start
	 * @return the start
	 */
	private int getStart() {
		return start;
	}

	/**
	 * Get the step
	 * @return the step
	 */
	private int getStep() {
		return step;
	}

	/**
	 * Get the repeat
	 * @return the repeat
	 */
	private int getRepeat() {
		return repeat;
	}

	/**
	 * Set the start
	 * @param start the start to set
	 */
	private void setStart(int start) {
		this.start = start;
	}

	/**
	 * Set the step
	 * @param step the step to set
	 */
	private void setStep(int step) {
		this.step = step;
	}

	/**
	 * Set the repeat
	 * @param repeat the repeat to set
	 */
	private void setRepeat(int repeat) {
		this.repeat = repeat;
	}

	/* (non-Javadoc)
	 * @see com.mockaroo.api.dataTypes.IMockarooObject#getJSONObject()
	 */
	@Override
	public JSONObject getJSONObject() {

		JSONObject jsonObject = new JSONObject();
		jsonObject.put(NAME, this.getColumnName());
		jsonObject.put(TYPE, this.getType());
		jsonObject.put(START, this.getStart());
		jsonObject.put(STEP, this.getStep());
		jsonObject.put(REPEAT, this.getRepeat());
		
		return jsonObject;
	}

	/* (non-Javadoc)
	 * @see com.mockaroo.api.dataTypes.IMockarooObject#getType()
	 */
	@Override
	public String getType() {
		return MockarooType.Sequence.toString();
	}
}
