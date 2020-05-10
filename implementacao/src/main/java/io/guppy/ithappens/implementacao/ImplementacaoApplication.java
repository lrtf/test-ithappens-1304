package io.guppy.ithappens.implementacao;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
public class ImplementacaoApplication {

	public static void main(String[] args) {
		SpringApplication.run(ImplementacaoApplication.class, args);
	}

}
