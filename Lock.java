public class Lock {

    private int[] code;
    private int currentCode;
    private int[] allGuesses;
    private int guessCount;

    public Lock(int[] newCode){

        code = new int[3];
        code = newCode;

        allGuesses = new int[120];
        currentCode = 0;
        guessCount = 0;

    }

    public Lock(int code1, int code2, int code3){

        code = new int[3];

        code[0] = code1;
        code[1] = code2;
        code[2] = code3;

        allGuesses = new int[120];
        currentCode = 0;
        guessCount = 0;

    }

    public boolean isLocked(){
        return currentCode != 3;
    }

    public void guess(int newGuess){

        allGuesses[guessCount++] = newGuess;

        if (newGuess < code[currentCode]){
            System.out.println("Go up");
        } else if (newGuess > code[currentCode]){
            System.out.println("Go down");
        } else {
            System.out.println("Correct");
            currentCode++;
        }

    }

    public String guesses(){

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < guessCount; i ++){
            sb.append(allGuesses[i] + " ");
        }

        return sb.toString();

    }

    public String toString(){

        StringBuilder sb = new StringBuilder();

        sb.append("The codes are: ");
        for (int i = 0; i < code.length; i ++){
            sb.append(code[i] + " ");
        }

        return sb.toString();

    }

}
