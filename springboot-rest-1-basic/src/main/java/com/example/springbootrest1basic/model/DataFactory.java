package com.example.springbootrest1basic.model;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class DataFactory {
    public static Collection<Employee> getEmployees(){
        Map<Integer, Employee> mapEmployee = new HashMap<>();

        Employee emp1 = new Employee();
        emp1.setName("Bagus Winarno");
        emp1.setDesignation("manager");
        emp1.setId(1);
        emp1.setSalary(3000);
        mapEmployee.put(1, emp1);

        Employee emp2 = new Employee();
        emp2.setName("Anis Winarni");
        emp2.setDesignation("IT");
        emp2.setId(2);
        emp2.setSalary(4500);
        mapEmployee.put(2, emp2);

        Employee emp3 = new Employee();
        emp3.setName("Tyat");
        emp3.setDesignation("operator");
        emp3.setId(3);
        emp3.setSalary(3000);
        mapEmployee.put(3, emp3);

        Employee emp4 = new Employee();
        emp4.setName("Kasiati");
        emp4.setDesignation("Admin");
        emp4.setId(4);
        emp4.setSalary(2700);
        mapEmployee.put(4, emp4);

        return mapEmployee.values();
    }
}
