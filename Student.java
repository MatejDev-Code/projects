public class Student {

    private String name;
    private int ID;
    private double[] scores;
    private double total = 0;

    private double average;

    public Student(String newName, int newID){

        name = newName;
        ID = newID;

    }

    public void setScore(double[] newScores){

        scores = newScores;

    }

    public double getAverage(){

        double minimum = scores[0];

        for (int i = 0; i < scores.length; i++){
            if (scores[i] < minimum){
                minimum = scores[i];
            }
            total += scores[i];
        }

        total -= minimum;
        total /= 4;

        return total;
    }

    public String toString(){
        StringBuilder sb = new StringBuilder();

        sb.append(name).append(" (").append(ID).append("): ").append(getAverage());

        return sb.toString();
    }


}
