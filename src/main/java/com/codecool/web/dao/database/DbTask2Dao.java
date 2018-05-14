package com.codecool.web.dao.database;

import com.codecool.web.dao.TaskDao;
import com.codecool.web.model.TaskResult;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public final class DbTask2Dao extends AbstractDao implements TaskDao {

    public DbTask2Dao(Connection connection) {
        super(connection);
    }

    public List<TaskResult> findResults() throws SQLException {
        List<TaskResult> taskResults = new ArrayList<>();
        String sql = "select companyname as Company, count(companyname) as NumberOfProducts from suppliers " +
                "join products on suppliers.supplierid = products.supplierid " +
                "group by companyname " +
                "order by numberofproducts desc, company";
        try (Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(sql)) {
            while (resultSet.next()) {
                String companyName = resultSet.getString("Company");
                int numberOfProducts = resultSet.getInt("NumberOfProducts");
                TaskResult taskResult = new TaskResult(companyName, numberOfProducts);
                taskResults.add(taskResult);
            }
        }
        return taskResults;
    }
}
