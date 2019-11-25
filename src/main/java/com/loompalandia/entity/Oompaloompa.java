package com.loompalandia.entity;

import javax.persistence.*;

@Entity
@Table(name="oompaloompa")
public class Oompaloompa {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    private Long id;

    private String name;
    private Integer age;
    private String job;
    private Integer height;
    private Integer weight;
    private String description;

    public Oompaloompa() {}

    public Oompaloompa(String name, Integer age, String job, Integer height, Integer weight, String description) {
        this.name = name;
        this.age = age;
        this.job = job;
        this.height = height;
        this.weight = weight;
        this.description = description;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public Integer getHeight() {
        return height;
    }

    public void setHeight(Integer height) {
        this.height = height;
    }

    public Integer getWeight() {
        return weight;
    }

    public void setWeight(Integer weight) {
        this.weight = weight;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Oompaloompa{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age='" + Integer.toString(age) + '\'' +
                ", job='" + job + '\'' +
                ", height='" + Integer.toString(height) + '\'' +
                ", weight='" + Integer.toString(weight) + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
