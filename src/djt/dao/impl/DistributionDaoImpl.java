package djt.dao.impl;

import djt.dao.DistributionDao;
import djt.db.MyDatabase;
import djt.pojo.Distribution;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DistributionDaoImpl implements DistributionDao {
    @Override
    public boolean deleteDistribution(int id) {
        Connection connection = MyDatabase.getConnection();
        if(connection == null){
            return false;
        }
        PreparedStatement ps = null;
        try{
            ps = connection.prepareStatement("DELETE FROM distribution WHERE id=?");
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
    public boolean addDistribution(Distribution distribution) {
        Connection connection= MyDatabase.getConnection();
        if (connection == null) {
            return false;
        }
        PreparedStatement ps=null;
        try {
            ps=connection.prepareStatement("INSERT INTO distribution(name,time,dizi) VALUES (?,?,?)");
            ps.setString(1,distribution.getName());
            ps.setString(2, distribution.getTime());
            ps.setString(3,distribution.getDizi());
            return ps.executeUpdate()>0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        } finally {
            MyDatabase.close(null,ps,connection);
        }
    }





    @Override
    public List<Distribution> getAllDistribution(){
        Connection connection=new MyDatabase().getConnection();
        ResultSet rs=null;
        PreparedStatement ps=null;
        try {
            ps=connection.prepareStatement("SELECT * FROM  distribution");
            rs=ps.executeQuery();
            ArrayList<Distribution> list = new ArrayList<>();
            while (rs.next()){
                Distribution distribution=new Distribution();
                distribution.setId(rs.getInt(1));
                distribution.setName(rs.getString(2));
                distribution.setTime(rs.getString(3));
                distribution.setDizi(rs.getString(4));
                list.add(distribution);
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
    public Distribution queryDistribution(int id){
        Connection connection=new MyDatabase().getConnection();
        ResultSet rs=null;
        PreparedStatement ps=null;
        try {
            ps=connection.prepareStatement("SELECT * FROM  distribution WHERE id=?");
            ps.setInt(1,id);
            rs=ps.executeQuery();

            if (rs.next()){
                Distribution distribution=new Distribution();
                distribution.setId(rs.getInt(1));
                distribution.setName(rs.getString(2));
                distribution.setTime(rs.getString(3));
                distribution.setDizi(rs.getString(4));
                return distribution;
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
    public boolean updateDistribution(Distribution distribution) {
        Connection connection=MyDatabase.getConnection();
        if (connection == null) {
            return false;
        }
        PreparedStatement ps=null;

        try {
            ps = connection.prepareStatement("UPDATE distribution SET name=?, time=?, dizi=? WHERE id=?");
            ps.setString(1, distribution.getName());
            ps.setString(2, distribution.getTime());
            ps.setString(3, distribution.getDizi());
            ps.setInt(4,distribution.getId());
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
