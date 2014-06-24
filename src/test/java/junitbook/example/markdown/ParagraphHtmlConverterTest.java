package junitbook.example.markdown;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import org.junit.Test;

public class ParagraphHtmlConverterTest {

    @Test
    public void decorate() throws Exception {
        String line = "これは *Markdown* コンバータです。";
        String expected = "これは <strong>Markdown</strong> コンバータです。";
        ParagraphHtmlConverter sut = new ParagraphHtmlConverter();
        String actual = sut.decorate(line);
        assertThat(actual, is(expected));
    }
}
