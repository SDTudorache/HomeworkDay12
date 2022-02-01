package com.endava.apache;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.*;

public class DbConnection {

    private static final Logger LOGGER = LogManager.getLogger(DbConnection.class);
    public static void main(String[] args) throws SQLException {

        Connection conn = DriverManager.getConnection("jdbc:mysql://bhdtest.endava.com:3306/petclinic","root","root");

        Statement statement = conn.createStatement();
        ResultSet resultSet = statement.executeQuery("SELECT first_name, id FROM owners");

        while (resultSet.next()){
        Object id = resultSet.getObject("id");
        Object firstName = resultSet.getObject("first_name");
        LOGGER.info("{}{}", id, firstName);
        }
        LOGGER.info(resultSet);

    }
}
