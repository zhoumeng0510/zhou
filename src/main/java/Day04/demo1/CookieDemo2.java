package Day04.demo1;

/*
  Created by zhoumeng on
  2017.8.7.
  上午 10:43.
 */

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
/**
 * 取出在CookieDemo1中添加的Cookie数据，
 * 测试同一路径下可以访问
 *
 * /servlet/demo2    可以访问
 * /servlet/aa/demo2 可以访问
 * /aa/demo2         不能访问
 */
public class CookieDemo2 extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();

		SimpleDateFormat ff =  new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		Cookie[] cookies = request.getCookies();
		for (int i = 0; i < cookies.length; i++) {
			if("lastAccessTime".equals(cookies[i].getName())){
				long l = Long.parseLong(cookies[i].getValue());
				out.write("你的最后访问时间："+ff.format(new Date(l)));
			}
		}
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}


}
