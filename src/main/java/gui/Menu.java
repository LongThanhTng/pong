package gui;

import javafx.application.Application;
import javafx.event.Event;
import javafx.stage.Stage;
import javafx.scene.*;
import javafx.scene.control.Button;
import javafx.scene.effect.ImageInput;
import javafx.scene.image.Image;
import javafx.scene.layout.Pane;
import javafx.scene.Scene;
import model.Court;
import model.RacketController;
import java.io.InputStream;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.stage.Stage;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;
import java.io.File; 
import java.io.IOException; 
import java.util.Scanner;

/* ------------------------------------------------------------------------------------------------------*/

//Menu principale du Jeu 


public class Menu extends Application{

    public void start (Stage primaryStage) {
        Pane root = new Pane() ;
        Scene gameScene = new Scene(root) ;

        //Logo du millieu
        Image image = new Image("file:src/Pictures/pong1.png");
        ImageView imageView = new ImageView(image);
        imageView.setLayoutX(350);
        imageView.setLayoutY(10);
        

        //Bouton Play
        Button play = new Button("play") ;
        play.setLayoutX(487);
        play.setLayoutY(554);
        play.setEffect(new ImageInput(new Image("file:src/Pictures/play.png")));
        play.setSkin(new MyButtonSkin(play));

        //Bouton Option
        Button option = new Button("option");
        option.setLayoutX(421);
        option.setLayoutY(600);
        option.setEffect(new ImageInput(new Image("file:src/Pictures/option.png")));
        option.setSkin(new MyButtonSkin(option));

        //Bouton quitter
        Button quitter = new Button("quitter");
        quitter.setLayoutX(704);
        quitter.setLayoutY(600);
        quitter.setEffect(new ImageInput(new Image("file:src/Pictures/exit.png")));
        quitter.setSkin(new MyButtonSkin(quitter));

        //Bouton pour le easter egg intégré à la page d'accueil
        Button Easter = new Button("Easter");
        Easter.setLayoutX(10);
        Easter.setLayoutY(700);
        Easter.setMinSize(100, 100);
        Easter.setOpacity(0);

        // Image img = new Image("file:src/Pictures/fond.png");
        Image image7 = new Image(new File("src/Pictures/fond1.gif").toURI().toString());
        BackgroundImage bImg = new BackgroundImage(image7, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT);
        Background bGround = new Background(bImg);
        root.setBackground(bGround);

       
        
    

       //Setting du Stage
        primaryStage.setWidth(1200);
        primaryStage.setHeight(800);
        primaryStage.setResizable(false);
        primaryStage.getIcons().add(new Image("file:src/Pictures/pong1.png")) ;
        primaryStage.setTitle("Pong");

        //Ajout des boutons sur le stage
        
        root.getChildren().addAll(imageView, play, option, quitter, Easter) ;
        primaryStage.setScene(gameScene);
        primaryStage.show(); 

        //Action du bouton option
        option.setOnAction(ev2 ->{
            root.getChildren().removeAll(play, option, quitter);
            
            //Creation des boutons stats et commande pour les menus
            Button Commande= new Button("play") ;
            Commande.setLayoutX(538);
            Commande.setLayoutY(570);
            Commande.setEffect(new ImageInput(new Image("file:src/Pictures/commande2.png")));
            Commande.setSkin(new MyButtonSkin(Commande));
            Commande.setOnAction(ev1 -> {
                Pane root1 = new Pane();
                gameScene.setRoot(root1);
                Commande a = new Commande(root1, gameScene);
                a.start(primaryStage);
            });


            Button Stat = new Button("option");
            Stat.setLayoutX(421);
            Stat.setLayoutY(580);
            Stat.setEffect(new ImageInput(new Image("file:src/Pictures/stat.png")));
            Stat.setSkin(new MyButtonSkin(Stat));

            Stat.setOnAction(ev1 -> {
                Pane root1 = new Pane();
                gameScene.setRoot(root1);
                Stat a = new Stat(root1, gameScene);
                a.start(primaryStage);
            });

            Button Retour = new Button("quitter");
            Retour.setLayoutX(704);
            Retour.setLayoutY(580);
            Retour.setEffect(new ImageInput(new Image("file:src/Pictures/retour.png")));
            Retour.setSkin(new MyButtonSkin(Retour));

            root.getChildren().addAll(Commande, Stat, Retour) ;

            Retour.setOnAction(ev3 ->{
                root.getChildren().removeAll(Commande, Stat, Retour);
                root.getChildren().addAll(play, option, quitter);
            });

            //ici, on ne fait que supprimer les anciens boutons pour en placer de nouveau. Pas de changement de root. 

        });



        //Action du bouton Play 
        play.setOnAction(ev1 -> {
            Pane root1 = new Pane();
            gameScene.setRoot(root1);
            ModeDeJeu a = new ModeDeJeu(root1, gameScene);
            a.start(primaryStage);
        });
        
        //Action du bouton Quitter
        quitter.setOnAction(ev3 ->{
            System.exit(0);
        });
       
        //Implémentation de l'easter-egg
        Easter.setOnAction(ev8 ->{
            Button Easter2 = new Button("Easter");
            Easter2.setLayoutX(1100);
            Easter2.setLayoutY(700);
            Easter2.setMinSize(100, 100);
            Easter2.setOpacity(0);
            root.getChildren().add(Easter2);
            Easter2.setOnAction(ev7 ->{
                Button Easter3 = new Button("Easter");
                Easter3.setLayoutX(1100);
                Easter3.setLayoutY(10);
                Easter3.setMinSize(100, 100);
                Easter3.setOpacity(0);
                root.getChildren().add(Easter3);
                Easter3.setOnAction(ev5 ->{
                    Image image2 = new Image("file:src/Pictures/Easter1.jpg");
                    ImageView imageView2 = new ImageView(image2);
                    imageView2.setLayoutX(350);
                    imageView2.setLayoutY(10);
                    ImageView imageView3 = new ImageView(image2);
                    ImageView imageView4 = new ImageView(image2);
                    imageView3.setLayoutX(150);
                    imageView3.setLayoutY(10);
                    imageView4.setLayoutX(650);
                    imageView4.setLayoutY(10);
                    root.getChildren().addAll(imageView2, imageView3, imageView4);
                });
            });
        });


    }
}

