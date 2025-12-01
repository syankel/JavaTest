public class TaskData {

    private static int idCounter = 0;
    private int id;
    private String title;
    private String description;
    private Status status;

    public enum Status {
        NEW, IN_PROGRESS, DONE
    }

    public TaskData() {
        this.title = "";
        this.description = "";
        this.status = Status.NEW;
        this.id = ++idCounter;
    }

    public TaskData(String title, String desc) {
        this.title = title;
        this.description = desc;
        this.status = Status.NEW;
        this.id = ++idCounter;
    }

    public TaskData(int id, String title, String desc, Status status) {
        this.id = id;
        this.title = title;
        this.description = desc;
        this.status = status;
    }

    public int getId() {
        return this.id;
    }

    public String getTitle() {
        return this.title;
    }

    public String getDescription() {
        return this.description;
    }

    public Status getStatus() {
        return this.status;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public void print() {
        System.out.println("the task id:" + this.id
                + " the task title:" + this.title
                + " the task description:" + this.description
                + " the task status:" + this.status);
    }
}
