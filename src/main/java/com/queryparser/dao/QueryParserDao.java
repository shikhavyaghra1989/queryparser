package com.queryparser.dao;

import com.fasterxml.jackson.databind.jsonFormatVisitors.JsonArrayFormatVisitor;
import com.queryparser.Model.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;
import org.json.simple.*;

@Component
public class QueryParserDao {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public Response executeSelectQuery(String query) {
        List<Map<String, Object>> rows = null;
        String jsonStr = "";
        try {
            rows = jdbcTemplate.queryForList(query);
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
            rows = jdbcTemplate.update(query);
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
            jdbcTemplate.update(query);
        } catch (Exception e) {
            response = e.getCause().getMessage();
            return new Response(response, HttpStatus.UNPROCESSABLE_ENTITY);
        }
        response =  "Query has been executed successfully";
        return new Response(response, HttpStatus.OK);
    }
}
