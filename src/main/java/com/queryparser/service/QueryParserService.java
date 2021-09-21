package com.queryparser.service;

import com.queryparser.Model.Response;
import com.queryparser.dao.QueryParserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.sql.SQLSyntaxErrorException;

@Service
public class QueryParserService {

    @Autowired
    private QueryParserDao dao;

    public Response executeSelectQuery(String query) {
       return dao.executeSelectQuery(query);
    }

    public Response executeDataManipulationQuery(String query) {
        return dao.executeDataManipulationQuery(query);
    }

    public Response executeDataDefinitionQuery(String query) {
        return dao.executeDataDefinitionQuery(query);
    }
}
