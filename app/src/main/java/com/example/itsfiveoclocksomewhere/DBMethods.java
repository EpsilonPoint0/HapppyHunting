package com.example.itsfiveoclocksomewhere;

import java.sql.*;
import java.util.ArrayList;


public class DBMethods {

    /**
     * Connects to the database if it exists, creates it if it does not, and returns the connection object.
     *
     * @param databaseFileName the database file name
     * @return a connection object to the designated database
     */
    public static Connection initializeDB(String databaseFileName) {
        /**
         * The "Connection String" or "Connection URL".
         *
         * "jdbc:sqlite:" is the "subprotocol".
         * (If this were a SQL Server database it would be "jdbc:sqlserver:".)
         */
        String url = "jdbc:sqlite:" + databaseFileName;
        Connection conn = null; // If you create this variable inside the Try block it will be out of scope

        //TODO: update display messages
        try {
            conn = DriverManager.getConnection(url);
            if (conn != null) {
                // Provides some positive assurance the connection and/or creation was successful.
                System.out.println("The connection to the database was successful. Beginning program:");
            } else {
                // Provides some feedback in case the connection failed but did not throw an exception.
                System.out.println("Null Connection");
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            System.out.println("There was a problem connecting to the database.");
            System.exit(1);
        }
        return conn;
    }

    /**
     * @author Leon Madrid
     *
     * Queries the database and prints the results.
     *
     * @param conn 			a connection object
     * @param sql 			a SQL statement that returns rows
     * @param ifnone		helper for message if nothing is found
     *
     * This query is written with the Statement class, typically
     * used for static SQL SELECT statements
     */
    public static void sqlGet(Connection conn, String sql, String ifNone){
        try {
            PreparedStatement stmt = conn.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            ResultSetMetaData rsmd = rs.getMetaData();
            int columnCount = rsmd.getColumnCount();

            //information to print in formatted table
            ArrayList<String> columnNames = new ArrayList<String>(); //column names
            ArrayList<String> data = new ArrayList<String>(); //data in columns


            if (rs.isBeforeFirst()) {
                for (int i = 1; i <= columnCount; i++) {
                    String value = rsmd.getColumnName(i);
                    data.add(value); //adding column names
                }
                while (rs.next()) {
                    for (int i = 1; i <= columnCount; i++) {
                        String columnValue = rs.getString(i);
                        data.add(columnValue); //getting data
                    }
                }

                //if nothing was found in the query, prints message
                //TODO change message stuff
            } else {
                System.out.println("Sorry, no " + ifNone + " found.");
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * Inserts or updates database information
     *
     * @param conn		connection to database
     * @param sql		sql statement to execute
     */
    public static void sqlSet(Connection conn, String sql) {
        try {
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.execute();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

}