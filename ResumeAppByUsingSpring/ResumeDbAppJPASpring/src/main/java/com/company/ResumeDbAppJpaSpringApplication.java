package com.company;

import com.company.dao.impl.UserRepository;
import com.company.dao.impl.UserRepositoryCustom;
import com.company.entity.User;
import com.company.service.inter.UserServiceInter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import java.util.List;

@SpringBootApplication
@EnableCaching
public class ResumeDbAppJpaSpringApplication {

	public static void main(String[] args) {
		SpringApplication.run(ResumeDbAppJpaSpringApplication.class, args);
	}

	//	DI - Dipendency Injection
	//  IoC - Inversion Of Control, RMI
	@Autowired
	@Qualifier("userDao1")
	private UserRepositoryCustom userDao;
//

	@Autowired
	private UserServiceInter service;

//	@Bean
//	public CommandLineRunner run() {
//		CommandLineRunner clr = new CommandLineRunner(){
//
//			@Override
//			public void run(String... args) throws Exception {
//				List<User> list= service.getAll(null,null,null);
//
//				System.out.println("list size="+list.size());
//			}
//		};
//
//		return clr;
//	}


	@Autowired
	private UserServiceInter userService;

	@Autowired
	private UserRepository repo;

//	@Bean
//	public CommandLineRunner run() {
//		CommandLineRunner clr = new CommandLineRunner(){
//
//			@Override
//			public void run(String... args) throws Exception {
//
//				for(int i=0;i<10;i++){
//					repo.getAll(null,null,null);
//				}
//
//				repo.getById(6);//
//			}
//		};
//
//		return clr;
//	}

}
