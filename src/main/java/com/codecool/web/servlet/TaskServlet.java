package com.codecool.web.servlet;

import com.codecool.web.dao.TaskDao;
import com.codecool.web.dao.database.DbTaskDao;
import com.codecool.web.model.TaskResult;
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
            List<TaskResult> taskResults = taskDao.findResults();
            req.getSession().setAttribute("taskResults", taskResults);
        } catch (SQLException ex) {
            throw new ServletException(ex);   // finally closing everything?!
        }
        req.getRequestDispatcher("task1.jsp").forward(req, resp);
    }


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        try (Connection connection = getConnection(req.getServletContext())) {
            String filter = req.getParameter("filter");
            TaskDao taskDao = new DbTaskDao(connection);
            List<TaskResult> taskResults = taskDao.findResults(filter);
            req.setAttribute("taskResults", taskResults);
        } catch (SQLException ex) {
            throw new ServletException(ex);
        }
        req.getRequestDispatcher("task1.jsp").forward(req, resp);
    }
}