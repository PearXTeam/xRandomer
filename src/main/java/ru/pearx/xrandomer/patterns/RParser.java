package ru.pearx.xrandomer.patterns;

import java.util.Random;
import java.util.function.Supplier;

/*
 * Created by mrAppleXZ on 15.04.18 16:21.
 */
public class RParser
{
    private Supplier<String> patternGetter;
    private String prevPattern;
    private ParsedPattern parsed;

    public RParser(Supplier<String> patternGetter)
    {
        this.patternGetter = patternGetter;
    }

    public String generate(Random rand)
    {
        String newPattern = patternGetter.get();
        if(parsed == null || !newPattern.equals(prevPattern))
        {
            prevPattern = newPattern;
            this.parsed = ParsedPattern.parse(patternGetter.get());
        }
        return parsed.generate(rand);
    }
}
