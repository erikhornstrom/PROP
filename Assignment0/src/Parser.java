import java.io.FileNotFoundException;
import java.io.IOException;

public class Parser implements IParser {


    private Tokenizer t = null;


    /**
     * Opens a file for parsing.
     */
    @Override
    public void open(String fileName) throws IOException, TokenizerException {
        t = new Tokenizer();
        t.open(fileName);
        t.moveNext();
    }

    /**
     * Parses a program from file returning a parse tree (the root node of a parse tree).
     */
    @Override
    public INode parse() throws IOException, TokenizerException, ParserException {
        BlockNode rootNode = null;
        if (t.current().value() == Token.LEFT_CURLY) {
            rootNode = new BlockNode();
            rootNode.addLexeme(t.current());
            t.moveNext();
        } else {
            throw new ParserException("Parserexception: Expected LEFT CURLY");
        }

        rootNode.addChild(new StatementsNode());

        if(t.current().value() == Token.RIGHT_CURLY) {
            endNode = new BlockNode();
            endNode.addLexeme(t.current());
            t.moveNext();
        } else {
            throw new ParserException("Parserexception: Expected RIGHT_CURLY");
        }





        return rootNode;
    }


    /**
     * Closes the file and releases any system resources associated with it.
     */
    @Override
    public void close() throws IOException  {

    }
}
