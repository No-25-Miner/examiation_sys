package web.client;

import domain.User;
import service.impl.SysServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class LoginServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        doPost(request,response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String sno = request.getParameter("sno");
        String password = request.getParameter("password");
        SysServiceImpl service = new SysServiceImpl();
        User user = service.userLogin(sno, password);
        if(user == null){
            request.setAttribute("message", "用户名或密码错误");
            request.getRequestDispatcher("/message.jsp").forward(request, response);
            return;
        }
        request.getSession().setAttribute("user", user);
        request.getRequestDispatcher("/client/body.jsp").forward(request, response);
        doPost(request, response);
    }
}
