public class Main {

    public static void main(String[] args) {
        Context context = new Context();
        context.contextMap.put("a", 3);
        context.contextMap.put("b", 5);
        IExpression expression1 = new Terminal("a");
        IExpression expression2 = new Terminal("b");
        IExpression expression3 = new NonTerminal(expression1, expression2, '+');
        IExpression expression4 = new NonTerminal(expression1, expression2, '-');
        IExpression expression5 = new NonTerminal(expression3, expression4, '*');

        System.out.println(expression5.interpret(context));
    }
}
