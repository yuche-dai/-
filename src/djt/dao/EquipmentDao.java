package djt.dao;

import djt.pojo.Equipment;

import java.util.List;

public interface EquipmentDao  {
    List<Equipment> getAllEquipment();

    boolean deleteEquipment(int id);
    boolean addEquipment(Equipment equipment);
    boolean updateEquipment(Equipment equipment);
    Equipment queryEquipment(int id);

}
