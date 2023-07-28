package com.example.WebApp.CRUD1;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

//public interface AlienRepo extends CrudRepository<Alien,Integer> {
//
//    List<Alien> findByAname(String aname);
//    List<Alien> findByTech(String tech);
//    List<Alien> findByAidGreaterThan(int aid);
//
//    @Query("from Alien where tech=?1 order by aname")
//    List<Alien> findByTechSortedByName(String tech);
//}

public interface AlienRepo extends JpaRepository<Alien,Integer> {

    List<Alien> findByAname(String aname);
    List<Alien> findByTech(String tech);
    List<Alien> findByAidGreaterThan(int aid);

    @Query("from Alien where tech=?1 order by aname")
    List<Alien> findByTechSortedByName(String tech);
}
