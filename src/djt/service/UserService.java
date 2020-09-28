package djt.service;

import djt.pojo.User;

import javax.servlet.http.HttpSession;

public interface UserService {

    boolean signUp(User user);
    boolean signIn(User user, HttpSession session);

}
