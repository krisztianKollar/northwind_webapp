package com.codecool.web.dao.database;

import com.codecool.web.dao.TaskDao;
import com.codecool.web.model.TaskResult;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public final class DbTask4Dao extends AbstractDao implements TaskDao {

    public DbTask4Dao(Connection connection) {
        super(connection);
    }

    public List<TaskResult> findResults() throws SQLException {
        List<TaskResult> taskResults = new ArrayList<>();
        String sql = "SELECT companyname as Company, array_to_string(array_agg(orderid), ', ') as Order_IDs " +
                "FROM customers " +
                "left join orders on customers.customerid = orders.customerid " +
                "GROUP BY companyname " +
                "order by companyname";
        try (Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(sql)) {
            while (resultSet.next()) {
                String companyName = resultSet.getString("Company");
                Array orderIds = resultSet.getArray("Order_IDs");
                TaskResult taskResult = new TaskResult(companyName, orderIds);
                taskResults.add(taskResult);
            }
        }
        return taskResults;

    }

    public List<TaskResult> findResults(String filter) throws SQLException {
        List<TaskResult> taskResults = new ArrayList<>();
        String sql = "SELECT companyname as Company, array_to_string(array_agg(orderid), ', ') as Order_IDs " +
                "FROM customers " +
                "left join orders on customers.customerid = orders.customerid " +
                "GROUP BY companyname " +
                "order by companyname";
        try (Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(sql)) {
            while (resultSet.next()) {
                String companyName = resultSet.getString("Company");
                Array orderIds = resultSet.getArray("Order_IDs");
                if (companyName.toLowerCase().contains(filter.toLowerCase())) {
                    TaskResult taskResult = new TaskResult(companyName, orderIds);
                    taskResults.add(taskResult);
                }
            }
        }
        return taskResults;
    }
}
