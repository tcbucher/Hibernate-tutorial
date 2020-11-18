package com.timbucher.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;

public class TestJDBC
{
    public static void main(String[] args)
    {
        try
        {
            String jdbcUrl = "jdbc:mysql://localhost:3306/hb_student_tracker?useSSL=false";
            String user = "hbstudent";
            String pass = "hbstudent";

            System.out.println("Connecting to database: " + jdbcUrl);

            Connection conn = DriverManager.getConnection(jdbcUrl, user, pass);

            System.out.println("Connection successful!");
        }
        catch (Exception ex)
        {
            ex.printStackTrace();
        }
    }
}

