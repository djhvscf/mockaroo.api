package com.mockaroo.api.classes;

import java.io.IOException;
import jxl.write.WriteException;
import org.json.JSONObject;

public abstract class MockarooFile {

	public abstract void write(JSONObject jsonObject) throws IOException, WriteException;
	public void write(String fileName, JSONObject jsonObject) throws IOException, WriteException {
	}
}