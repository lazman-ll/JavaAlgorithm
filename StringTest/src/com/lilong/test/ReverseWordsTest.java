package com.lilong.test;

import com.lilong.java.ReverseWords;
import org.junit.jupiter.api.Test;

public class ReverseWordsTest {

    @Test
    public void test01(){
        ReverseWords sample = new ReverseWords();
        sample.reverseWords("the sky is blue");
    }
}
