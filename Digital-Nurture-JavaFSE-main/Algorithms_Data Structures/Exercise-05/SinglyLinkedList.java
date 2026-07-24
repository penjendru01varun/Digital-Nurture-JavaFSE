public class SinglyLinkedList {
    private Node head;

    public SinglyLinkedList() {
        this.head = null;
    }

    public void addTask(Task task) {
        Node newNode = new Node(task);
        if (head == null) {
            head = newNode;
        } else {
            Node current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }
        System.out.println("Added: " + task.getTaskName());
    }

    public Task searchTask(String taskId) {
        Node current = head;
        while (current != null) {
            if (current.task.getTaskId().equals(taskId)) {
                return current.task;
            }
            current = current.next;
        }
        return null;
    }

    public void traverseTasks() {
        System.out.println("--- Task List ---");
        if (head == null) {
            System.out.println("No tasks found.");
            return;
        }
        Node current = head;
        while (current != null) {
            System.out.println(current.task);
            current = current.next;
        }
        System.out.println("-----------------");
    }

    public void deleteTask(String taskId) {
        if (head == null) {
            System.out.println("Cannot delete. List is empty.");
            return;
        }

        if (head.task.getTaskId().equals(taskId)) {
            System.out.println("Deleted: " + head.task.getTaskName());
            head = head.next;
            return;
        }

        Node current = head;
        while (current.next != null && !current.next.task.getTaskId().equals(taskId)) {
            current = current.next;
        }

        if (current.next != null) {
            System.out.println("Deleted: " + current.next.task.getTaskName());
            current.next = current.next.next;
        } else {
            System.out.println("Task with ID " + taskId + " not found.");
        }
    }
}
