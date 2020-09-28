package djt.service;

import djt.pojo.Discuss;

import java.util.List;

public interface DiscussService {
    List<Discuss> getAllDiscuss();

    boolean deleteDiscuss(int id);

    boolean insertDiscuss(Discuss discuss);

    Discuss queryDiscuss(int id);

    boolean updateDiscuss(Discuss discuss);
}
