public class Terminal implements IExpression{

    String expression;

    public Terminal(String val) {
        expression = val;
    }

    @Override
    public int interpret(Context context) {
        return context.contextMap.get(expression);
    }

}
