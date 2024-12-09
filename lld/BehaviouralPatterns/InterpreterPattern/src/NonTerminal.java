public class NonTerminal implements IExpression {

    IExpression leftExpression;
    IExpression rightExpression;
    char operator;

    public NonTerminal(IExpression leftExpression, IExpression rightExpression, char operator) {
        this.leftExpression = leftExpression;
        this.rightExpression = rightExpression;
        this.operator = operator;
    }
    @Override
    public int interpret(Context context) {
        switch (operator) {
            case '+':
                return leftExpression.interpret(context) + rightExpression.interpret(context);
            case '-':
                return leftExpression.interpret(context) - rightExpression.interpret(context);
            case '*':
                return leftExpression.interpret(context) * rightExpression.interpret(context);
        }
        return -1;
    }
}
