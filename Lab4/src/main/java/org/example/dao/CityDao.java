package org.example.dao;

import org.example.dao.BaseDaoImp;
import org.example.domain.City;

public class CityDao extends BaseDaoImp<City, Integer> {
    public CityDao() {
        super(City.class);
    }
}