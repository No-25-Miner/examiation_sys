package web.manager;

import domain.MultipleChoice;
import domain.Record;
import domain.User;
import service.impl.SysServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public class RecordServlet extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String method = request.getParameter("method");
        //System.out.println(method);
        if("list".equals(method)){
            list(request,response);
        }
        if("find".equals(method)) {
            String user_number = request.getParameter("user_number");
            int a = Integer.parseInt(user_number);
            find(request,response,a);
        }
        if("delete".equals(method)) {
            String user_number = request.getParameter("user_number");
            int a = Integer.parseInt(user_number);
            try {
                delete(request,response,a);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        //doGet(request,response);
    }

    public void delete(HttpServletRequest request, HttpServletResponse response,int user_number) throws ServletException, IOException, SQLException {
        HttpSession session = request.getSession();
        User user = (User)session.getAttribute("user");
        String sno = user.getSno();
        SysServiceImpl service = new SysServiceImpl();
        service.delete(sno,user_number);
        int time = service.findTime(sno);
        service.updateUser(sno,time-1);
        list(request,response);

    }
    public void list(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        HttpSession session = request.getSession();
        User user = (User)session.getAttribute("user");
        SysServiceImpl service = new SysServiceImpl();
        List<Record> records = service.find(user.getSno());

        /*for(Record x: records){
            System.out.println(x.getUser_number());
        }*/
        request.setAttribute("records", records);
        request.getRequestDispatcher("/client/listrecord.jsp").forward(request, response);
    }

    public void find(HttpServletRequest request, HttpServletResponse response,int user_number) throws ServletException, IOException{
        HttpSession session = request.getSession();
        User user = (User)session.getAttribute("user");
        SysServiceImpl service = new SysServiceImpl();
        //System.out.println(user.getSno());
        List<MultipleChoice> MultipleChoices = service.find();
        Record record = service.find(user.getSno(),user_number);

        String ans[] = {record.getAns1(),record.getAns2(),record.getAns3(),record.getAns4(),record.getAns5()};

        request.getSession().setAttribute("user_ans", ans);
        request.getSession().setAttribute("questions",MultipleChoices);
        request.getRequestDispatcher("/client/recorddetail.jsp").forward(request, response);
    }

    public void grade(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {

        HttpSession session = request.getSession();
        String answer1 = request.getParameter("1");
        String answer2 = request.getParameter("2");
        String answer3 = request.getParameter("3");
        String answer4 = request.getParameter("4");
        String answer5 = request.getParameter("5");

        String[] op = {answer1,answer2,answer3,answer4,answer5};


        SysServiceImpl service = new SysServiceImpl();

        List<MultipleChoice> MultipleChoices = service.find();

        int score = 0,i=0;
        for(MultipleChoice x : MultipleChoices){
            String re = x.getRight_option();
            if(re.equals(op[i])){
                score++;
                i++;
            }
        }

        Record record = new Record();
        User user = (User) session.getAttribute("user");
        int times = (int)service.findTime(user.getSno());

        record.setSno(user.getSno());
        record.setScore(score);
        record.setAns1(answer1);
        record.setAns2(answer2);
        record.setAns3(answer3);
        record.setAns4(answer4);
        record.setAns5(answer5);
        record.setUser_number(times+1);
        service.addRecord(record);

        service.updateUser(user.getSno(),times+1);

        request.setAttribute("score", score);
        request.getRequestDispatcher("/client/score.jsp").forward(request, response);
    }
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String method = request.getParameter("method");
        //System.out.println(method);
        if("grade".equals(method)){
            try {
                grade(request,response);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

    }
}
