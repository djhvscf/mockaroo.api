Mockaroo API
================

Mockaroo API is an API that let us generate random data and insert into our data base. That's it.<br />
This API is based in JSON Objects.

Author Homepage:      http://djhv92.wix.com/dennishernandez<br />

How to use it?
==============

        MockarooApi mockarooApi = new MockarooApi("Apikey", "application/json"); 

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
	
		MockarooDataAccess dataAccess = new MockarooDataAccess("databaseDriver", "localhost", "username", "password");
		String[] columnsTable = new String[2];
		columnsTable[0] = "department";
		columnsTable[1] = "name";
		
		mockarooApi.Insert(data, dataAccess, "tableName", columnsTable);//Insert into a data base
		
		MockarooFile test = new MockarooExcel("c:/temp/","test","testing","en", "EN");
	    test.write(data); //Generate a Excel file
	    
	    MockarooFile json = new MockarooJSON("c:/temp/", "test");
	    json.write(data); //Generate a .json file

Dependencies
=============
Not yet.

Repo Contents
=============
Not yet.

Release history
======================
Version: 0.1.0 - 18/July/2014

Download mockarooapi.jar
=======================
https://github.com/djhvscf/mockaroo.api/releases/tag/v0.1.0

