package com.queryparser.dao;

import com.queryparser.Model.Response;
import org.apache.camel.CamelContext;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.impl.DefaultCamelContext;
import org.apache.camel.support.SimpleRegistry;
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
    private JdbcTemplate mongoDbDataSource;

    public Response executeSelectQuery(String query) throws Exception {
        SimpleRegistry reg = new SimpleRegistry();
        reg.bind("myDataSource", mongoDbDataSource);

        CamelContext context = new DefaultCamelContext(reg);
        String jsonStr = "";
        context.addRoutes(new RouteBuilder() {
            @Override
            public void configure() {
                from("timer://foo?repeatCount=1")
                        .setBody(constant("SELECT * FROM TABLE"))
                        .to("jdbc:myDataSource")
                        .marshal().json(true).to(jsonStr);
            }
        });

        context.start();
        Thread.sleep(10000);
        context.stop();
        return new Response(jsonStr, HttpStatus.OK);
    }
}
