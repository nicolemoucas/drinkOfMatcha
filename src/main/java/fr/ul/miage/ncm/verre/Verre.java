package fr.ul.miage.ncm.verre;

import java.util.logging.Logger;

public class Verre {
    private static final Logger LOG = Logger.getLogger(Verre.class.getName());
    public static final double MAX = 354.0;
    private double capacite;
    private double volume;

    // Constructeur
    public Verre(double capacite) {
        this.capacite = capacite;
    }

    // Constructeur (capacité par défaut)
    public Verre() {
        this(MAX);
    }

    // Tester si le verre est plein
    public boolean estPlein() {
        return (capacite <= volume);
    }

    // Remplir le verre d'une unité
    public double glou() {
        volume += 5.0;
        if (volume >= capacite) {
            volume = capacite;
        }
        return volume;
    }

    // Getters et Setters
    public double getVolume() {
        return volume;
    }

    public void setVolume(double volume) {
        this.volume = volume;
    }
}