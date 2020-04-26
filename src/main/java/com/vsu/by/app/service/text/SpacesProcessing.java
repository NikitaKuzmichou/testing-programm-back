package com.vsu.by.app.service.text;

import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class SpacesProcessing {

    public String deleteExcessSpaces(final String str, int maxNumSpaces) {
        StringBuilder sb = new StringBuilder(str.trim());
        for (int i = 0; i < sb.length(); ++i) {
            if (Objects.equals(' ', sb.charAt(i))) {
                int numSpaces = getNumSpaces(sb.toString(), ++i);
                if (numSpaces - maxNumSpaces >= 0) {
                    sb.delete(i, i + numSpaces);
                }
            }
        }
        return sb.toString();
    }

    public int getFirstSpace(final String str, int from) {
        for (int i = from; i < str.length(); ++i) {
            if (Objects.equals(' ', str.charAt(i))) {
                return i;
            }
        }
        return -1;
    }

    public int getFirstNonSpace(final String str, int from) {
        for (int i = from; i < str.length(); ++i) {
            if (!Objects.equals(' ', str.charAt(i))) {
                return i;
            }
        }
        return -1;
    }

    private int getNumSpaces(final String str, int start) {
        int numSpaces = 0;
        while (Objects.equals(' ', str.charAt(start))) {
            ++start;
            ++numSpaces;
        }
        return numSpaces;
    }
}
