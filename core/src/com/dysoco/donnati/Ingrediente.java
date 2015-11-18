package com.dysoco.donnati;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.scenes.scene2d.Actor;

public class Ingrediente extends Actor {
    public int key;
    public TextureAtlas.AtlasRegion texture;

    public float ox;
    public float oy;

    public Ingrediente(int key, TextureAtlas.AtlasRegion texture) {
        this.key = key;
        this.texture = texture;
        setSize(texture.getRegionWidth(), texture.getRegionHeight());
        setPosition(key);
    }

    public void setPosition(int pos) {
        float tx;
        float ty;

        switch(pos) {
            case 1:
                tx = 435;
                ty = 250;
                break;
            case 2:
                tx = 656;
                ty = 120;
                break;
            case 3:
                tx = 210;
                ty = 130;
                break;
            case 4:
                tx = 630;
                ty = 220;
                break;
            case 5:
                tx = 255;
                ty = 230;
                break;
            default:
                tx = 0;
                ty = 0;
                break;
        }

        ox = tx;
        oy = ty;
        setPosition(tx, ty);
    }

    public void goBack() {
        setPosition(ox, oy);
    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        batch.draw(texture, this.getX(), this.getY(), texture.getRegionWidth(), texture.getRegionHeight());
    }

    public Rectangle getBounds() {
        return new Rectangle((int)getX(), (int)getY(), (int)getWidth(), (int)getHeight());
    }
}
