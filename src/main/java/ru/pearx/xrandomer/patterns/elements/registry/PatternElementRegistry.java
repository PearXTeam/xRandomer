package ru.pearx.xrandomer.patterns.elements.registry;

import ru.pearx.carbide.Alphabets;
import ru.pearx.carbide.Tuple;
import ru.pearx.xrandomer.patterns.elements.IPatternElement;
import ru.pearx.xrandomer.patterns.elements.PatternElementDictionary;
import ru.pearx.xrandomer.patterns.elements.PatternElementPlain;

import java.util.ArrayList;
import java.util.List;

/*
 * Created by mrAppleXZ on 15.04.18 16:54.
 */
public class PatternElementRegistry
{
    private static List<Tuple<IPatternElementMatcher, IPatternElementCreator>> elements = new ArrayList<>();

    public static List<Tuple<IPatternElementMatcher, IPatternElementCreator>> getElements()
    {
        return elements;
    }

    static
    {
        getElements().add(new Tuple<>(new PatternElementMatcherEquals("char"), (s) -> new PatternElementDictionary(Alphabets.ENGLISH)));
    }

    public static IPatternElement create(String s)
    {
        for(Tuple<IPatternElementMatcher, IPatternElementCreator> t : getElements())
        {
            if(t.getLeft().matches(s))
            {
                return t.getRight().create(s);
            }
        }
        return new PatternElementPlain(s);
    }
}
