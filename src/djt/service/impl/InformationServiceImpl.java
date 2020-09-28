package djt.service.impl;

import djt.dao.InformationDao;
import djt.dao.impl.InformationDaoImpl;
import djt.pojo.Information;
import djt.service.InformationService;

import java.util.List;

public class InformationServiceImpl implements InformationService {
    @Override
    public boolean deleteInformation(int id) {
        InformationDao informationDao = new InformationDaoImpl();
        return informationDao.deleteInformation(id);
    }

    @Override
    public List<Information> getAllInformation() {
        InformationDao InformationDao=new InformationDaoImpl();
        return InformationDao.getAllInformation();
    }

    @Override
    public boolean insertInformation(Information information) {
        InformationDao informationDao=new InformationDaoImpl();
        return informationDao.addInformation(information);
    }
    @Override
    public Information queryInformation(int id){
        InformationDao InformationDao=new InformationDaoImpl();
        return InformationDao.queryInformation(id);
    }

    @Override
    public boolean updateInformation(Information information) {
        InformationDao informationDao = new InformationDaoImpl();
        return informationDao.updateInformation(information);
    }
}
