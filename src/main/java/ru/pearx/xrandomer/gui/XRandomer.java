package ru.pearx.xrandomer.gui;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import ru.pearx.carbide.ResourceContainer;
import ru.pearx.carbide.i18n.I18n;
import ru.pearx.carbide.i18n.I18nLoaderResources;
import ru.pearx.carbide.javafx.FXUtils;
import ru.pearx.xrandomer.gui.parents.InterfaceMain;

/*
 * Created by mrAppleXZ on 13.04.18 17:19.
 */
public class XRandomer extends Application
{
    public static XRandomer INSTANCE;

    private I18n i18n;

    public I18n getI18n()
    {
        return i18n;
    }

    @Override
    public void start(Stage stage)
    {
        INSTANCE = this;

        i18n = new I18n(new I18nLoaderResources(new ResourceContainer(getClass().getClassLoader(), "assets/xrandomer/lang")), "en_us");
        i18n.loadSystemLocale(true);

        stage.setTitle(getI18n().format("general.title"));
        stage.setScene(new Scene(new InterfaceMain()));
        stage.show();
        FXUtils.setMinSize(stage, 512, 256);
    }
}
