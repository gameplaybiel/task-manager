package br.cleancode.TaskManager;

import br.cleancode.TaskManager.dto.TaskDTO;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import jakarta.validation.ValidatorFactory;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.assertj.core.api.Assertions.assertThat;

public class TaskDTOTest {
    private final Validator validator;

    public TaskDTOTest() {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();
    }

    @Test
    void shouldCreateValidTaskDTO() {
        // Arrange
        TaskDTO dto = new TaskDTO(
                "Título válido",
                "Descrição válida dentro do limite",
                false,
                LocalDateTime.now(),
                null
        );

        // Act
        var violations = validator.validate(dto);

        // Assert
        assertThat(violations).isEmpty();
    }

    @Test
    void shouldFailWhenTitleIsBlank() {
        // Arrange
        TaskDTO dto = new TaskDTO(
                "", // Título inválido
                "Descrição válida",
                false,
                LocalDateTime.now(),
                null
        );

        // Act
        var violations = validator.validate(dto);

        // Assert
        assertThat(violations)
                .hasSize(1)
                .extracting("message")
                .contains("Title cannot be blank");
    }

    @Test
    void shouldFailWhenDescriptionExceedsMaxLength() {
        // Arrange
        String longDescription = "a".repeat(501); // 501 caracteres
        TaskDTO dto = new TaskDTO(
                "Título válido",
                longDescription,
                false,
                LocalDateTime.now(),
                null
        );

        // Act
        var violations = validator.validate(dto);

        // Assert
        assertThat(violations)
                .hasSize(1)
                .extracting("message")
                .contains("Description cannot exceed 500 characters");
    }
}
