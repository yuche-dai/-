package djt.service.impl;

import djt.dao.EquipmentDao;
import djt.dao.impl.EquipmentDaoImpl;
import djt.pojo.Equipment;
import djt.service.EquipmentService;

import java.util.List;

public class EquipmentServiceImpl implements EquipmentService {
    @Override
    public boolean deleteEquipment(int id) {
        EquipmentDao equipmentDao = new EquipmentDaoImpl();
        return equipmentDao.deleteEquipment(id);
    }

    @Override
    public List<Equipment> getAllEquipment() {
        EquipmentDao EquipmentDao=new EquipmentDaoImpl();
        return EquipmentDao.getAllEquipment();
    }

    @Override
    public boolean insertEquipment(Equipment equipment) {
        EquipmentDao equipmentDao=new EquipmentDaoImpl();
        return equipmentDao.addEquipment(equipment);
    }
    @Override
    public Equipment queryEquipment(int id){
        EquipmentDao EquipmentDao=new EquipmentDaoImpl();
        return EquipmentDao.queryEquipment(id);
    }

    @Override
    public boolean updateEquipment(Equipment equipment) {
        EquipmentDao equipmentDao = new EquipmentDaoImpl();
        return equipmentDao.updateEquipment(equipment);
    }
}
