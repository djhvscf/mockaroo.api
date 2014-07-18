package com.mockaroo.api.helpers;

import java.io.File;
import java.io.IOException;
import java.util.Locale;

import org.json.JSONArray;
import org.json.JSONObject;

import com.mockaroo.api.interfaces.IMockarooExcelHelper;

import jxl.Workbook;
import jxl.WorkbookSettings;
import jxl.format.CellFormat;
import jxl.format.UnderlineStyle;
import jxl.write.Label;
import jxl.write.WritableCellFormat;
import jxl.write.WritableFont;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;
import jxl.write.biff.RowsExceededException;

/**
 * Class that create a Excel file
 * @author Dennis Hernández Vargas
 * @version 0.1.0
 * @since 17/July/2014
 */
public class MockarooExcelHelper implements IMockarooExcelHelper {

	private WritableCellFormat timesBoldUnderline;
	private WritableCellFormat times;
	private static MockarooExcelHelper instance = null;

	/**
	 * Default constructor
	 * @throws WriteException
	 */
	private MockarooExcelHelper() throws WriteException
	{
		this.setTimes();
		this.setTimesBoldUnderline();
	}
	
	/**
	 * Applying singleton
	 * @return {@link MockarooExcelHelper}
	 * @throws WriteException
	 */
	public static MockarooExcelHelper getInstance() throws WriteException
	{
		if(instance == null)
		{
			instance = new MockarooExcelHelper();
		}
		
		return instance;
	}
	
	/**
	 * Get the times bold underline format
	 * @return {@link WritableCellFormat}
	 */
	private WritableCellFormat getTimesBoldUnderline() {
		return this.timesBoldUnderline;
	}

	/**
	 * Get the times format
	 * @return {@link WritableCellFormat}
	 */
	private WritableCellFormat getTimes() {
		return this.times;
	}

	/**
	 * Sets the times bold underline format
	 * @throws WriteException
	 */
	private void setTimesBoldUnderline() throws WriteException 
	{
		WritableFont times10ptBoldUnderline = new WritableFont(WritableFont.TIMES, 10, 
				WritableFont.BOLD, false, UnderlineStyle.SINGLE);
		this.timesBoldUnderline = new WritableCellFormat(times10ptBoldUnderline);
		this.timesBoldUnderline.setWrap(true);
	}

	/**
	 * Set the times format
	 * @throws WriteException
	 */
	private void setTimes() throws WriteException 
	{
		WritableFont times10pt = new WritableFont(WritableFont.TIMES, 10);
		this.times = new WritableCellFormat(times10pt);
		this.times.setWrap(true);
	}

	@Override
	public void write(String sheetName, String language, String country, File file, JSONObject jsonObject) 
			throws IOException, WriteException
	{
		WorkbookSettings wbSettings = new WorkbookSettings();
		wbSettings.setLocale(new Locale(language, country));

		WritableWorkbook workbook = Workbook.createWorkbook(file, wbSettings);
		workbook.createSheet(sheetName, 0);
		WritableSheet excelSheet = workbook.getSheet(0);
		createHeader(excelSheet, jsonObject);
		createData(excelSheet, jsonObject);

		workbook.write();
		workbook.close();
	}
	
	/**
	 * Create a header of the columns in the Excel file
	 * @param sheet Excel file sheet
	 * @param jsonObject {@link JSONObject} with data
	 * @throws WriteException
	 */
	private void createHeader(WritableSheet sheet, JSONObject jsonObject) throws WriteException 
	{
		/*CellView cv = new CellView();
		cv.setFormat(times);
		cv.setFormat(timesBoldUnderline);
		cv.setAutosize(true);*/

		String[] header = getHeader(jsonObject);
		for(int i= 0; i < header.length; i++)
		{
			addData(sheet, i, 0, header[i], this.getTimesBoldUnderline());
		}
	}

	/**
	 * Create a data to write in Excel file
	 * @param sheet Excel file sheet
	 * @param jsonObject {@link JSONObject} with data
	 * @throws WriteException
	 * @throws RowsExceededException
	 */
	private void createData(WritableSheet sheet, JSONObject jsonObject) throws WriteException, RowsExceededException 
	{
		String[] data = generateValuesInsert(jsonObject);
		for (int i = 0; i < data.length; i++) 
		{
			addData(sheet, i, 1, data[i], this.getTimes());
		}
	}

	/**
	 * Add data to a cell in Excel file
	 * @param sheet Excel file sheet
	 * @param column Number of the column
	 * @param row Number of the row
	 * @param data Data to write in the cell
	 * @param format Format
	 * @throws WriteException
	 * @throws RowsExceededException
	 */
	private void addData(WritableSheet sheet, int column, int row, String data, CellFormat format) throws WriteException, RowsExceededException 
	{
		sheet.addCell(new Label(column, row, data, format));
	}
	
	/**
	 * Generate the values to insert
	 * @param jsonObject
	 * @return String with values to insert
	 */
	public String[] getHeader(JSONObject jsonObject)
	{
		JSONArray name = jsonObject.names();
		String[] valuesToInsert = new String[name.length()];
		
		for(int i = 0; i < name.length(); i++)
		{
			valuesToInsert[i] = name.getString(i);
		}
		
		return valuesToInsert;
	}
	
	/**
	 * Generate the values to insert
	 * @param jsonObject
	 * @return String with values to insert
	 */
	public String[] generateValuesInsert(JSONObject jsonObject)
	{
		JSONArray name = jsonObject.names();
		String valuesToInsert[] = new String[name.length()];
		
		for(int i = 0; i < name.length(); i++)
		{
			valuesToInsert[i] = jsonObject.getString(name.getString(i));
		}
		
		return valuesToInsert;
	}
}