package djt.dao.impl;

import djt.dao.DiscussDao;
import djt.db.MyDatabase;
import djt.pojo.Discuss;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DiscussDaoImpl implements DiscussDao {
    @Override
    public boolean deleteDiscuss(int id) {
        Connection connection = MyDatabase.getConnection();
        if(connection == null){
            return false;
        }
        PreparedStatement ps = null;
        try{
            ps = connection.prepareStatement("DELETE FROM discuss WHERE id=?");
            ps.setInt(1,id);
            return ps.executeUpdate()>0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }finally {
            MyDatabase.close(null,ps,connection);
        }

    }


    @Override
    public boolean addDiscuss(Discuss discuss) {
        Connection connection= MyDatabase.getConnection();
        if (connection == null) {
            return false;
        }
        PreparedStatement ps=null;
        try {
            ps=connection.prepareStatement("INSERT INTO discuss(discussTitle, discussContent, discussTime) VALUES (?,?,?)");
            ps.setString(1,discuss.getDiscussTitle());
            ps.setString(2, discuss.getDiscussContent());
            ps.setString(3,discuss.getDiscussTime());
            return ps.executeUpdate()>0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        } finally {
            MyDatabase.close(null,ps,connection);
        }
    }





    @Override
    public List<Discuss> getAllDiscuss(){
        Connection connection=new MyDatabase().getConnection();
        ResultSet rs=null;
        PreparedStatement ps=null;
        try {
            ps=connection.prepareStatement("SELECT * FROM  discuss");
            rs=ps.executeQuery();
            ArrayList<Discuss> list = new ArrayList<>();
            while (rs.next()){
                Discuss discuss=new Discuss();
                discuss.setId(rs.getInt(1));
                discuss.setDiscussTitle(rs.getString(2));
                discuss.setDiscussContent(rs.getString(3));
                discuss.setDiscussTime(rs.getString(4));
                list.add(discuss);
            }
            return list;
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }finally {
            if (rs !=null){
                MyDatabase.close(rs,ps,connection);
            }
        }


    }
    @Override
    public Discuss queryDiscuss(int id){
        Connection connection=new MyDatabase().getConnection();
        ResultSet rs=null;
        PreparedStatement ps=null;
        try {
            ps=connection.prepareStatement("SELECT * FROM  discuss WHERE id=?");
            ps.setInt(1,id);
            rs=ps.executeQuery();

            if (rs.next()){
                Discuss discuss=new Discuss();
                discuss.setId(rs.getInt(1));
                discuss.setDiscussTitle(rs.getString(2));
                discuss.setDiscussContent(rs.getString(3));
                discuss.setDiscussTime(rs.getString(4));
                return discuss;
            }
            return null;
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }finally {
            if (rs !=null){
                MyDatabase.close(rs,ps,connection);
            }
        }
    }

    @Override
    public boolean updateDiscuss(Discuss discuss) {
        Connection connection=MyDatabase.getConnection();
        if (connection == null) {
            return false;
        }
        PreparedStatement ps=null;

        try {
            ps = connection.prepareStatement("UPDATE discuss SET discussTitle=?, discussContent=?, discussTime=? WHERE id=?");
            ps.setString(1, discuss.getDiscussTitle());
            ps.setString(2, discuss.getDiscussContent());
            ps.setString(3, discuss.getDiscussTime());
            ps.setInt(4,discuss.getId());
            int result = ps.executeUpdate();
            return result>0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;

        } finally {
            MyDatabase.close(null,ps,connection);
        }


    }

}
