package Day04.demo1;

/*
 * Created by zhoumeng on
 * 2017.8.7.
 * 上午 10:43.
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

public class CookieDemo1 extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();//获取字符输出流
		SimpleDateFormat ff =  new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		//SimpleDateFormat ff =  new SimpleDateFormat("yyyy年MM月dd日");

		//1.获取Cookie中保存的最后的访问时间,写回到浏览器中进行显示
		Cookie[] cookies = request.getCookies();//获得客户端所有的Cookie

		for (int  i = 0; cookies != null&&i < cookies.length;  i++) {
			if("lastAccessTime".equals(cookies[i].getName())){//判断当前Cookie的名称是否是最后保存的时间
				long lon = Long.parseLong(cookies[i].getValue());
				out.write("您的最后访问时间："+ ff.format(new Date(lon)));  //SimpleDateFormat
				//out.print();
			}
		}

		out.write("<a href='"+request.getContextPath()+"/servlet/clear'>clear</a>");

		//2.创建Cookie,保存当前访问日期，并把Cookie写回到客户端
		Cookie cookie = new Cookie("lastAccessTime", System.currentTimeMillis()+"");//value值不能存中文

		//关闭浏览器再次访问cookie就没了，默认cookie是保存在浏览器的缓存中
		//设置cookie的有效时间
		//cookie.setMaxAge(60*5);//单位是秒
		//设置cookie的path
//		cookie.setPath("/Day04_Cookie");
//		cookie.setPath(request.getContextPath());//  /Day04_Cookie
		cookie.setPath("/");//代表当前应用下  /Day04_Cookie

		//将Cookie写回到客户端
		response.addCookie(cookie);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}


}