package djt.servlet;

import djt.pojo.User;
import djt.service.UserService;
import djt.service.impl.UserServiceImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;


@WebServlet(urlPatterns = "/user.do")
public class UseServlet extends HttpServlet{

    private String formatStr(String str) {
        return str == null ? "" : str;
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String tempMethod = req.getParameter("method");
        if (tempMethod == null) {
            tempMethod="0";
        }
        int method = Integer.parseInt(tempMethod);

        switch (method) {
            case 1:
                signUp(req, resp);
                break;
            case 2:
                signIn(req, resp);
                break;

            default:
        }
    }
    private void signUp(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        User user = new User();
        user.setUserName(formatStr(req.getParameter("name")));
        user.setUserPwd(formatStr(req.getParameter("pwd")));
        user.setLevel("2");

        UserService userService = new UserServiceImpl();
        if (userService.signUp(user)) {
            req.setAttribute("result", "<script language=javascript>alert('成功注册！');</script>");
            RequestDispatcher dispatcher = req.getRequestDispatcher("sign_in.jsp");
            dispatcher.forward(req, resp);
        } else {
            req.setAttribute("result", "<script language=javascript>alert('注册失败！');</script>");
            RequestDispatcher dispatcher = req.getRequestDispatcher("sign_up.jsp");
            dispatcher.forward(req, resp);
        }


    }
    private void signIn(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        User user = new User();
        user.setUserName(formatStr(req.getParameter("name")));
        user.setUserPwd(formatStr(req.getParameter("pwd")));
        UserService userService = new UserServiceImpl();
        HttpSession session = req.getSession();
        PrintWriter out=resp.getWriter();
        if (userService.signIn(user,session)) {
            Cookie c = new Cookie("user", user.getUserName());
             c.setMaxAge(60);
            resp.addCookie(c);
            out.print("<script language=javascript>alert('登录失败！');history.go(-1);</script>");
        } else {
            out.print("<script language=javascript>alert('登录成功！');window.location.href='index.jsp';</script>");
        }
    }
}


