package com.haley.spring0to1.service;

import com.haley.spring0to1.dao.DemoRepository;
import com.haley.spring0to1.domain.model.Demo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class DemoService {

    @Autowired
    private DemoRepository demoRepository;

    @Transactional
    public Demo addDemo(Demo demo) {
        return demoRepository.save(demo);
    }


    @Transactional
    public void deleteDemo(Integer demoId) {
        demoRepository.delete(demoId);
    }

    @Transactional
    public Demo updateDemo(Demo demo) {
        return demoRepository.save(demo);
    }

    public Demo findOneDemo(Integer demoId) {
        return demoRepository.findOne(demoId);
    }

    public List<Demo> findAllDemo() {
        return demoRepository.findAll();
    }

}
