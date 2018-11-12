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
    public Node parse() throws IOException, TokenizerException, ParserException {
        Node root = new Node(t);
        return root;
    }


    /**
     * Closes the file and releases any system resources associated with it.
     */
    @Override
    public void close() throws IOException  {

    }
}
