package djt.dao;

import djt.pojo.Information;

import java.util.List;

public interface InformationDao {
    List<Information> getAllInformation();

    boolean deleteInformation(int id);
    boolean addInformation(Information information);
    boolean updateInformation(Information information);
    Information queryInformation(int id);

}
