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
public class ClearServlet extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //创建一个Cookie对象
        Cookie cookie = new Cookie("lastAccessTime", "");
        cookie.setPath("/");//要删除的cookie的path,否则可能会删除对象
        cookie.setMaxAge(0);//相当于删除
        response.addCookie(cookie);//写回到客户端
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        doGet(request, response);
    }


}
