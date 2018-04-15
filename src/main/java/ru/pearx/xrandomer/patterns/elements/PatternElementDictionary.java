package ru.pearx.xrandomer.patterns.elements;

import ru.pearx.carbide.RandomUtils;

import java.util.Random;

/*
 * Created by mrAppleXZ on 15.04.18 16:35.
 */
public class PatternElementDictionary implements IPatternElement
{
    private String dictionary;

    public PatternElementDictionary(String dictionary)
    {
        this.dictionary = dictionary;
    }

    @Override
    public void apply(Random rand, StringBuilder sb)
    {
        sb.append(RandomUtils.genChar(rand, dictionary));
    }
}
