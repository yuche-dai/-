package djt.service.impl;

import djt.dao.DiscussDao;
import djt.dao.impl.DiscussDaoImpl;
import djt.pojo.Discuss;
import djt.service.DiscussService;

import java.util.List;

public class DiscussServiceImpl implements DiscussService {
    @Override
    public boolean deleteDiscuss(int id) {
        DiscussDao discussDao = new DiscussDaoImpl();
        return discussDao.deleteDiscuss(id);
    }

    @Override
    public List<Discuss> getAllDiscuss() {
        DiscussDao DiscussDao=new DiscussDaoImpl();
        return DiscussDao.getAllDiscuss();
    }

    @Override
    public boolean insertDiscuss(Discuss discuss) {
        DiscussDao discussDao=new DiscussDaoImpl();
        return discussDao.addDiscuss(discuss);
    }
    @Override
    public Discuss queryDiscuss(int id){
        DiscussDao DiscussDao=new DiscussDaoImpl();
        return DiscussDao.queryDiscuss(id);
    }

    @Override
    public boolean updateDiscuss(Discuss discuss) {
        DiscussDao discussDao = new DiscussDaoImpl();
        return discussDao.updateDiscuss(discuss);
    }
}