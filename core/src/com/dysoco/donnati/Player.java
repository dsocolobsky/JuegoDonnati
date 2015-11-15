package com.dysoco.donnati;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureAtlas.AtlasRegion;

import java.util.ArrayList;

public class Player extends Actor {
    TextureRegion texture;

    private ArrayList<AtlasRegion> pelos;
    private ArrayList<AtlasRegion> torso;
    private ArrayList<AtlasRegion> piernas;
    private ArrayList<AtlasRegion> zapatos;

    private int pelosIndex;
    private int torsoIndex;
    private int piernasIndex;
    private int zapatosIndex;

    public Player(TextureRegion texture) {
        this.texture = texture;
        setBounds(0, 0, texture.getRegionWidth(), texture.getRegionHeight());

        pelos = new ArrayList<AtlasRegion>();
        torso = new ArrayList<AtlasRegion>();
        piernas = new ArrayList<AtlasRegion>();
        zapatos = new ArrayList<AtlasRegion>();

        pelos.add(0, Assets.VACIO);
        pelos.add(1, Assets.PELO);
        pelos.add(2, Assets.COCINERO_GORRO);

        torso.add(0, Assets.VACIO);
        torso.add(1, Assets.BUZO);
        torso.add(2, Assets.COCINERO_TRAJE);

        piernas.add(0, Assets.VACIO);
        piernas.add(1, Assets.PANTALONES);
        piernas.add(2, Assets.COCINERO_PANTALONES);

        zapatos.add(0, Assets.VACIO);
        zapatos.add(1, Assets.ZAPATOS);
        zapatos.add(2, Assets.COCINERO_ZAPATOS);

        pelosIndex = 0;
        torsoIndex = 0;
        piernasIndex = 0;
        zapatosIndex = 0;
    }

    public void moverPelos(int d) {
        if(d < 0) {
            if(pelosIndex == 0) {
                pelosIndex = pelos.size()-1;
            } else {
                pelosIndex--;
            }
        } else {
            if (pelosIndex == (pelos.size()-1)) {
                pelosIndex = 0;
            } else {
                pelosIndex++;
            }
        }
    }

    public void moverTorso(int d) {
        if(d < 0) {
            if(torsoIndex == 0) {
                torsoIndex = torso.size()-1;
            } else {
                torsoIndex--;
            }
        } else {
            if (torsoIndex == (torso.size()-1)) {
                torsoIndex = 0;
            } else {
                torsoIndex++;
            }
        }
    }

    public void moverPiernas(int d) {
        if(d < 0) {
            if(piernasIndex == 0) {
                piernasIndex = piernas.size()-1;
            } else {
                piernasIndex--;
            }
        } else {
            if (piernasIndex == (piernas.size()-1)) {
                piernasIndex = 0;
            } else {
                piernasIndex++;
            }
        }
    }

    public void moverZapatos(int d) {
        if(d < 0) {
            if(zapatosIndex == 0) {
                zapatosIndex = zapatos.size()-1;
            } else {
                zapatosIndex--;
            }
        } else {
            if (zapatosIndex == (zapatos.size()-1)) {
                zapatosIndex = 0;
            } else {
                zapatosIndex++;
            }
        }
    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        batch.draw(texture, getX(), getY());

        if(pelosIndex >= 0) {
            if(pelosIndex == 2) {
                batch.draw(pelos.get(pelosIndex), getX()+6, getY()+415);
            } else {
                batch.draw(pelos.get(pelosIndex), getX() + 27, getY() + 382);
            }
        }

        if(piernasIndex >= 0) {
            if(piernasIndex == 2) {
                batch.draw(piernas.get(piernasIndex), getX()+20, getY()+32);
            } else {
                batch.draw(piernas.get(piernasIndex), getX() + 11, getY() + 30);
            }
        }

        if(torsoIndex >= 0) {
            batch.draw(torso.get(torsoIndex), getX()+11, getY()+212);
        }

        if(zapatosIndex >= 0) {
            batch.draw(zapatos.get(zapatosIndex), getX()+11, getY()-5);
        }
    }


}
