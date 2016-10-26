package services;


import models.Auto;

import java.util.List;

public interface AutoService {
    List<Auto> getAllAuto();
    Auto findAuto(int id);
    void addAuto(Auto auto);
}
