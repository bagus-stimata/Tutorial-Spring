package com.example.springbootdata4jpaexttest.foo.repo;

import com.example.springbootdata4jpaexttest.foo.domain.Foo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface FooRepository extends JpaRepository<Foo, Long> {

  Foo findById(Long id);

}
