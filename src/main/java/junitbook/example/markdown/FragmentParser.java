package junitbook.example.markdown;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.StringReader;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

class FragmentParser {
    private static final Logger log = Logger.getLogger(FragmentParser.class.getName());

    BufferedReader reader;
    LinkedList<String> lines = new LinkedList<>();
    LinkedList<Fragment> fragments = new LinkedList<>();

    FragmentParser(String text) {
        this(new StringReader(text));
    }

    FragmentParser(InputStream input) {
        this(new InputStreamReader(input));
    }

    FragmentParser(Reader reader) {
        if (reader instanceof BufferedReader) {
            this.reader = (BufferedReader) reader;
        } else {
            this.reader = new BufferedReader(reader);
        }
    }

    List<Fragment> parse() {
        parseLines();
        parseFragments();
        return fragments;
    }

    private void parseLines() {
        try {
            for (;;) {
                String line = reader.readLine();
                if (line == null) break;
                lines.add(line);
            }
            log.log(Level.FINE, "lines {0}", lines);
        } catch (IOException e) {
            throw new MarkdownRuntimeException("Parse Error.", e);
        }
    }

    private void parseFragments() {
        LinkedList<String> buf = new LinkedList<>();
        outer: while (!lines.isEmpty()) {
            buf.clear();
            for (;;) {
                if (lines.isEmpty()) break;
                String line = lines.removeFirst();
                buf.add(line);
                if (line.matches("#+\\s.*")) {
                    int lv = line.lastIndexOf('#') + 1;
                    fragments.add(new HeaderFragment(lv, buf));
                    continue outer;
                }
            }
        }
        if (!buf.isEmpty()) {
            fragments.add(new ParagraphFragment(buf));
            buf.clear();
        }
    }
}
