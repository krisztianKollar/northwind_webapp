package com.codecool.web.servlet;

import com.codecool.web.dao.TaskDao;
import com.codecool.web.dao.database.DbTaskDao;
import com.codecool.web.model.TaskResult;
import com.codecool.web.service.SimpleTaskService;
import com.codecool.web.service.TaskService;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

@WebServlet("/task1")
public final class TaskServlet extends AbstractServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        try (Connection connection = getConnection(req.getServletContext())) {
            TaskDao taskDao = new DbTaskDao(connection);
            TaskService taskService = new SimpleTaskService(taskDao);
            List<TaskResult> taskResults = taskService.getTaskResults();

            String info = String.format("Coupon %s with id has been created", taskResults.size());
            req.setAttribute("info", info);
            req.setAttribute("taskResults", taskResults);
        } catch (SQLException ex) {
            throw new ServletException(ex);
        }
        req.getRequestDispatcher("task1.jsp").forward(req, resp);
    }
}