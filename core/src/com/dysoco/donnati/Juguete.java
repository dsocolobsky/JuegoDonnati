package com.dysoco.donnati;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.dysoco.donnati.screens.JuguetesScreen;

public class Juguete extends Actor {

    private TextureRegion texture;
    public JuguetesScreen.ChestColor chestColor;

    public float originalX;
    public float originalY;

    public Juguete(TextureRegion texture, JuguetesScreen.ChestColor chestColor) {
        this.texture = texture;
        this.chestColor = chestColor;
        this.setSize(64, 64);
    }

    public void setOrder(int order) {
        float tx;
        float ty;

        switch(order) {
            case 0:
                tx = 40;
                ty = 220;
                break;
            case 1:
                tx = 240;
                ty = 220;
                setPosition(240, 220);
                break;
            case 2:
                tx = 440;
                ty = 220;
                break;
            case 3:
                tx = 40;
                ty = 80;
                break;
            case 4:
                tx = 240;
                ty = 80;
                break;
            case 5:
                tx = 440;
                ty = 80;
                break;
            default:
                tx = 0;
                ty = 0;
                break;
        }

        originalX = tx;
        originalY = ty;
        setPosition(tx, ty);
    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        batch.draw(texture, this.getX(), this.getY());
    }

    public Rectangle getBounds() {
        return new Rectangle((int)getX(), (int)getY(), (int)getWidth(), (int)getHeight());
    }
}
