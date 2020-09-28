package djt.servlet;

import djt.pojo.Ranks;
import djt.service.RanksService;
import djt.service.impl.RanksServiceImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = "/Ranks99")
public class RanksServlet extends HttpServlet {
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
                listRanks(req, resp);
                break;
            case "2":
                deleteRanks(req,resp);
            case  "3":
                addRanks(req,resp);
            case "4":
                findRanks(req,resp);
                break;
            case "5":
                updateRanks(req,resp);
                break;
            default:

        }
    }

    private void deleteRanks(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        RanksService ranksService = new RanksServiceImpl();
        if (ranksService.deleteRanks(id)) {
            req.setAttribute("result", "<script language'javascript'>alert('删除成功');</script>");
        } else {
            req.setAttribute("result", "<script language'javascript'>alert('删除失败');</script>");
        }
        listRanks(req, resp);
    }

    private void listRanks(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RanksService ranksService = new RanksServiceImpl();
        List<Ranks> ranks = ranksService.getAllRanks();
        RequestDispatcher dispatcher = req.getRequestDispatcher("ranksList.jsp");
        req.setAttribute("ranks", ranks);
        dispatcher.forward(req, resp);
    }

    private void addRanks (HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name=req.getParameter("name");
        if (name!= null) {
            String konlon = req.getParameter("konlon");
            String powers = req.getParameter("powers");
            String ranking = req.getParameter("ranking");
            Ranks ranks=new Ranks();
            ranks.setName(name);
            ranks.setKonlon(konlon);
            ranks.setPowers(powers);
            ranks.setRanking(ranking);
            RanksService ranksService=new RanksServiceImpl();
            String result;
            if(ranksService.insertRanks(ranks)){
                result="成功添加";
            }else {
                result = "添加失败";
            }
            req.setAttribute("result",result);
        }
        RequestDispatcher dispatcher = req.getRequestDispatcher("addRanks.jsp");
        dispatcher.forward(req, resp);
    }
    private void updateRanks(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id=Integer.parseInt(req.getParameter("id"));
        String name = req.getParameter("name");
        if (name != null){
            Ranks ranks = new Ranks();
            ranks.setId(id);
            ranks.setName(name);
            ranks.setKonlon(formatStr(req.getParameter("konlon")));
            ranks.setPowers(formatStr(req.getParameter("powers")));
            ranks.setRanking(formatStr(req.getParameter("ranking")));
            RanksService ranksService = new RanksServiceImpl();
            ranksService.updateRanks(ranks);
        }
        listRanks(req,resp);
    }


    private void findRanks(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RanksService ranksservice=new RanksServiceImpl();
        int id=Integer.parseInt(req.getParameter("id"));
        Ranks ranks = ranksservice.queryRanks(id);
        RequestDispatcher dispatcher = req.getRequestDispatcher("modifyRanks.jsp");
        req.setAttribute("ranks",ranks);
        dispatcher.forward(req,resp);
    }









}
