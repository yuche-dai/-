package djt.service;

import djt.pojo.Ranks;

import java.util.List;

public interface RanksService {
    List<Ranks> getAllRanks();

    boolean deleteRanks(int id);

    boolean insertRanks(Ranks ranks);

    Ranks queryRanks(int id);

    boolean updateRanks(Ranks ranks);
}
