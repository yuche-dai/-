package djt.service;

import djt.pojo.Distribution;

import java.util.List;

public interface DistributionService {
    List<Distribution> getAllDistribution();

    boolean deleteDistribution(int id);

    boolean insertDistribution(Distribution distribution);

    Distribution queryDistribution(int id);

    boolean updateDistribution(Distribution distribution);
}
