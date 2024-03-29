package builder;

public class Client {

    public static void main(String args[]){

        Director directorObj2 = new Director(new MBAStudentBuilder());

        Student mbaStudent = directorObj2.createStudent();

        System.out.println(mbaStudent.toString());

    }

}
