public class ExpressionEvaluation {

    public static boolean infixToPostfix(String expression, List result, StackChar stack){

        char currentChar;

        for (int i = 0; i < expression.length(); i++){

            currentChar = expression.charAt(i);

            if (Character.isDigit(currentChar)) {
                StringBuilder numString = new StringBuilder();

                int k = i;

                while (k < expression.length() && Character.isDigit(expression.charAt(k))) {
                    numString.append(expression.charAt(k));
                    k++;
                }

                i = k - 1;

                String digit = String.valueOf(numString);
                result.append(digit);

            } else if (currentChar == '('){
                stack.push(currentChar);
            } else if (currentChar == ')') {

                char value = stack.top();

                while (value != '('){

                    result.append(String.valueOf(value));
                    stack.pop();
                    value = stack.top();

                    if (stack.isEmpty() && value != '('){
                        System.out.println("Error: Mismatched parentheses");
                        return false;
                    }

                }

                stack.pop();

            } else if (currentChar == '+' || currentChar == '-' ||
                       currentChar == '*' || currentChar == '/'){

                char value = currentChar;

                while ((!stack.isEmpty()) && (checkPrecedence(stack.top()) >= checkPrecedence(currentChar))){

                    result.append(String.valueOf(value));
                    stack.pop();
                    value = stack.top();

                }

                stack.push(currentChar);

            }
        }

        char value;

        while (!stack.isEmpty()){

            value = stack.top();

            if (value == '('){
                System.out.println("Error: Mismatched parentheses");
                return false;
            }

            result.append(String.valueOf(value));
            stack.pop();

        }


        return true;
    }

    public static int checkPrecedence(char newOperator){
        if (newOperator == '+' || newOperator == '-'){
            return 1;
        } else if (newOperator == '*' || newOperator == '/'){
            return 2;
        } else {
            return 0;
        }
    }

    public static Integer testExpressionEvaluation(String infixExpression, List postfix){
        StackChar cStack = new StackChar(postfix.listCapacity());
        if(infixToPostfix(infixExpression, postfix, cStack)) {
            StackInt iStack = new StackInt(postfix.listCapacity());
            return evaluatePostfix(postfix, iStack);
        }
        return null;
    }

    public static int evaluatePostfix(List postfixExpression, StackInt stack){

        String currentString;

        for (int i = 0; i < postfixExpression.size(); i++){

            currentString = postfixExpression.itemAt(i);

            if(Character.isDigit((currentString.charAt(0)))){
                stack.push(Integer.parseInt(currentString));
            } else if (currentString.equals("+") || currentString.equals("-") ||
                       currentString.equals("*") || currentString.equals("/")){

                int right = stack.top();
                stack.pop();
                int left = stack.top();
                stack.pop();

                int answer;

                if (currentString.equals("+")){
                    answer = left + right;
                } else if (currentString.equals("-")){
                    answer = left - right;
                } else if (currentString.equals("*")){
                    answer = left * right;
                } else {
                    answer = left / right;
                }

                stack.push(answer);

            }
        }

        return stack.top();

    }


}
