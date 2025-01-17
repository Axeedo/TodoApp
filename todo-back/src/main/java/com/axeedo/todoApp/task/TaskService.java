package com.axeedo.todoApp.task;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
public class TaskService {
    private final TaskRepository taskRepository;

    public TaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    public List<Task> getTaskList(Optional<Boolean> isDone) {
        if (isDone.isPresent()) {
            return taskRepository.findAllByIsDone(isDone.get());
        }else{
            return (List<Task>) taskRepository.findAll();
        }
    }

    public Task createTask(Task task){
        return taskRepository.save(task);
    }

    public Task updateTask(Long taskId, Task taskInput) {
        if(taskInput.getName() == null || taskInput.getDone() == null){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Missing required field in request body.");
        }
        Task task = taskRepository.findById(taskId)
                .orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND, "Entity not found"));
        task.setDone(taskInput.getDone());
        task.setName(taskInput.getName());
        return taskRepository.save(task);
    }

    public void delete(Long taskId){
        taskRepository.findById(taskId)
                .orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND, "Entity not found"));
        taskRepository.deleteById(taskId);
    }
}
