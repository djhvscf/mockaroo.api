package testApi;

import java.io.OutputStream;
import java.net.HttpURLConnection;

import org.apache.commons.io.IOUtils;
import org.json.JSONArray;
import org.json.JSONObject;

import com.mockaroo.api.classes.CreateJSONObject;
import com.mockaroo.api.classes.Url;
import com.mockaroo.api.enums.MockarooTimeType;
import com.mockaroo.api.interfaces.IUrl;

public class testoftest {
	public static void main(String[] args) throws Exception {
		
		CreateJSONObject creater = new CreateJSONObject();
		
		IUrl url = Url.getInstance();
		HttpURLConnection conn = url.openConnecion("60391b90", "application/json");

		JSONArray values = new JSONArray();
		values.put("R+D");
		values.put("Marketing");
		values.put("HR");

		//dob.put("format", "%m/%d/%Y");*/
		JSONArray columns = new JSONArray();
		columns.put(creater.createNumber("yearsEmployed", 1, 30, 0));
		columns.put(creater.createCustomList("department", values));
		columns.put(creater.createDate("dob", "1/1/1950", "1/1/2000", "%m/%d/%Y"));
		columns.put(creater.createFirstName("name"));
		columns.put(creater.createTime("time", "05:00 AM", "06:59 AM", MockarooTimeType.N));

		OutputStream os = conn.getOutputStream();
		os.write(columns.toString().getBytes());
		os.flush();

		JSONObject data = new JSONObject(IOUtils.toString(conn.getInputStream()));
		
		//JSONArray data = new JSONArray(IOUtils.toString(conn.getInputStream()));

		System.out.println(data.getInt("yearsEmployed"));
		System.out.println(data.getString("department"));
		System.out.println(data.getString("dob"));
		System.out.println(data.getString("name"));
		System.out.println(data.getString("time"));
	}
}