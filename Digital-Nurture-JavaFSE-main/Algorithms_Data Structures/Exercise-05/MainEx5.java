public class MainEx5 {
    public static void main(String[] args) {
        SinglyLinkedList taskList = new SinglyLinkedList();

        Task t1 = new Task("T001", "Design Database", "In Progress");
        Task t2 = new Task("T002", "Develop API", "Not Started");
        Task t3 = new Task("T003", "Write Tests", "Not Started");

        // Add
        taskList.addTask(t1);
        taskList.addTask(t2);
        taskList.addTask(t3);

        // Traverse
        taskList.traverseTasks();

        // Search
        System.out.println("Searching for T002...");
        Task found = taskList.searchTask("T002");
        if (found != null) {
            System.out.println("Found: " + found);
        }

        // Delete
        taskList.deleteTask("T002");
        
        // Traverse after deletion
        taskList.traverseTasks();
    }
}
