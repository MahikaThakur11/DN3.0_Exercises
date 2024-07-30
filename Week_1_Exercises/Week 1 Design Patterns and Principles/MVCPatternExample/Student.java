public class Student{
    private String name;
    private String id;
    private String grade;

    public String showId(){
        return id;
    }

    public String showName(){
        return name;
    }

    public String showGrade(){
        return grade;
    }

    public void setId(String id){
        this.id=id;
    }

    public void setName(String name){
        this.name=name;
    }

    public void setGrade(String grade){
        this.grade=grade;
    }
}