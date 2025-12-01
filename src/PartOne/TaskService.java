package PartOne;

import java.util.List;
import java.util.stream.Collectors;
import java.util.Comparator;

public class TaskService {

    private TaskRepository repository;

    public TaskService(TaskRepository repository) {
        this.repository = repository;
    }

    public void addTask(String title, String description) {
        TaskData task = new TaskData(title, description);
        repository.addTask(task);
    }

    public void updateTask(TaskData task) {
        TaskData t = repository.getById(task.getId());
        if (t != null) {
            repository.updateTask(task, task.getId());
        }
    }

    public void UpdateStatusAsDone(TaskData task) {
        TaskData t = repository.getById(task.getId());
        if (t != null) {
            task.setStatus(TaskData.Status.DONE);
            repository.updateTask(task, task.getId());
        }
    }

    public void deleteTask(int id) {
        repository.deleteTask(id);
    }

    public TaskData getById(int id) {
        return repository.getById(id);
    }

    public List<TaskData> listAllTasks() {
        return repository.listAll();
    }

    public List<TaskData> searchTasks(String s) {
        return repository.listAll().stream()
                .filter(task -> task.getTitle().equals(s) || task.getDescription().equals(s))
                .collect(Collectors.toList());
    }

    public List<TaskData> storageAllTasksByStatus() {
        return repository.listAll().stream()
                .sorted(Comparator.comparing(TaskData::getStatus))
                .collect(Collectors.toList());
    }
}
