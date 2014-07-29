package com.mockaroo.api.classes;

import org.json.JSONArray;
import org.json.JSONObject;

import com.mockaroo.api.enums.MockarooMoneyType;
import com.mockaroo.api.enums.MockarooTimeType;
import com.mockaroo.api.exceptions.MockarooExceptionArray;
import com.mockaroo.api.exceptions.MockarooExceptionFormatDate;
import com.mockaroo.api.exceptions.MockarooExceptionFormatTime;
import com.mockaroo.api.exceptions.MockarooExceptionFormula;
import com.mockaroo.api.exceptions.MockarooExceptionMyList;
import com.mockaroo.api.exceptions.MockarooExceptionName;
import com.mockaroo.api.exceptions.MockarooExceptionNumber;
import com.mockaroo.api.exceptions.MockarooExceptionRegExpValue;
import com.mockaroo.api.exceptions.MockarooExceptionValue;
import com.mockaroo.api.interfaces.IMockarooObject;
import com.mockaroo.api.objects.Blank;
import com.mockaroo.api.objects.City;
import com.mockaroo.api.objects.Color;
import com.mockaroo.api.objects.CompanyName;
import com.mockaroo.api.objects.Country;
import com.mockaroo.api.objects.CreditCardNumber;
import com.mockaroo.api.objects.CreditCardType;
import com.mockaroo.api.objects.Currency;
import com.mockaroo.api.objects.CurrencyCode;
import com.mockaroo.api.objects.CustomList;
import com.mockaroo.api.objects.Date;
import com.mockaroo.api.objects.DomainName;
import com.mockaroo.api.objects.EmailAddress;
import com.mockaroo.api.objects.Encrypt;
import com.mockaroo.api.objects.FamilyNameChinese;
import com.mockaroo.api.objects.FirstName;
import com.mockaroo.api.objects.FirstNameEuropean;
import com.mockaroo.api.objects.FirstNameFemale;
import com.mockaroo.api.objects.FirstNameMale;
import com.mockaroo.api.objects.Formula;
import com.mockaroo.api.objects.Frequency;
import com.mockaroo.api.objects.FullName;
import com.mockaroo.api.objects.GUID;
import com.mockaroo.api.objects.Gender;
import com.mockaroo.api.objects.GenderAbbrev;
import com.mockaroo.api.objects.GivenNameChinese;
import com.mockaroo.api.objects.HexColor;
import com.mockaroo.api.objects.IPAddressv4;
import com.mockaroo.api.objects.IPAddressv6;
import com.mockaroo.api.objects.ISBN;
import com.mockaroo.api.objects.Language;
import com.mockaroo.api.objects.LastName;
import com.mockaroo.api.objects.Latitude;
import com.mockaroo.api.objects.Longitude;
import com.mockaroo.api.objects.MACAddress;
import com.mockaroo.api.objects.Money;
import com.mockaroo.api.objects.MyList;
import com.mockaroo.api.objects.NormalDistribution;
import com.mockaroo.api.objects.Number;
import com.mockaroo.api.objects.Paragraphs;
import com.mockaroo.api.objects.Password;
import com.mockaroo.api.objects.Phone;
import com.mockaroo.api.objects.Province;
import com.mockaroo.api.objects.ProvinceAbbrev;
import com.mockaroo.api.objects.Race;
import com.mockaroo.api.objects.RegularExpression;
import com.mockaroo.api.objects.RowNumber;
import com.mockaroo.api.objects.SSN;
import com.mockaroo.api.objects.Sentences;
import com.mockaroo.api.objects.Sequence;
import com.mockaroo.api.objects.ShirtSize;
import com.mockaroo.api.objects.ShortHexColor;
import com.mockaroo.api.objects.State;
import com.mockaroo.api.objects.StateAbbrev;
import com.mockaroo.api.objects.StreetAddress;
import com.mockaroo.api.objects.StreetName;
import com.mockaroo.api.objects.StreetNumber;
import com.mockaroo.api.objects.StreetSuffix;
import com.mockaroo.api.objects.Suffix;
import com.mockaroo.api.objects.Template;
import com.mockaroo.api.objects.Time;
import com.mockaroo.api.objects.TimeZone;
import com.mockaroo.api.objects.Title;
import com.mockaroo.api.objects.TopLevelDomain;
import com.mockaroo.api.objects.URL;
import com.mockaroo.api.objects.Username;
import com.mockaroo.api.objects.Words;
import com.mockaroo.api.objects.Zip;

