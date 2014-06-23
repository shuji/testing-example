package junitbook.example.markdown;

@SuppressWarnings("serial")
public class MarkdownRuntimeException extends RuntimeException {

    public MarkdownRuntimeException(String message, Throwable cause) {
        super(message, cause);
    }

    public MarkdownRuntimeException(String message) {
        super(message);
    }

}
