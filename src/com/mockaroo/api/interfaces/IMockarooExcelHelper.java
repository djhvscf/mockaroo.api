package com.mockaroo.api.interfaces;

import java.io.File;
import java.io.IOException;

import org.json.JSONArray;
import org.json.JSONObject;

import jxl.write.WriteException;

/**
 * Interface that Mockaroo Excel helper
 * @author Dennis Hernández Vargas
 * @version 0.1.0 - 17/July/2014
 * @since 0.1.0
 */
public interface IMockarooExcelHelper {

	/**
	 * Write in the Excel file
	 * @param sheetName Sheet name
	 * @param language Language of the Excel file
	 * @param country Country of the Excel file
	 * @throws IOException
	 * @throws WriteException
	 */
	public void write(String sheetName, String language, String country, File file, JSONObject jsonObject) 
			throws IOException, WriteException;

	/**
	 * Write in the Excel file
	 * @param sheetName Sheet name
	 * @param language Language of the Excel file
	 * @param country Country of the Excel file
	 * @throws IOException
	 * @throws WriteException
	 */
	public void write(String sheetName, String language, String country, File file,
			JSONArray jsonArray) throws IOException, WriteException;
}
