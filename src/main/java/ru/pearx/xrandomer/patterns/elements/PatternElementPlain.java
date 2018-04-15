package ru.pearx.xrandomer.patterns.elements;

import java.util.Random;

/*
 * Created by mrAppleXZ on 15.04.18 16:34.
 */
public class PatternElementPlain implements IPatternElement
{
    private String text;

    public PatternElementPlain(String text)
    {
        this.text = text;
    }

    @Override
    public void apply(Random rand, StringBuilder sb)
    {
        sb.append(text);
    }
}
