package testApi;

import java.net.HttpURLConnection;

import org.json.JSONArray;
import org.json.JSONObject;

import com.mockaroo.api.MockarooApi;
import com.mockaroo.api.MockarooDataAccess;
import com.mockaroo.api.classes.MockarooCreateJSONObject;
import com.mockaroo.api.enums.MockarooTimeType;

public class testoftest {
	public static void main(String[] args) throws Exception {
		
		MockarooApi mockarooApi = new MockarooApi("60391b90", "application/json");
		HttpURLConnection conn = mockarooApi.getUrl().openConnecion();
		
		MockarooCreateJSONObject creater = mockarooApi.getCreater();
		
		JSONArray values = new JSONArray();
		values.put("R+D");
		values.put("Marketing");
		values.put("HR");

		JSONArray columns = new JSONArray();
		//columns.put(creater.createNumber("yearsEmployed", 1, 30, 0));
		columns.put(creater.createCustomList("department", values));
		//columns.put(creater.createDate("dob", "1/1/1950", "1/1/2000", "%m/%d/%Y"));
		columns.put(creater.createFirstName("name"));
		//columns.put(creater.createTime("time", "05:00 AM", "06:59 AM", MockarooTimeType.H));

		JSONObject data = mockarooApi.getJSONObject(conn, columns);
	
		MockarooDataAccess dataAccess = new MockarooDataAccess("com.mysql.jdbc.Driver", "jdbc:mysql://localhost:3306/test", "root", "mtrlnk");
		String[] valuesf = new String[2];
		valuesf[0] = "varascol";
		valuesf[1] = "varascol1";
		
		mockarooApi.Insert(data, dataAccess, "varas", valuesf);
		
		//System.out.println(data.getInt("yearsEmployed"));
		System.out.println(data.getString("department"));
		//System.out.println(data.getString("dob"));
		System.out.println(data.getString("name"));
		//System.out.println(data.getString("time"));
	}
}