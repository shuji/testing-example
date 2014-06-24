package junitbook.example.markdown;

import java.util.LinkedList;

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
