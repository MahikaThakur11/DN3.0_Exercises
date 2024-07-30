public class StudentController {
    private Student model;
    private StudentView view;

    public StudentController(Student model, StudentView view){
        this.model=model;
        this.view=view;
    }

    public void setStudName(String name){
        model.setName(name);
    }

    public String showStudName(){
        return model.showName();
    }

    public void setID(String id){
        model.setId(id);
    }

    public String showID(){
        return model.showId();
    }

    public void setGrade(String grade){
        model.setGrade(grade);
    }

    public String showGrade(){
        return model.showGrade();
    }

    public void updateView(){
        view.displayStudentDetails(model.showName(), model.showId(), model.showGrade());
    }
}
