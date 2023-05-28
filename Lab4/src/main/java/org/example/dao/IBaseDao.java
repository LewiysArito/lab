package org.example.dao;


import java.io.Serializable;
import java.util.List;

public interface IBaseDao<T, Id extends Serializable> {
    Id save (T entity);//сохраняет сущность в бд, вовзращает идентификатор
    void update (T entity);//обновляет базу данных
    T findOne(Id id);//получает сущность из бд по идентификатору id
    List<T> findAll();// получает списко всех существующих сущностей
    void delete(T entity);//удаление сущностей
}
