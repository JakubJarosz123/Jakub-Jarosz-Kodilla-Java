package com.kodilla.jdbc;

import org.junit.jupiter.api.Test;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import static org.junit.jupiter.api.Assertions.*;

public class StoredProcTestSuite {

    @Test
    void testUpdateVipLevels() throws SQLException {
        //Given
        DbManager dbManager = DbManager.getInstance();
        String sqlUpdate = "UPDATE READERS SET VIP_LEVEL=\"Not set\"";
        Statement statement = dbManager.getConnection().createStatement();
        statement.executeUpdate(sqlUpdate);
        String sqlCheckTable = "SELECT COUNT(*) AS HOW_MANY FROM READERS WHERE VIP_LEVEL=\"Not set\"";

        //When
        Statement statement2 = dbManager.getConnection().createStatement();
        String sqlProcedureCall = "CALL UpdateVipLevels()";
        statement2.execute(sqlProcedureCall);
        ResultSet resultSet = statement.executeQuery(sqlCheckTable);

        //Then
        int howMany = -1;
        if (resultSet.next()) {
            howMany = resultSet.getInt("HOW_MANY");
        }
        assertEquals(0, howMany);
        resultSet.close();
        statement.close();
        statement2.close();
    }

    @Test
    void testUpdateBestSellers() throws SQLException {
        //Given
        DbManager dbManager = DbManager.getInstance();
        String sqlUpdate = "UPDATE BOOKS SET BESTSELLER = 0";
        Statement statement = dbManager.getConnection().createStatement();
        statement.executeUpdate(sqlUpdate);
        String checkTable = "SELECT COUNT(*) AS HOW_MANY FROM BOOKS WHERE BESTSELLER = 1";
        //When
        Statement statement2 = dbManager.getConnection().createStatement();
        String sqlProcedureCall = "CALL UpdateBestSellers()";
        statement2.execute(sqlProcedureCall);
        ResultSet rs = statement.executeQuery(checkTable);
        //Then
        int howMany = 0;
        if (rs.next()) {
            howMany = rs.getInt("HOW_MANY");
        }
        assertTrue(howMany > 0);
        rs.close();
        statement.close();
        statement2.close();
    }
}