package djt.dao;

import djt.pojo.Discuss;

import java.util.List;

public interface DiscussDao {
    List<Discuss> getAllDiscuss();

    boolean deleteDiscuss(int id);
    boolean addDiscuss(Discuss discuss);
    boolean updateDiscuss(Discuss discuss);
    Discuss queryDiscuss(int id);

}
