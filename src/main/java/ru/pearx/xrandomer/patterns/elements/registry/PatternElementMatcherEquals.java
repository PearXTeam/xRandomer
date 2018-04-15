package ru.pearx.xrandomer.patterns.elements.registry;

import ru.pearx.xrandomer.patterns.elements.registry.IPatternElementMatcher;

/*
 * Created by mrAppleXZ on 15.04.18 17:27.
 */
public class PatternElementMatcherEquals implements IPatternElementMatcher
{
    private String key;

    public PatternElementMatcherEquals(String key)
    {
        this.key = key;
    }

    @Override
    public boolean matches(String substitute)
    {
        return key.equals(substitute);
    }
}
