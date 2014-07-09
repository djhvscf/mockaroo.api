package com.mockaroo.api.classes;

import org.json.JSONArray;
import org.json.JSONObject;

import com.mockaroo.api.enums.MockarooType;
import com.mockaroo.api.exceptions.MockarooExceptionArray;
import com.mockaroo.api.exceptions.MockarooExceptionName;
import com.mockaroo.api.exceptions.MockarooExceptionNumber;

/**
 * Class to create a specific JSONObject
 * @author Dennis Hernández Vargas
 * @version 0.1.0
 * @since 09/July/2014
 */
public class CreateJSONObject {

	private CreateJSONObjectHelper createJSONObject = new CreateJSONObjectHelper();
	
	/**
	 * Create a Blank JSONObject
	 * @param name Column name
	 * @return Blank JSONObject
	 * @throws MockarooExceptionName
	 */
	public JSONObject createBlank(String name) throws MockarooExceptionName
	{
		return createJSONObject.createJSONObject(name, MockarooType.Blank.toString());
	}
	
	/**
	 * Create a Boolean JSONObject
	 * @param name Column name
	 * @return Boolean JSONObject
	 * @throws MockarooExceptionName
	 */
	public JSONObject createBoolean(String name) throws MockarooExceptionName
	{
		return createJSONObject.createJSONObject(name, MockarooType.Boolean.toString());
	}
	
	/**
	 * Create a City JSONObject
	 * @param name Column name
	 * @return City JSONObject
	 * @throws MockarooExceptionName
	 */
	public JSONObject createCity(String name) throws MockarooExceptionName
	{
		return createJSONObject.createJSONObject(name, MockarooType.City.toString());
	}
	
	/**
	 * Create a Color JSONObject
	 * @param name Column name
	 * @return Color JSONObject
	 * @throws MockarooExceptionName
	 */
	public JSONObject createColor(String name) throws MockarooExceptionName
	{
		return createJSONObject.createJSONObject(name, MockarooType.Color.toString());
	}
	
	/**
	 * Create a Company Name JSONObject
	 * @param name Column name
	 * @return Company name JSONObject
	 * @throws MockarooExceptionName
	 */
	public JSONObject createCompanyName(String name) throws MockarooExceptionName
	{
		return createJSONObject.createJSONObject(name, MockarooType.Company_Name.toString()
																.replace('_', ' '));
	}
	
	/**
	 * Create a Country JSONObject
	 * @param name Column name
	 * @return Country JSONObject
	 * @throws MockarooExceptionName
	 */
	public JSONObject createCountry(String name) throws MockarooExceptionName
	{
		return createJSONObject.createJSONObject(name, MockarooType.Country.toString());
	}
	
	/**
	 * Create a Credit Card Number JSONObject
	 * @param name Column name
	 * @return Credit Card Number JSONObject
	 * @throws MockarooExceptionName
	 */
	public JSONObject createCreditCardNumber(String name) throws MockarooExceptionName
	{
		return createJSONObject.createJSONObject(name, MockarooType.Credit_Card_1.toString()
																.replace('_', ' ').replace('1', '#'));
	}
	
	/**
	 * Create a Credit Card Type JSONObject
	 * @param name Column name
	 * @return Credti Card Type JSONObject
	 * @throws MockarooExceptionName
	 */
	public JSONObject createCreditCardType(String name) throws MockarooExceptionName
	{
		return createJSONObject.createJSONObject(name, MockarooType.Credit_Card_Type.toString()
																.replace('_', ' '));
	}
	
	/**
	 * Create a Currency JSONObject
	 * @param name Column name
	 * @return Currency JSONObjct
	 * @throws MockarooExceptionName
	 */
	public JSONObject createCurrency(String name) throws MockarooExceptionName
	{
		return createJSONObject.createJSONObject(name, MockarooType.Currency.toString());
	}
	
	/**
	 * Create a Currency Code JSONObject
	 * @param name Column name
	 * @return Currency Code JSONObject
	 * @throws MockarooExceptionName
	 */
	public JSONObject createCurrencyCode(String name) throws MockarooExceptionName
	{
		return createJSONObject.createJSONObject(name, MockarooType.Currency_Code.toString()
																.replace('_', ' '));
	}
	
	/**
	 * Create a Custom List JSONObject
	 * @param name Column name
	 * @param values Array with values
	 * @return Custom List JSONObject
	 * @throws MockarooExceptionName
	 * @throws MockarooExceptionArray
	 */
	public JSONObject createCustomList(String name, JSONArray values) 
			throws MockarooExceptionName, MockarooExceptionArray
	{
		return createJSONObject.createJSONObject(name,MockarooType.Custom_List.toString()
																.replace('_', ' '), values);
	}
	
	/**
	 * Create a Date JSONObject
	 * @param name Column name
	 * @param min Min date
	 * @param max Max date
	 * @param format Date format
	 * @return Date JSONObject
	 * @throws MockarooExceptionName
	 */
	public JSONObject createDate(String name, String min, String max, String format) 
			throws MockarooExceptionName
	{
		return createJSONObject.createJSONObject(name, min, max, format);
	}
	
	/**
	 * Create a Domain Name JSONObject
	 * @param name Column name
	 * @return Domain Name JSONObject
	 * @throws MockarooExceptionName
	 */
	public JSONObject createDomainName(String name) throws MockarooExceptionName
	{
		return createJSONObject.createJSONObject(name, MockarooType.Domain_Name.toString()
																.replace('_', ' '));
	}
	
	/**
	 * Create a Email Address JSONObject
	 * @param name Column name
	 * @return Email Address JSONObject
	 * @throws MockarooExceptionName
	 */
	public JSONObject createEmailAddress(String name) throws MockarooExceptionName
	{
		return createJSONObject.createJSONObject(name, MockarooType.Email_Address.toString()
																.replace('_', ' '));
	}
	
	/**
	 * Create a Encrypt JSONObject
	 * @param name Column name
	 * @return Encrypt JSONObject
	 * @throws MockarooExceptionName
	 */
	public JSONObject createEncrypt(String name) throws MockarooExceptionName
	{
		return createJSONObject.createJSONObject(name, MockarooType.Encrypt.toString());
	}
	
	/**
	 * Create a Family Name Chinese JSONObject
	 * @param name Column name
	 * @return Family Name Chinese JSONObject 
	 * @throws MockarooExceptionName
	 */
	public JSONObject createFamilyNameChinese(String name) throws MockarooExceptionName
	{
		return createJSONObject.createJSONObject(name, "Family Name (Chinese)");
	}
	
	/**
	 * Create a First Name JSONObject
	 * @param name Column name
	 * @return First Name JSONObject
	 * @throws MockarooExceptionName
	 */
	public JSONObject createFirstName(String name) throws MockarooExceptionName
	{
		return createJSONObject.createJSONObject(name, MockarooType.First_Name.toString()
																.replace('_', ' '));
	}
	
	/**
	 * Create a Number JSONObjct
	 * @param name Column name
	 * @param min Min number
	 * @param max Max number
	 * @param decimals Quantity of decimals
	 * @return Number JSONOoject
	 * @throws MockarooExceptionNumber
	 * @throws MockarooExceptionName
	 */
	public JSONObject createNumber(String name, int min, int max, int decimals) 
			throws MockarooExceptionNumber, MockarooExceptionName
	{
		return createJSONObject.createJSONObject(name, min, max, decimals);
	}
}