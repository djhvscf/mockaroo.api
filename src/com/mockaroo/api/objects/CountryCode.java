package com.mockaroo.api.objects;

import com.mockaroo.api.enums.MockarooType;
import com.mockaroo.api.exceptions.MockarooExceptionName;
import com.mockaroo.api.interfaces.IMockarooObject;
import org.json.JSONObject;

/**
 * CountryCode mockaroo object
 * @author Dennis Hernández Vargas
 * @version 2.0.0 - 14/06/2014
 * @since 2.0.0
 */
public class CountryCode implements IMockarooObject {

    private static CountryCode instance = null;
    private String columnName;

    /**
     * Constructor
     * @param columnName Column name
     */
    private CountryCode(String columnName)
    {
        this.setColumnName(columnName);
    }

    /**
     * Get the {@link CountryCode} object
     * @param columnName Column name
     * @return {@link CountryCode} object
     * @throws MockarooExceptionName
     */
    public static CountryCode getInstance(String columnName) throws MockarooExceptionName
    {
        VALIDATOR.validateColumnName(columnName, messageExceptionName);

        if(instance == null)
        {
            instance = new CountryCode(columnName);
        }

        return instance;
    }

    /**
     * Get the columnName
     * @return the columnName
     */
    private String getColumnName() {
        return columnName;
    }

    /**
     * Set the columnName
     * @param columnName the columnName to set
     */
    private void setColumnName(String columnName) {
        this.columnName = columnName;
    }

    @Override
    public JSONObject getJSONObject() {

        JSONObject jsonObject = new JSONObject();
        jsonObject.put(NAME, this.getColumnName());
        jsonObject.put(TYPE, this.getType());

        return jsonObject;
    }

    @Override
    public String getType() {
        return MockarooType.CountryCode.toString();
    }
}
