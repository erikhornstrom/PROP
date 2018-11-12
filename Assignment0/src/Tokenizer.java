import java.io.IOException;

public class Tokenizer implements ITokenizer {
    private Scanner s = null;
    private Lexeme currentLexeme = null;

    @Override
    public void open(String fileName) throws IOException, TokenizerException {
        s = new Scanner();
        s.open(fileName);
    }

    @Override
    public Lexeme current() {
        return currentLexeme;
    }

    /*
    *Moves current to the next token in the stream.
    */
    
    @Override
    public void moveNext() throws IOException, TokenizerException {

        if (s != null) {
            s.moveNext();
            char current = s.current();
            String currentString = current + "";
            if (current == '\n' || current == '\t' || current == ' ' ) {
                s.moveNext();
            } else if (current == s.EOF) {
                currentLexeme = new Lexeme(currentString, Token.EOF);
            } else {
                switch(currentString) {
                    case "+": currentLexeme = new Lexeme(currentString, Token.ADD_OP); break;
                    case "=": currentLexeme = new Lexeme(currentString, Token.ASSIGN_OP); break;
                    case "-": currentLexeme = new Lexeme(currentString, Token.SUB_OP); break;
                    case "*": currentLexeme = new Lexeme(currentString, Token.MULT_OP); break;
                    case "/": currentLexeme = new Lexeme(currentString, Token.DIV_OP); break;
                    case "(": currentLexeme = new Lexeme(currentString, Token.LEFT_PAREN); break;
                    case ")": currentLexeme = new Lexeme(currentString, Token.RIGHT_PAREN); break;
                    case ";": currentLexeme = new Lexeme(currentString, Token.SEMICOLON); break;
                    case "{": currentLexeme = new Lexeme(currentString, Token.LEFT_CURLY); break;
                    case "}": currentLexeme = new Lexeme(currentString, Token.RIGHT_CURLY); break;
                    default:
                        if (currentString.matches("[a-z]")) {
                            currentLexeme = new Lexeme(currentString, Token.IDENT);
                        } else if (currentString.matches("\\d")) {
                            currentLexeme = new Lexeme(Double.parseDouble(currentString), Token.INT_LIT));
                        } else {
                            throw new TokenizerException("TokenizerException");
                        }
                }
            }
        }
    }

    @Override
    public void close() throws IOException {
        s.close();
    }
} §
