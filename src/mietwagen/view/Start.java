package mietwagen.view;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.*;
import javafx.stage.Screen;
import javafx.stage.Stage;

public class Start extends Application {
	File file = new File("input.txt");
	Scanner sc = null;
	
	
	
	MietwagenTabelle mt = new MietwagenTabelle();

	public static void main(String[] args) {
		launch();

	}

	@Override
	public void start(Stage primaryStage) throws Exception {

		try {
			sc = new Scanner(file);
		}
		catch (FileNotFoundException e) {
			System.out.println("nu merge cititul");
			System.out.println(e);
		}
		
		primaryStage.setTitle("Mietwagen Unternehmen");

		BorderPane border = new BorderPane();
		MenuBar menuBar = new MenuBar();
		Menu menuFile = new Menu("File");

		

		MenuItem exit = new MenuItem("Exit");
		exit.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				System.exit(0);

			}
		});

		
		menuFile.getItems().add(exit);
		menuBar.getMenus().add(menuFile);

		border.setTop(menuBar);
		border.setCenter(mt.grid());
		border.setBottom(addMietwagen());

		Scene scene = new Scene(border);
		
		
		
		

		Screen screen = Screen.getPrimary();

		javafx.geometry.Rectangle2D bounds = screen.getVisualBounds();

		primaryStage.setX(bounds.getMinX());
		primaryStage.setY(bounds.getMinY());
		primaryStage.setWidth(bounds.getWidth());
		primaryStage.setHeight(bounds.getHeight());
		
		
		int id;
		String marke;
		Boolean vermietet; 
		String vermietetVon;
		Integer tag;
		String monat;
		Integer jahr;
		
		for(int i = 0; i<2; i++)
		{
			id = sc.nextInt();
			marke = sc.next();
			vermietet = sc.nextBoolean();
			tag = sc.nextInt();
			monat = sc.next();
			jahr = sc.nextInt();
			vermietetVon = sc.next();
			
			mt.addNeueZeile(id, marke, vermietet, tag, monat, jahr, vermietetVon);
			
		}
		sc.close();	
		

		primaryStage.setScene(scene);

		primaryStage.show();
		
		
		
		
		
		

	}

	public HBox addMietwagen() {
		HBox hbox = new HBox();
		hbox.setPadding(new Insets(50, 5, 40, 5));
		hbox.setSpacing(5);
		hbox.setStyle("-fx-background-color: #FFFFFF");

		Label idLabel = new Label("ID: ");
		TextField idField = new TextField();
		idField.setMaxWidth(40);

		Label markeLabel = new Label("MARKE: ");
		TextField markeField = new TextField();
		markeField.setMaxWidth(100);

		Label vermietetLabel = new Label("Vermietet: ");
		CheckBox vermietetBox = new CheckBox();

		Label datumLabel = new Label("Vermietet bis: ");

		Label vermietetVonLabel = new Label("Vermietet von: ");
		TextField vermietetVonField = new TextField();
		vermietetVonField.setMaxWidth(100);

		ObservableList<Integer> tage = FXCollections.observableArrayList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14,
				15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30, 31);
		ComboBox<Integer> tagcb = new ComboBox<Integer>(tage);

		ObservableList<String> monate = FXCollections.observableArrayList("januar", "februar", "marz", "april", "mai",
				"juni", "juli", "august", "september", "oktober", "november", "dezember");
		ComboBox<String> monatcb = new ComboBox<String>(monate);

		ObservableList<Integer> jahre = FXCollections.observableArrayList(2016, 2017);
		ComboBox<Integer> jahrcb = new ComboBox<Integer>(jahre);

		Button addButton = new Button("Add");

		addButton.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				// TODO Auto-generated method stub
				int id = 0;
				try {
					id = Integer.parseInt(idField.getText());
				} catch (NumberFormatException e) {
					Alert alert = new Alert(AlertType.ERROR);
					alert.setTitle("Type Error...");
					alert.setContentText("Das eingegebene Wert fur den id" + idField.getText() + "ist keine Zahl");
					alert.showAndWait();
				}

				String marke = markeField.getText();
				Boolean vermietet = vermietetBox.isSelected();
				String vermietetVon;
				Integer tag;
				String monat;
				Integer jahr;

				if (vermietet) {
					tag = tagcb.getValue();
					monat = monatcb.getValue();
					jahr = jahrcb.getValue();
					vermietetVon = vermietetVonField.getText();
				} else {
					tag = null;
					monat = null;
					jahr = null;
					vermietetVon = null;
				}
				mt.addNeueZeile(id, marke, vermietet, tag, monat, jahr, vermietetVon);

			}

		});
		
		Button deleteButton = new Button("delete");
		
		deleteButton.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				
				int id = 0;
				try {
					id = Integer.parseInt(idField.getText());
				} catch (NumberFormatException e) {
					Alert alert = new Alert(AlertType.ERROR);
					alert.setTitle("Type Error...");
					alert.setContentText("Das eingegebene Wert fur den id" + idField.getText() + "ist keine Zahl");
					alert.showAndWait();
				}

				String marke = markeField.getText();
				
				mt.deleteZeile(id);
		
		
		
		
			}
			});
		
		

		hbox.getChildren().addAll(idLabel, idField, markeLabel, markeField, vermietetLabel, vermietetBox, datumLabel,
				tagcb, monatcb, jahrcb, vermietetVonLabel, vermietetVonField, addButton,deleteButton);
		return hbox;

	}

}
