package com.dysoco.donnati.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.utils.DragListener;
import com.dysoco.donnati.*;

import java.util.ArrayList;
import java.util.Collections;

public class JuguetesScreen extends Screen {

    public static enum ChestColor {
        BLUE, GREEN, RED
    }

    ArrayList<Chest> chests;
    ArrayList<Juguete> juguetes;

    public JuguetesScreen(final Juego juego) {
        super(juego);

        chests = new ArrayList<Chest>();
        chests.add(new Chest(ChestColor.BLUE));
        chests.add(new Chest(ChestColor.GREEN));
        chests.add(new Chest(ChestColor.RED));
        Collections.shuffle(chests);

        for(int i = 0; i < 3; i++) {
            Chest c = chests.get(i);

            if(c != null) {
                c.setOrder(i);
                stage.addActor(c);
            }
        }

        juguetes = new ArrayList<Juguete>();
        juguetes.add(new Juguete(Assets.SQUARE_BLUE, ChestColor.BLUE));
        juguetes.add(new Juguete(Assets.SQUARE_GREEN, ChestColor.GREEN));
        juguetes.add(new Juguete(Assets.SQUARE_RED, ChestColor.RED));
        juguetes.add(new Juguete(Assets.TRIANGLE_BLUE, ChestColor.BLUE));
        juguetes.add(new Juguete(Assets.TRIANGLE_GREEN, ChestColor.GREEN));
        juguetes.add(new Juguete(Assets.TRIANGLE_RED, ChestColor.RED));

        Collections.shuffle(juguetes);

        for(int i = 0; i < 6; i++) {
            Juguete j = juguetes.get(i);

            if(j != null) {
                j.setOrder(i);

                final Juguete juguete = (Juguete)j;
                j.addListener(new DragListener() {
                    public void drag(InputEvent event, float x, float y, int pointer) {
                        event.getTarget().moveBy(x - event.getTarget().getWidth() / 2, y - event.getTarget().getHeight() / 2);
                    }

                    public void dragStop(InputEvent event, float x, float y, int pointer) {

                        for(Chest chest : chests) {
                            if(overCorrectChest(juguete, chest)) {
                                event.getTarget().remove();
                            } else if(overWrongChest(juguete, chest)) {
                                event.getTarget().setPosition(juguete.originalX, juguete.originalY);
                            }
                        }

                    }
                });

                stage.addActor(j);
            }
        }
    }

    @Override
    public void show(){
        super.show();

        Gdx.input.setInputProcessor(stage);
    }

    @Override
    public void resize(int width, int height) {
        stage.getViewport().update(width, height, true);
    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(0, 0, 0.0f, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        stage.act(delta);

        stage.draw();
    }

    @Override
    public void dispose() {
        stage.dispose();
    }

    private boolean overCorrectChest(Juguete juguete, Chest chest) {
        if(juguete.getBounds().overlaps(chest.getBounds())) {
            return juguete.chestColor == chest.chestColor;
        }

        return false;
    }

    private boolean overWrongChest(Juguete juguete, Chest chest) {
        if(juguete.getBounds().overlaps(chest.getBounds())) {
            return juguete.chestColor != chest.chestColor;
        }

        return false;
    }

}
