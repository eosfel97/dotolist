package org.example.controller;

import org.example.model.Task;
import org.example.repository.TaskRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/tasks")
public class TaskController {
    private final TaskRepository taskRepository;

    public TaskController(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    @GetMapping
    public String listTasks(Model model) {
        var tasks = taskRepository.findByOrderByCreatedAtDesc();
        long completedCount = taskRepository.countByCompleted(true);
        long pendingCount = taskRepository.countByCompleted(false);

        model.addAttribute("tasks", tasks);
        model.addAttribute("completedCount", completedCount);
        model.addAttribute("pendingCount", pendingCount);
        return "tasks";
    }

    @PostMapping("/add")
    public String addTask(@RequestParam String description) {
        if (description != null && !description.trim().isEmpty()) {
            Task newTask = new Task(description.trim());
            taskRepository.save(newTask);
        }
        return "redirect:/tasks";
    }

    @PostMapping("/delete/{id}")
    public String deleteTask(@PathVariable Long id) {
        taskRepository.deleteById(id);
        return "redirect:/tasks";
    }

    @PostMapping("/toggle/{id}")
    public String toggleTask(@PathVariable Long id) {
        Task task = taskRepository.findById(id).orElse(null);
        if (task != null) {
            task.setCompleted(!task.isCompleted());
            taskRepository.save(task);
        }
        return "redirect:/tasks";
    }
}
