public class TMS {
    public static void main(String[] args) {
        SinglyLinkedList taskList=new SinglyLinkedList();

        Task task1=new Task(1,"Task 1","Pending");
        Task task2=new Task(2, "Task 2", "In Progress");
        Task task3=new Task(3,"Task 3","Completed");

        taskList.addTask(task1);
        taskList.addTask(task2);
        taskList.addTask(task3);

        System.out.println("Traversing tasks");
        taskList.traverseTasks();

        System.out.println("Searching tasks with Id 2");
        Task foundTask=taskList.searchTask(2);
        if(foundTask!=null){
            System.out.println("Found: "+foundTask);
        }
        else{
            System.out.println("Task not found");
        }

        System.out.println("Deleting tasks with TaskId: 1");
        taskList.deleteTask(1);

        System.out.println("\nTraversing tasks after deletion:");
        taskList.traverseTasks();
    }
}
