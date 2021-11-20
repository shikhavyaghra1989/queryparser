package com.queryparser.dao;

import com.queryparser.Model.Response;
import org.json.simple.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public class QueryParserMongoDbDao {
    @Autowired
    private JdbcTemplate jdbcTemplateMongoDb;

    public Response executeSelectQuery(String query) {
        List<Map<String, Object>> rows = null;
        String jsonStr = "";
        try {
            rows = jdbcTemplateMongoDb.queryForList(query);
        } catch (Exception e) {
            jsonStr = e.getCause().getMessage();
            return new Response(jsonStr, HttpStatus.UNPROCESSABLE_ENTITY);
        }
        jsonStr = JSONArray.toJSONString(rows);
        return new Response(jsonStr, HttpStatus.OK);
    }

    public Response executeDataManipulationQuery(String query) {
        int rows = 0;
        String response = "";
        try {
            rows = jdbcTemplateMongoDb.update(query);
        } catch (Exception e) {
             response = e.getCause().getMessage();
            return new Response(response, HttpStatus.UNPROCESSABLE_ENTITY);
        }
        response = rows + "rows affected";
        return new Response(response, HttpStatus.OK);
    }

    public Response executeDataDefinitionQuery(String query) {
        String response = "";
        try {
            jdbcTemplateMongoDb.update(query);
        } catch (Exception e) {
            response = e.getCause().getMessage();
            return new Response(response, HttpStatus.UNPROCESSABLE_ENTITY);
        }
        response =  "Query has been executed successfully";
        return new Response(response, HttpStatus.OK);
    }
}
