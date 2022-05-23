package Controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;

import DAO.UserDAO;
import DAO.impl.UserDaoimpl;
import Entity.User;


@WebServlet({"/UserServlet","/admin/usersmanager/*"})
public class UserServlet extends HttpServlet {
	UserDAO userdao = new UserDaoimpl();
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		String uri = request.getRequestURI().toString();
		
		Entity.User nd = null; 
		if(uri.contains("edit")) {
			edit(request, response);
		}else if(uri.contains("delete")) {
			delete(request, response);
		}else if(uri.contains("reset")) {
			request.setAttribute("nguoi",nd);
		}else if(uri.contains("insert")) {
			insert(request, response);
		} else if(uri.contains("update")) {
			update(request, response);
		}
		
		
		List<User> list =userdao.findAll();
		
		request.setAttribute("items", list);
		request.getRequestDispatcher("/views/admin/usersmanager.jsp").forward(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
  	String uri = request.getRequestURI().toString();
  	System.out.println(uri);
		Entity.User nd = null; 
		if(uri.contains("edit")) {
			edit(request, response);
		}else if(uri.contains("delete")) {
			delete(request, response);
		}else if(uri.contains("reset")) {
			request.setAttribute("nguoi",nd);
		}else if(uri.contains("insert")) {
			System.out.println("insert");
			insert(request, response);
		}else if(uri.contains("update")) {
			System.out.println("updates");
			update(request, response);
		}
		findAll(request, response);
	
		request.getRequestDispatcher("/views/admin/usersmanager.jsp").forward(request, response);
	}
	
		
	protected void insert(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {
			Entity.User us = new Entity.User();
			us.setId(request.getParameter("id"));
			us.setPassword(request.getParameter("password"));
			us.setFullname(request.getParameter("fullname"));
			us.setEmail(request.getParameter("email"));
			//us.setAdmin(request.getParameter("admin"));
			UserDAO dao = new UserDaoimpl();
			dao.create(us);
			request.setAttribute("message", "Nhập thành công");
		}catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("error", "Lỗi");
		}
	}
	
	protected void edit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {
			String entity = request.getParameter("id");
			
			UserDAO dao = new UserDaoimpl();
			Entity.User us = dao.findbyID(entity);
			System.out.println(us.getId());
			request.setAttribute("nguoi", us);
			request.setAttribute("message", "Nhập thành công");
		}catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("error","Lỗi");
		}
	}
	
	protected void findAll(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
				try {
			UserDAO dao = new UserDaoimpl();
			List<Entity.User> list = dao.findAll();
			request.setAttribute("items", list);
		}catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("error", "Lỗi");
		}
	}
	
	protected void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			String entity = request.getParameter("id");
			User user = new User();
			UserDAO dao = new UserDaoimpl();
			user = dao.findbyID(entity);
			dao.delete(user);
			request.setAttribute("message", "Xóa thành công");
		}catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("error","Lỗi");
		}
	}
	
	protected void update(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {
			String entity = request.getParameter("id");
			User us = new User();
			UserDAO dao = new UserDaoimpl();
			us = dao.findbyID(entity);
			us.setPassword(request.getParameter("password"));
			us.setFullname(request.getParameter("fullname"));
			us.setEmail(request.getParameter("email"));
			dao.update(us);
			System.out.println(us.getId());
			request.setAttribute("message", "Nhập thành công");
		}catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("error", "Lỗi");
		}
	}

}
