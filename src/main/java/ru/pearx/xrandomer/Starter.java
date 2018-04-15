package ru.pearx.xrandomer;

import javafx.application.Application;
import ru.pearx.xrandomer.gui.XRandomer;

/*
 * Created by mrAppleXZ on 13.04.18 17:19.
 */
public final class Starter
{
    private Starter() {}

    public static void main(String... args)
    {
        Application.launch(XRandomer.class, args);
    }
}
