package com.queryparser.Model;

public class QueryRequest {
    private String query = "";
    private String database = "";
    private String databaseType = "";

    public QueryRequest(String query, String database, String  databaseType) {
        this.query = query;
        this.database = database;
        this.databaseType = databaseType;
    }

    public String getQuery() {
        return query;
    }

    public String getDatabase() {
        return database;
    }

    public void setQuery(String query) {
        this.query = query;
    }

    public void setDatabase(String database) {
        this.database = database;
    }

    public String getDatabaseType() {
        return databaseType;
    }

    public void setDatabaseType(String databaseType) {
        this.databaseType = databaseType;
    }
}
