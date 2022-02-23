package web.manager;

import domain.MultipleChoice;
import service.impl.SysServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class ExaminationServlet extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String method = request.getParameter("method");
        if("list".equals(method)){
            list(request, response);
        }

    }


    public void list(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        SysServiceImpl service = new SysServiceImpl();
        List<MultipleChoice> MultipleChoices = service.find();
        //System.out.println(MultipleChoices);
        //System.out.println("123456");
        request.setAttribute("questions", MultipleChoices);
//        MultipleChoices.forEach(System.out::println);
        request.getRequestDispatcher("/manager/examination.jsp").forward(request, response);


    }

    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        doGet(request, response);
    }

}
