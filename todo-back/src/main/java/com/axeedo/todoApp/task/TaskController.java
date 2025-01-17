package com.axeedo.todoApp.task;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class TaskController {
    private final TaskService taskService;

    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @GetMapping("/tasks")
    List<Task> getTasks(@RequestParam(name="done") Optional<Boolean> isDone) {
        return taskService.getTaskList(isDone);
    }

    @PostMapping("/tasks")
    Task createTask(@RequestBody Task task){
        return taskService.createTask(task);
    }

    @PutMapping("/tasks/{id}")
    Task updateTask(@PathVariable("id") Long id, @RequestBody Task task){
        return taskService.updateTask(id, task);
    }

    @DeleteMapping("/tasks/{id}")
    ResponseEntity<Object> deleteTask(@PathVariable("id") Long id){
        taskService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
