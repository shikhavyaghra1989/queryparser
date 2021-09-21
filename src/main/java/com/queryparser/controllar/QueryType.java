package com.queryparser.controllar;

public enum QueryType {

    SELECT("select", "SELECT"),
    UPDATE("update", "UPDATE"),
    INSERT("insert", "INSERT"),
    DELETE("delete", "DELETE"),
    DROP("drop", "DROP"),
    ALTER("alter", "ALTER"),
    DESC("desc", "DESC"),
    CREATE("create", "CREATE");

    private final String key;
    private final String value;

    QueryType(String key, String value) {
        this.key = key;
        this.value = value;
    }

    public String getKey() {
        return key;
    }

    public String getValue() {
        return value;
    }
}
