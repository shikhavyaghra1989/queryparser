package com.queryparser.Model;

public class QueryRequest {
    private String query = "";
    private String database = "";

    public QueryRequest(String query, String database) {
        this.query = query;
        this.database = database;
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
}
