package com.dysoco.donnati;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.scenes.scene2d.Actor;

public class Traje extends Actor {

    private float scaleFactor = 2f;

    private TextureRegion texture;
    private String key;

    public Traje(String key, TextureRegion texture) {
        this.key = key;
        this.texture = texture;
        setSize(texture.getRegionWidth()/3, texture.getRegionHeight()/3);
    }

    public void setOrder(int order) {
        float tx;
        float ty;

        switch(order) {
            case 0:
                tx = 380;
                ty = 240;
                break;
            case 1:
                tx = 380;
                ty = 5;
                break;
            case 2:
                tx = 640;
                ty = 5;
                break;
            case 3:
                tx = 640;
                ty = 240;
                break;
            default:
                tx = 0;
                ty = 0;
                break;
        }

        setPosition(tx, ty);
    }

    public void finish(float x, float y) {
        setPosition(x, y);
        setSize(texture.getRegionWidth(), texture.getRegionHeight());
        scaleFactor = 1f;
    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        batch.draw(texture, this.getX(), this.getY(), texture.getRegionWidth()/scaleFactor, texture.getRegionHeight()/scaleFactor);
    }

    public Rectangle getBounds() {
        return new Rectangle((int)getX(), (int)getY(), (int)getWidth(), (int)getHeight());
    }

}
