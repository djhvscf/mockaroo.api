package com.mockaroo.api.helpers;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.FileWriter;
import jxl.write.WriteException;
import org.json.JSONObject;

import com.mockaroo.api.interfaces.IMockarooJSONHelper;

public class MockarooJSONHelper implements IMockarooJSONHelper {

	@Override
	public void write(String fileName, JSONObject jsonObject)throws IOException, WriteException {
		
		FileWriter write = new FileWriter(fileName, true);
		PrintWriter writer = new PrintWriter(write);
		writer.println(jsonObject.toString());
		writer.close();
	}
}