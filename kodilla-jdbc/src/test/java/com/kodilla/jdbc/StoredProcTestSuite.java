package com.kodilla.jdbc;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import static org.junit.jupiter.api.Assertions.*;

public class StoredProcTestSuite {

    private DbManager dbManager;
    private Connection con;

    @BeforeEach
    void setup() throws SQLException {
        //Given
        dbManager = DbManager.getInstance();
        con = dbManager.getConnection();

        try (Statement statement = con.createStatement()) {
            statement.executeUpdate("UPDATE READERS SET VIP_LEVEL= 'Not set'");
            statement.executeUpdate("UPDATE BOOKS SET BESTSELLER = 0");
        }
    }

    @Test
    void testUpdateVipLevels() throws SQLException {
        try (Statement statement = con.createStatement()) {
            //When
            statement.execute("CALL UpdateVipLevels()");

            //Then
            String sql = "SELECT COUNT(*) AS HOW_MANY FROM READERS WHERE VIP_LEVEL = 'Not set'";

            try (ResultSet resultSet = statement.executeQuery(sql)) {
                resultSet.next();
                assertEquals(0, resultSet.getInt("HOW_MANY"));
                }
            }
        }

    @Test
    void testUpdateBestSellers() throws SQLException {
        try (Statement statement = con.createStatement()) {
            //When
            statement.execute("CALL UpdateBestSellers()");

            //Then
            String sql = "SELECT COUNT(*) AS HOW_MANY FROM BOOKS WHERE BESTSELLER = 1";

            try (ResultSet resultSet = statement.executeQuery(sql)) {
                resultSet.next();
                assertTrue(resultSet.getInt("HOW_MANY") > 0);
            }
        }
    }
}