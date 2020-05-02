package com.example.springbootdata2jdbc_ext;



import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.example.springbootdata2jdbc_ext.model.Person;
import com.example.springbootdata2jdbc_ext.model.Todo;
import com.example.springbootdata2jdbc_ext.repositories.PersonJDBCRepository;
import com.example.springbootdata2jdbc_ext.repositories.PersonRepositoryImpl;
import com.example.springbootdata2jdbc_ext.repositories.TodoJDBCRepository;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class SpringbootData2JdbcExtApplication implements CommandLineRunner{

	Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	PersonJDBCRepository personJDBCRepository;
	@Autowired
	TodoJDBCRepository todoJDBCRepository;


	//Second 
	@Autowired
	PersonRepositoryImpl personRepositoryImpl;

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

		Todo todo1 = new Todo();
		todo1.setID(6);
		todo1.setDescription("Maling");
		todo1.setDateFrom(LocalDate.now());
		todo1.setDateTo(LocalDate.now() );
		todo1.setPersonBean(person1);

		try {
			todoJDBCRepository.insert(todo1);
		} catch (Exception e) {
			logger.error("Error Save Todo");
			e.printStackTrace();
		}


		List<Person> list = new ArrayList<>();
		logger.info("Get Person Ukuran ", personJDBCRepository.findAll().size());
		logger.info("Get Person", list = personJDBCRepository.findAll());
		for (Person person: list) {
			logger.info(">>>> " + person.getID() + " : " + person.getName() + " >> " + person.getAddress() );
		}

		List<Todo> listDetil = new ArrayList<>();
		logger.info("Get Todo", listDetil = todoJDBCRepository.findAll() );
		for (Todo detilItem: listDetil) {
			logger.info(">>>> " + detilItem.getID() + " : " + detilItem.getDescription() + " >> " + detilItem.getDateFrom() + " >> " + detilItem.getDateTo() );
		}

		logger.info("Get Person Second Ukurun: ", list = personRepositoryImpl.findAll() );
		for (Person person: list) {
			logger.info("#### " + person.getID() + " : " + person.getName() + " >> " + person.getAddress() );
		}


	}

	public static void main(String[] args) {
		SpringApplication.run(SpringbootData2JdbcExtApplication.class, args);
	}


	//Tidak Efektif Brow: Terutama saat ditambahkan Bean. menjadi circular
	// public CommandLineRunner commandLineRunner(ApplicationContext ctx) {
	// 	return args -> {
	// 		List<Person> list = new ArrayList<>();
	// 		logger.info("Get Some Thing", list = personJDBCRepository.findAll());
	// 		for (Person person: list) {
	// 			logger.info(">>>> " + person.getID() + " : " + person.getName() + " >> " + person.getAddress());
	// 		}

	// 	};
	// }

	// @Bean
	// public CommandLineRunner commandLineRunner(ApplicationContext ctx) {
	// 	return args -> {
		
	// 		// System.out.println("Let's inspect the beans provided by Spring Boot:");
	// 		// String[] beanNames = ctx.getBeanDefinitionNames();
	// 		// Arrays.sort(beanNames);
	// 		// for (String beanName : beanNames) {
	// 		// 	System.out.println(beanName);
	// 		// }


	// 	};
		
	// }

}
