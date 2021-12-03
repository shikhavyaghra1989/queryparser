//package com.queryparser.dao;
//
//import com.queryparser.Model.Response;
//import org.apache.camel.CamelContext;
//import org.apache.camel.Exchange;
//import org.apache.camel.Processor;
//import org.apache.camel.builder.RouteBuilder;
//import org.apache.camel.impl.DefaultCamelContext;
//import org.apache.camel.support.SimpleRegistry;
//import org.json.simple.JSONArray;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//
//import org.springframework.jdbc.core.JdbcTemplate;
//import org.springframework.stereotype.Repository;
//
//import javax.sql.DataSource;
//import javax.xml.crypto.Data;
//import java.util.List;
//import java.util.Map;
//
//@Repository
//public class QueryParserMongoDbDao {
//    @Autowired
//    private DataSource jdbcTemplateMongoDb;
//
//    public Response executeSelectQuery(String query) throws Exception {
//        SimpleRegistry reg = new SimpleRegistry();
//        reg.bind("jdbcTemplateMongoDb", jdbcTemplateMongoDb);
//
//        CamelContext context = new DefaultCamelContext(reg);
//        String jsonStr = "";
//
//        context.addRoutes(new RouteBuilder() {
//            @Override
//            public void configure() {
//                from("timer://query_parser?repeatCount=1")
//                        .setBody(constant(query))
//                        .to("jdbc:jdbcTemplateMongoDb")
//                        .split(simple("${body}"))
//                        .process(new Processor() {
//                            public void process(Exchange exchange) throws Exception {
//                                Map customer = exchange.getIn().getBody(Map.class);
//                                System.out.println("Process customer " + customer);
//                            }
//                        });
//            }
//        });
//
//        context.start();
//        Thread.sleep(10000);
//        context.stop();
//        return new Response(jsonStr, HttpStatus.OK);
//    }
//}
