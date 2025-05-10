package br.cleancode.TaskManager;

import br.cleancode.TaskManager.model.Task;
import br.cleancode.TaskManager.repository.TaskRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class TaskIntegrationTest {

    @Autowired
    private TaskRepository taskRepository;

    @Test
    void shouldSaveAndRetrieveTask() {
        // Arrange
        Task task = new Task();
        task.setTitle("Teste Integração");
        task.setDescription("Descrição teste");
        task.setCreatedAt(LocalDateTime.now());

        // Act
        Task savedTask = taskRepository.save(task);
        Task foundTask = taskRepository.findById(savedTask.getId()).orElse(null);

        // Assert
        assertThat(foundTask).isNotNull();
        assertThat(foundTask.getTitle()).isEqualTo("Teste Integração");
    }
}
