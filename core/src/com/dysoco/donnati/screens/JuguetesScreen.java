package com.dysoco.donnati.screens;

import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.utils.DragListener;
import com.dysoco.donnati.*;

import java.util.ArrayList;
import java.util.Collections;

public class JuguetesScreen extends Screen {

    Image background;

    public static enum ChestColor {
        BLUE, GREEN, RED
    }

    ArrayList<Chest> chests;
    ArrayList<Juguete> juguetes;

    private int juguetesMetidos;

    public JuguetesScreen(final Juego juego) {
        super(juego);

        juguetesMetidos = 0;

        background = new Image(Assets.CHESTS_BACKGROUND);
        background.setScale(0.5f);
        stage.addActor(background);

        stage.addActor(volver);

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
        juguetes.add(new Juguete(Assets.OSO, ChestColor.BLUE));
        juguetes.add(new Juguete(Assets.AUTO, ChestColor.BLUE));
        juguetes.add(new Juguete(Assets.DOLL, ChestColor.RED));
        juguetes.add(new Juguete(Assets.PELOTA, ChestColor.RED));
        juguetes.add(new Juguete(Assets.AVION, ChestColor.GREEN));
        juguetes.add(new Juguete(Assets.BARCO, ChestColor.GREEN));

        Collections.shuffle(juguetes);

        for(int i = 0; i < 6; i++) {
            Juguete j = juguetes.get(i);

            if(j != null) {
                j.setOrder(i);

                final Juguete juguete = (Juguete)j;
                j.addListener(new DragListener() {
                    public void drag(InputEvent event, float x, float y, int pointer) {
                        event.getTarget().moveBy(x - event.getTarget().getWidth() / 2, y - event.getTarget().getHeight() / 2);

                        for(Chest chest : chests) {
                            if(overCorrectChest(juguete, chest) || overWrongChest(juguete, chest)) {
                                chest.openChest();
                            } else if(chest.isOpen()) {
                                chest.closeChest();
                            }
                        }
                    }

                    public void dragStop(InputEvent event, float x, float y, int pointer) {

                        for(Chest chest : chests) {
                            if(overCorrectChest(juguete, chest)) {
                                event.getTarget().remove();
                                Assets.SOUND_CORRECT.play(1.80f);
                                chest.closeChest();
                                juguetesMetidos++;

                                if(juguetesMetidos >= 6) {
                                    ganar();
                                }
                            } else if(overWrongChest(juguete, chest)) {
                                event.getTarget().setPosition(juguete.originalX, juguete.originalY);
                                Assets.SOUND_WRONG.play(1.5f);
                                chest.closeChest();
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
        Assets.MUSIC_JUGUETES.setLooping(true);
        Assets.MUSIC_JUGUETES.play();

        super.show();
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
