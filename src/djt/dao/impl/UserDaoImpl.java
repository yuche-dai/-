package djt.dao.impl;

import djt.dao.UserDao;
import djt.db.MyDatabase;
import djt.pojo.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDaoImpl implements UserDao {
    @Override
    public boolean findUserByName(String username) {
        Connection connection = MyDatabase.getConnection();
        if (connection == null) return false;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            ps = connection.prepareStatement("SELECT * FROM users WHERE userName=?");
            ps.setString(1, username);
            rs = ps.executeQuery();
//            return rs.first();
            return rs.next();
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        } finally {
            MyDatabase.close(rs, ps, connection);
        }
    }
    @Override
    public boolean insertUser(User user) {
        Connection connection = MyDatabase.getConnection();
        if (connection == null) return false;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            ps = connection.prepareStatement("INSERT users(UserName, UserPwd, Level) VALUES (?,?,?)");

            ps.setString(1, user.getUserName());
            ps.setString(2, user.getUserPwd());
            ps.setString(3, user.getLevel());
            return ps.executeUpdate() > 0;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        } finally {
            MyDatabase.close(rs,ps, connection);
        }
    }
    @Override
    public User findUserByNameAndPwd(String name, String pwd) {
        Connection connection = MyDatabase.getConnection();
        if (connection == null) return null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            ps = connection.prepareStatement("SELECT * FROM users WHERE Username=? AND Userpwd=?");
            ps.setString(1, name);
            ps.setString(2, pwd);
            rs = ps.executeQuery();
//            if( rs.first()){
            if( rs.next()){
                User user = new User();
                user.setUserId(rs.getInt(1));
                user.setUserName(rs.getString(2));
                user.setUserPwd(rs.getString(3));
                user.setLevel(rs.getString(4));
                return user;
            }else {
                return null;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        } finally {
            MyDatabase.close(rs, ps, connection);
        }
    }


}
