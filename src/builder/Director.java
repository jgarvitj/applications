package builder;

public class Director {

    StudentBuilder studentBuilder;

    Director(StudentBuilder studentBuilder) {
        this.studentBuilder = studentBuilder;
    }

    public Student createStudent() {
        if(studentBuilder instanceof MBAStudentBuilder) {
            return createMBAStudent();
        }
        return studentBuilder.build();
    }

    private Student createMBAStudent() {

        return studentBuilder.setAge(23).setName("gj").setSubjects().build();
    }
}
