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

    public Ingrediente(int key, TextureAtlas.AtlasRegion texture, float x, float y) {
        this.key = key;
        this.texture = texture;
        setSize(texture.getRegionWidth(), texture.getRegionHeight());
        setLocation(x, y);
    }

    public void setLocation(float x, float y) {
        ox = x;
        oy = y;
        setPosition(x, y);
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
