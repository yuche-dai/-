package djt.servlet;

import djt.pojo.Equipment;
import djt.service.EquipmentService;
import djt.service.impl.EquipmentServiceImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = "/Equipment99")
public class EquipmentServlet extends HttpServlet {
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
                listEquipment(req, resp);
                break;
            case "2":
                deleteEquipment(req,resp);
            case  "3":
                addEquipment(req,resp);
            case "4":
                findEquipment(req,resp);
                break;
            case "5":
                updateEquipment(req,resp);
                break;
            default:

        }
    }

    private void deleteEquipment(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        EquipmentService equipmentService = new EquipmentServiceImpl();
        if (equipmentService.deleteEquipment(id)) {
            req.setAttribute("result", "<script language'javascript'>alert('删除成功');</script>");
        } else {
            req.setAttribute("result", "<script language'javascript'>alert('删除失败');</script>");
        }
        listEquipment(req, resp);
    }

    private void listEquipment(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        EquipmentService equipmentService = new EquipmentServiceImpl();
        List<Equipment> equipment = equipmentService.getAllEquipment();
        RequestDispatcher dispatcher = req.getRequestDispatcher("equipmentList.jsp");
        req.setAttribute("equipment", equipment);
        dispatcher.forward(req, resp);
    }

    private void addEquipment (HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name=req.getParameter("name");
        if (name!= null) {
            String category = req.getParameter("category");
            String attribute1 = req.getParameter("attribute1");
            Equipment equipment=new Equipment();
            equipment.setName(name);
            equipment.setCategory(category);
            equipment.setAttribute1(attribute1);
            EquipmentService equipmentService=new EquipmentServiceImpl();
            String result;
            if(equipmentService.insertEquipment(equipment)){
                result="成功添加";
            }else {
                result = "添加失败";
            }
            req.setAttribute("result",result);
        }
        RequestDispatcher dispatcher = req.getRequestDispatcher("addEquipment.jsp");
        dispatcher.forward(req, resp);
    }
    private void updateEquipment(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id=Integer.parseInt(req.getParameter("id"));
        String name = req.getParameter("name");
        if (name != null){
            Equipment equipment = new Equipment();
            equipment.setId(id);
            equipment.setName(name);
            equipment.setCategory(formatStr(req.getParameter("category")));
            equipment.setAttribute1(formatStr(req.getParameter("attribute1")));
            EquipmentService equipmentService = new EquipmentServiceImpl();
            equipmentService.updateEquipment(equipment);
        }
        listEquipment(req,resp);
    }


    private void findEquipment(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        EquipmentService equipmentservice=new EquipmentServiceImpl();
        int id=Integer.parseInt(req.getParameter("id"));
        Equipment equipment = equipmentservice.queryEquipment(id);
        RequestDispatcher dispatcher = req.getRequestDispatcher("modifyEquipment.jsp");
        req.setAttribute("equipment",equipment);
        dispatcher.forward(req,resp);
    }









}
