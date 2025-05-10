package br.cleancode.TaskManager.service;

import br.cleancode.TaskManager.exception.ResourceNotFoundException;
import br.cleancode.TaskManager.dto.TaskDTO;
import br.cleancode.TaskManager.model.Task;
import br.cleancode.TaskManager.repository.TaskRepository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TaskService {
    private final TaskRepository taskRepository;

    public TaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    @Transactional(readOnly = true)
    public List<TaskDTO> getAllTasks() {
        return taskRepository.findAll().stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public TaskDTO getTaskById(Long id) {
        Task task = findTaskOrThrow(id);
        return convertToDto(task);
    }

    @Transactional
    public TaskDTO createTask(TaskDTO taskDto) {
        Task task = new Task(
                taskDto.getTitle(),
                taskDto.getDescription(),
                taskDto.isCompleted(),
                taskDto.getCreatedAt(),
                taskDto.getUpdatedAt()
        );

        Task savedTask = taskRepository.save(task);
        return convertToDto(savedTask);
    }

    @Transactional
    public TaskDTO updateTask(Long id, TaskDTO taskDto) {
        Task existingTask = findTaskOrThrow(id);

        existingTask.setTitle(taskDto.getTitle());
        existingTask.setDescription(taskDto.getDescription());
        existingTask.setCompleted(taskDto.isCompleted());

        Task updatedTask = taskRepository.save(existingTask);
        return convertToDto(updatedTask);
    }

    @Transactional
    public void deleteTask(Long id) {
        Task task = findTaskOrThrow(id);
        taskRepository.delete(task);
    }

    private Task findTaskOrThrow(Long id) {
        return taskRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Task not found with id: " + id));
    }

    private TaskDTO convertToDto(Task task) {
        return new TaskDTO(
                task.getTitle(),
                task.getDescription(),
                task.isCompleted(),
                task.getCreatedAt(),
                task.getUpdatedAt()
        );
    }
}
