package junitbook.example.markdown;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Markdown {

    private static final Logger log = Logger.getLogger(Markdown.class.getName());

    public String toHtml(String text) {
        String ls = System.getProperty("line.separator");
        List<Fragment> framents = new FragmentParser(text).parse();
        log.log(Level.INFO, "{0}", framents);
        StringBuffer html = new StringBuffer();
        for (Fragment f : framents) {
            html.append(getConverter(f).toHtml(f)).append(ls);
        }
        return html.toString();
    }

    private HtmlConverter getConverter(Fragment f) {
        if (f instanceof HeaderFragment) return new HeaderHtmlConverter();
        if (f instanceof ParagraphFragment) return new ParagraphHtmlConverter();
        throw new Error();
    }

}