/**
 * Class to create a specific JSONObject
 * @author Dennis Hernández Vargas
 * @version 0.1.0 - 09/July/2014
 * @since 0.1.0
 */
public class MockarooCreateJSONObject {

	/**
	 * Create a Blank JSONObject
	 * @param name Column name
	 * @return Blank JSONObject
	 * @throws MockarooExceptionName
	 */
	public JSONObject createBlank(String name) throws MockarooExceptionName
	{
		IMockarooObject blank = Blank.getInstance(name);
		return blank.getJSONObject();
	}
	
	/**
	 * Create a Boolean JSONObject
	 * @param name Column name
	 * @return Boolean JSONObject
	 * @throws MockarooExceptionName
	 */
	public JSONObject createBoolean(String name) throws MockarooExceptionName
	{
		IMockarooObject booleanM = com.mockaroo.api.objects.Boolean.getInstance(name);
		return booleanM.getJSONObject();
	}
	
	/**
	 * Create a City JSONObject
	 * @param name Column name
	 * @return City JSONObject
	 * @throws MockarooExceptionName
	 */
	public JSONObject createCity(String name) throws MockarooExceptionName
	{
		IMockarooObject city = City.getInstance(name);
		return city.getJSONObject();
	}
	
	/**
	 * Create a Color JSONObject
	 * @param name Column name
	 * @return Color JSONObject
	 * @throws MockarooExceptionName
	 */
	public JSONObject createColor(String name) throws MockarooExceptionName
	{
		IMockarooObject color = Color.getInstance(name);
		return color.getJSONObject();
	}
	
	/**
	 * Create a Company Name JSONObject
	 * @param name Column name
	 * @return Company name JSONObject
	 * @throws MockarooExceptionName
	 */
	public JSONObject createCompanyName(String name) throws MockarooExceptionName
	{
		IMockarooObject companyName = CompanyName.getInstance(name);
		return companyName.getJSONObject();
	}
	
	/**
	 * Create a Country JSONObject
	 * @param name Column name
	 * @return Country JSONObject
	 * @throws MockarooExceptionName
	 */
	public JSONObject createCountry(String name) throws MockarooExceptionName
	{
		IMockarooObject country = Country.getInstance(name);
		return country.getJSONObject();
	}
	
	/**
	 * Create a Credit Card Number JSONObject
	 * @param name Column name
	 * @return Credit Card Number JSONObject
	 * @throws MockarooExceptionName
	 */
	public JSONObject createCreditCardNumber(String name) throws MockarooExceptionName
	{
		IMockarooObject creditCardNumber = CreditCardNumber.getInstance(name);
		return creditCardNumber.getJSONObject();
	}
	
	/**
	 * Create a Credit Card Type JSONObject
	 * @param name Column name
	 * @return Credti Card Type JSONObject
	 * @throws MockarooExceptionName
	 */
	public JSONObject createCreditCardType(String name) throws MockarooExceptionName
	{
		IMockarooObject creditCardType = CreditCardType.getInstance(name);
		return creditCardType.getJSONObject();
	}
	
	/**
	 * Create a Currency JSONObject
	 * @param name Column name
	 * @return Currency JSONObjct
	 * @throws MockarooExceptionName
	 */
	public JSONObject createCurrency(String name) throws MockarooExceptionName
	{
		IMockarooObject currency = Currency.getInstance(name);
		return currency.getJSONObject();
	}
	
	/**
	 * Create a Currency Code JSONObject
	 * @param name Column name
	 * @return Currency Code JSONObject
	 * @throws MockarooExceptionName
	 */
	public JSONObject createCurrencyCode(String name) throws MockarooExceptionName
	{
		IMockarooObject currencyCode = CurrencyCode.getInstance(name);
		return currencyCode.getJSONObject();
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
		IMockarooObject customList = CustomList.getInstance(name, values);
		return customList.getJSONObject();
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
		IMockarooObject date = Date.getInstance(name, min, max, format);
		return date.getJSONObject();
	}
	
