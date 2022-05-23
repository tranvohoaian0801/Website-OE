package Common;

import java.io.IOException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.collections.map.HashedMap;
public class PageInfo {
	public static Map<PageType, PageInfo> pageRoute = new HashedMap();
	
	static {
		pageRoute.put(PageType.USER_MANAGEMENT_PAGE, new PageInfo("User Management","/views/admin/usersmanager.jsp",null));
		pageRoute.put(PageType.REPORT_MANAGEMENT_PAGE, new PageInfo("Report","/views/admin/report.jsp",null));
		pageRoute.put(PageType.VIDEO_MANAGEMENT_PAGE, new PageInfo("Video Management","/views/admin/videomanager.jsp",null));
	}
	
	public static void prepareAndForward(HttpServletRequest request,HttpServletResponse response ,PageType pageType) throws ServletException, IOException {
		PageInfo page = pageRoute.get(pageType);
		
		request.setAttribute("page", page);
		request.getRequestDispatcher("/views/admin/videomanager.jsp").forward(request, response);
	}
	
	private String title;
	private String contenUrl;
	private String scriptUrl;
	
	
	public PageInfo(String title, String contenUrl, String scriptUrl) {
		super();
		this.title = title;
		this.contenUrl = contenUrl;
		this.scriptUrl = scriptUrl;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContenUrl() {
		return contenUrl;
	}
	public void setContenUrl(String contenUrl) {
		this.contenUrl = contenUrl;
	}
	public String getScriptUrl() {
		return scriptUrl;
	}
	public void setScriptUrl(String scriptUrl) {
		this.scriptUrl = scriptUrl;
	}
}
