package com.haley.spring0to1.domain.model;

import org.springframework.stereotype.Component;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Component
@Entity
public class Demo {

    @Id  //主键
    @GeneratedValue //自增
    private Integer id;

    @Column(name = "demo_name", nullable = true, length = 20)
    private String demoName;

    private Integer demoSize;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDemoName() {
        return demoName;
    }

    public void setDemoName(String demoName) {
        this.demoName = demoName;
    }

    public Integer getDemoSize() {
        return demoSize;
    }

    public void setDemoSize(Integer demoSize) {
        this.demoSize = demoSize;
    }

    @Override
    public String toString() {
        return "Demo{" +
                "id=" + id +
                ", demoName='" + demoName + '\'' +
                ", demoSize=" + demoSize +
                '}';
    }
}
