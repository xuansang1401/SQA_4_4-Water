/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import dao.UsersDAO;

import entity.Users;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Nal
 */
@WebServlet(name = "HomeControl", urlPatterns = {"/home"})
public class UserControl extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
         response.setContentType("text/html;charset=UTF-8");
        //get data from dao
        UsersDAO dao = new UsersDAO();
        List<Users> list = dao.getAllUser();
        for (Users o : list) {
            System.out.println(o);
        }
        HttpSession session = request.getSession();
        session.setAttribute("DSExcel", list);
        //set data to jsp
        request.setAttribute("listP", list);
        request.getRequestDispatcher("Home.jsp").forward(request, response);
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
            request.setCharacterEncoding("UTF-8");
		UsersDAO dao = new UsersDAO();
                HttpSession session = request.getSession();
                List<Users> lstDS = (List<Users>) session.getAttribute("DSExcel");
		request.setAttribute("lstUser", lstDS);
		RequestDispatcher rd = request.getRequestDispatcher("Excelreport.jsp");
		rd.forward(request, response);
	}
}
