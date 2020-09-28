package djt.servlet;

import djt.pojo.Discuss;
import djt.service.DiscussService;
import djt.service.impl.DiscussServiceImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = "/abc99")
public class DiscussServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }

    private String formatStr(String string){
        return string==null?"":string;
    }
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        String age = req.getParameter("method");
        if (age == null) {
            age = "1";
        }
        switch (age) {
            case "1":
                listStudents(req, resp);
                break;
            case "2":
                deleteDiscuss(req,resp);
            case  "3":
                addDiscuss(req,resp);
            case "4":
                findDiscuss(req,resp);
                break;
            case "5":
                updateDiscuss(req,resp);
                break;
            default:

        }
    }

    private void deleteDiscuss(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        DiscussService studentService = new DiscussServiceImpl();
        if (studentService.deleteDiscuss(id)) {
            req.setAttribute("result", "<script language'javascript'>alert('删除成功');</script>");
        } else {
            req.setAttribute("result", "<script language'javascript'>alert('删除失败');</script>");
        }
        listStudents(req, resp);
    }

    private void listStudents(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        DiscussService discussService = new DiscussServiceImpl();
        List<Discuss> discuss = discussService.getAllDiscuss();
        RequestDispatcher dispatcher = req.getRequestDispatcher("discussList.jsp");
        req.setAttribute("dicuss", discuss);
        dispatcher.forward(req, resp);
    }

    private void addDiscuss (HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String discussTitle=req.getParameter("discussTitle");
        if (discussTitle != null) {
            String discussContent = req.getParameter("discussContent");
            String discussTime = req.getParameter("discussTime");
            Discuss discuss=new Discuss();
            discuss.setDiscussTitle(discussTitle);
            discuss.setDiscussContent(discussContent);
            discuss.setDiscussTime(discussTime);
            DiscussService discussService=new DiscussServiceImpl();
            String result;
            if(discussService.insertDiscuss(discuss)){
                result="成功添加";
            }else {
                result = "添加失败";
            }
            req.setAttribute("result",result);
        }
        RequestDispatcher dispatcher = req.getRequestDispatcher("addDiscuss.jsp");
        dispatcher.forward(req, resp);
    }
    private void updateDiscuss(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id=Integer.parseInt(req.getParameter("id"));
        String discussTitle = req.getParameter("discussTitle");
        if (discussTitle != null){
            Discuss discuss = new Discuss();
            discuss.setId(id);
            discuss.setDiscussTitle(discussTitle);
            discuss.setDiscussContent(formatStr(req.getParameter("discussContent")));
            discuss.setDiscussTime(formatStr(req.getParameter("discussTime")));
            DiscussService discussService = new DiscussServiceImpl();
            discussService.updateDiscuss(discuss);
        }
        listStudents(req,resp);
    }


    private void findDiscuss(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        DiscussService discussservice=new DiscussServiceImpl();
        int id=Integer.parseInt(req.getParameter("id"));
        Discuss discuss = discussservice.queryDiscuss(id);
//        Discuss discuss = discussservice.queryDiscuss(discuss.getId());
        RequestDispatcher dispatcher = req.getRequestDispatcher("modifyDiscuss.jsp");
        req.setAttribute("discuss",discuss);
        dispatcher.forward(req,resp);
    }

}