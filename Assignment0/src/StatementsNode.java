public class StatementsNode implements INode {

    Lexeme lexeme;
    INode child;

    @Override
    public Object evaluate(Object[] args) throws Exception {
        return null;
    }

    @Override
    public void buildString(StringBuilder builder, int tabs) {

    }

    public void addLexeme(Lexeme lexeme) {this.lexeme = lexeme;}

    public void addChild(INode child) {this.child = child;}
}
