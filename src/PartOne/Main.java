package PartOne;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        TaskRepository repository = new TaskRepository();
        TaskService service = new TaskService(repository);

        try (Scanner scanner = new Scanner(System.in)) {

            System.out.println("Welcome to the Task Management System!");
            while (true) {
                System.out.println("\nChoose an option:");
                System.out.println("1. Add Task");
                System.out.println("2. Update Task");
                System.out.println("3. Mark Task as Done");
                System.out.println("4. Delete Task");
                System.out.println("5. View All Tasks");
                System.out.println("6. Search Tasks by Title/Description");
                System.out.println("7. View Tasks Sorted by Status");
                System.out.println("8. Exit");

                int choice = scanner.nextInt();
                scanner.nextLine();

                switch (choice) {
                    case 1:
                        System.out.print("Enter Title: ");
                        String title = scanner.nextLine();
                        System.out.print("Enter Description: ");
                        String description = scanner.nextLine();
                        service.addTask(title, description);
                        System.out.println("Task added successfully!");
                        break;
                    case 2:
                        System.out.print("Enter Task ID to Update: ");
                        int updateId = scanner.nextInt();
                        TaskData taskToUpdate = service.getById(updateId);
                        if (taskToUpdate != null) {
                            System.out.print("Enter New Title: ");
                            scanner.nextLine();
                            String newTitle = scanner.nextLine();
                            System.out.print("Enter New Description: ");
                            String newDescription = scanner.nextLine();

                            taskToUpdate.setTitle(newTitle);
                            taskToUpdate.setDescription(newDescription);
                            service.updateTask(taskToUpdate);
                            System.out.println("Task updated successfully!");
                        } else {
                            System.out.println("Task not found!");
                        }
                        break;
                    case 3:
                        System.out.print("Enter Task ID to Mark as Done: ");
                        int doneId = scanner.nextInt();
                        TaskData taskToMarkDone = service.getById(doneId);
                        if (taskToMarkDone != null) {
                            service.UpdateStatusAsDone(taskToMarkDone);
                            System.out.println("Task marked as done!");
                        } else {
                            System.out.println("Task not found!");
                        }
                        break;
                    case 4:
                        System.out.print("Enter Task ID to Delete: ");
                        int deleteId = scanner.nextInt();
                        TaskData taskToDelete = service.getById(deleteId);
                        if (taskToDelete == null) {
                            System.out.println("Task not found!");
                            break;
                        }
                        service.deleteTask(deleteId);
                        System.out.println("Task deleted successfully!");
                        break;
                    case 5:
                        System.out.println("All Tasks:");
                        for (TaskData task : service.listAllTasks()) {
                            task.print();
                        }
                        break;
                    case 6:
                        System.out.print("Enter Title/Description to Search: ");
                        String searchStr = scanner.nextLine();
                        System.out.println("Search Results:");
                        for (TaskData task : service.searchTasks(searchStr)) {
                            task.print();
                        }
                        break;
                    case 7:
                        System.out.println("Tasks Sorted by Status:");
                        for (TaskData task : service.storageAllTasksByStatus()) {
                            task.print();
                        }
                        break;
                    case 8:
                        System.out.println("Exiting... Goodbye!");
                        return;
                    default:
                        System.out.println("Invalid choice. Please try again.");
                } 
            }
        } 
        }
    }

