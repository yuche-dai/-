package djt.service.impl;

import djt.dao.UserDao;
import djt.dao.impl.UserDaoImpl;
import djt.pojo.User;
import djt.service.UserService;

import javax.servlet.http.HttpSession;

public class UserServiceImpl implements UserService {
    @Override
    public boolean signUp(User user) {
        UserDao userDao = new UserDaoImpl();

        if (userDao.findUserByName(user.getUserName())) {
            return false;
        } else {
            userDao.insertUser(user);
            return true;
        }
    }
    @Override
    public boolean signIn(User user, HttpSession session) {
        UserDao userDao = new UserDaoImpl();
        user=userDao.findUserByNameAndPwd(user.getUserName(), user.getUserPwd());
        if (user == null) {
            return false;
        }else{
            String level=user.getLevel();
            session.setAttribute("level",level);
            return true;
        }
    }
}
