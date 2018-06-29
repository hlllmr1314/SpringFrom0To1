package com.haley.spring0to1.dao;

import com.haley.spring0to1.domain.model.Demo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Component;

@Component
public interface DemoRepository extends JpaRepository<Demo, Integer> {


    @Query(value = "select demo_name from demo where id=?", nativeQuery = true)
    String findDemoNameById(Integer id);

}
