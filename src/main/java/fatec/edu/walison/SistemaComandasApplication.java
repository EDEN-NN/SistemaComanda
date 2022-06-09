package fatec.edu.walison;

import fatec.edu.walison.model.*;
import fatec.edu.walison.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.lang.reflect.Array;
import java.util.Arrays;

@SpringBootApplication
public class SistemaComandasApplication {

	public static void main(String[] args) {
		SpringApplication.run(SistemaComandasApplication.class, args);
	}

	@Bean
	CommandLineRunner run(ClientService userService, EmployeeService employeeService, OrdersService ordersService, ProductService productService, StoreService storeService, RoleService roleService) {
		return args -> {


			Role client = new Role(null,"CLIENT");
			roleService.saveRole(client);
			Role employee = new Role(null,"EMPLOYEE");
			roleService.saveRole(employee);
			Role store = new Role(null,"STORE");
			roleService.saveRole(store);

			Client walisoca = new Client("Walisoca",
					"123456",
					"walisoca@gmail.com",
					"949504437",
					"29/01/2001",
					"48024472805");
			walisoca.getRole().add(client);
			userService.saveClient(walisoca);
			Client johnsons = new Client("Johnsons",
					"123456",
					"johnsons@gmail.com",
					"949504437",
					"29/01/2002",
					"48024472810");
			johnsons.getRole().add(client);
			userService.saveClient(johnsons);
			Store zaazEsfihas = new Store("zaazesfihas",
					"esfihas",
					"12345678910",
					"zamoraesfihas@gmail.com",
					"40028922",
					"rua anesio pinto rosa, 203",
					"Esfiharia");
			zaazEsfihas.getRole().addAll(Arrays.asList(client, employee, store));
			storeService.saveStore(zaazEsfihas);
			Employee toguro = new Employee("Toguro",
					"projetinho",
					"48024472807",
					"togs@gmail.com",
					"970707070",
					"29/05/2022",
					null,
					zaazEsfihas);
			toguro.getRole().addAll(Arrays.asList(client, employee));
			employeeService.saveEmployee(toguro);
			Employee bluezao = new Employee("Bluezao",
					"porco",
					"48024472808",
					"bigazul@gmail.com",
					"970707070",
					"29/05/2022",
					null,
					zaazEsfihas);
			bluezao.getRole().addAll(Arrays.asList(client, employee));
			employeeService.saveEmployee(bluezao);
			Product esfihaTop = new Product(null, "Esfiha de pombo", 2.50, 10);
			productService.saveProduct(esfihaTop);
			zaazEsfihas.getProducts().add(esfihaTop);
			productService.saveProduct(esfihaTop);
			storeService.saveStore(zaazEsfihas);
			Orders orders = new Orders(null, walisoca, toguro);
			walisoca.setOrder(orders);
			walisoca.getOrder().setEmployee(toguro);
			ordersService.saveOrders(orders);
			toguro.setStore(zaazEsfihas);
			toguro.getOrders().add(walisoca.getOrder());
			zaazEsfihas.getEmployees().addAll(Arrays.asList(toguro, bluezao));
			userService.saveClient(walisoca);
			johnsons.setOrder(orders);
			johnsons.getOrder().setEmployee(bluezao);
			bluezao.getOrders().add(johnsons.getOrder());
			bluezao.setStore(zaazEsfihas);
			employeeService.saveEmployee(bluezao);
			employeeService.saveEmployee(toguro);
			storeService.saveStore(zaazEsfihas);
			userService.saveClient(walisoca);
			userService.saveClient(johnsons);
		};
	}

}
