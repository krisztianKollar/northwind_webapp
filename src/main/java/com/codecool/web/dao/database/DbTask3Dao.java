package com.codecool.web.dao.database;

import com.codecool.web.dao.TaskDao;
import com.codecool.web.model.TaskResult;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public final class DbTask3Dao extends AbstractDao implements TaskDao {

    public DbTask3Dao(Connection connection) {
        super(connection);
    }

    public List<TaskResult> findResults() throws SQLException {
        List<TaskResult> taskResults = new ArrayList<>();
        String sql = "select companyname as Company from suppliers " +
                "join products on suppliers.supplierid = products.supplierid " +
                "group by companyname " +
                "having count(companyname) = 5 " +
                "order by company ";
        try (Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(sql)) {
            while (resultSet.next()) {
                String companyName = resultSet.getString("Company");
                TaskResult taskResult = new TaskResult(companyName);
                taskResults.add(taskResult);
            }
        }
        return taskResults;
    }

    public List<TaskResult> findResults(String filter) throws SQLException {
        List<TaskResult> taskResults = new ArrayList<>();
        String sql = "select companyname as Company from suppliers " +
                "join products on suppliers.supplierid = products.supplierid " +
                "group by companyname " +
                "having count(companyname) = 5 " +
                "order by company ";
        try (Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(sql)) {
            while (resultSet.next()) {
                String companyName = resultSet.getString("Company");
                if (companyName.toLowerCase().contains(filter.toLowerCase())) {
                    TaskResult taskResult = new TaskResult(companyName);
                    taskResults.add(taskResult);
                }
            }
        }
        return taskResults;
    }
}
