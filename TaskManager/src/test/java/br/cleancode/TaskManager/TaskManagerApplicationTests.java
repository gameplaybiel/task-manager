package br.cleancode.TaskManager;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class TaskManagerApplicationTests {

	@Autowired
	private ApplicationContext context;

	@Test
	void contextLoads() {
		assertThat(context).isNotNull();
	}

	@Test
	void verifyMainBeansAreAvailable() {
		// Verifica se os beans essenciais estão carregados
		assertThat(context.getBean("taskController")).isNotNull();
		assertThat(context.getBean("taskService")).isNotNull();
		assertThat(context.getBean("taskRepository")).isNotNull();
	}
}
