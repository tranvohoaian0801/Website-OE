package Controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Entity.Video;
import Service.VideoService;
import Service.impl.VideoServiceimpl;

/**
 * Servlet implementation class VideoServlet
 */
@WebServlet(urlPatterns="/video")
public class VideoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
	
	private VideoService videoService = new VideoServiceimpl();
    public VideoServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String actionParam = req.getParameter("action");
		String link = req.getParameter("id");
		HttpSession session = req.getSession();
		
		switch (actionParam) {
		case "watch":
			doGetWatch(session,link,req,resp);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	private void doGetWatch(HttpSession session , String link ,HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		Video video = videoService.findbyhref(link);
		List<Video> videoList = videoService.findAll();
		req.setAttribute("videolst",videoList);
		req.setAttribute("video", video);
		req.getRequestDispatcher("/views/details.jsp").forward(req, resp);
	}

}
