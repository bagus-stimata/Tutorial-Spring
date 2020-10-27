package com.example.springbootrest2basicsecurity.model;

import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository
public class DataRepository {
    public Map<Integer, Employee> mapEmployee = new HashMap<>();
    public DataRepository(){
        DataFactory.getEmployees().forEach(employee -> {
            mapEmployee.put(employee.getId(), employee);
        });
    }
}
