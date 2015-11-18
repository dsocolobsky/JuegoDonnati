package com.dysoco.donnati;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.scenes.scene2d.Actor;

import java.util.ArrayList;

public class Comida extends Actor {

    public String key;
    public ArrayList<Ingrediente> ingredientes;
    public ArrayList<TextureAtlas.AtlasRegion> sprites;

    public int currentSprite;

    public Comida(String key) {
        this.key = key;
        ingredientes = new ArrayList<Ingrediente>();
        sprites = new ArrayList<TextureAtlas.AtlasRegion>();

        if(key.equals("hamburguesa")) {
            ingredientes.add(new Ingrediente(1, Assets.COC_CARNE, 435, 250));
            ingredientes.add(new Ingrediente(2, Assets.COC_QUESO, 656, 120));
            ingredientes.add(new Ingrediente(3, Assets.COC_TOMATES, 210, 130));
            ingredientes.add(new Ingrediente(4, Assets.COC_LECHUGA, 630, 220));
            ingredientes.add(new Ingrediente(5, Assets.COC_PAN, 255, 230));

            sprites.add(Assets.HAMB_PANABAJO);
            sprites.add(Assets.HAMB_CARNE);
            sprites.add(Assets.HAMB_QUESO);
            sprites.add(Assets.HAMB_TOMATES);
            sprites.add(Assets.HAMB_LECHUGA);
            sprites.add(Assets.HAMB_PANARRIBA);
        }

        currentSprite = 0;
        setSize(Assets.HAMB_PANARRIBA.getRegionWidth(), Assets.HAMB_PANARRIBA.getRegionHeight());
    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        batch.draw(sprites.get(currentSprite), this.getX(), this.getY());
    }

    public Rectangle getBounds() {
        return new Rectangle((int)getX(), (int)getY(), (int)getWidth(), (int)getHeight());
    }

}
