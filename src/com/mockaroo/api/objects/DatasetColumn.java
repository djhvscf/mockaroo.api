package com.mockaroo.api.objects;

import com.mockaroo.api.enums.MockarooType;
import com.mockaroo.api.exceptions.MockarooExceptionArray;
import com.mockaroo.api.exceptions.MockarooExceptionName;
import com.mockaroo.api.interfaces.IMockarooObject;
import org.json.*;

/**
 * Created by Dennis on 14/06/2015.
 */
public class DatasetColumn implements IMockarooObject {

    private static DatasetColumn instance = null;
    private String columnName;
    private String datasetName;
    private String selectionType;

    /**
     * Constructor
     * @param columnName Column name
     * @param datasetName The name of a saved dataset
     */
    private DatasetColumn(String columnName, String datasetName) {
        this(columnName, datasetName, "random");
    }

    /**
     * Constructor
     * @param columnName Column name
     */
    private DatasetColumn(String columnName, String datasetName, String selectionType) {
        this.setColumnName(columnName);
        this.setDatasetName(datasetName);
        this.setSelectionType(selectionType);
    }

    /**
     * Get the {@link DatasetColumn} object
     * @param columnName Column name
     * @param datasetName The name of a saved dataset
     * @return {@link DatasetColumn} object
     * @throws MockarooExceptionName
     * @throws MockarooExceptionArray
     */
    public static DatasetColumn getInstance(String columnName, String datasetName)
            throws MockarooExceptionName, MockarooExceptionArray
    {
        VALIDATOR.validateColumnName(columnName, messageExceptionName);

        if (instance == null) {
            instance = new DatasetColumn(columnName, datasetName);
        }

        return instance;
    }

    /**
     * Get the {@link DatasetColumn} object
     * @param columnName Column name
     * @param datasetName The name of a saved dataset
     * @return {@link DatasetColumn} object
     * @throws MockarooExceptionName
     * @throws MockarooExceptionArray
     */
    public static DatasetColumn getInstance(String columnName, String datasetName, String selectionType)
            throws MockarooExceptionName, MockarooExceptionArray
    {
        VALIDATOR.validateColumnName(columnName, messageExceptionName);

        if (instance == null) {
            instance = new DatasetColumn(columnName, datasetName, selectionType);
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

    /**
     * Get the datasetName
     * @return the datasetName
     */
    private String getDatasetName() {
        return datasetName;
    }

    /**
     * Set the values
     * @param datasetName the datasetName to set
     */
    private void setDatasetName(String datasetName) {
        this.datasetName = datasetName;
    }

    /**
     * Set the selectionType
     * @param selectionType the selectionType to set
     */
    private void setSelectionType(String selectionType) { this.selectionType = selectionType; }

    /**
     * Get the selectionType
     * @return the selectionType
     */
    private String getSelectionType() { return selectionType; }

    /* (non-Javadoc)
     * @see com.mockaroo.api.dataTypes.IMockarooObject#getJSONObject()
     */
    @Override
    public JSONObject getJSONObject() {

        JSONObject jsonObject = new JSONObject();
        jsonObject.put(NAME, this.getColumnName());
        jsonObject.put(TYPE, this.getType());
        jsonObject.put(SELECTIONSTYLE, this.getSelectionType());
        jsonObject.put(DATASET, this.getDatasetName());

        return jsonObject;
    }

    /* (non-Javadoc)
     * @see com.mockaroo.api.dataTypes.IMockarooObject#geyType()
     */
    @Override
    public String getType() {
        return MockarooType.Dataset_Column.toString().replace(UNDERSCORE, SPACE);
    }
}
