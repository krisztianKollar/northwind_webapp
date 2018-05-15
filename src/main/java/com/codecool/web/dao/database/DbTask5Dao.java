package com.codecool.web.dao.database;

import com.codecool.web.dao.TaskDao;
import com.codecool.web.model.TaskResult;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public final class DbTask5Dao extends AbstractDao implements TaskDao {

    public DbTask5Dao(Connection connection) {
        super(connection);
    }

    public List<TaskResult> findResults() throws SQLException {
        List<TaskResult> taskResults = new ArrayList<>();
        String sql = "select s.companyname as Company, p.productname as Product, p.unitprice as Unitprice " +
                "from products as p " +
                "join suppliers as s " +
                "on s.supplierid = p.supplierid " +
                "left join products as pp " +
                "on p.supplierid = pp.supplierid " +
                "and p.unitprice > pp.unitprice " +
                "where pp.productid is null " +
                "order by p.supplierid, p.unitprice";
        try (Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(sql)) {
            while (resultSet.next()) {
                String companyName = resultSet.getString("Company");
                String productName = resultSet.getString("Product");
                float unitPrice = resultSet.getFloat("Unitprice");
                TaskResult taskResult = new TaskResult(companyName, productName, unitPrice);
                taskResults.add(taskResult);
            }
        }
        return taskResults;

    }

    public List<TaskResult> findResults(String filter) throws SQLException {
        List<TaskResult> taskResults = new ArrayList<>();
        String sql = "select s.companyname as Company, p.productname as Product, p.unitprice as Unitprice " +
                "from products as p " +
                "join suppliers as s " +
                "on s.supplierid = p.supplierid " +
                "left join products as pp " +
                "on p.supplierid = pp.supplierid " +
                "and p.unitprice > pp.unitprice " +
                "where pp.productid is null " +
                "order by p.supplierid, p.unitprice";
        try (Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(sql)) {
            while (resultSet.next()) {
                String companyName = resultSet.getString("Company");
                String productName = resultSet.getString("Product");
                float unitPrice = resultSet.getFloat("Unitprice");
                if (companyName.toLowerCase().contains(filter.toLowerCase())) {
                    TaskResult taskResult = new TaskResult(companyName, productName, unitPrice);
                    taskResults.add(taskResult);
                }
            }
        }
        return taskResults;
    }
}
