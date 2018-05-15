package com.codecool.web.servlet;

import com.codecool.web.dao.TaskDao;
import com.codecool.web.dao.database.DbTask3Dao;
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

@WebServlet("/task3")
public final class Task3Servlet extends AbstractServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        try (Connection connection = getConnection(req.getServletContext())) {
            TaskDao taskDao = new DbTask3Dao(connection);
            TaskService taskService = new SimpleTaskService(taskDao);
            List<TaskResult> taskResults = taskService.getTaskResults();

            req.setAttribute("taskResults", taskResults);
        } catch (SQLException ex) {
            throw new ServletException(ex);
        }
        req.getRequestDispatcher("task3.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        try (Connection connection = getConnection(req.getServletContext())) {
            String filter = req.getParameter("filter");
            TaskDao taskDao = new DbTask3Dao(connection);
            List<TaskResult> taskResults = taskDao.findResults(filter);
            req.setAttribute("taskResults", taskResults);
        } catch (SQLException ex) {
            throw new ServletException(ex);
        }
        req.getRequestDispatcher("task3.jsp").forward(req, resp);
    }
}