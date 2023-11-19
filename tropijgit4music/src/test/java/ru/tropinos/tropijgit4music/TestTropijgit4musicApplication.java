package ru.tropinos.tropijgit4music;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.test.context.TestConfiguration;

@TestConfiguration(proxyBeanMethods = false)
public class TestTropijgit4musicApplication {

	public static void main(String[] args) {
		SpringApplication.from(Tropijgit4musicApplication::main).with(TestTropijgit4musicApplication.class).run(args);
	}

}
