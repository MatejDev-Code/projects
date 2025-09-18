public class Course {

    private String title;
    private int number;
    private String instructorName;
    private Student[] roster;
    private static final int DEFAULT_CAPACITY = 30;
    private int num_enrolled;

    public Course(String newTitle, int newNumber, String newInstructorName){
        title = newTitle;
        number = newNumber;
        instructorName = newInstructorName;

        roster = new Student[DEFAULT_CAPACITY];
        num_enrolled = 0;
    }

    public String getTitle(){
        return title;
    }

    public int getNumber(){
        return number;
    }

    public String getInstructorName(){
        return instructorName;
    }

    public int getEnrollmentCount(){
        return num_enrolled;
    }

    public boolean equals(Course c){
        return number == c.getNumber() && title.equals(c.getTitle());
    }

    public boolean add(Student s){

        if (num_enrolled == DEFAULT_CAPACITY){
            return false;
        }

        for (int i = 0; i < num_enrolled; i++){
            if(s.equals(roster[i])){
                return false;
            }
        }

        roster[num_enrolled++] = s;
        return true;

    }

    public boolean remove(Student s){

        int position = -1;

        for (int i = 0; i < num_enrolled; i++){
            if(s.equals(roster[i])){
                position = i;
            }
        }
        if (position != -1){
            for (int i = position; i < num_enrolled - 1; i++){
                roster[i] = roster[i+1];
            }

            roster[num_enrolled--] = null;
            return true;

        } else {
            return false;
        }

    }

    public String toString(){
        StringBuilder sb = new StringBuilder();

        sb.append("Course Title: " + title);
        sb.append("\n");
        sb.append("Course Number: " + number);
        sb.append("\n");
        sb.append("Instructor: " + instructorName);
        sb.append("\n");
        sb.append("Enrollment: " + num_enrolled);

        return sb.toString();
    }

    public void print(){
        System.out.println(this.toString());
        for (int i = 0; i < num_enrolled; i++){
            System.out.println("    " + roster[i].toString());
        }
    }



}
