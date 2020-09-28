package djt.dao.impl;

import djt.dao.EquipmentDao;
import djt.db.MyDatabase;
import djt.pojo.Equipment;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EquipmentDaoImpl implements EquipmentDao {
    @Override
    public boolean deleteEquipment(int id) {
        Connection connection = MyDatabase.getConnection();
        if(connection == null){
            return false;
        }
        PreparedStatement ps = null;
        try{
            ps = connection.prepareStatement("DELETE FROM equipment WHERE id=?");
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
    public boolean addEquipment(Equipment equipment) {
        Connection connection= MyDatabase.getConnection();
        if (connection == null) {
            return false;
        }
        PreparedStatement ps=null;
        try {
            ps=connection.prepareStatement("INSERT INTO equipment(name,category,attribute) VALUES (?,?,?)");
            ps.setString(1,equipment.getName());
            ps.setString(2, equipment.getCategory());
            ps.setString(3,equipment.getAttribute1());
            return ps.executeUpdate()>0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        } finally {
            MyDatabase.close(null,ps,connection);
        }
    }





    @Override
    public List<Equipment> getAllEquipment(){
        Connection connection=new MyDatabase().getConnection();
        ResultSet rs=null;
        PreparedStatement ps=null;
        try {
            ps=connection.prepareStatement("SELECT * FROM  equipment");
            rs=ps.executeQuery();
            ArrayList<Equipment> list = new ArrayList<>();
            while (rs.next()){
                Equipment equipment=new Equipment();
                equipment.setId(rs.getInt(1));
                equipment.setName(rs.getString(2));
                equipment.setCategory(rs.getString(3));
                equipment.setAttribute1(rs.getString(4));
                list.add(equipment);
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
    public Equipment queryEquipment(int id){
        Connection connection=new MyDatabase().getConnection();
        ResultSet rs=null;
        PreparedStatement ps=null;
        try {
            ps=connection.prepareStatement("SELECT * FROM  equipment WHERE id=?");
            ps.setInt(1,id);
            rs=ps.executeQuery();

            if (rs.next()){
                Equipment equipment=new Equipment();
                equipment.setId(rs.getInt(1));
                equipment.setName(rs.getString(2));
                equipment.setCategory(rs.getString(3));
                equipment.setAttribute1(rs.getString(4));
                return equipment;
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
    public boolean updateEquipment(Equipment equipment) {
        Connection connection=MyDatabase.getConnection();
        if (connection == null) {
            return false;
        }
        PreparedStatement ps=null;

        try {
            ps = connection.prepareStatement("UPDATE equipment SET name=?, category=?, attribute=? WHERE id=?");
            ps.setString(1, equipment.getName());
            ps.setString(2, equipment.getCategory());
            ps.setString(3, equipment.getAttribute1());
            ps.setInt(4,equipment.getId());
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
