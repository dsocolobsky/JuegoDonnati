package com.dysoco.donnati;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.scenes.scene2d.Actor;

public class MemoCard extends Actor {

    private final float OFFSET = 40;

    private TextureRegion back;
    private TextureRegion front;

    private int index;
    private boolean flipped;

    public MemoCard(int index) {
        this.back = Assets.MEMOCARD_BACK;
        this.setSize(128, 128);
        this.index = index;
        this.flipped = false;

        switch(index) {
            case 0:
                this.front = Assets.DOLL;
                break;
            case 1:
                this.front = Assets.PELOTA;
                break;
            case 2:
                this.front = Assets.AVION;
                break;
            case 3:
                this.front = Assets.BARCO;
                break;
        }
    }

    public void setOrder(int order) {
        switch(order) {
            case 0:
                setPosition(64, 80);
                break;
            case 1:
                setPosition(64+(180*1), 80);
                break;
            case 2:
                setPosition(64+(180*2), 80);
                break;
            case 3:
                setPosition(64+(180*3), 80);
                break;
            case 4:
                setPosition(64, 280);
                break;
            case 5:
                setPosition(64+(180*1), 280);
                break;
            case 6:
                setPosition(64+(180*2), 280);
                break;
            case 7:
                setPosition(64+(180*3), 280);
                break;
            default:
                setPosition(0, 0);
        }
    }

    public boolean isFlipped() {
        return this.flipped;
    }

    public void flip() {
        this.flipped = !this.flipped;
    }

    public int getIndex() {
        return this.index;
    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        if(!flipped) {
            batch.draw(back, this.getX(), this.getY());
        } else {
            batch.draw(back, this.getX(), this.getY());
            batch.draw(front, this.getX()+OFFSET, this.getY()+OFFSET, front.getRegionWidth()/1.75f, front.getRegionHeight()/1.75f);
        }
    }
}
