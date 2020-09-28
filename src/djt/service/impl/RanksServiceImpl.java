package djt.service.impl;

import djt.dao.RanksDao;
import djt.dao.impl.RanksDaoImpl;
import djt.pojo.Ranks;
import djt.service.RanksService;

import java.util.List;

public class RanksServiceImpl implements RanksService {
    @Override
    public boolean deleteRanks(int id) {
        RanksDao ranksDao = new RanksDaoImpl();
        return ranksDao.deleteRanks(id);
    }

    @Override
    public List<Ranks> getAllRanks() {
        RanksDao RanksDao=new RanksDaoImpl();
        return RanksDao.getAllRanks();
    }

    @Override
    public boolean insertRanks(Ranks ranks) {
        RanksDao ranksDao=new RanksDaoImpl();
        return ranksDao.addRanks(ranks);
    }
    @Override
    public Ranks queryRanks(int id){
        RanksDao RanksDao=new RanksDaoImpl();
        return RanksDao.queryRanks(id);
    }

    @Override
    public boolean updateRanks(Ranks ranks) {
        RanksDao ranksDao = new RanksDaoImpl();
        return ranksDao.updateRanks(ranks);
    }
}
