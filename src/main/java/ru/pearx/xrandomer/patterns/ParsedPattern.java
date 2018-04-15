package ru.pearx.xrandomer.patterns;

import ru.pearx.carbide.StringUtils;
import ru.pearx.carbide.Tuple;
import ru.pearx.xrandomer.patterns.elements.IPatternElement;
import ru.pearx.xrandomer.patterns.elements.PatternElementPlain;
import ru.pearx.xrandomer.patterns.elements.registry.PatternElementRegistry;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/*
 * Created by mrAppleXZ on 15.04.18 16:24.
 */
public class ParsedPattern
{
    public enum ParseMode
    {
        PLAIN,
        PARSE_SUBSTITUTE,
        PARSE_COUNT
    }
    public static ParsedPattern parse(String pattern)
    {
        return new ParsedPattern(pattern);
    }

    private List<Tuple<IPatternElement, Integer>> elements = new ArrayList<>();

    private ParsedPattern(String s)
    {
        ParseMode parse = ParseMode.PLAIN;
        StringBuilder sequence = new StringBuilder();
        StringBuilder countSequence = new StringBuilder();
        for (int i = 0; i < s.length(); i++)
        {
            char ch = s.charAt(i);

            if(parse == ParseMode.PARSE_SUBSTITUTE)
            {
                if(ch == '}')
                {
                    if(s.length() > i + 1 && s.charAt(i + 1) == '[')
                    {
                        parse = ParseMode.PARSE_COUNT;
                        i++;
                    }
                    else
                    {
                        parse = ParseMode.PLAIN;
                        pushText(true, sequence, 1);
                    }
                }
                else
                    sequence.append(ch);
            }
            else if(parse == ParseMode.PARSE_COUNT)
            {
                if (ch == ']')
                {
                    parse = ParseMode.PLAIN;
                    pushText(true, sequence, StringUtils.parseInt(countSequence.toString(), 1));
                    countSequence.setLength(0);
                }
                else
                    countSequence.append(ch);
            }
            else
            {
                //${ parser
                if (ch == '$' && s.length() > i + 1 && s.charAt(i + 1) == '{')
                {
                    parse = ParseMode.PARSE_SUBSTITUTE;
                    i++;
                    pushText(false, sequence, 1);
                }
                else
                {
                    sequence.append(ch);
                }
            }
        }
        pushText(parse != ParseMode.PLAIN, sequence, 1);
    }

    private void pushText(boolean parse, StringBuilder sequence, int times)
    {
        if(sequence.length() > 0)
        {
            IPatternElement elem = parse ? PatternElementRegistry.create(sequence.toString()) : new PatternElementPlain(sequence.toString());
            elements.add(new Tuple<>(elem, times));
            sequence.setLength(0);
        }
    }

    public String generate(Random rand)
    {
        StringBuilder sb = new StringBuilder();
        for(Tuple<IPatternElement, Integer> el : elements)
            for(int i = 0; i < el.getRight(); i++)
                el.getLeft().apply(rand, sb);
        return sb.toString();
    }
}
