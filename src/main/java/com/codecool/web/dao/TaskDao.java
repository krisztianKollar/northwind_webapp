package com.codecool.web.dao;

import com.codecool.web.model.TaskResult;

import java.sql.SQLException;
import java.util.List;

public interface TaskDao {

    public List<TaskResult> findResults() throws SQLException;
    public List<TaskResult> findResults(String filter) throws SQLException;
}
