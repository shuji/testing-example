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