	/**
	 * Create a Domain Name JSONObject
	 * @param name Column name
	 * @return Domain Name JSONObject
	 * @throws MockarooExceptionName
	 */
	public JSONObject createDomainName(String name) throws MockarooExceptionName
	{
		IMockarooObject domainName = DomainName.getInstance(name);
		return domainName.getJSONObject();
	}
	
	/**
	 * Create a Email Address JSONObject
	 * @param name Column name
	 * @return Email Address JSONObject
	 * @throws MockarooExceptionName
	 */
	public JSONObject createEmailAddress(String name) throws MockarooExceptionName
	{
		IMockarooObject emailAddress = EmailAddress.getInstance(name);
		return emailAddress.getJSONObject();
	}
	
	/**
	 * Create a Encrypt JSONObject
	 * @param name Column name
	 * @return Encrypt JSONObject
	 * @throws MockarooExceptionName
	 */
	public JSONObject createEncrypt(String name) throws MockarooExceptionName
	{
		IMockarooObject encrypt = Encrypt.getInstance(name);
		return encrypt.getJSONObject();
	}
	
	/**
	 * Create a Family Name Chinese JSONObject
	 * @param name Column name
	 * @return Family Name Chinese JSONObject 
	 * @throws MockarooExceptionName
	 */
	public JSONObject createFamilyNameChinese(String name) throws MockarooExceptionName
	{
		IMockarooObject familyNameChinese = FamilyNameChinese.getInstance(name);
		return familyNameChinese.getJSONObject();
	}
	
	/**
	 * Create a First Name JSONObject
	 * @param name Column name
	 * @return First Name JSONObject
	 * @throws MockarooExceptionName
	 */
	public JSONObject createFirstName(String name) throws MockarooExceptionName
	{
		IMockarooObject firstName = FirstName.getInstance(name);
		return firstName.getJSONObject();
	}
	
	/**
	 * Create a First Name European JSONObject
	 * @param name Column name
	 * @return First Name JSONObject
	 * @throws MockarooExceptionName
	 */
	public JSONObject createFirstNameEuropean(String name) throws MockarooExceptionName
	{
		IMockarooObject firstNameEuropean = FirstNameEuropean.getInstance(name);
		return firstNameEuropean.getJSONObject();
	}
	
	/**
	 * Create a First Name Female JSONObject
	 * @param name Column name
	 * @return First Name Female JSONObject
	 * @throws MockarooExceptionName
	 */
	public JSONObject createFirstNameFemale(String name) throws MockarooExceptionName
	{
		IMockarooObject firstNameFemale = FirstNameFemale.getInstance(name);
		return firstNameFemale.getJSONObject();
	}
	
	/**
	 * Create a First Name Male JSONObject
	 * @param name Column name
	 * @return First Name Male JSONObject
	 * @throws MockarooExceptionName
	 */
	public JSONObject creatFirstNameMale(String name) throws MockarooExceptionName
	{
		IMockarooObject firstNameMale = FirstNameMale.getInstance(name);
		return firstNameMale.getJSONObject();
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
		IMockarooObject formulaM = Formula.getInstance(name, formula);
		return formulaM.getJSONObject();
	}
	
	/**
	 * Create a Frequency JSONObject
	 * @param name Column name
	 * @return Frequency JSONObject
	 * @throws MockarooExceptionName
	 */
	public JSONObject createFrequency(String name) throws MockarooExceptionName
	{
		IMockarooObject frequency = Frequency.getInstance(name);
		return frequency.getJSONObject();
	}
	
	/**
	 * Create a Full Name JSONObject
	 * @param name Column name
	 * @return Full Name JSONObject
	 * @throws MockarooExceptionName
	 */
	public JSONObject createFullName(String name) throws MockarooExceptionName
	{
		IMockarooObject fullName = FullName.getInstance(name);
		return fullName.getJSONObject();
	}
	
	/**
	 * Create a Gender JSONObject
	 * @param name Column name
	 * @return Gender JSONObject
	 * @throws MockarooExceptionName
	 */
	public JSONObject createGender(String name) throws MockarooExceptionName
	{
		IMockarooObject gender = Gender.getInstance(name);
		return gender.getJSONObject();
	}
	
	/**
	 * Create a Gender (abbrev) JSONObject
	 * @param name Column name
	 * @return Gender (abbrev) JSONObject
	 * @throws MockarooExceptionName
	 */
	public JSONObject createGenderAbbrev(String name) throws MockarooExceptionName
	{
		IMockarooObject genderAbbrev = GenderAbbrev.getInstance(name);
		return genderAbbrev.getJSONObject();
	}
	
