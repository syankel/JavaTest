package PartOne;

import java.io.*;
import java.nio.file.*;
import java.util.*;

public class TaskRepository {
    private final String filePath;
    private Map<Integer, TaskData> taskMap = new HashMap<>();

    public TaskRepository() {
        this.filePath = "\\Tasks_JSON.JSON";
        loadFromFile();
    }

    public void loadFromFile() {
        Path path = Paths.get(filePath);
        if (!Files.exists(path)) {
            try {
                Files.writeString(path, "[]", StandardOpenOption.CREATE_NEW);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        try {
            String content = Files.readString(path).trim();
            if (content.isEmpty() || content.equals("[]")) {
                return;
            }
            String[] lines = content.split("\n");
            for (String line : lines) {
                String[] parts = line.split(", ");
                if (parts.length < 4)
                    continue;
                int id = Integer.parseInt(parts[0].split(": ")[1]);
                String title = parts[1].split(": ")[1];
                String description = parts[2].split(": ")[1];
                TaskData.Status status = TaskData.Status.valueOf(parts[3].split(": ")[1]);
                TaskData task = new TaskData(id, title, description, status);
                taskMap.put(id, task);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void writeToFile() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            writer.write("[\n");
            boolean first = true;
            for (TaskData task : taskMap.values()) {
                if (!first) {
                    writer.write(",\n");
                }
                writer.write("  {\n" +
                        "    \"ID\": " + task.getId() + ",\n" +
                        "    \"Title\": \"" + task.getTitle() + "\",\n" +
                        "    \"Description\": \"" + task.getDescription() + "\",\n" +
                        "    \"Status\": \"" + task.getStatus() + "\"\n" +
                        "  }");
                first = false;
            }
            writer.write("\n]");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public TaskData addTask(TaskData task) {
        int newId = taskMap.size() + 1;
        task.setId(newId);
        taskMap.put(task.getId(), task);
        writeToFile();
        return task;
    }

    public TaskData updateTask(TaskData task, int id) {
        if (taskMap.containsKey(id)) {
            taskMap.put(id, task);
            writeToFile();
            return task;
        }
        return null;
    }

    public Boolean deleteTask(int id) {
        if (!taskMap.containsKey(id)) {
            return false;
        }
        taskMap.remove(id);
        writeToFile();
        return true;
    }

    public TaskData getById(int id) {
        return taskMap.get(id);
    }

    public List<TaskData> listAll() {
        return new ArrayList<>(taskMap.values());
    }
}
