package junitbook.example.markdown;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.logging.LogManager;
import java.util.stream.Collectors;

import org.junit.Test;

public class MarkdownTest {

    static {
        try {
            LogManager.getLogManager().readConfiguration(MarkdownTest.class.getResourceAsStream("/log.properties"));
        } catch (SecurityException | IOException e) {
            throw new Error(e);
        }
    }

    @Test
    public void case01() throws Exception {
        // Setup
        Markdown sut = new Markdown();
        String input = load("01.input.txt");
        String expected = load("01.expected.txt");
        String actual = sut.toHtml(input);
        assertThat(actual, is(expected));
    }

    private static String load(String resourceName) throws IOException {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(
                MarkdownTest.class.getResourceAsStream(resourceName)))) {
            return br.lines().collect(Collectors.joining("\n")) + "\n";
        }
    }
}
