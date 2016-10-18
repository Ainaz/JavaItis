package services;


import dao.OwnersDao;
import models.Owner;

public class OwnersServiceImpl implements OwnersService {
    private OwnersDao ownersDao;

    public OwnersServiceImpl(OwnersDao ownersDao) {
        this.ownersDao = ownersDao;
    }

    public Owner findByOwnerInId(int id) {
        return ownersDao.find(id);
    }

    public void getAllOwners() {
        this.ownersDao.getAll();
    }

    public void deleteOwnerInId(int id) {
        this.ownersDao.delete(id);
    }

    public void addOwner(Owner owner) {
        this.ownersDao.add(owner);
    }

    public void updateOwner(Owner owner) {
        this.ownersDao.update(owner);
    }
}
