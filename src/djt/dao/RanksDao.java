package djt.dao;

import djt.pojo.Ranks;

import java.util.List;

public interface RanksDao {
    List<Ranks> getAllRanks();

    boolean deleteRanks(int id);
    boolean addRanks(Ranks ranks);
    boolean updateRanks(Ranks ranks);
    Ranks queryRanks(int id);

}
