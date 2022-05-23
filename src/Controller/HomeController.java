package Controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.metamodel.SetAttribute;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Entity.Favorite;
import Entity.User;
import Entity.Video;
import Service.FavoriteService;
import Service.VideoService;
import Service.impl.FavoriteServiceimpl;
import Service.impl.VideoServiceimpl;
import constrant.SessionAttr;


@WebServlet({"/favorites"})
public class HomeController extends HttpServlet{
	
	private static final long serialVersionUID = -2643165434104921001L;
	private static final int VIDEO_MAX_PAGE_SIZE = 3;
	private VideoService videoService = new VideoServiceimpl();
	private FavoriteService favoriteService = new FavoriteServiceimpl();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		String path = req.getServletPath();
		switch (path) {
		case "/favorites":
			doGetFavorites(session, req, resp);
			System.out.println("favorites");
			break;
			
		}
	}	
	private void doGetFavorites(HttpSession session, HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
		User user = (User) session.getAttribute(SessionAttr.CurrentUser);
		List<Favorite> favorite = favoriteService.findbyUserAndlike(user.getId());
		List<Video> video = new ArrayList<>();
		favorite.forEach(item -> video.add(item.getVideo()));
		
		List<Video> videos = videoService.findAll();
		req.setAttribute("videos", videos);
		req.getRequestDispatcher("/views/share.jsp").forward(req, resp);	
	}
}
 