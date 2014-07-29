/**
 * 
 */
package com.mockaroo.api.objects;

import org.json.JSONObject;

import com.mockaroo.api.enums.MockarooType;
import com.mockaroo.api.exceptions.MockarooExceptionName;
import com.mockaroo.api.exceptions.MockarooExceptionNumber;
import com.mockaroo.api.interfaces.IMockarooObject;

/**
 * NormalDistribution mockaroo object
 * @author Dennis Hernández Vargas
 * @version 2.0.0 - 27/07/2014
 * @since 2.0.0
 */
public class NormalDistribution implements IMockarooObject {

	private static NormalDistribution instance = null;
	private String columnName;
	private Double mean;
	private Double sd;
	private int decimals;

	/**
	 * Constructor
	 * @param columnName Column name
	 * @param mean The mean value for the normal distribution
	 * @param sd The standard deviation for the normal distribution
	 * @param decimals The number of decimals places for each generated value
	 */
	private NormalDistribution(String columnName, Double mean, Double sd, int decimals) {
		this.setColumnName(columnName);
		this.setMean(mean);
		this.setSd(sd);
		this.setDecimals(decimals);
	}

	/**
	 * Get the {@link NormalDistribution} object
	 * @param columnName Column name
	 * @param mean The mean value for the normal distribution
	 * @param sd The standard deviation for the normal distribution
	 * @param decimals The number of decimals places for each generated value
	 * @return {@link NormalDistribution} object
	 * @throws MockarooExceptionName 
	 * @throws MockarooExceptionNumber 
	 */
	public static NormalDistribution getInstance(String columnName, Double mean, Double sd, int decimals)
			throws MockarooExceptionName, MockarooExceptionNumber {
		
		VALIDATOR.validateColumnName(columnName, messageExceptionName);
		VALIDATOR.validateNumber(mean, messageExceptionMeanLess);
		VALIDATOR.validateNumber(decimals, messageExceptionDecimalLess);		
		VALIDATOR.validateNumber(sd, 1, messageExceptionSdLess);
		
		if (instance == null) {
			instance = new NormalDistribution(columnName, mean, sd, decimals);
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
	 * Get the mean
	 * @return the mean
	 */
	private Double getMean() {
		return mean;
	}

	/**
	 * Get the sd
	 * @return the sd
	 */
	private Double getSd() {
		return sd;
	}

	/**
	 * Set the mean
	 * @param mean the mean to set
	 */
	private void setMean(Double mean) {
		this.mean = mean;
	}

	/**
	 * Set the sd
	 * @param sd the sd to set
	 */
	private void setSd(Double sd) {
		this.sd = sd;
	}

	/**
	 * Get the decimals
	 * @return the decimals
	 */
	private int getDecimals() {
		return decimals;
	}

	/**
	 * Set the decimals
	 * @param decimals the decimals to set
	 */
	private void setDecimals(int decimals) {
		this.decimals = decimals;
	}

	/* (non-Javadoc)
	 * @see com.mockaroo.api.dataTypes.IMockarooObject#getJSONObject()
	 */
	@Override
	public JSONObject getJSONObject() {

		JSONObject jsonObject = new JSONObject();
		jsonObject.put(NAME, this.getColumnName());
		jsonObject.put(TYPE, this.getType());
		jsonObject.put(MEAN, this.getMean());
		jsonObject.put(SD, this.getSd());
		jsonObject.put(DECIMALS, this.getDecimals());
		
		return jsonObject;
	}

	/* (non-Javadoc)
	 * @see com.mockaroo.api.dataTypes.IMockarooObject#getType()
	 */
	@Override
	public String getType() {
		return MockarooType.Normal_Distribution.toString().replace(UNDERSCORE, SPACE);
	}
}
