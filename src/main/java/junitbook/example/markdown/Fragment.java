package junitbook.example.markdown;

import java.util.LinkedList;

abstract class Fragment {

    LinkedList<String> lines = new LinkedList<>();

    void appendLines(StringBuffer buf) {
        for (String line : lines) {
            buf.append(line).append("\n");
        }
    }
}

class ParagraphFragment extends Fragment {

    ParagraphFragment(LinkedList<String> lines) {
        this.lines.addAll(lines);
    }

    @Override
    public String toString() {
        StringBuffer buf = new StringBuffer();
        buf.append("ParagraphFragment\n");
        appendLines(buf);
        return buf.toString();
    }
}

class HeaderFragment extends Fragment {

    final int level;

    HeaderFragment(int level, LinkedList<String> lines) {
        this.level = level;
        this.lines.addAll(lines);
    }

    @Override
    public String toString() {
        StringBuffer buf = new StringBuffer();
        buf.append("HeaderFragment[level=").append(level).append("]\n");
        appendLines(buf);
        return buf.toString();
    }

}