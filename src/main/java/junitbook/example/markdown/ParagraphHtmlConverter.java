package junitbook.example.markdown;

import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class ParagraphHtmlConverter implements HtmlConverter {
    private static final Logger log = Logger.getLogger(ParagraphHtmlConverter.class.getName());

    @Override
    public String toHtml(Fragment fragment) {
        log.log(Level.FINE, "{0}", fragment);
        if (!ParagraphFragment.class.isInstance(fragment)) {
            throw new Error();
        }
        StringBuffer buf = new StringBuffer();
        buf.append("<p>");
        for (String line : fragment.lines) {
            buf.append(decorate(line));
        }
        buf.append("</p>");
        return buf.toString();
    }

    String decorate(String line) {
        String[] words = line.split("\\s");
        StringBuilder decorated = new StringBuilder();
        for (String word : words) {
            log.log(Level.FINEST, "decorate {0}", word);
            Pattern p = Pattern.compile("\\*(.+)\\*");
            Matcher m = p.matcher(word);
            if (m.matches()) {
                log.log(Level.FINE, "BOLD {0}", m.group(1));
                decorated.append(String.format("<strong>%s</strong> ", m.group(1)));
            } else {
                decorated.append(word).append(' ');
            }
        }
        return decorated.toString().trim();
    }

}
