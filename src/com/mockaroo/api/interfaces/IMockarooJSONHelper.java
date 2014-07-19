package com.mockaroo.api.interfaces;

import java.io.IOException;

import jxl.write.WriteException;

import org.json.JSONObject;

/**
 * Class to create a .json file
 * @author Dennis Hernández Vargas
 * @version 0.1.0
 * @since 17/July/2014
 */
public interface IMockarooJSONHelper {

	/**
	 * Write in the Excel file
	 * @param sheetName Sheet name
	 * @param language Language of the Excel file
	 * @param country Country of the Excel file
	 * @throws IOException
	 * @throws WriteException
	 */
	public void write(String fileName, JSONObject jsonObject) 
			throws IOException, WriteException;
}
