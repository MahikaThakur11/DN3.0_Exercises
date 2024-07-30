public class MVCTest {
    public static void main(String[] args) {
        Student student=new Student();
        student.setName("Patrick Smith");
        student.setId("8832");
        student.setGrade("A");

        StudentView view = new StudentView();

        StudentController controller=new StudentController(student, view);

        controller.updateView();
        controller.setStudName("Jane Doe");
        controller.setGrade("A+");

        controller.updateView();
    }
}
