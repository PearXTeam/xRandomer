package ru.pearx.xrandomer.patterns.elements.registry;

import ru.pearx.xrandomer.patterns.elements.IPatternElement;

/*
 * Created by mrAppleXZ on 15.04.18 16:58.
 */
public interface IPatternElementCreator
{
    IPatternElement create(String substitute);
}
