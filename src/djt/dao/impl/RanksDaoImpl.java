package djt.dao.impl;

import djt.dao.RanksDao;
import djt.db.MyDatabase;
import djt.pojo.Ranks;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class RanksDaoImpl implements RanksDao {
    @Override
    public boolean deleteRanks(int id) {
        Connection connection = MyDatabase.getConnection();
        if(connection == null){
            return false;
        }
        PreparedStatement ps = null;
        try{
            ps = connection.prepareStatement("DELETE FROM ranks WHERE id=?");
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
    public boolean addRanks(Ranks ranks) {
        Connection connection= MyDatabase.getConnection();
        if (connection == null) {
            return false;
        }
        PreparedStatement ps=null;
        try {
            ps=connection.prepareStatement("INSERT INTO ranks(name,konlon,powers,ranking) VALUES (?,?,?,?)");
            ps.setString(1,ranks.getName());
            ps.setString(2, ranks.getKonlon());
            ps.setString(3,ranks.getPowers());
            ps.setString(4,ranks.getRanking());
            return ps.executeUpdate()>0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        } finally {
            MyDatabase.close(null,ps,connection);
        }
    }





    @Override
    public List<Ranks> getAllRanks(){
        Connection connection=new MyDatabase().getConnection();
        ResultSet rs=null;
        PreparedStatement ps=null;
        try {
            ps=connection.prepareStatement("SELECT * FROM  ranks");
            rs=ps.executeQuery();
            ArrayList<Ranks> list = new ArrayList<>();
            while (rs.next()){
                Ranks ranks=new Ranks();
                ranks.setId(rs.getInt(1));
                ranks.setName(rs.getString(2));
                ranks.setKonlon(rs.getString(3));
                ranks.setPowers(rs.getString(4));
                ranks.setRanking(rs.getString(5));
                list.add(ranks);
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
    public Ranks queryRanks(int id){
        Connection connection=new MyDatabase().getConnection();
        ResultSet rs=null;
        PreparedStatement ps=null;
        try {
            ps=connection.prepareStatement("SELECT * FROM  ranks WHERE id=?");
            ps.setInt(1,id);
            rs=ps.executeQuery();

            if (rs.next()){
                Ranks ranks=new Ranks();
                ranks.setId(rs.getInt(1));
                ranks.setName(rs.getString(2));
                ranks.setKonlon(rs.getString(3));
                ranks.setPowers(rs.getString(4));
                ranks.setRanking(rs.getString(5));
                return ranks;
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
    public boolean updateRanks(Ranks ranks) {
        Connection connection=MyDatabase.getConnection();
        if (connection == null) {
            return false;
        }
        PreparedStatement ps=null;

        try {
            ps = connection.prepareStatement("UPDATE ranks SET name=?, konlon=?,powers=?,ranking=?  WHERE id=?");
            ps.setString(1, ranks.getName());
            ps.setString(2, ranks.getKonlon());
            ps.setString(3, ranks.getPowers());
            ps.setString(4, ranks.getRanking());
            ps.setInt(5,ranks.getId());
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
