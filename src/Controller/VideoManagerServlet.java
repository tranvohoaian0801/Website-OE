package Controller;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import org.apache.commons.beanutils.BeanUtils;

import DAO.UserDAO;
import DAO.VideoDAO;
import DAO.impl.UserDaoimpl;
import DAO.impl.VideoDaoimpl;
import Entity.User;
import Entity.Video;
import Service.VideoService;
import Service.impl.VideoServiceimpl;
import Untils.UploadUtils;

/**
 * Servlet implementation class VideoManagerServlet
 */
@MultipartConfig()
@WebServlet({"/VideoManagerServlet","/admin/videomanager/*","/VideoManagerServlet/insert",
	"/VideoManagerServlet/edit","/VideoManagerServlet/update","/VideoManagerServlet/delete","/VideoManagerServlet/reset"})
public class VideoManagerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	VideoDAO videodao = new VideoDaoimpl();
	VideoService vService = new VideoServiceimpl();
	Video video = new Video();
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		
		String uri = request.getRequestURI().toString();
		Video nd = null; 
		if(uri.contains("edit")) {
			edit(request, response);
			return;
		}else if(uri.contains("delete")) {
			delete(request, response);
			return;
		}else if(uri.contains("reset")) {
			findAll(request, response);
			request.getRequestDispatcher("/views/admin/videomanager.jsp").forward(request, response);
			return;
		}else if(uri.contains("insert")) {
			insert(request, response);
			return;
		} else if(uri.contains("update")) {
			update(request, response);
			return;
		}
		
		
		List<Video> list =videodao.findAll();
		
		request.setAttribute("items", list);
		request.getRequestDispatcher("views/admin/videomanager.jsp").forward(request, response);

	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		
		String uri = request.getRequestURI().toString();
	  	System.out.println(uri);
			Video nd = null; 
			if(uri.contains("edit")) {
				edit(request, response);
				return;
			}else if(uri.contains("delete")) {
				delete(request, response);
				return;
			}else if(uri.contains("reset")) {
				findAll(request, response);
				request.getRequestDispatcher("/views/admin/videomanager.jsp").forward(request, response);
				return;
			}else if(uri.contains("insert")) {
				System.out.println("insert");
				insert(request, response);
				return;
			}else if(uri.contains("update")) {
				System.out.println("updates");
				update(request, response);
				return;
			}
		
			findAll(request, response);
		
			request.getRequestDispatcher("/views/admin/videomanager.jsp").forward(request, response);

	}
	protected void insert(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			BeanUtils.populate(video, request.getParameterMap());
			video.setPoster("" + UploadUtils.processUploadField("poster", request, "/views/img", video.getPoster()));
			videodao.create(video);
			findAll(request, response);
			request.setAttribute("video", videodao.findAll());
			request.getRequestDispatcher("/views/admin/videomanager.jsp").forward(request, response);

		} catch (Exception e) {
			request.setAttribute("msg", "Tạo không thành công.");
			e.printStackTrace();
		}
	}
	
	protected void edit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {
			String entity = request.getParameter("id");
			Video videos = videodao.findID(entity);
			
		//	videodao.findID(entity);
			//video = videodao.findID(entity);
			System.out.println(videos.getId());
			request.setAttribute("currentVideo", videos);
			findAll(request, response);
			request.getRequestDispatcher("/views/admin/videomanager.jsp").forward(request, response);
		}catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("error","Lỗi");
		}
	}
	
	protected void findAll(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
				try {
			VideoDAO dao = new VideoDaoimpl();
			List<Video> list = vService.findAll();
			request.setAttribute("items", list);
		}catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("error", "Lỗi");
		}
	}
	
	protected void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			String id = request.getParameter("id");
			vService.delete(id);
			request.setAttribute("items", videodao.findAll());
			request.getRequestDispatcher("/views/admin/videomanager.jsp").forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("msg", "Xóa không thành công.");
		}
	}
	
	protected void update(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			Video videos = new Video();
			BeanUtils.populate(videos, request.getParameterMap());
			video.setPoster("" + UploadUtils.processUploadField("poster", request, "/views/img", video.getPoster()));
			videodao.update(videos);
			request.setAttribute("items", videodao.findAll());
			request.getRequestDispatcher("/views/admin/videomanager.jsp").forward(request, response);
		} catch (Exception e) {
			request.setAttribute("msg", "Cập nhập không thành công.");
			e.printStackTrace();
		}
	}
	
	
}
	


