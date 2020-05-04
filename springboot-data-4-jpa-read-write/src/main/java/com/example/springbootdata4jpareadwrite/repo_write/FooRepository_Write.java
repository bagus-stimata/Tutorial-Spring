package com.example.springbootdata4jpareadwrite.repo_write;



import com.example.springbootdata4jpareadwrite.model.Foo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface FooRepository_Write extends JpaRepository<Foo, Long> {

    // Foo findById(Long id);

}