	/**
	 * Create a Given Name (Chinese) JSONObject
	 * @param name Column name
	 * @return Given Name (Chinese) JSONObject
	 * @throws MockarooExceptionName
	 */
	public JSONObject createGivenNameChinese(String name) throws MockarooExceptionName
	{
		IMockarooObject givenNameChinese = GivenNameChinese.getInstance(name);
		return givenNameChinese.getJSONObject();
	}
	
	/**
	 * Create a GUID JSONObject
	 * @param name Column name
	 * @return GUID JSONObject
	 * @throws MockarooExceptionName
	 */
	public JSONObject createGUID(String name) throws MockarooExceptionName
	{
		IMockarooObject guid = GUID.getInstance(name);
		return guid.getJSONObject();
	}
	
	/**
	 * Create a Hex Color JSONObject
	 * @param name Column name
	 * @return Hex Color JSONObject
	 * @throws MockarooExceptionName
	 */
	public JSONObject createHexColor(String name) throws MockarooExceptionName
	{
		IMockarooObject hexColor = HexColor.getInstance(name);
		return hexColor.getJSONObject();
	}
	
	/**
	 * Create a IP Address v4 JSONObject
	 * @param name Column name
	 * @return IP Address v4 JSONObject
	 * @throws MockarooExceptionName
	 */
	public JSONObject createIPAddressv4(String name) throws MockarooExceptionName
	{
		IMockarooObject ipAddressv4 = IPAddressv4.getInstance(name);
		return ipAddressv4.getJSONObject();
	}
	
	/**
	 * Create a IP Address v6 JSONObject
	 * @param name Column name
	 * @return IP Address v6 JSONObject
	 * @throws MockarooExceptionName
	 */
	public JSONObject createIPAddressv6(String name) throws MockarooExceptionName
	{
		IMockarooObject ipAddressv6 = IPAddressv6.getInstance(name);
		return ipAddressv6.getJSONObject();
	}
	
	/**
	 * Create a ISBN JSONObject
	 * @param name Column name
	 * @return ISBN JSONObject
	 * @throws MockarooExceptionName
	 */
	public JSONObject createISBN(String name) throws MockarooExceptionName
	{
		IMockarooObject isbn = ISBN.getInstance(name);
		return isbn.getJSONObject();
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
		IMockarooObject jsonArray = com.mockaroo.api.objects.JSONArray.getInstance(name, minItems, maxItems);
		return jsonArray.getJSONObject();
	}
	
	/**
	 * Create a Language JSONObject
	 * @param name Column name
	 * @return Language JSONObject
	 * @throws MockarooExceptionName
	 */
	public JSONObject createLanguage(String name) throws MockarooExceptionName
	{
		IMockarooObject language = Language.getInstance(name);
		return language.getJSONObject();
	}
	
	/**
	 * Create a Last Name JSONObject
	 * @param name Column name
	 * @return Last Name JSONObject
	 * @throws MockarooExceptionName
	 */
	public JSONObject createLastName(String name) throws MockarooExceptionName
	{
		IMockarooObject lastName = LastName.getInstance(name);
		return lastName.getJSONObject();
	}
	
	/**
	 * Create a Latitude JSONObject
	 * @param name Column name
	 * @return Latitude JSONObject
	 * @throws MockarooExceptionName
	 */
	public JSONObject createLatitude(String name) throws MockarooExceptionName
	{
		IMockarooObject latitude = Latitude.getInstance(name);
		return latitude.getJSONObject();
	}
	
	/**
	 * Create a Longitude JSONObject
	 * @param name Column name
	 * @return Longitude JSONObject
	 * @throws MockarooExceptionName
	 */
	public JSONObject createLongitude(String name) throws MockarooExceptionName
	{
		IMockarooObject longitude = Longitude.getInstance(name);
		return longitude.getJSONObject();
	}
	
	/**
	 * Create a MAC Address JSONObject
	 * @param name Column name
	 * @return MAC Address JSONObject
	 * @throws MockarooExceptionName
	 */
	public JSONObject createMACAddress(String name) throws MockarooExceptionName
	{
		IMockarooObject macAddress = MACAddress.getInstance(name);
		return macAddress.getJSONObject();
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
		IMockarooObject money = Money.getInstance(name, min, max, moneyType);
		return money.getJSONObject();
	}
	
