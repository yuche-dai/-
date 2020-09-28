package djt.dao;

import djt.pojo.Distribution;

import java.util.List;

public interface DistributionDao {
    List<Distribution> getAllDistribution();

    boolean deleteDistribution(int id);
    boolean addDistribution(Distribution distribution);
    boolean updateDistribution(Distribution distribution);
    Distribution queryDistribution(int id);

}
