package com.dysoco.donnati;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.scenes.scene2d.Actor;

public class Player extends Actor {
    TextureRegion texture;

    public boolean hombre;
    public int color;

    public ChangableCollection pelos;
    public ChangableCollection torso;
    public ChangableCollection piernas;
    public ChangableCollection zapatos;

    public Player(boolean hombre, int color) {
        this.hombre = hombre;
        this.color = color;

        change(hombre, color);

        setBounds(0, 0, texture.getRegionWidth(), texture.getRegionHeight());

        pelos = new ChangableCollection();
        torso = new ChangableCollection();
        piernas = new ChangableCollection();
        zapatos = new ChangableCollection();

        pelos.add("vacio", Assets.VACIO);
        pelos.add("pelo", Assets.PELO);
        pelos.add("gorro", Assets.COCINERO_GORRO);

        torso.add("vacio", Assets.VACIO);
        torso.add("buzo", Assets.BUZO);
        torso.add("traje", Assets.COCINERO_TRAJE);

        piernas.add("vacio", Assets.VACIO);
        piernas.add("pantalones", Assets.PANTALONES);
        piernas.add("cocinero", Assets.COCINERO_PANTALONES);

        zapatos.add("vacio", Assets.VACIO);
        zapatos.add("zapatos", Assets.ZAPATOS);
        zapatos.add("cocinero", Assets.COCINERO_ZAPATOS);
    }

    public void change(boolean hombre, int color) {
        this.hombre = hombre;
        this.color = color;

        if(hombre) {
            switch(color) {
                case 1:
                    texture = Assets.HOMBRE_BLANCO;
                    break;
                case 2:
                    texture = Assets.HOMBRE_CANELA;
                    break;
                case 3:
                    texture = Assets.HOMBRE_YOEL;
                    break;
            }
        } else {
            switch(color) {
                case 1:
                    texture = Assets.MUJER_BLANCO;
                    break;
                case 2:
                    texture = Assets.MUJER_CANELA;
                    break;
                case 3:
                    texture = Assets.MUJER_YOEL;
                    break;
            }
        }
    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        batch.draw(texture, getX(), getY());

        if(pelos.currentKey() == "gorro") {
            batch.draw(pelos.currentAtlas(), getX()+6, getY()+415);
        } else {
            batch.draw(pelos.currentAtlas(), getX() + 27, getY() + 382);
        }

        if(piernas.currentKey() == "cocinero") {
            batch.draw(piernas.currentAtlas(), getX()+20, getY()+32);
        } else {
            batch.draw(piernas.currentAtlas(), getX() + 11, getY() + 30);
        }

        batch.draw(torso.currentAtlas(), getX()+11, getY()+212);

        batch.draw(zapatos.currentAtlas(), getX()+11, getY()-5);
    }

    public Rectangle getBounds() {
        return new Rectangle((int)getX(), (int)getY(), (int)getWidth(), (int)getHeight());
    }


}
