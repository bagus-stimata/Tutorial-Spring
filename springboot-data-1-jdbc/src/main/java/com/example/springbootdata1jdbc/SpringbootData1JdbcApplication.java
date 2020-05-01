package com.example.springbootdata1jdbc;

import java.util.ArrayList;
import java.util.List;

import com.example.springbootdata1jdbc.model.Person;
import com.example.springbootdata1jdbc.repository.PersonJDBCRepository;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringbootData1JdbcApplication implements CommandLineRunner{

	Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	PersonJDBCRepository personJDBCRepository;

	/*
	Menggunakan CommandLineRunnerBisa
	*/
	@Override
	public void run(String... args) throws Exception {

		Person person1 = new Person();
		person1.setID(4);
		person1.setName("Elma Theana");
		person1.setAddress("Jalan Jalan Bos");

		try{
			personJDBCRepository.insert(person1);
		} catch (Exception e) {
			logger.error("Error simpan person");
			e.printStackTrace();
		}

		List<Person> list = new ArrayList<>();
		logger.info("Get Person Ukuran ", personJDBCRepository.findAll().size());
		logger.info("Get Person", list = personJDBCRepository.findAll());
		for (Person person: list) {
			logger.info(">>>> " + person.getID() + " : " + person.getName() + " >> " + person.getAddress() );
		}


	}



	public static void main(String[] args) {
		SpringApplication.run(SpringbootData1JdbcApplication.class, args);
	}

}
