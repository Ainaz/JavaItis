package services;

import models.Owner;

/**
 * Created by Ainaz on 18.10.2016.
 */
public interface OwnersService {
    Owner findByOwnerInId(int id);
    void getAllOwners();
    void deleteOwnerInId(int id);
    void addOwner(Owner owner);
    void updateOwner(Owner owner);
}
