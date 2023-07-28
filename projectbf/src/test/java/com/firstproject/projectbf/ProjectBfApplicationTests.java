package com.firstproject.projectbf;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;

@SpringBootTest
@ComponentScan(basePackages = "com.firstproject.projectbf") //se der erro remover este, dependencia mvc (pom.xml) e arquivo properties
class ProjectBfApplicationTests {

	@Test
	void contextLoads() {
	}

}
