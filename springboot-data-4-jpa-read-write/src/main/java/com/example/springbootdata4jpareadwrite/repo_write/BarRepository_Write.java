package com.example.springbootdata4jpareadwrite.repo_write;




import com.example.springbootdata4jpareadwrite.model.Bar;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface BarRepository_Write extends JpaRepository<Bar, Long> {

  // Bar findById(Long id);

}
