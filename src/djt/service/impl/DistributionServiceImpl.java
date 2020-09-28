package djt.service.impl;

import djt.dao.DistributionDao;
import djt.dao.impl.DistributionDaoImpl;
import djt.pojo.Distribution;
import djt.service.DistributionService;

import java.util.List;

public class DistributionServiceImpl implements DistributionService {
    @Override
    public boolean deleteDistribution(int id) {
        DistributionDao distributionDao = new DistributionDaoImpl();
        return distributionDao.deleteDistribution(id);
    }

    @Override
    public List<Distribution> getAllDistribution() {
        DistributionDao DistributionDao=new DistributionDaoImpl();
        return DistributionDao.getAllDistribution();
    }

    @Override
    public boolean insertDistribution(Distribution distribution) {
        DistributionDao distributionDao=new DistributionDaoImpl();
        return distributionDao.addDistribution(distribution);
    }
    @Override
    public Distribution queryDistribution(int id){
        DistributionDao DistributionDao=new DistributionDaoImpl();
        return DistributionDao.queryDistribution(id);
    }

    @Override
    public boolean updateDistribution(Distribution distribution) {
        DistributionDao distributionDao = new DistributionDaoImpl();
        return distributionDao.updateDistribution(distribution);
    }
}