package com.codecool.web.service;

import com.codecool.web.dao.TaskDao;
import com.codecool.web.model.TaskResult;

import java.sql.SQLException;
import java.util.List;

public interface TaskService {

    List<TaskResult> getTaskResults() throws SQLException;

}
