package com.mockaroo.api.classes;

public class MockarooType {

	public static enum Type {
		Blank("Blank"),
		Boolean("Boolean"),
		City("City"),
		Color("Color"),
		Company_Name("Company Name"),
		Country("Country"),
		Credit_Card_1("Credit Card #"),
		Credit_Card_Type("Credit Card Type"),
		Currency("Currency"),
		Currency_Code("Currency Code"),
		Custom_List("Custom List"),
		Date("Date"),
		Domain_Name("Domain Name"),
		Email_Address("Email Address"),
		Encrypt("Encrypt"),
		Family_Name_Chinese("Family Name (Chinese)"),
		First_Name("First Name"),
		First_Name_European("First Name (European)"),
		First_Name_Female("First Name (Female)"),//(Female)
		First_Name_Male("First Name Male"),//(Male)
		Formula("Formula"),
		Frequency("Frequency"),
		Full_Name("Full Name"),
		Gender("Gender"),
		Gender_abbrev("Gender (abbrev)"),//(abbrev)
		Given_Name_Chinese("Given Name (Chinese)"),//(Chinese)
		GUID("GUID"),
		Hex_Color("Hex Color"),
		IP_Address_v4("IP Address v4"),
		IP_Address_v6("IP Address v6"),
		ISBN("ISBN"),
		JSON_Array("JSON Array"),
		Language("Language"),
		Last_Name("Last Name"),
		Latitude("Latitude"),
		Longitude("Longitude"),
		MAC_Address("MAC Address"),
		Money("Money"),
		My_List("My List"),
		Normal_Distribution("Normal Distribution"),
		Number("Number", 0, 100),
		Paragraphs("Paragraphs"),
		Password("Password"),
		Phone("Phone"),
		Province("Province"),
		Province_abbrev("Province (abbrev)"),//(abbrev)
		Race("Race"),
		Regular_Expression("Regular Expression"),
		Row_Number("Row Number"),
		Sentences("Sentences"),
		Sequence("Sequence"),
		Shirt_Size("Shirt Size"),
		Short_Hex_Color("Short Hex Color"),
		SSN("SSN"),
		State("State"),
		State_abbrev("State (abbrev)"),//(abbrev)
		Street_Address("Street Address"),
		Street_Name("Street Name"),
		Street_Number("Street Number"),
		Street_Suffix("Street Suffix"),
		Suffix("Suffix"),
		Template("Template"),
		Time("Time"),
		Time_Zone("Time Zone"),
		Title("Title"),
		Top_Level_Domain("Top Level Domain"),
		URL("URL"),
		Username("Username"),
		Words("Words"),
		Zip("Zip");
		
		private String type;
		private int min;
		private int max;
		private Type() {
		}
		
		private Type(final String pType){
			this.type = pType;
		}
		
		//Number, Words, Paragraphs, Sentences
		private Type(final String ptype, final int pmin, final int pmax)
		{
			this.type = ptype;
			this.min = pmin;
			this.max = pmax;
		}
		
		public String getType()
		{
			return this.type;
		}
		
		public int getMin()
		{
			return this.min;
		}
		
		public int getMax()
		{
			return this.max;
		}
		
		public void setMax(int pmax)
		{
			this.max = pmax;
		}
	}
}