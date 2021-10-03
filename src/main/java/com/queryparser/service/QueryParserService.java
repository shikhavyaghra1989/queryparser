package com.queryparser.service;

import com.queryparser.Model.QueryRequest;
import com.queryparser.Model.Response;
import com.queryparser.dao.QueryParserDao;
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

    public Response executeSelectQuery(QueryRequest request) {
        if(request.getDatabase().equals("MySQL server")) {
            return dao.executeSelectQuery(request.getQuery());
        } else {
            return redshiftDao.executeSelectQuery(request.getQuery());
        }

    }

    public Response executeDataManipulationQuery(QueryRequest request) {
        if(request.getDatabase().equals("MySQL server")) {
            return dao.executeDataManipulationQuery(request.getQuery());
        } else {
            return redshiftDao.executeDataManipulationQuery(request.getQuery());
        }
    }

    public Response executeDataDefinitionQuery(QueryRequest request) {
        if(request.getDatabase().equals("MySQL server")) {
            return dao.executeDataDefinitionQuery(request.getQuery());
        } else {
            return redshiftDao.executeDataDefinitionQuery(request.getQuery());
        }
    }
}
