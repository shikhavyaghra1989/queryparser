package com.queryparser.service;

import com.queryparser.Model.QueryRequest;
import com.queryparser.Model.Response;
import com.queryparser.dao.QueryParserAdnimergeDao;
import com.queryparser.dao.QueryParserDao;
//import com.queryparser.dao.QueryParserMongoDbDao;
import com.queryparser.dao.QueryParserRedshiftDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class QueryParserService {

    @Autowired
    private QueryParserDao dao;

    @Autowired
    private QueryParserRedshiftDao redshiftDao;

    @Autowired
    private QueryParserAdnimergeDao mysqlAdniDao;

//    @Autowired
//    private QueryParseAdnimergerRedshiftDao redshiftAdnimergeDao;

//    @Autowired
//    private QueryParserMongoDbDao mongoDbDao;

    public Response executeSelectQuery(QueryRequest request) throws Exception {
        if(request.getDatabaseType().equalsIgnoreCase("MySQL server") && request.getDatabase().equalsIgnoreCase("instacart")) {
            return dao.executeSelectQuery(request.getQuery());
        } else if(request.getDatabaseType().equalsIgnoreCase("MySQL server") && request.getDatabase().equalsIgnoreCase("Adnimerge")){
            return mysqlAdniDao.executeSelectQuery(request.getQuery());
        }
//         else if (request.getDatabase().equals("MongoDB")){*/
//        else{
//            return mongoDbDao.executeSelectQuery(request.getQuery());
//        }
        else {
            return redshiftDao.executeSelectQuery(request.getQuery());
        }
    }

    public Response executeDataManipulationQuery(QueryRequest request) {
        if(request.getDatabaseType().equalsIgnoreCase("MySQL server") && request.getDatabaseType().equalsIgnoreCase("instacart")) {
            return dao.executeDataManipulationQuery(request.getQuery());
        } else if(request.getDatabaseType().equalsIgnoreCase("MySQL server") && request.getDatabaseType().equalsIgnoreCase("Adnimerge")){
            return mysqlAdniDao.executeDataManipulationQuery(request.getQuery());
        }
//         else if (request.getDatabase().equals("MongoDB")){*/
//        else{
//            return mongoDbDao.executeSelectQuery(request.getQuery());
//        }
        else {
            return redshiftDao.executeDataManipulationQuery(request.getQuery());
        }
    }

    public Response executeDataDefinitionQuery(QueryRequest request) {
        if(request.getDatabaseType().equalsIgnoreCase("MySQL server") && request.getDatabaseType().equalsIgnoreCase("instacart")) {
            return dao.executeDataDefinitionQuery(request.getQuery());
        } else if(request.getDatabaseType().equalsIgnoreCase("MySQL server") && request.getDatabaseType().equalsIgnoreCase("Adnimerge")){
            return mysqlAdniDao.executeDataDefinitionQuery(request.getQuery());
        }
//         else if (request.getDatabase().equals("MongoDB")){*/
//        else{
//            return mongoDbDao.executeSelectQuery(request.getQuery());
//        }
        else {
            return redshiftDao.executeDataDefinitionQuery(request.getQuery());
        }
    }
}
