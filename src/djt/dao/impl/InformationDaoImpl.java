package djt.dao.impl;

import djt.dao.InformationDao;
import djt.db.MyDatabase;
import djt.pojo.Information;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class InformationDaoImpl implements InformationDao {
    @Override
    public boolean deleteInformation(int id) {
        Connection connection = MyDatabase.getConnection();
        if(connection == null){
            return false;
        }
        PreparedStatement ps = null;
        try{
            ps = connection.prepareStatement("DELETE FROM information WHERE id=?");
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
    public boolean addInformation(Information information) {
        Connection connection= MyDatabase.getConnection();
        if (connection == null) {
            return false;
        }
        PreparedStatement ps=null;
        try {
            ps=connection.prepareStatement("INSERT INTO information(name1,name2,name3,tixin,weight1,diwei) VALUES (?,?,?,?,?,?)");
            ps.setString(1,information.getName1());
            ps.setString(2,information.getName2());
            ps.setString(3,information.getName3());
            ps.setString(4, information.getTixin());
            ps.setString(5,information.getWeight1());
            ps.setString(6,information.getDiwei());
            return ps.executeUpdate()>0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        } finally {
            MyDatabase.close(null,ps,connection);
        }
    }





    @Override
    public List<Information> getAllInformation(){
        Connection connection=new MyDatabase().getConnection();
        ResultSet rs=null;
        PreparedStatement ps=null;
        try {
            ps=connection.prepareStatement("SELECT * FROM  information");
            rs=ps.executeQuery();
            ArrayList<Information> list = new ArrayList<>();
            while (rs.next()){
                Information information=new Information();
                information.setId(rs.getInt(1));
                information.setName1(rs.getString(2));
                information.setName2(rs.getString(3));
                information.setName3(rs.getString(4));
                information.setTixin(rs.getString(5));
                information.setWeight1(rs.getString(6));
                information.setDiwei(rs.getString(7));
                list.add(information);
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
    public Information queryInformation(int id){
        Connection connection=new MyDatabase().getConnection();
        ResultSet rs=null;
        PreparedStatement ps=null;
        try {
            ps=connection.prepareStatement("SELECT * FROM  information WHERE id=?");
            ps.setInt(1,id);
            rs=ps.executeQuery();

            if (rs.next()){
                Information information=new Information();
                information.setId(rs.getInt(1));
                information.setName1(rs.getString(2));
                information.setName2(rs.getString(3));
                information.setName3(rs.getString(4));
                information.setTixin(rs.getString(5));
                information.setWeight1(rs.getString(6));
                information.setDiwei(rs.getString(7));
                return information;
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
    public boolean updateInformation(Information information) {
        Connection connection=MyDatabase.getConnection();
        if (connection == null) {
            return false;
        }
        PreparedStatement ps=null;

        try {
            ps = connection.prepareStatement("UPDATE information SET name1=?,name2=?,name3=?,tixin=?,weight1=?,diwei=? WHERE id=?");
            ps.setString(1, information.getName1());
            ps.setString(2, information.getName2());
            ps.setString(3, information.getName3());
            ps.setString(4, information.getTixin());
            ps.setString(5, information.getWeight1());
            ps.setString(6, information.getDiwei());
            ps.setInt(7,information.getId());
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
