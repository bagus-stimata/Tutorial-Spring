package com.example.springbootdata4jpaexttest.bar.repo;

import com.example.springbootdata4jpaexttest.bar.domain.Bar;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;



@Repository
public interface BarRepository extends JpaRepository<Bar, Long> {

  Bar findById(Long id);

}
