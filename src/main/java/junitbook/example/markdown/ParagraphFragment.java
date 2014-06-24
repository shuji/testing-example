package junitbook.example.markdown;

import java.util.LinkedList;

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
