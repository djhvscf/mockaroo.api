package com.mockaroo.api.classes;

import java.io.IOException;

import javax.xml.transform.TransformerException;

import jxl.write.WriteException;

import org.json.JSONArray;
import org.json.JSONObject;

/**
 * Class to create a specific JSONObject
 * @author Dennis Hernández Vargas
 * @version 0.1.0 - 09/July/2014
 * @since 0.1.0
 */
public abstract class MockarooFile {

	public abstract void write(JSONObject jsonObject) throws IOException, WriteException, TransformerException;
	
	public abstract void write(JSONArray jsonArray) throws IOException, WriteException, TransformerException;
}