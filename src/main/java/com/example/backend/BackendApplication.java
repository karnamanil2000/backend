package com.example.backend;

import com.example.backend.entity.Employee;
import com.example.backend.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BackendApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(BackendApplication.class, args);
	}

	@Autowired
	private EmployeeRepository employeeRepository;

	@Override
	public void run(String... args) throws Exception {

		Employee employee1 = Employee.builder()
				.firstName("Ramesh")
				.lastName("Fadatare")
				.email("ramesh@gmail.com")
				.build();

		Employee employee2 = Employee.builder()
				.firstName("Tony")
				.lastName("Stark")
				.email("tony@gmail.com")
				.build();

		Employee employee3 = Employee.builder()
				.firstName("John")
				.lastName("Cena")
				.email("john@gmail.com")
				.build();

		Employee employee4 = Employee.builder()
				.firstName("John")
				.lastName("Cena")
				.email("john@gmail.com")
				.build();

		employeeRepository.save(employee1);
		employeeRepository.save(employee2);
		employeeRepository.save(employee3);
		employeeRepository.save(employee4);

	}
}
