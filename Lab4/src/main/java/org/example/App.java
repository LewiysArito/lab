package org.example;


import org.example.dao.CityDao;
import org.example.dao.CountryDao;
import org.example.dao.VillageDao;
import org.example.domain.City;
import org.example.domain.Country;
import org.example.domain.Village;
import org.example.util.HibernateUtil;
import org.hibernate.Metamodel;
import org.hibernate.Session;
import org.hibernate.query.Query;
import javax.persistence.metamodel.EntityType;


public class App {
    public static void main( String[] args ) throws Exception{
        final Session session = HibernateUtil.getSession();

        CountryDao countryDao = new CountryDao();
        Country country = new Country();

        country.setName("Россия");
        country.setCapital("Москва");
        country.setSquare(17098246);
        country.setPopulation(146980061);
        countryDao.save(country);


        VillageDao villageDao= new VillageDao();
        Village village= new Village();

        village.setName("Каневская");
        village.setPopulation(98903);
        village.setCountry(country);
        village.setFoundingDate(1794);;
        villageDao.save(village);

        CityDao cityDao= new CityDao();
        City city = new City();

        city.setName("Москва");
        city.setPopulation(13097539);
        city.setCountry(country);
        city.setFoundingDate(1147);
        cityDao.save(city);

        try {
            System.out.println("quering all the managed entities...");
            final Metamodel metamodel = session.getSessionFactory().getMetamodel();// получает информацию о сущностях из сессии
            for (EntityType<?> entityType : metamodel.getEntities()) {
                final String entityName = entityType.getName();//тут выполняется запрос для каждой сущности
                final Query query = session.createQuery("from " + entityName);//выполняет запрос к каждой сущности
                System.out.println("executing: " + query.getQueryString());
                for (Object o : query.list()) {
                    System.out.println(" " + o);//вывод списка объектов внутри сущности
                }
            }
        }finally {
            session.close();
        }
    }
}
