package com.dysoco.donnati;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.dysoco.donnati.screens.JuguetesScreen.ChestColor;

public class Chest extends Actor {

    private TextureRegion texture;
    public ChestColor chestColor;

    public Chest(ChestColor color) {

        this.chestColor = color;
        this.setSize(90, 105);

        switch (chestColor) {
            case BLUE:
                this.texture = Assets.CHEST_BLUE;
                break;
            case GREEN:
                this.texture = Assets.CHEST_GREEN;
                break;
            case RED:
                this.texture = Assets.CHEST_RED;
                break;
        }
    }

    public void setOrder(int order) {
        switch(order) {
            case 0:
                this.setPosition(40, 350);
                break;
            case 1:
                this.setPosition(340, 350);
                break;
            case 2:
                this.setPosition(640, 350);
                break;
        }
    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        batch.draw(texture, this.getX(), this.getY());
    }

    public Rectangle getBounds() {
        return new Rectangle((int)getX(), (int)getY(), (int)getWidth(), (int)getHeight());
    }

}
