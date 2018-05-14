package com.codecool.web.dao.database;

import com.codecool.web.dao.TaskDao;
import com.codecool.web.model.TaskResult;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public final class DbTaskDao extends AbstractDao implements TaskDao {

    public DbTaskDao(Connection connection) {
        super(connection);
    }

    public List<TaskResult> findResults() throws SQLException {
        List<TaskResult> taskResults = new ArrayList<>();
        String sql = "select p.productname as product, s.companyname as company from products as p " +
                "join suppliers as s on s.supplierid = p.supplierid " +
                "order by product, company";
        try (Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(sql)) {
            while (resultSet.next()) {
                taskResults.add(fetchTaskResult(resultSet));
            }
        }
        System.out.println(taskResults.size());
        return taskResults;
    }

    private TaskResult fetchTaskResult(ResultSet resultSet) throws SQLException {
        String companyName = resultSet.getString("product");
        String productName = resultSet.getString("company");
        return new TaskResult(companyName, productName);
    }

}
