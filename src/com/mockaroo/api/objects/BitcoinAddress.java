package com.mockaroo.api.objects;

import com.mockaroo.api.enums.MockarooType;
import com.mockaroo.api.exceptions.MockarooExceptionName;
import com.mockaroo.api.interfaces.IMockarooObject;
import org.json.JSONObject;

/**
 * BitcoinAddress mockaroo object
 * @author Dennis Hernández Vargas
 * @version 2.0.0 - 14/June/2015
 * @since 2.0.0
 */
public class BitcoinAddress implements IMockarooObject {

    private static BitcoinAddress instance = null;
    private String columnName;

    /**
     * Default constructor
     * @param columnName Column name
     */
    private BitcoinAddress(String columnName)
    {
        this.setColumnName(columnName);
    }

    /**
     * Get the {@link BitcoinAddress} object
     * @param columnName Column name
     * @return {@link BitcoinAddress} object
     * @throws MockarooExceptionName
     */
    public static BitcoinAddress getInstance(String columnName) throws MockarooExceptionName
    {
        VALIDATOR.validateColumnName(columnName, messageExceptionName);
        if(instance == null)
        {
            instance = new BitcoinAddress(columnName);
        }

        return instance;
    }

    /**
     * @return the columnName
     */
    public String getColumnName() {
        return columnName;
    }

    /**
     * @param columnName the columnName to set
     */
    public void setColumnName(String columnName) {
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
        return MockarooType.BitcoinAddress.toString();
    }
}
