package com.findamentosplatzi.springboot.fundamentos;

import com.findamentosplatzi.springboot.fundamentos.bean.MyBean;
import com.findamentosplatzi.springboot.fundamentos.bean.MyBeanWhitDependency;
import com.findamentosplatzi.springboot.fundamentos.bean.MyBeanWhitProperties;
import com.findamentosplatzi.springboot.fundamentos.component.ComponentDependency;
import com.findamentosplatzi.springboot.fundamentos.entity.User;
import com.findamentosplatzi.springboot.fundamentos.pojo.UserPojo;
import com.findamentosplatzi.springboot.fundamentos.repository.UserRepository;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.domain.Sort;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

@SpringBootApplication
public class FundamentosApplication implements CommandLineRunner {

	private Log LOGGER = LogFactory.getLog(FundamentosApplication.class);

	private ComponentDependency componentDependency;
	private MyBean myBean;
	private MyBeanWhitDependency myBeanWhitDependency;
	private MyBeanWhitProperties myBeanWhitProperties;
	private UserPojo userPojo;
	private UserRepository userRepository;

	public FundamentosApplication(@Qualifier("componentTwoImplement") ComponentDependency componentDependency, MyBean myBean, MyBeanWhitDependency myBeanWhitDependency, MyBeanWhitProperties myBeanWhitProperties, UserPojo userPojo, UserRepository userRepository) {
		this.componentDependency = componentDependency;
		this.myBean = myBean;
		this.myBeanWhitDependency = myBeanWhitDependency;
		this.myBeanWhitProperties = myBeanWhitProperties;
		this.userPojo = userPojo;
		this.userRepository = userRepository;
	}
	public static void main(String[] args) {
		SpringApplication.run(FundamentosApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
//		examplesBefore();
		saveUserInDataBase();
		getInformationJpqlFromUser();
	}

	private void getInformationJpqlFromUser() {
//		LOGGER.info("Usuario con jpql buscado por email: " +
//				userRepository.findByEmail("pedro@mail.com")
//				.orElseThrow(() -> new RuntimeException("No se encontro el usuario")));
//
//		userRepository.findAndSort("A", Sort.by("id").descending())
//				.stream()
//				.forEach(user -> LOGGER.info("Usuario con jpql buscado por nombre: " + user));
//
//		userRepository.findByName("pedro")
//				.stream()
//				.forEach(user -> LOGGER.info("Usuario con query metod buscado por nombre: " + user));
//
//		LOGGER.info("Usuario con quermetod por email y nombre: " +userRepository.findByEmailAndName("karen@domain.com","Karen")
//				.orElseThrow(() -> new RuntimeException("No se encontro el usuario")));
//
//		userRepository.findByNameLike("%a%")
//				.stream()
//				.forEach(user -> LOGGER.info("Usuario con query metod buscado por like nombre: " + user));
//
//		userRepository.findByNameOrEmail("paola",null)
//				.stream()
//				.forEach(user -> LOGGER.info("Usuario findByNameOrEmail: " + user));

		userRepository.findByBirthDateBetween(LocalDate.of(2021,1,1),LocalDate.of(2021,12,31))
				.stream()
				.forEach(user -> LOGGER.info("Usuario findByBirthDateBetween: " + user));
		userRepository.findByNameLikeOrderByIdDesc("%ar%")
				.stream()
				.forEach(user -> LOGGER.info("Usuario findByNameLikeOrderByIdDesc: " + user));
		userRepository.findByNameContainingOrderByIdDesc("ar")
				.stream()
				.forEach(user -> LOGGER.info("Usuario findByNameContainingOrderByIdDesc: " + user));
	}
	private void saveUserInDataBase(){
		LOGGER.info("Insertando Usuarios en la base de datos");
		User user1 = new User("Andres", "andres@mail.com", LocalDate.of(2000, 10, 10));
		User user2 = new User("pedro", "pedro@mail.com", LocalDate.of(2011, 5, 10));
		User user3 = new User("Andrea", "andrea@mail.com", LocalDate.of(2011, 11, 22));
		User user4 = new User("user4", "user4@mail.com", LocalDate.of(1995, 1, 12));
		User user5 = new User("Karen", "karen@domain.com", LocalDate.of(2021, 1, 1));
		User user6 = new User("Carlos", "carlos@domain.com", LocalDate.of(2021, 7, 7));
		User user7 = new User("Enrique", "enrique@domain.com", LocalDate.of(2021, 11, 12));
		User user8 = new User("Luis", "luis@domain.com", LocalDate.of(2021, 2, 27));
		User user9 = new User("Paola", "paola@domain.com", LocalDate.of(2021, 4, 10));
		User user10 = new User("John", "john@domain.com", LocalDate.of(2021, 3, 13));
		User user11 = new User("Marco", "marco@domain.com", LocalDate.of(2021, 12, 8));
		User user12 = new User("Daniela", "daniela@domain.com", LocalDate.of(2021, 9, 8));
		User user13 = new User("Marisol", "marisol@domain.com", LocalDate.of(2021, 6, 18));

		List<User> list = Arrays.asList(user1, user2, user3, user4, user5, user6, user7, user8, user9, user10, user11, user12, user13);
		list.stream().forEach(userRepository::save);
		LOGGER.info("Usuarios insertados en la base de datos con Exito..");
	}

	private void examplesBefore(){
		componentDependency.saludar();
		myBean.print();
		myBeanWhitDependency.printWithDependency();
		System.out.println(myBeanWhitProperties.function());
		System.out.println(userPojo.getEmail() + "-" + userPojo.getPassword()+"-" + userPojo.getAge());
		try{
			int value = 10/0;
			LOGGER.debug("Mi valor: " + value);
		}catch (Exception e){
			LOGGER.error("Esto es un error al dividir por cero"+e.getMessage());
		}
	}
}
