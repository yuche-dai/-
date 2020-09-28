package djt.dao;

import djt.pojo.User;

public interface UserDao {

    boolean findUserByName(String username);

    boolean insertUser(User user);

  User findUserByNameAndPwd(String name, String pwd);

}
