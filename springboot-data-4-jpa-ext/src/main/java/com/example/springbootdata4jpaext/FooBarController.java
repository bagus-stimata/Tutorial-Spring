package com.example.springbootdata4jpaext;


import com.example.springbootdata4jpaext.bar.repo.BarRepository;
import com.example.springbootdata4jpaext.foo.repo.FooRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class FooBarController {

  private final FooRepository fooRepo;
  private final BarRepository barRepo;

  @Autowired
  FooBarController(FooRepository fooRepo, BarRepository barRepo) {
    this.fooRepo = fooRepo;
    this.barRepo = barRepo;
  }

  @RequestMapping("/foobar/{id}")
  public String fooBar(@PathVariable("id") Long id) {
    System.out.println("Oke dipanggil #### ##############");
    fooRepo.findAll();
    // Foo foo = fooRepo.findById(id)
    // Bar bar = barRepo.findById(id);

    // return foo.getFoo() + " " + bar.getBar() + "!";
    return null;
  }

}
