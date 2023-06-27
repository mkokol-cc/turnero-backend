package com.sistema.examenes;


import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import com.mercadopago.MercadoPago;



@SpringBootApplication
@ComponentScan(basePackages = {"com.sistema"})
public class SistemaExamenesBackendApplication implements CommandLineRunner {


	public static void main(String[] args) {
		SpringApplication.run(SistemaExamenesBackendApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
        /*
		String url = "jdbc:postgresql://localhost:5432/cal2?serverTimezone=America/Argentina/Buenos_Aires";
        String username = "postgres";
        String password = "postgres";
        tenantService.changeTenant(url, username, password);
        */
		MercadoPago.SDK.setAccessToken("TEST-7405079288753970-041215-b9acfd241ad71407ba522bda572489f1-554532024");
	}
	
	
	/*
	@Autowired
    private ApplicationContext context;
    
    @PostConstruct
    public void imprimirBeans() {
        System.out.println("Beans registrados:");
        String[] nombresBeans = context.getBeanDefinitionNames();
        Arrays.sort(nombresBeans);
        for (String nombreBean : nombresBeans) {
            System.out.println(nombreBean);
        }
    }*/


}
