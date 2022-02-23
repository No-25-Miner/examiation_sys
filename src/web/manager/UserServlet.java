package web.manager;

import dao.UserDao;
import dao.impl.UserDaoImpl;
import domain.User;
import service.impl.SysServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "UserServlet")
public class UserServlet extends HttpServlet {

    UserDao userDao = new UserDaoImpl();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String method = request.getParameter("method");
        if ("add".equals(method)) {
            add(request, response);
        }
    }

    private void add(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        try{
            String sno = request.getParameter("sno");
            String username = request.getParameter("username");
            String password = request.getParameter("password");

            SysServiceImpl service = new SysServiceImpl();
            //System.out.println(user.getSno());
            List<User> users = service.findUser();

            for(User x:users){
                if(x.getSno().equals(sno)){
                    request.setAttribute("message", "用户名重复");
                    request.getRequestDispatcher("/message.jsp").forward(request, response);
                }
            }

            User user = new User();
            user.setSno(sno);
            user.setUsername(username);
            user.setPassword(password);
            user.setNumber_of_times();
            userDao.add(user);
            request.setAttribute("message", "注册成功");
            request.getRequestDispatcher("/message.jsp").forward(request, response);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        doPost(request,response);

    }
}