	/**
	 * Create a My List JSONObject
	 * @param name Column name
	 * @param myListName The name of a saved list
	 * @return My List JSONObject
	 * @throws MockarooExceptionName
	 * @throws MockarooExceptionMyList 
	 * @throws MockarooExceptionValue 
	 */
	public JSONObject createMyList(String name, String myListName) 
			throws MockarooExceptionName, MockarooExceptionMyList, MockarooExceptionValue
	{
		IMockarooObject myList = MyList.getInstance(name, myListName);
		return myList.getJSONObject();
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
		IMockarooObject normalDistribution = NormalDistribution.getInstance(name, mean, sd, decimals);
		return normalDistribution.getJSONObject();
	}
	
	/**
	 * Create a Number JSONObjct
	 * @param name Column name
	 * @param min Min number
	 * @param decimals Quantity of decimals
	 * @return Number JSONOoject
	 * @throws MockarooExceptionNumber
	 * @throws MockarooExceptionName
	 */
	public JSONObject createNumber(String name, int min, int decimals) 
			throws MockarooExceptionNumber, MockarooExceptionName
	{
		IMockarooObject number = Number.getInstance(name, min, decimals);
		return number.getJSONObject();
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
		IMockarooObject paragraph = Paragraphs.getInstance(name, min, max);
		return paragraph.getJSONObject();
	}
	
	/**
	 * Create a Password JSONObject
	 * @param name Column name
	 * @return Password JSONObject
	 * @throws MockarooExceptionName 
	 */
	public JSONObject createPassword(String name) throws MockarooExceptionName
	{
		IMockarooObject password = Password.getInstance(name);
		return password.getJSONObject();
	}
	
	/**
	 * Create a Phone JSONObject
	 * @param name Column name
	 * @return Phone JSONObject
	 * @throws MockarooExceptionName 
	 */
	public JSONObject createPhone(String name) throws MockarooExceptionName
	{
		IMockarooObject phone = Phone.getInstance(name);
		return phone.getJSONObject();
	}
	
	/**
	 * Create a Province JSONObject
	 * @param name Column name
	 * @return Province JSONObject
	 * @throws MockarooExceptionName 
	 */
	public JSONObject createProvince(String name) throws MockarooExceptionName
	{
		IMockarooObject province = Province.getInstance(name);
		return province.getJSONObject();
	}
	
	/**
	 * Create a Province (abbrev) JSONObject
	 * @param name Column name
	 * @return Province (abbrev) JSONObject
	 * @throws MockarooExceptionName 
	 */
	public JSONObject createProvinceAbbrev(String name) throws MockarooExceptionName
	{
		IMockarooObject provinceAbbrev = ProvinceAbbrev.getInstance(name);
		return provinceAbbrev.getJSONObject();
	}
	
	/**
	 * Create a Race JSONObject
	 * @param name Column name
	 * @return Race JSONObject
	 * @throws MockarooExceptionName 
	 */
	public JSONObject createRace(String name) throws MockarooExceptionName
	{
		IMockarooObject race = Race.getInstance(name);
		return race.getJSONObject();
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
		IMockarooObject regExpression = RegularExpression.getInstance(name, value);
		return regExpression.getJSONObject();
	}
	
	/**
	 * Create a Row Number JSONObject
	 * @param name Column name
	 * @return Row Number JSONObject
	 * @throws MockarooExceptionName 
	 */
	public JSONObject createRowNumber(String name) throws MockarooExceptionName
	{
		IMockarooObject rowNumber = RowNumber.getInstance(name);
		return rowNumber.getJSONObject();
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
		IMockarooObject sentences = Sentences.getInstance(name, min, max);
		return sentences.getJSONObject();
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
		IMockarooObject sequence = Sequence.getInstance(name, start, step, repeat);
		return sequence.getJSONObject();
	}
	
	/**
	 * Create a Shirt Size JSONObject
	 * @param name Column name
	 * @return Shirt Size JSONObject
	 * @throws MockarooExceptionName 
	 */
	public JSONObject createShirtSize(String name) throws MockarooExceptionName
	{
		IMockarooObject shirtSize = ShirtSize.getInstance(name);
		return shirtSize.getJSONObject();
	}
	
