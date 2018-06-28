package com.haley.spring0to1.dao;

import com.haley.spring0to1.domain.model.Demo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

@Component
public interface DemoRepository extends JpaRepository<Demo, Long> {

}
