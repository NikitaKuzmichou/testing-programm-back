package com.vsu.by.app.service;

import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class TextProcessing {
    public String deleteExcessSpaces(String str, int maxNumSpaces) {
        StringBuilder sb = new StringBuilder(str);
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

    private int getNumSpaces(String str, int start) {
        int numSpaces = 0;
        while (Objects.equals(' ', str.charAt(start))) {
            ++start;
            ++numSpaces;
        }
        return numSpaces;
    }
}
