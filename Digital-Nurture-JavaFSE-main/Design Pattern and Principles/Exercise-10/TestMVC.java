public class TestMVC {
    public static void main(String[] args) {
        Student model = new Student("101", "Alice", "A");
        StudentView view = new StudentView();
        
        StudentController controller = new StudentController(model, view);
        
        System.out.println("--- Initial State ---");
        controller.updateView();
        
        System.out.println("--- Updating Student Record ---");
        controller.setStudentName("Alice Smith");
        controller.setStudentGrade("A+");
        controller.updateView();
    }
}
