package com.dysoco.donnati.screens;

import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.utils.DragListener;
import com.dysoco.donnati.*;

import java.util.ArrayList;
import java.util.Collections;

public class MemoScreen extends Screen {

    ArrayList<MemoCard> cards;
    boolean secondFlip;
    MemoCard previousCard;

    Button volver;

    int pares;

    public MemoScreen(final Juego juego) {
        super(juego);

        volver = new Button(new TextureRegion(Assets.BACK_BUTTON), 10, 420, 56, 56);

        volver.addListener(new InputListener() {
            public boolean touchDown (InputEvent event, float x, float y, int pointer, int button) {
                juego.setScreen(new MenuScreen(juego));
                return false;
            }
            public void touchUp (InputEvent event, float x, float y, int pointer, int button) {
            }
        });
        stage.addActor(volver);

        secondFlip = false;
        previousCard = null;
        pares = 0;

        cards = new ArrayList<MemoCard>();
        cards.add(new MemoCard(0));
        cards.add(new MemoCard(0));
        cards.add(new MemoCard(1));
        cards.add(new MemoCard(1));
        cards.add(new MemoCard(2));
        cards.add(new MemoCard(2));
        cards.add(new MemoCard(3));
        cards.add(new MemoCard(3));

        Collections.shuffle(cards);

        for(int i = 0; i < 8; i++) {
            MemoCard c = cards.get(i);

            if(c != null) {
                c.setOrder(i);

                final MemoCard card = (MemoCard)c;
                c.addListener(new DragListener() {
                    public boolean touchDown (InputEvent event, float x, float y, int pointer, int button) {
                        if(!card.isFlipped()) {

                            if (previousCard == null) {
                                card.flip();
                                previousCard = card;
                            } else {
                                card.flip();

                                if(card.getIndex() != previousCard.getIndex()) {
                                    card.flip();
                                    previousCard.flip();
                                    Assets.SOUND_WRONG.play();
                                } else {
                                    Assets.SOUND_CORRECT.play();
                                    pares++;
                                    if(pares >= 4) {
                                        Assets.SOUND_APPLAUSE.play();
                                    }
                                }

                                previousCard = null;
                            }

                        }

                        return false;
                    }
                    public void touchUp (InputEvent event, float x, float y, int pointer, int button) {}
                });

                stage.addActor(c);
            }
        }

    }

}
