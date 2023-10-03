/*
 * This Java source file was generated by the Gradle 'init' task.
 */

package com.crio.starter;
import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class App {

  public static void main(String[] args) {
    SpringApplication.run(App.class, args);
  }
  @Bean
	public ModelMapper modelMapper()
	{
		return new ModelMapper();
	}
}
