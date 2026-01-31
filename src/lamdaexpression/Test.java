package lamdaexpression;

public class Test {
    public static void main(String[] args) {
        Student engineeringst = new Student() {
            @Override
            public String getBio(String name) {
                return name + " an enginner";
            }
        };

        Student lawstudent =  name->{
            return name;
        };

        String bio = engineeringst.getBio("Neetesh");
        System.out.println(bio);
    }
}
