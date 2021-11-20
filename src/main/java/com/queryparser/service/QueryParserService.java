package com.queryparser.service;

import com.queryparser.Model.QueryRequest;
import com.queryparser.Model.Response;
import com.queryparser.dao.QueryParserDao;
import com.queryparser.dao.QueryParserMongoDbDao;
import com.queryparser.dao.QueryParserRedshiftDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.sql.SQLSyntaxErrorException;

@Service
public class QueryParserService {

    @Autowired
    private QueryParserDao dao;

    @Autowired
    private QueryParserRedshiftDao redshiftDao;

    @Autowired
    private QueryParserMongoDbDao mongoDbDao;

    public Response executeSelectQuery(QueryRequest request) {
        if(request.getDatabase().equals("MySQL server")) {
            return dao.executeSelectQuery(request.getQuery());
        } else if(request.getDatabase().equals("MongoDB")){
            return mongoDbDao.executeSelectQuery(request.getQuery());
        } else {
            return redshiftDao.executeSelectQuery(request.getQuery());
        }
    }

    public Response executeDataManipulationQuery(QueryRequest request) {
        if(request.getDatabase().equals("MySQL server")) {
            return dao.executeDataManipulationQuery(request.getQuery());
        } else if(request.getDatabase().equals("MongoDB")){
            return mongoDbDao.executeDataManipulationQuery(request.getQuery());
        } else {
            return redshiftDao.executeDataManipulationQuery(request.getQuery());
        }
    }

    public Response executeDataDefinitionQuery(QueryRequest request) {
        if(request.getDatabase().equals("MySQL server")) {
            return dao.executeDataDefinitionQuery(request.getQuery());
        } else if(request.getDatabase().equals("MongoDB")){
            return mongoDbDao.executeDataDefinitionQuery(request.getQuery());
        } else {
            return redshiftDao.executeDataDefinitionQuery(request.getQuery());
        }
    }
}
