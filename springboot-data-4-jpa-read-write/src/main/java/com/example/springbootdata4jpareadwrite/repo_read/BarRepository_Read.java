package com.example.springbootdata4jpareadwrite.repo_read;




import com.example.springbootdata4jpareadwrite.model.Bar;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;



@Repository
public interface BarRepository_Read extends JpaRepository<Bar, Long> {

  // Bar findById(Long id);

}
