package djt.service;

import djt.pojo.Equipment;

import java.util.List;

public interface EquipmentService {
    List<Equipment> getAllEquipment();

    boolean deleteEquipment(int id);

    boolean insertEquipment(Equipment equipment);

    Equipment queryEquipment(int id);

    boolean updateEquipment(Equipment equipment);
}
