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

    private boolean playOpenSound;
    private boolean playCloseSound;

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
        this.setSize(chestClosed.getRegionWidth()/2, chestClosed.getRegionHeight()/8);

        shadowPos = new Vector2();
        altShadowPos = new Vector2();

        playOpenSound = true;
        playCloseSound = true;
    }

    public void setOrder(int order) {
        switch(order) {
            case 0:
                this.setPosition(20, 200);
                shadowPos.set(-19, 113);
                altShadowPos.set(-38, 120);
                this.shadowClosed = Assets.SHADOW_LEFT_CLOSED;
                this.shadowOpen = Assets.SHADOW_LEFT_OPEN;
                break;
            case 1:
                this.setPosition(320, 200);
                shadowPos.set(280, 112);
                altShadowPos.set(276, 120);
                this.shadowClosed = Assets.SHADOW_MIDDLE_CLOSED;
                this.shadowOpen = Assets.SHADOW_MIDDLE_OPEN;
                break;
            case 2:
                this.setPosition(610, 200);
                shadowPos.set(590, 112);
                altShadowPos.set(570, 122);
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
        this.setSize(chestOpen.getRegionWidth()/2, chestOpen.getRegionHeight()/8);

        if(playOpenSound) {
            Assets.SOUND_CHEST_OPEN.play(0.50f);
            playOpenSound = false;
            playCloseSound = true;
        }
    }

    public void closeChest() {
        current = chestClosed;
        currentShadow = shadowClosed;
        this.setSize(chestClosed.getRegionWidth()/2, chestClosed.getRegionHeight()/8);

        if(playCloseSound) {
            Assets.SOUND_CHEST_CLOSE.play(0.50f);
            playCloseSound = false;
            playOpenSound = true;
        }
    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        batch.draw(current, this.getX(), this.getY(), current.getRegionWidth()/2, current.getRegionHeight()/2);
        if(!isOpen()) {
            batch.draw(currentShadow, shadowPos.x, shadowPos.y, currentShadow.getRegionWidth() / 2, currentShadow.getRegionHeight() / 2);
        } else {
            batch.draw(currentShadow, altShadowPos.x, altShadowPos.y, currentShadow.getRegionWidth() / 2, currentShadow.getRegionHeight() / 2);
        }
    }

    public Rectangle getBounds() {
        return new Rectangle((int)getX(), (int)getY(), (int)getWidth(), (int)getHeight());
    }

}
