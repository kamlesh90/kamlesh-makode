package com.flowable.flowboot.integ;


import org.flowable.engine.RepositoryService;
import org.flowable.engine.RuntimeService;
import org.flowable.engine.TaskService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class FlowableIntegrationApplication {

	public static void main(String[] args) {
		SpringApplication.run(FlowableIntegrationApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner init(final RepositoryService repositoryService,
			  					  final TaskService taskService,
								  final RuntimeService runtimeService
								  ) {
		return new CommandLineRunner() {

			public void run(String... args) throws Exception {
				System.out.println("No of Process Definitions :"+repositoryService.createProcessDefinitionQuery().count());
				System.out.println("No of Tasks :"+taskService.createTaskQuery().count());
				
				System.out.println("No of Tasks after process start :"+taskService.createTaskQuery().count());
			}
		};
	}
	
}
