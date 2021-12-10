package com.nulp;

import com.nulp.command.*;
import com.nulp.config.MongoConfig;
import com.nulp.controller.LifecycleController;
import com.nulp.response.ResponseEntity;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.io.IOException;

public class Main extends Application {

    private static final ApplicationContext context = new AnnotationConfigApplicationContext(MongoConfig.class);
    private final LifecycleController lifecycleController = new LifecycleController(context);

    private BorderPane root;

    @Override
    public void init() throws Exception {
        root = new BorderPane();
        root.setStyle("-fx-background-color: GRAY");

        // Initializing control boxes
        VBox controlBoxHolder = new VBox();
        controlBoxHolder.setAlignment(Pos.CENTER);
        controlBoxHolder.setSpacing(10);
        controlBoxHolder.setPadding(new Insets(0, 20, 40, 20));

        HBox controlBox = new HBox();
        controlBox.setAlignment(Pos.CENTER);
        controlBox.setSpacing(25);

        VBox infoBox = new VBox();
        infoBox.setAlignment(Pos.CENTER);
        infoBox.setSpacing(20);
        infoBox.setPadding(new Insets(0, 20, 0, 20));

        // Initializing user control elements
        Text infoPanelText = new Text("Інформаційна панель");

        TextArea textField = new TextArea();
        textField.setFocusTraversable(false);
        textField.setFont(Font.font(16));
        textField.setEditable(false);

        Button showTariffsBtn = new Button("Камені");
        showTariffsBtn.setOnAction(event -> {
            ResponseEntity response = lifecycleController.executeCommand(ShowAvailableGemstonesCommand.NAME);
            textField.setText(response.toString());
        });

        Button clientsAmountBtn = new Button("Намисто");
        clientsAmountBtn.setOnAction(event -> {
            ResponseEntity response = lifecycleController.executeCommand(ShowNecklaceCommand.NAME);
            textField.setText(response.toString());
        });

        TextField gemIdField = new TextField();
        gemIdField.setPromptText("id каменя");
        gemIdField.setMaxWidth(90);

        Button addGemToNecklaceBtn = new Button("Додати камінь");
        addGemToNecklaceBtn.setOnAction(event -> {
            int gemId = Integer.parseInt(gemIdField.getText());
            lifecycleController.getCommandParams().put("gemId", gemId);
            ResponseEntity responseEntity = lifecycleController.executeCommand(AddGemstoneToNecklaceCommand.NAME);
            textField.setText(responseEntity.toString());
        });

        Button priceAndWeightBtn = new Button("Вага та ціна");
        priceAndWeightBtn.setOnAction(event ->  {
            ResponseEntity responseEntity = lifecycleController.executeCommand(NecklacePriceAndWeightCommand.NAME);
            textField.setText(responseEntity.toString());
        });

        // Sort part
        Button sortCostBtn = new Button("Сортувати (ціна)");
        sortCostBtn.setOnAction(event -> {
            ResponseEntity response = lifecycleController.executeCommand(SortByCostCommand.NAME);
            textField.setText(response.toString());
        });

        // Search in diapason part
        HBox diapasonSearchBox = new HBox();
        diapasonSearchBox.setAlignment(Pos.CENTER);
        diapasonSearchBox.setSpacing(20);

        TextField leftBound = new TextField();
        leftBound.setPromptText("Ліва межа");
        leftBound.setMaxWidth(90);

        TextField rightBound = new TextField();
        rightBound.setPromptText("Права межа");
        rightBound.setMaxWidth(90);

        Button searchInDiapasonBtn = new Button("Діапазон прозорості");
        searchInDiapasonBtn.setOnAction(event -> {
            double lb = Double.parseDouble(leftBound.getText());
            double rb = Double.parseDouble(rightBound.getText());

            lifecycleController.getCommandParams().put("lb", lb);
            lifecycleController.getCommandParams().put("rb", rb);

            ResponseEntity response = lifecycleController.executeCommand(TransparencyDiapasonCommand.NAME);
            textField.setText(response.toString());
        });

        diapasonSearchBox.getChildren().addAll(
                priceAndWeightBtn,
                searchInDiapasonBtn,
                leftBound,
                rightBound
        );

        controlBox.getChildren().addAll(
                showTariffsBtn,
                clientsAmountBtn,
                addGemToNecklaceBtn,
                gemIdField,
                sortCostBtn,
                diapasonSearchBox
        );

        infoBox.getChildren().addAll(
                infoPanelText,
                textField
        );

        controlBoxHolder.getChildren().addAll(
                controlBox,
                diapasonSearchBox
        );

        root.setCenter(infoBox);
        root.setBottom(controlBoxHolder);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        Scene scene = new Scene(root, 640, 480);
        primaryStage.setTitle("Курсува робота студента Засименка Н.О. КН-205");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) throws IOException {
        launch(args);
//        MongoTemplate mongoTemplate = new MongoTemplate(MongoClients.create("mongodb://localhost:27017"), "necklace-db");
//        mongoTemplate.createCollection(Gemstone.class);

//        Diamond diamond = new Diamond();
//        diamond.setName("White Diamond");
//        diamond.setUahPerCarat(new BigDecimal(2280));
//        diamond.setHardness(8);
//        diamond.setDiamondFormName("Heart");
//        diamond.setTransparency(9);
//        diamond.setWeightInCarats(5);
//
//        Ruby ruby = new Ruby();
//        ruby.setName("Royal Ruby");
//        ruby.setUahPerCarat(new BigDecimal(2600));
//        ruby.setHardness(6.5);
//        ruby.setTransparency(5);
//        ruby.setWeightInCarats(4);
//        ruby.setManufacturerCountry("Vietnam");

//        ApplicationContext context = new AnnotationConfigApplicationContext(MongoConfig.class);
    }
}
