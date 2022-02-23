package web.client;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ClientListRecordServlet extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        /*String userid = request.getParameter("userid");
        SysServiceImpl service = new SysServiceImpl();
        List<Record> orders = service.clientListOrder(userid);
        request.setAttribute("orders", orders);
        request.getRequestDispatcher("/client/clientlistorder.jsp").forward(request, response);*/
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        doGet(request, response);
    }

}
