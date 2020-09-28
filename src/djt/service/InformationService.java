package djt.service;

import djt.pojo.Information;

import java.util.List;

public interface InformationService {
    List<Information> getAllInformation();

    boolean deleteInformation(int id);

    boolean insertInformation(Information information);

    Information queryInformation(int id);

    boolean updateInformation(Information information);
}
