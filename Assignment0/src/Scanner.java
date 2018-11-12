import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

public class Scanner implements IScanner {
	public static final char NULL = (char)0;
	public static final char EOF = (char)-1; // End of file.

	private FileInputStream stream = null;
	private InputStreamReader reader = null;
	private char current = NULL;
	
	public Scanner() {

	}


	/**
	 * Opens a file for scanning.
	 */
	public void open(String fileName) throws FileNotFoundException {
		stream = new FileInputStream(fileName);
		reader = new InputStreamReader(stream);
	}


	public char current() {
		return current;
	}

	/**
	 * Moves current to the next character in the stream.
	 */
	public void moveNext() throws IOException {
		if (reader == null)
			throw new IOException("No open file.");
		if (current != EOF)
			current = (char)reader.read();
	}

	/**
	 * Closes the file and releases any system resources associated with it.
	 */
	public void close() throws IOException {
		if (reader != null)
			reader.close();
		if (stream != null)
			stream.close();
	}
}
