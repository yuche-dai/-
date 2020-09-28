package djt.servlet;

import djt.pojo.Distribution;
import djt.service.DistributionService;
import djt.service.impl.DistributionServiceImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = "/Distribution99")
public class DistributionServlet extends HttpServlet {
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
                listDistribution(req, resp);
                break;
            case "2":
                deleteDistribution(req,resp);
            case  "3":
                addDistribution(req,resp);
            case "4":
                findDistribution(req,resp);
                break;
            case "5":
                updateDistribution(req,resp);
                break;
            default:

        }
    }

    private void deleteDistribution(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        DistributionService distributionService = new DistributionServiceImpl();
        if (distributionService.deleteDistribution(id)) {
            req.setAttribute("result", "<script language'javascript'>alert('删除成功');</script>");
        } else {
            req.setAttribute("result", "<script language'javascript'>alert('删除失败');</script>");
        }
        listDistribution(req, resp);
    }

    private void listDistribution(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        DistributionService distributionService = new DistributionServiceImpl();
        List<Distribution> distribution = distributionService.getAllDistribution();
        RequestDispatcher dispatcher = req.getRequestDispatcher("distributionList.jsp");
        req.setAttribute("distribution", distribution);
        dispatcher.forward(req, resp);
    }

    private void addDistribution (HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name=req.getParameter("name");
        if (name!= null) {
            String time = req.getParameter("time");
            String dizi = req.getParameter("dizi");
            Distribution distribution=new Distribution();
            distribution.setName(name);
            distribution.setTime(time);
            distribution.setDizi(dizi);
            DistributionService distributionService=new DistributionServiceImpl();
            String result;
            if(distributionService.insertDistribution(distribution)){
                result="成功添加";
            }else {
                result = "添加失败";
            }
            req.setAttribute("result",result);
        }
        RequestDispatcher dispatcher = req.getRequestDispatcher("addDistribution.jsp");
        dispatcher.forward(req, resp);
    }
    private void updateDistribution(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id=Integer.parseInt(req.getParameter("id"));
        String name = req.getParameter("name");
        if (name != null){
            Distribution distribution = new Distribution();
            distribution.setId(id);
            distribution.setName(name);
            distribution.setTime(formatStr(req.getParameter("time")));
            distribution.setDizi(formatStr(req.getParameter("dizi")));
            DistributionService distributionService = new DistributionServiceImpl();
            distributionService.updateDistribution(distribution);
        }
        listDistribution(req,resp);
    }


    private void findDistribution(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        DistributionService distributionservice=new DistributionServiceImpl();
        int id=Integer.parseInt(req.getParameter("id"));
        Distribution distribution = distributionservice.queryDistribution(id);
        RequestDispatcher dispatcher = req.getRequestDispatcher("modifyDistribution.jsp");
        req.setAttribute("distribution",distribution);
        dispatcher.forward(req,resp);
    }









}