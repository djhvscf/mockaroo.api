package testMockarooApi;

import java.net.HttpURLConnection;

import org.json.JSONArray;
import org.json.JSONObject;

import com.mockaroo.api.MockarooApi;
import com.mockaroo.api.MockarooDataAccess;
import com.mockaroo.api.MockarooExcel;
import com.mockaroo.api.classes.MockarooCreateJSONObject;

public class test {
	public static void main(String[] args) throws Exception {

	    MockarooApi mockarooApi = new MockarooApi("60391b90", "application/json"); 

	    HttpURLConnection conn = mockarooApi.getUrl().openConnecion();
	    MockarooCreateJSONObject creater = mockarooApi.getCreater();

	    JSONArray array= new JSONArray();
	    array.put("R+D");
	    array.put("Marketing");
	    array.put("HR");

	    JSONArray columns = new JSONArray();
	    columns.put(creater.createCustomList("department", array));
	    columns.put(creater.createFirstName("name"));

	    JSONObject data = mockarooApi.getJSONObject(conn, columns);

	    try
	    {
		    MockarooDataAccess dataAccess = new MockarooDataAccess("com.mysql.jdbc.Driver", 
		    									"jdbc:mysql://localhost:3306/test", "root", "mtrlnk");
		    String[] columnsTable = new String[2];
		    columnsTable[0] = "department";
		    columnsTable[1] = "name";
	
		    mockarooApi.Insert(data, dataAccess, "testtable", columnsTable);
	    }
	    catch(Exception e)
	    {
	    	
	    }
	    MockarooExcel test = new MockarooExcel("c:/temp/","test.xls","testing","en", "EN");
	    test.write(data);
	}
}