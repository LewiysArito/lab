package org.example.dao;

import org.example.dao.BaseDaoImp;
import org.example.domain.Country;

public class CountryDao extends BaseDaoImp<Country, Integer> {
    public CountryDao() {super(Country.class);}
}