	/**
	 * Create a Short Hex Color JSONObject
	 * @param name Column name
	 * @return Short Hex Color JSONObject
	 * @throws MockarooExceptionName 
	 */
	public JSONObject createShortHexColor(String name) throws MockarooExceptionName
	{
		IMockarooObject shortHexColor = ShortHexColor.getInstance(name);
		return shortHexColor.getJSONObject();
	}
	
	/**
	 * Create a SSN JSONObject
	 * @param name Column name
	 * @return SSN JSONObject
	 * @throws MockarooExceptionName 
	 */
	public JSONObject createSSN(String name) throws MockarooExceptionName
	{
		IMockarooObject ssn = SSN.getInstance(name);
		return ssn.getJSONObject();
	}
	
	/**
	 * Create a State JSONObject
	 * @param name Column name
	 * @return State JSONObject
	 * @throws MockarooExceptionName 
	 */
	public JSONObject createState(String name) throws MockarooExceptionName
	{
		IMockarooObject state = State.getInstance(name);
		return state.getJSONObject();
	}
	
	/**
	 * Create a State (abbrev) JSONObject
	 * @param name Column name
	 * @return State (abbrev) JSONObject
	 * @throws MockarooExceptionName 
	 */
	public JSONObject createStateAbbrev(String name) throws MockarooExceptionName
	{
		IMockarooObject stateAbbrev = StateAbbrev.getInstance(name);
		return stateAbbrev.getJSONObject();
	}
	
	/**
	 * Create a Street Address JSONObject
	 * @param name Column name
	 * @return Street Address JSONObject
	 * @throws MockarooExceptionName 
	 */
	public JSONObject createStreetAddress(String name) throws MockarooExceptionName
	{
		IMockarooObject streetAddress = StreetAddress.getInstance(name);
		return streetAddress.getJSONObject();
	}
	
	/**
	 * Create a Street Name JSONObject
	 * @param name Column name
	 * @return Street Name JSONObject
	 * @throws MockarooExceptionName 
	 */
	public JSONObject createStreetName(String name) throws MockarooExceptionName
	{
		IMockarooObject streetName = StreetName.getInstance(name);
		return streetName.getJSONObject();
	}
	
	/**
	 * Create a Street Number JSONObject
	 * @param name Column name
	 * @return Street Number JSONObject
	 * @throws MockarooExceptionName 
	 */
	public JSONObject createStreetNumber(String name) throws MockarooExceptionName
	{
		IMockarooObject streetNumber = StreetNumber.getInstance(name);
		return streetNumber.getJSONObject();
	}
	
	/**
	 * Create a Street Suffix JSONObject
	 * @param name Column name
	 * @return Street Suffix JSONObject
	 * @throws MockarooExceptionName 
	 */
	public JSONObject createStreetSuffix(String name) throws MockarooExceptionName
	{
		IMockarooObject streetSuffix = StreetSuffix.getInstance(name);
		return streetSuffix.getJSONObject();
	}
	
	/**
	 * Create a Suffix JSONObject
	 * @param name Column name
	 * @return Suffix JSONObject
	 * @throws MockarooExceptionName 
	 */
	public JSONObject createSuffix(String name) throws MockarooExceptionName
	{
		IMockarooObject suffix = Suffix.getInstance(name);
		return suffix.getJSONObject();
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
		IMockarooObject template = Template.getInstance(name, value);
		return template.getJSONObject();
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
		IMockarooObject time = Time.getInstance(name, min, max, format);
		return time.getJSONObject();
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
		IMockarooObject timeZone = TimeZone.getInstance(name);
		return timeZone.getJSONObject();
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
		IMockarooObject title = Title.getInstance(name);
		return title.getJSONObject();
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
		IMockarooObject topLevelDomain = TopLevelDomain.getInstance(name);
		return topLevelDomain.getJSONObject();
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
		IMockarooObject url = URL.getInstance(name, includeProtocol, includeHost, includePath, includeQueryString);
		return url.getJSONObject();
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
		IMockarooObject username = Username.getInstance(name);
		return username.getJSONObject();
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
		IMockarooObject words = Words.getInstance(name, min, max);
		return words.getJSONObject();
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
		IMockarooObject zip = Zip.getInstance(name);
		return zip.getJSONObject();
	}
}