package ru.pearx.xrandomer.gui.parents;

import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import ru.pearx.carbide.javafx.FXUtils;
import ru.pearx.xrandomer.gui.XRandomer;
import ru.pearx.xrandomer.patterns.RParser;

import java.util.Random;

/*
 * Created by mrAppleXZ on 15.04.18 10:49.
 */
public class InterfaceMain extends SplitPane
{
    public TextField code;
    public TextField out;
    public Button generate;
    public RParser parser = new RParser(() -> code.getText());
    public Random rand = new Random();

    public InterfaceMain()
    {
        super();

        StackPane leftPane = new StackPane();
        {
            VBox left = new VBox();
            left.setAlignment(Pos.CENTER);
            left.setMaxWidth(Double.POSITIVE_INFINITY);
            FXUtils.setSpacingAndPadding(left, 5);

            left.getChildren().add(FXUtils.createHalign(new Label(XRandomer.INSTANCE.getI18n().format("main.left.pattern")), Pos.BASELINE_LEFT));

            code = new TextField();
            left.getChildren().add(code);

            out = new TextField();
            out.setEditable(false);
            out.setMinHeight(35);
            left.getChildren().add(out);

            generate = new Button(XRandomer.INSTANCE.getI18n().format("main.left.generate"));
            generate.setMaxWidth(Double.POSITIVE_INFINITY);
            generate.addEventHandler(MouseEvent.MOUSE_CLICKED, (me) ->
                    out.setText(parser.generate(rand)));
            left.getChildren().add(generate);

            leftPane.getChildren().add(left);
        }


        StackPane rightPane = new StackPane();
        {
            TabPane tabs = new TabPane();
            tabs.setTabClosingPolicy(TabPane.TabClosingPolicy.UNAVAILABLE);
            Tab tabPatterns = new Tab(XRandomer.INSTANCE.getI18n().format("main.right.patterns"));
            Tab tabAutogen = new Tab(XRandomer.INSTANCE.getI18n().format("main.right.autogen"));
            tabs.getTabs().addAll(tabPatterns, tabAutogen);

            rightPane.getChildren().add(tabs);
        }

        setDividerPositions(0.7f);
        getItems().addAll(leftPane, rightPane);
    }
}
