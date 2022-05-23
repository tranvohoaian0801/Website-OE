	package Controller;

	import java.io.IOException;
	import java.util.List;

	import javax.servlet.ServletException;
	import javax.servlet.annotation.WebServlet;
	import javax.servlet.http.HttpServlet;
	import javax.servlet.http.HttpServletRequest;
	import javax.servlet.http.HttpServletResponse;
	import javax.servlet.http.HttpSession;

	import Entity.User;
	import Entity.Video;
	import Service.EmailService;
	import Service.UserService;
	import Service.VideoService;
	import Service.impl.EmailServiceImpl;
	import Service.impl.UserServiceimpl;
	import Service.impl.VideoServiceimpl;
	import constrant.SessionAttr;

	@WebServlet({"/login","/logout","/registration","/forgotPass","/changePass"})
	public class UserController extends HttpServlet{
		
		private static final long serialVersionUID = -5565497574896653698L;
		
		private UserService userService = new UserServiceimpl();
		private EmailService emailService = new EmailServiceImpl();
		private VideoService videoService = new VideoServiceimpl();
		
		@Override
		protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			HttpSession session = req.getSession();
			String path = req.getServletPath();
			switch (path) {
			case "/login":
				doGetLogin(req, resp);
				break;
			case "/logout":
				doGetLogout(session, req, resp);
				break;
			case "/registration":
				doGetRegister(req, resp);
				break;	
			case "/forgotPass":
				doGetForgotPass(req, resp);
				break;
			case "/changePass":
				doGetChangePass(req,resp);
			}		
		}

		private void doGetChangePass(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			// TODO Auto-generated method stub
			req.getRequestDispatcher("/views/changepass.jsp").forward(req, resp);
		}

		private void doGetRegister(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
			req.getRequestDispatcher("/views/registration.jsp").forward(req, resp);
		} 	

		@Override
		protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			HttpSession session = req.getSession();
			String path = req.getServletPath();
			switch (path) {
			case "/login":
				doPostLogin(session,req, resp);
				break;
			case "/registration":
				doPostRegister(session, req, resp);
				System.out.println("day");
				break;
			case "/forgotPass":
				doPostForgotPass(req, resp);
				System.out.println("gui mail");
				break;
			case "/changePass":
				doPostChangePass(session, req, resp);
				break;
			}
		}

		private void doPostRegister(HttpSession session, HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
			String username = req.getParameter("id");
			String password = req.getParameter("password");
			String email = req.getParameter("email");
			String fullname=req.getParameter("fullname");
			User user = userService.register(username, password, email,fullname);
			
			if(user != null) {
				emailService.sendEmail(getServletContext(), user, "welcome");
				session.setAttribute(SessionAttr.CurrentUser, user);
				req.getRequestDispatcher("/views/index.jsp").forward(req, resp);
			}else {
				req.getRequestDispatcher("/views/registration.jsp").forward(req, resp);
			}
			
		}

		private void doPostLogin(HttpSession session, HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
			String username = req.getParameter("id");
			String password = req.getParameter("password");
			
			User user = userService.login(username, password);
			
			if(user != null) {
				System.out.println("error");
				if(user.isAdmin()==true) {
					resp.sendRedirect("VideoManagerServlet");
				}
				else {
				session.setAttribute(SessionAttr.CurrentUser, user);
				resp.sendRedirect("index");
				}
			}else {
				
				System.out.println("that bai");
				req.setAttribute("error", "Tài khoản không chính xác!");
				req.getRequestDispatcher("/views/login.jsp").forward(req, resp);
			}
		}

		private void doGetLogout(HttpSession session, HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
			session.removeAttribute(SessionAttr.CurrentUser);
			req.getRequestDispatcher("/views/login.jsp").forward(req, resp);
		}

		private void doGetLogin(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
			req.getRequestDispatcher("/views/login.jsp").forward(req, resp);
			
		}
		
		private void doGetForgotPass(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
			req.getRequestDispatcher("/views/forgotpass.jsp").forward(req, resp);
		}
		
		private void doPostForgotPass(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
			resp.setContentType("application/json");
			String email = req.getParameter("email");
			User userWithNewPass = userService.resetPassword(email);
			System.out.println("thanhcp");
			if(userWithNewPass != null) {
				emailService.sendEmail(getServletContext(), userWithNewPass, "forgot");
				resp.setStatus(204);
				System.out.println("thanhcp");
			}else {
				resp.setStatus(400);
				
			}
		}
		
		private void doPostChangePass(HttpSession session, HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
			String id =req.getParameter("id");
			String currentPass = req.getParameter("currentPass");
			String newPass = req.getParameter("newPass");
			String nhaplaipass=req.getParameter("nhaplai");
			
			User user = userService.login(id, currentPass);
			
			if(user != null) {
				if(newPass.equalsIgnoreCase(nhaplaipass)) {
					user.setPassword(newPass);
					userService.update(user);
					req.setAttribute("error","Đổi mk thành công");
					req.getRequestDispatcher("/views/login.jsp").forward(req, resp);
				}
				else {
					req.setAttribute("error","Mật khẩu không trùng khớp");
					req.getRequestDispatcher("/views/changepass.jsp").forward(req, resp);
				}
			}else {
				req.getRequestDispatcher("/views/login.jsp").forward(req, resp);
			}	
		}
	}

