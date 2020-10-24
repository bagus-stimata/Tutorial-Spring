package com.example.springbootrest1basic.model;

import org.springframework.format.datetime.joda.DateTimeFormatterFactory;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Repository
public class DataRepository {
    public Map<Integer, Employee> mapEmployee = new HashMap<>();
    public DataRepository(){
        DataFactory.getEmployees().forEach(employee -> {
            mapEmployee.put(employee.getId(), employee);
        });
    }
}
