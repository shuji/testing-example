package junitbook.example.markdown;

import java.util.logging.Level;
import java.util.logging.Logger;


class HeaderHtmlConverter implements HtmlConverter {
    private static final Logger log = Logger.getLogger(HeaderHtmlConverter.class.getName());

    @Override
    public String toHtml(Fragment fragment) {
        log.log(Level.FINE, "{0}", fragment);
        if (!HeaderFragment.class.isInstance(fragment)) {
            throw new Error();
        }
        HeaderFragment header = (HeaderFragment) fragment;
        String text = fragment.lines.getFirst().substring(header.level + 1);
        return String.format("<h%s>%s</h%s>", header.level, text, header.level);
    }
}

