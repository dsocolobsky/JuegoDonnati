package com.dysoco.donnati;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.scenes.scene2d.Actor;

import java.util.ArrayList;

public class MemoCard extends Actor {

    private float offsetX = 0;
    private float offsetY = 0;

    public boolean flipping = false;

    private TextureRegion front;

    private int index;
    private boolean flipped;

    private TextureRegion[] frames;
    private TextureRegion currentFrame;
    private Animation animation;

    private float time = 0.0f;

    private MemoCard other;

    public MemoCard(int index) {
        this.setSize(128, 128);
        this.index = index;
        this.flipped = false;
        this.flipping = false;

        frames = new TextureRegion[8];

        frames[0] = Assets.MEMOCARD_BACK;
        frames[1] = Assets.MEMOCARD_ONE;
        frames[2] = Assets.MEMOCARD_TWO;
        frames[3] = Assets.MEMOCARD_THREE;
        frames[4] = Assets.MEMOCARD_FOUR;
        frames[5] = Assets.MEMOCARD_FIVE;
        frames[6] = Assets.MEMOCARD_SIX;
        frames[7] = Assets.MEMOCARD_FRONT;

        currentFrame = frames[0];

        animation = new Animation(0.08f, frames);

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
        flipping = true;
    }

    public int getIndex() {
        return this.index;
    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        if(flipping) {
            if(!flipped) {
                time += Gdx.graphics.getDeltaTime();
                currentFrame = animation.getKeyFrame(time, true);
                if (animation.getKeyFrameIndex(time) == 7) {
                    time = 0;
                    flipping = false;
                    flipped = true;
                }
            } else {
                animation.setPlayMode(Animation.PlayMode.REVERSED);
                time += Gdx.graphics.getDeltaTime();
                currentFrame = animation.getKeyFrame(time, true);
                if(animation.getKeyFrameIndex(time) == 0) {
                    time = 0;
                    flipping = false;
                    flipped = false;
                    animation.setPlayMode(Animation.PlayMode.NORMAL);
                }
            }
        }

        batch.draw(currentFrame, this.getX(), this.getY());
        if(flipped && !flipping) {
            switch(index) {
                case 0:
                    offsetX = 28;
                    offsetY = 12;
                    break;
                case 1:
                    offsetX = 28;
                    offsetY = 32;
                    break;
                case 2:
                    offsetX = 28;
                    offsetY = 35;
                    break;
                case 3:
                    offsetX = 28;
                    offsetY = 15;
                    break;
            }
            batch.draw(front, this.getX()+offsetX, this.getY()+offsetY, front.getRegionWidth()/1.75f, front.getRegionHeight()/1.75f);
            offsetX = 0;
            offsetY = 0;
        }
    }

    public Rectangle getBounds() {
        return new Rectangle((int)getX(), (int)getY(), (int)getWidth(), (int)getHeight());
    }
}
