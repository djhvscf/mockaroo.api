package com.mockaroo.api.classes;

import org.json.JSONArray;
import org.json.JSONObject;

import com.mockaroo.api.enums.MockarooMoneyType;
import com.mockaroo.api.enums.MockarooTimeType;
import com.mockaroo.api.enums.MockarooType;
import com.mockaroo.api.exceptions.MockarooExceptionArray;
import com.mockaroo.api.exceptions.MockarooExceptionFormatDate;
import com.mockaroo.api.exceptions.MockarooExceptionFormatTime;
import com.mockaroo.api.exceptions.MockarooExceptionFormula;
import com.mockaroo.api.exceptions.MockarooExceptionMyList;
import com.mockaroo.api.exceptions.MockarooExceptionName;
import com.mockaroo.api.exceptions.MockarooExceptionNumber;
import com.mockaroo.api.exceptions.MockarooExceptionRegExpValue;
import com.mockaroo.api.exceptions.MockarooExceptionValue;
import com.mockaroo.api.helpers.MockarooCreateJSONObjectHelper;

/**
 * Class to create a specific JSONObject
 * @author Dennis Hernández Vargas
 * @version 0.1.0
 * @since 09/July/2014
 */
public class MockarooCreateJSONObject {

	private MockarooCreateJSONObjectHelper createJSONObject = new MockarooCreateJSONObjectHelper();
	
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
	 * @throws MockarooExceptionFormatDate 
	 */
	//public JSONObject createDate(String name, String min, String max, MockarooDateType format) 
	public JSONObject createDate(String name, String min, String max, String format)
			throws MockarooExceptionName, MockarooExceptionFormatDate
	{
		return createJSONObject.createJSONObject(name, min, max, format, MockarooType.Date.toString());
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
	 * Create a First Name European JSONObject
	 * @param name Column name
	 * @return First Name JSONObject
	 * @throws MockarooExceptionName
	 */
	public JSONObject createFirstNameEuropean(String name) throws MockarooExceptionName
	{
		return createJSONObject.createJSONObject(name, MockarooType.First_Name_European.toString()
																.replace('_', ' '));
	}
	
	/**
	 * Create a First Name Female JSONObject
	 * @param name Column name
	 * @return First Name Female JSONObject
	 * @throws MockarooExceptionName
	 */
	public JSONObject createFirstNameFemale(String name) throws MockarooExceptionName
	{
		return createJSONObject.createJSONObject(name, MockarooType.First_Name_Female.toString()
																.replace('_', ' '));
	}
	
	/**
	 * Create a First Name Male JSONObject
	 * @param name Column name
	 * @return First Name Male JSONObject
	 * @throws MockarooExceptionName
	 */
	public JSONObject creatFirstNameMale(String name) throws MockarooExceptionName
	{
		return createJSONObject.createJSONObject(name, MockarooType.First_Name_Male.toString()
																.replace('_', ' '));
	}
	
	/**
	 * Create a Formula JSONObject
	 * @param name Column name
	 * @param formula Formula
	 * @return Formula JSONObject
	 * @see {@link http://www.mockaroo.com/api/docs#type_formula}
	 * @throws MockarooExceptionName
	 * @throws MockarooExceptionFormula
	 */
	public JSONObject createFormula(String name, String formula) 
			throws MockarooExceptionName, MockarooExceptionFormula
	{
		return createJSONObject.createJSONObject(name, formula, MockarooType.Formula.toString());
	}
	
	/**
	 * Create a Frequency JSONObject
	 * @param name Column name
	 * @return Frequency JSONObject
	 * @throws MockarooExceptionName
	 */
	public JSONObject createFrequency(String name) throws MockarooExceptionName
	{
		return createJSONObject.createJSONObject(name, MockarooType.Frequency.toString());
	}
	
	/**
	 * Create a Full Name JSONObject
	 * @param name Column name
	 * @return Full Name JSONObject
	 * @throws MockarooExceptionName
	 */
	public JSONObject createFullName(String name) throws MockarooExceptionName
	{
		return createJSONObject.createJSONObject(name, MockarooType.Full_Name.toString()
															.replace('_', ' '));
	}
	
	/**
	 * Create a Gender JSONObject
	 * @param name Column name
	 * @return Gender JSONObject
	 * @throws MockarooExceptionName
	 */
	public JSONObject createGender(String name) throws MockarooExceptionName
	{
		return createJSONObject.createJSONObject(name, MockarooType.Gender.toString());
	}
	
	/**
	 * Create a Gender (abbrev) JSONObject
	 * @param name Column name
	 * @return Gender (abbrev) JSONObject
	 * @throws MockarooExceptionName
	 */
	public JSONObject createGenderAbbrev(String name) throws MockarooExceptionName
	{
		return createJSONObject.createJSONObject(name, "Gender (abbrev)");
	}
	
	/**
	 * Create a Given Name (Chinese) JSONObject
	 * @param name Column name
	 * @return Given Name (Chinese) JSONObject
	 * @throws MockarooExceptionName
	 */
	public JSONObject createGivenNameChinese(String name) throws MockarooExceptionName
	{
		return createJSONObject.createJSONObject(name, "Given Name (Chinese)");
	}
	
	/**
	 * Create a GUID JSONObject
	 * @param name Column name
	 * @return GUID JSONObject
	 * @throws MockarooExceptionName
	 */
	public JSONObject createGUID(String name) throws MockarooExceptionName
	{
		return createJSONObject.createJSONObject(name, MockarooType.GUID.toString());
	}
	
	/**
	 * Create a Hex Color JSONObject
	 * @param name Column name
	 * @return Hex Color JSONObject
	 * @throws MockarooExceptionName
	 */
	public JSONObject createHexColor(String name) throws MockarooExceptionName
	{
		return createJSONObject.createJSONObject(name, MockarooType.Hex_Color.toString()
															.replace('_', ' '));
	}
	
	/**
	 * Create a IP Address v4 JSONObject
	 * @param name Column name
	 * @return IP Address v4 JSONObject
	 * @throws MockarooExceptionName
	 */
	public JSONObject createIPAddressv4(String name) throws MockarooExceptionName
	{
		return createJSONObject.createJSONObject(name, MockarooType.IP_Address_v4.toString()
															.replace('_', ' '));
	}
	
	/**
	 * Create a IP Address v6 JSONObject
	 * @param name Column name
	 * @return IP Address v6 JSONObject
	 * @throws MockarooExceptionName
	 */
	public JSONObject createIPAddressv6(String name) throws MockarooExceptionName
	{
		return createJSONObject.createJSONObject(name, MockarooType.IP_Address_v6.toString()
															.replace('_', ' '));
	}
	
	/**
	 * Create a ISBN JSONObject
	 * @param name Column name
	 * @return ISBN JSONObject
	 * @throws MockarooExceptionName
	 */
	public JSONObject createISBN(String name) throws MockarooExceptionName
	{
		return createJSONObject.createJSONObject(name, MockarooType.ISBN.toString());
	}
	
	/**
	 * Create a JSON Array JSONObject
	 * @param name Column name
	 * @return JSON Array JSONObject
	 * @throws MockarooExceptionName
	 * @throws MockarooExceptionNumber 
	 */
	public JSONObject createJSONArray(String name, int minItems, int maxItems) 
			throws MockarooExceptionName, MockarooExceptionNumber
	{
		return createJSONObject.createJSONObject(name,minItems, maxItems, MockarooType.JSON_Array.toString()
																				.replace('_', ' '));
	}
	
	/**
	 * Create a Language JSONObject
	 * @param name Column name
	 * @return Language JSONObject
	 * @throws MockarooExceptionName
	 */
	public JSONObject createLanguage(String name) throws MockarooExceptionName
	{
		return createJSONObject.createJSONObject(name, MockarooType.Language.toString());
	}
	
	/**
	 * Create a Last Name JSONObject
	 * @param name Column name
	 * @return Last Name JSONObject
	 * @throws MockarooExceptionName
	 */
	public JSONObject createLastName(String name) throws MockarooExceptionName
	{
		return createJSONObject.createJSONObject(name, MockarooType.Last_Name.toString()
															.replace('_', ' '));
	}
	
	/**
	 * Create a Latitude JSONObject
	 * @param name Column name
	 * @return Latitude JSONObject
	 * @throws MockarooExceptionName
	 */
	public JSONObject createLatitude(String name) throws MockarooExceptionName
	{
		return createJSONObject.createJSONObject(name, MockarooType.Latitude.toString());
	}
	
	/**
	 * Create a Longitude JSONObject
	 * @param name Column name
	 * @return Longitude JSONObject
	 * @throws MockarooExceptionName
	 */
	public JSONObject createLongitude(String name) throws MockarooExceptionName
	{
		return createJSONObject.createJSONObject(name, MockarooType.Longitude.toString());
	}
	
	/**
	 * Create a MAC Address JSONObject
	 * @param name Column name
	 * @return MAC Address JSONObject
	 * @throws MockarooExceptionName
	 */
	public JSONObject createMACAddress(String name) throws MockarooExceptionName
	{
		return createJSONObject.createJSONObject(name, MockarooType.MAC_Address.toString()
															.replace('_', ' '));
	}
	
	/**
	 * Create a Money JSONObject
	 * @param name Column name
	 * @param min Minimum value
	 * @param max Maximum value
	 * @param moneyType {@link MockarooMoneyType}
	 * @return Money JSONObject
	 * @throws MockarooExceptionName
	 * @throws MockarooExceptionNumber 
	 */
	public JSONObject createMoney(String name, int min, int max, MockarooMoneyType moneyType) 
			throws MockarooExceptionName, MockarooExceptionNumber
	{
		return createJSONObject.createJSONObject(name,min, max, MockarooType.Money.toString(), 
													moneyType.toString());
	}
	
	/**
	 * Create a My List JSONObject
	 * @param name Column name
	 * @param myListName The name of a saved list
	 * @return My List JSONObject
	 * @throws MockarooExceptionName
	 * @throws MockarooExceptionMyList 
	 */
	public JSONObject createMyList(String name, String myListName) 
			throws MockarooExceptionName, MockarooExceptionMyList
	{
		return createJSONObject.createJSONObjectMyList(name, MockarooType.My_List.toString()
															.replace('_', ' '), myListName);
	}
	
	/**
	 * Create a Normal Distribution JSONObject
	 * @param name Column name
	 * @param mean The mean value for the normal distribution
	 * @param sd The standard deviation for the normal distribution
	 * @param decimals The number of decimals places for each generated value
	 * @return Normal Distribution JSONObject
	 * @throws MockarooExceptionName
	 * @throws MockarooExceptionMyList 
	 * @throws MockarooExceptionNumber 
	 */
	public JSONObject createNormalDistribution(String name, Double mean, Double sd, int decimals) 
			throws MockarooExceptionName, MockarooExceptionMyList, MockarooExceptionNumber
	{
		return createJSONObject.createJSONObject(name, mean, sd, decimals, MockarooType.Normal_Distribution.toString()
																				.replace('_', ' ' ));
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
		return createJSONObject.createJSONObject(name, min, max, decimals, MockarooType.Number.toString());
	}
	
	/**
	 * Create a Paragraphs JSONObject
	 * @param name Column name
	 * @param min Minimum value
	 * @param max Maximum value
	 * @return Paragraphs JSONObject
	 * @throws MockarooExceptionName
	 * @throws MockarooExceptionNumber 
	 */
	public JSONObject createParagraphs(String name, int min, int max) 
			throws MockarooExceptionName, MockarooExceptionNumber
	{
		return createJSONObject.createJSONObject(name,min, max, MockarooType.Paragraphs.toString());
	}
	
	/**
	 * Create a Password JSONObject
	 * @param name Column name
	 * @return Password JSONObject
	 * @throws MockarooExceptionName 
	 */
	public JSONObject createPassword(String name) throws MockarooExceptionName
	{
		return createJSONObject.createJSONObject(name, MockarooType.Password.toString());
	}
	
	/**
	 * Create a Phone JSONObject
	 * @param name Column name
	 * @return Phone JSONObject
	 * @throws MockarooExceptionName 
	 */
	public JSONObject createPhone(String name) throws MockarooExceptionName
	{
		return createJSONObject.createJSONObject(name, MockarooType.Phone.toString());
	}
	
	/**
	 * Create a Province JSONObject
	 * @param name Column name
	 * @return Province JSONObject
	 * @throws MockarooExceptionName 
	 */
	public JSONObject createProvince(String name) throws MockarooExceptionName
	{
		return createJSONObject.createJSONObject(name, MockarooType.Province.toString());
	}
	
	/**
	 * Create a Province (abbrev) JSONObject
	 * @param name Column name
	 * @return Province (abbrev) JSONObject
	 * @throws MockarooExceptionName 
	 */
	public JSONObject createProvinceAbbrev(String name) throws MockarooExceptionName
	{
		return createJSONObject.createJSONObject(name, "Province (abbrev)");
	}
	
	/**
	 * Create a Race JSONObject
	 * @param name Column name
	 * @return Race JSONObject
	 * @throws MockarooExceptionName 
	 */
	public JSONObject createRace(String name) throws MockarooExceptionName
	{
		return createJSONObject.createJSONObject(name, MockarooType.Race.toString());
	}
	
	/**
	 * Create a Regular Expression JSONObject
	 * @param name Column name
	 * @param value Regular expression value
	 * @return Regular Expression JSONObject
	 * @throws MockarooExceptionName 
	 * @throws MockarooExceptionMyList 
	 */
	public JSONObject createRegularExpression(String name, String value) 
			throws MockarooExceptionName, MockarooExceptionRegExpValue
	{
		return createJSONObject.createJSONObjectRegExp(name, value, MockarooType.Regular_Expression.toString()
																.replace('_', ' '));
	}
	
	/**
	 * Create a Row Number JSONObject
	 * @param name Column name
	 * @return Row Number JSONObject
	 * @throws MockarooExceptionName 
	 */
	public JSONObject createRowNumber(String name) throws MockarooExceptionName
	{
		return createJSONObject.createJSONObject(name, MockarooType.Row_Number.toString()
															.replace('_', ' '));
	}
	
	/**
	 * Create a Sentences JSONObject
	 * @param name Column name
	 * @return Sentences JSONObject
	 * @throws MockarooExceptionName 
	 * @throws MockarooExceptionNumber 
	 */
	public JSONObject createSentences(String name, int min, int max) throws MockarooExceptionName, MockarooExceptionNumber
	{
		return createJSONObject.createJSONObjectSentences(name, min, max, MockarooType.Sentences.toString()
															.replace('_', ' '));
	}
	
	/**
	 * Create a Sequence JSONObject
	 * @param name Column name
	 * @param start The first number in the sequence
	 * @param step The number to add to each subsequent value
	 * @param repeat The number of times each value should occur before the step amount is added
	 * @return Sequence JSONObject
	 * @throws MockarooExceptionName 
	 * @throws MockarooExceptionNumber 
	 */
	public JSONObject createSequence(String name, int start, int step, int repeat) throws MockarooExceptionName, MockarooExceptionNumber
	{
		return createJSONObject.createJSONObjectSequence(name, start, step, repeat, MockarooType.Sequence.toString());
	}
	
	/**
	 * Create a Shirt Size JSONObject
	 * @param name Column name
	 * @return Shirt Size JSONObject
	 * @throws MockarooExceptionName 
	 */
	public JSONObject createShirtSize(String name) throws MockarooExceptionName
	{
		return createJSONObject.createJSONObject(name, MockarooType.Shirt_Size.toString()
															.replace('_', ' '));
	}
	
	/**
	 * Create a Short Hex Color JSONObject
	 * @param name Column name
	 * @return Short Hex Color JSONObject
	 * @throws MockarooExceptionName 
	 */
	public JSONObject createShortHexColor(String name) throws MockarooExceptionName
	{
		return createJSONObject.createJSONObject(name, MockarooType.Short_Hex_Color.toString()
															.replace('_', ' '));
	}
	
	/**
	 * Create a SSN JSONObject
	 * @param name Column name
	 * @return SSN JSONObject
	 * @throws MockarooExceptionName 
	 */
	public JSONObject createSSN(String name) throws MockarooExceptionName
	{
		return createJSONObject.createJSONObject(name, MockarooType.SSN.toString()
															.replace('_', ' '));
	}
	
	/**
	 * Create a State JSONObject
	 * @param name Column name
	 * @return State JSONObject
	 * @throws MockarooExceptionName 
	 */
	public JSONObject createState(String name) throws MockarooExceptionName
	{
		return createJSONObject.createJSONObject(name, MockarooType.State.toString()
															.replace('_', ' '));
	}
	
	/**
	 * Create a State (abbrev) JSONObject
	 * @param name Column name
	 * @return State (abbrev) JSONObject
	 * @throws MockarooExceptionName 
	 */
	public JSONObject createStateAbbrev(String name) throws MockarooExceptionName
	{
		return createJSONObject.createJSONObject(name, "State (abbrev)");
	}
	
	/**
	 * Create a Street Address JSONObject
	 * @param name Column name
	 * @return Street Address JSONObject
	 * @throws MockarooExceptionName 
	 */
	public JSONObject createStreetAddress(String name) throws MockarooExceptionName
	{
		return createJSONObject.createJSONObject(name, MockarooType.Street_Address.toString()
															.replace('_', ' '));
	}
	
	/**
	 * Create a Street Name JSONObject
	 * @param name Column name
	 * @return Street Name JSONObject
	 * @throws MockarooExceptionName 
	 */
	public JSONObject createStreetName(String name) throws MockarooExceptionName
	{
		return createJSONObject.createJSONObject(name, MockarooType.Street_Name.toString()
															.replace('_', ' '));
	}
	
	/**
	 * Create a Street Number JSONObject
	 * @param name Column name
	 * @return Street Number JSONObject
	 * @throws MockarooExceptionName 
	 */
	public JSONObject createStreetNumber(String name) throws MockarooExceptionName
	{
		return createJSONObject.createJSONObject(name, MockarooType.Street_Number.toString()
															.replace('_', ' '));
	}
	
	/**
	 * Create a Street Suffix JSONObject
	 * @param name Column name
	 * @return Street Suffix JSONObject
	 * @throws MockarooExceptionName 
	 */
	public JSONObject createStreetSuffix(String name) throws MockarooExceptionName
	{
		return createJSONObject.createJSONObject(name, MockarooType.Street_Suffix.toString()
															.replace('_', ' '));
	}
	
	/**
	 * Create a Suffix JSONObject
	 * @param name Column name
	 * @return Suffix JSONObject
	 * @throws MockarooExceptionName 
	 */
	public JSONObject createSuffix(String name) throws MockarooExceptionName
	{
		return createJSONObject.createJSONObject(name, MockarooType.Suffix.toString()
															.replace('_', ' '));
	}
	
	/**
	 * Create a Template JSONObject
	 * @param name Column name
	 * @param value Template value
	 * @return Template JSONObject
	 * @throws MockarooExceptionName 
	 * @throws MockarooExceptionValue 
	 */
	public JSONObject createTemplate(String name, String value) 
			throws MockarooExceptionName, MockarooExceptionValue
	{
		return createJSONObject.createJSONObjectTemplate(name, value, MockarooType.Template.toString());
	}
	
	/**
	 * Create a Time JSONObject
	 * @param name Column name
	 * @param min The minimum time in HH:MM AM/PM format
	 * @param max The maximum time in HH:MM AM/PM format
	 * @param format The format to output
	 * @return Time JSONObject
	 * @throws MockarooExceptionName
	 * @throws MockarooExceptionValue
	 * @throws MockarooExceptionFormatTime 
	 */
	public JSONObject createTime(String name, String min, String max, MockarooTimeType format) 
			throws MockarooExceptionName, MockarooExceptionValue, MockarooExceptionFormatTime
	{
		return createJSONObject.createJSONObjectTime(name, min, max, format.getTimeType(), 
															MockarooType.Time.toString());
	}
	
	/**
	 * Create a Time Zone JSONObject
	 * @param name Column name
	 * @return Time Zone JSONObject
	 * @throws MockarooExceptionName 
	 * @throws MockarooExceptionValue 
	 */
	public JSONObject createTimeZone(String name)throws MockarooExceptionName
	{
		return createJSONObject.createJSONObject(name, MockarooType.Time_Zone.toString());
	}
	
	/**
	 * Create a Title JSONObject
	 * @param name Column name
	 * @return Title JSONObject
	 * @throws MockarooExceptionName 
	 * @throws MockarooExceptionValue 
	 */
	public JSONObject createTitle(String name)throws MockarooExceptionName
	{
		return createJSONObject.createJSONObject(name, MockarooType.Title.toString());
	}
	
	/**
	 * Create a Top Level Domain JSONObject
	 * @param name Column name
	 * @return Top Level Domain JSONObject
	 * @throws MockarooExceptionName 
	 * @throws MockarooExceptionValue 
	 */
	public JSONObject createTopLevelDomain(String name)throws MockarooExceptionName
	{
		return createJSONObject.createJSONObject(name, MockarooType.Top_Level_Domain.toString()
															.replace('_', ' '));
	}
	
	/**
	 * Create a URL JSONObject
	 * @param name Column name
	 * @param includeProtocol True to include a protocol in the url
	 * @param includeHost True to include a hostname in the url
	 * @param includePath True to include a path in the url
	 * @param includeQueryString True to include a query string in the url
	 * @return URL JSONObject
	 * @throws MockarooExceptionName
	 */
	public JSONObject createURL(String name, boolean includeProtocol, boolean includeHost,
			boolean includePath, boolean includeQueryString) throws MockarooExceptionName
	{
		return createJSONObject.createJSONObject(name, includeProtocol, includeHost, 
				includePath, includeQueryString, MockarooType.URL.toString());
	}
	
	/**
	 * Create a Username JSONObject
	 * @param name Column name
	 * @return Username JSONObject
	 * @throws MockarooExceptionName 
	 * @throws MockarooExceptionValue 
	 */
	public JSONObject createUsername(String name)throws MockarooExceptionName
	{
		return createJSONObject.createJSONObject(name, MockarooType.Username.toString());
	}
	
	/**
	 * Create a Words JSONObject
	 * @param name Column name
	 * @param min Minimun words
	 * @param max Maximum words
	 * @return Words JSONObject
	 * @throws MockarooExceptionName 
	 * @throws MockarooExceptionNumber 
	 * @throws MockarooExceptionValue 
	 */
	public JSONObject createWords(String name, int min, int max)
			throws MockarooExceptionName, MockarooExceptionNumber
	{
		return createJSONObject.createJSONObjectWords(name, min, max, MockarooType.Words.toString());
	}
	
	/**
	 * Create a Zip JSONObject
	 * @param name Column name
	 * @return Zip JSONObject
	 * @throws MockarooExceptionName 
	 * @throws MockarooExceptionValue 
	 */
	public JSONObject createZip(String name)throws MockarooExceptionName
	{
		return createJSONObject.createJSONObject(name, MockarooType.Zip.toString());
	}
}