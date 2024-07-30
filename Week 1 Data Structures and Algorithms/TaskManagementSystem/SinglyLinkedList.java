public class SinglyLinkedList{
    private class Node{
        Task task;
        Node next;

        Node(Task task){
            this.task=task;
            this.next=null;
        }
    }
    private Node head;

    public SinglyLinkedList(){
            head=null;
    }

    public void addTask(Task task){
        Node newNode=new Node(task);
        if(head==null){
            head=newNode;
        }
        else{
            Node temp=head;
            while(temp.next!=null){
                temp=temp.next;
            }
            temp.next=newNode;
        }
    }

    public Task searchTask(int taskId){
        Node temp=head;
        while(temp!=null){
            if(temp.task.getTaskId()==taskId){
                return temp.task;
            }
            temp=temp.next;
        }
        return null;
    }

    public void traverseTasks() {
        Node temp = head;
        while (temp != null) {
            System.out.println(temp.task);
            temp = temp.next;
        }
    }
    public void deleteTask(int taskId) {
        if (head == null) {
            return;
        }

        if (head.task.getTaskId() == taskId) {
            head = head.next;
            return;
        }

        Node temp = head;
        while (temp.next != null && temp.next.task.getTaskId() != taskId) {
            temp = temp.next;
        }

        if (temp.next != null) {
            temp.next = temp.next.next;
        }
    }
}