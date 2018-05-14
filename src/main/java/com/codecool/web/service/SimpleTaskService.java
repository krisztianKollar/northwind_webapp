package com.codecool.web.service;

import com.codecool.web.dao.TaskDao;
import com.codecool.web.model.TaskResult;

import java.sql.SQLException;
import java.util.List;

public class SimpleTaskService implements TaskService {

    private final TaskDao taskDao;

    public SimpleTaskService(TaskDao taskDao) {
        this.taskDao = taskDao;
    }

    @Override
    public List<TaskResult> getTaskResults() throws SQLException {
        return taskDao.findResults();
    }
}
