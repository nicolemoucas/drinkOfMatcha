package fr.ul.miage.ncm.verre;

import javafx.concurrent.WorkerStateEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.shape.Rectangle;
import javafx.util.Duration;

import java.time.Instant;

public class Controller {
    @FXML
    Button demarrer;
    @FXML
    Rectangle verre;
    @FXML
    TextArea message;

    /**
     * Initialisation de l'interface
     */
    @FXML
    public void initialize() {
        verre.setHeight(0.0); // hauteur de remplissage = 0 au début
    }
    @FXML
    public void action_demarrer() {
        Instant top = Instant.now();
        demarrer.setDisable(true);
        Verre v = new Verre();
        Ajouteur svc = new Ajouteur(v);
        svc.setOnSucceeded((WorkerStateEvent e)->{
            verre.setHeight(v.getVolume());
            message.appendText("Et glou \uD83C\uDF75...\n");
            if (v.estPlein()) {
                java.time.Duration duration = java.time.Duration.between(top, Instant.now());
                message.appendText("Matcha is ready!\nTemps de remplissage : " + duration.toMillis() + "ms");
                svc.cancel(); // arrÊte le service
                demarrer.setDisable(false); // réactive le bouton
            }
        });
        svc.setPeriod(Duration.millis(100));
        svc.start();
    }
}
