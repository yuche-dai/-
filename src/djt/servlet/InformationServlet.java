package djt.servlet;

import djt.pojo.Information;
import djt.service.InformationService;
import djt.service.impl.InformationServiceImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = "/Information99")
public class InformationServlet extends HttpServlet {
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
                listInformation(req, resp);
                break;
            case "2":
                deleteInformation(req,resp);
            case  "3":
                addInformation(req,resp);
            case "4":
                findInformation(req,resp);
                break;
            case "5":
                updateInformation(req,resp);
                break;
            default:

        }
    }

    private void deleteInformation(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        InformationService informationService = new InformationServiceImpl();
        if (informationService.deleteInformation(id)) {
            req.setAttribute("result", "<script language'javascript'>alert('删除成功');</script>");
        } else {
            req.setAttribute("result", "<script language'javascript'>alert('删除失败');</script>");
        }
        listInformation(req, resp);
    }

    private void listInformation(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        InformationService informationService = new InformationServiceImpl();
        List<Information> information = informationService.getAllInformation();
        RequestDispatcher dispatcher = req.getRequestDispatcher("informationList.jsp");
        req.setAttribute("information", information);
        dispatcher.forward(req, resp);
    }

    private void addInformation (HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name1=req.getParameter("name1");
        if (name1!= null) {
            String name2 = req.getParameter("name2");
            String name3 = req.getParameter("name3");
            String tixin = req.getParameter("tixin");
            String weight1 = req.getParameter("weight1");
            String diwei = req.getParameter("diwei");
            Information information=new Information();
            information.setName1(name1);
            information.setName2(name2);
            information.setName3(name3);
            information.setTixin(tixin);
            information.setWeight1(weight1);
            information.setDiwei(diwei);
            InformationService informationService=new InformationServiceImpl();
            String result;
            if(informationService.insertInformation(information)){
                result="成功添加";
            }else {
                result = "添加失败";
            }
            req.setAttribute("result",result);
        }
        RequestDispatcher dispatcher = req.getRequestDispatcher("addInformation.jsp");
        dispatcher.forward(req, resp);
    }
    private void updateInformation(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id=Integer.parseInt(req.getParameter("id"));
        String name1 = req.getParameter("name1");
        if (name1 != null){
            Information information = new Information();
            information.setId(id);
            information.setName1(name1);
            information.setName2(formatStr(req.getParameter("name2")));
            information.setName3(formatStr(req.getParameter("name3")));
            information.setTixin(formatStr(req.getParameter("tixin")));
            information.setWeight1(formatStr(req.getParameter("weight1")));
            information.setDiwei(formatStr(req.getParameter("diwei")));
            InformationService informationService = new InformationServiceImpl();
            informationService.updateInformation(information);
        }
        listInformation(req,resp);
    }


    private void findInformation(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        InformationService informationservice=new InformationServiceImpl();
        int id=Integer.parseInt(req.getParameter("id"));
        Information information = informationservice.queryInformation(id);
        RequestDispatcher dispatcher = req.getRequestDispatcher("modifyInformation.jsp");
        req.setAttribute("information",information);
        dispatcher.forward(req,resp);
    }









}
