package fr.ul.miage.ncm.verre;

import javafx.concurrent.ScheduledService;
import javafx.concurrent.Task;

import java.util.logging.Logger;

public class Ajouteur extends ScheduledService<Verre> {
    private static final Logger LOG = Logger.getLogger(Ajouteur.class.getName());
    private Verre verre;

    public Ajouteur(Verre verre) {
        super();
        this.verre = verre;
    }

    @Override
    protected Task<Verre> createTask() {
        return new Task<Verre>() {
            @Override
            protected Verre call() throws Exception {
                verre.glou();
                return verre;
            }
        };
    }
}
