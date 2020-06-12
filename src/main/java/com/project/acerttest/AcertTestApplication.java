package com.project.acerttest;

import java.util.stream.LongStream;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.project.acerttest.model.Converted;
import com.project.acerttest.repository.ConvertedRepository;

@SpringBootApplication
public class AcertTestApplication {

	public static void main(String[] args) {
		SpringApplication.run(AcertTestApplication.class, args);
	}

	 @Bean
	    CommandLineRunner init(
	    		ConvertedRepository repository) {
	        return args -> {
	            repository.deleteAll();
	            LongStream.range(1, 6)
	                    .mapToObj(i -> {
	                        Converted c = new Converted();
	                        c.setOrigin("celsius");
	                        c.setDestiny("fahrenheit");
	                        c.setOriginValue(90 + i * 10);
	                        c.setConvertedValue(363 + i * 10);
	                        return c;
	                    })
	                    .map(v -> repository.save(v))
	                    .forEach(System.out::println);
	        };
	    }
}
