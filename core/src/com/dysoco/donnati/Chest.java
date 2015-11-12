package com.dysoco.donnati;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.dysoco.donnati.screens.JuguetesScreen.ChestColor;

public class Chest extends Actor {

    private TextureRegion current;
    private TextureRegion chestClosed;
    private TextureRegion chestOpen;
    private TextureRegion currentShadow;
    private TextureRegion shadowClosed;
    private TextureRegion shadowOpen;

    private Vector2 shadowPos;
    private Vector2 altShadowPos;

    public ChestColor chestColor;

    public Chest(ChestColor color) {
        this.chestColor = color;

        switch (chestColor) {
            case RED:
                this.chestClosed = Assets.CHEST_RED_CLOSED;
                this.chestOpen = Assets.CHEST_RED_OPEN;
                break;
            case GREEN:
                this.chestClosed = Assets.CHEST_GREEN_CLOSED;
                this.chestOpen = Assets.CHEST_GREEN_OPEN;
                break;
            case BLUE:
                this.chestClosed = Assets.CHEST_BLUE_CLOSED;
                this.chestOpen = Assets.CHEST_BLUE_OPEN;
                break;
        }

        this.current = chestClosed;
        this.setSize(chestClosed.getRegionWidth()/3, chestClosed.getRegionHeight()/3);

        shadowPos = new Vector2();
        altShadowPos = new Vector2();
    }

    public void setOrder(int order) {
        switch(order) {
            case 0:
                this.setPosition(40, 200);
                shadowPos.set(14, 142);
                altShadowPos.set(4, 146);
                this.shadowClosed = Assets.SHADOW_LEFT_CLOSED;
                this.shadowOpen = Assets.SHADOW_LEFT_OPEN;
                break;
            case 1:
                this.setPosition(340, 200);
                shadowPos.set(314, 142);
                altShadowPos.set(310, 148);
                this.shadowClosed = Assets.SHADOW_MIDDLE_CLOSED;
                this.shadowOpen = Assets.SHADOW_MIDDLE_OPEN;
                break;
            case 2:
                this.setPosition(640, 200);
                shadowPos.set(628, 142);
                altShadowPos.set(618, 148);
                this.shadowClosed = Assets.SHADOW_RIGHT_CLOSED;
                this.shadowOpen = Assets.SHADOW_RIGHT_OPEN;
                break;
        }

        currentShadow = shadowClosed;
    }

    public boolean isOpen() {
        return current == chestOpen;
    }

    public void openChest() {
        current = chestOpen;
        currentShadow = shadowOpen;
        this.setSize(chestOpen.getRegionWidth()/3, chestOpen.getRegionHeight()/3);
    }

    public void closeChest() {
        current = chestClosed;
        currentShadow = shadowClosed;
        this.setSize(chestClosed.getRegionWidth()/3, chestClosed.getRegionHeight()/3);
    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        batch.draw(current, this.getX(), this.getY(), current.getRegionWidth()/3, current.getRegionHeight()/3);
        if(!isOpen()) {
            batch.draw(currentShadow, shadowPos.x, shadowPos.y, currentShadow.getRegionWidth() / 3, currentShadow.getRegionHeight() / 3);
        } else {
            batch.draw(currentShadow, altShadowPos.x, altShadowPos.y, currentShadow.getRegionWidth() / 3, currentShadow.getRegionHeight() / 3);
        }
    }

    public Rectangle getBounds() {
        return new Rectangle((int)getX(), (int)getY(), (int)getWidth(), (int)getHeight());
    }

}
