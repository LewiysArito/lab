package org.example.dao;

import org.example.dao.BaseDaoImp;
import org.example.domain.Village;

public class VillageDao extends BaseDaoImp<Village, Integer> {
    public VillageDao() {super(Village.class);}
}