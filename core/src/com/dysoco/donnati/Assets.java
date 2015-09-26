package com.dysoco.donnati;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureAtlas.AtlasRegion;

public class Assets {

    public static Texture FONDO_TEXTURE;

    private static TextureAtlas atlas;
    public static AtlasRegion PLAYER_TEXTURE;
    public static AtlasRegion EDIT_BUTTON;
    public static AtlasRegion LEFT_BUTTON;
    public static AtlasRegion RIGHT_BUTTON;

    public static AtlasRegion GAME_ONE;
    public static AtlasRegion GAME_TWO;
    public static AtlasRegion GAME_THREE;
    public static AtlasRegion GAME_FOUR;

    public static AtlasRegion CHEST_BLUE;
    public static AtlasRegion CHEST_GREEN;
    public static AtlasRegion CHEST_RED;

    public static AtlasRegion SQUARE_BLUE;
    public static AtlasRegion SQUARE_GREEN;
    public static AtlasRegion SQUARE_RED;

    public static AtlasRegion TRIANGLE_RED;
    public static AtlasRegion TRIANGLE_GREEN;
    public static AtlasRegion TRIANGLE_BLUE;

    public static void load() {
        atlas = new TextureAtlas(Gdx.files.internal("textures/atlas.atlas"));

        FONDO_TEXTURE = new Texture(Gdx.files.internal("textures/background.png"));

        PLAYER_TEXTURE = new AtlasRegion(atlas.findRegion("character"));
        EDIT_BUTTON = new AtlasRegion(atlas.findRegion("button_config"));
        LEFT_BUTTON = new AtlasRegion(atlas.findRegion("button_right"));
        RIGHT_BUTTON = new AtlasRegion(atlas.findRegion("button_left"));

        GAME_ONE = new AtlasRegion(atlas.findRegion("game_one"));
        GAME_TWO = new AtlasRegion(atlas.findRegion("game_two"));
        GAME_THREE = new AtlasRegion(atlas.findRegion("game_three"));
        GAME_FOUR = new AtlasRegion(atlas.findRegion("game_four"));

        CHEST_BLUE = new AtlasRegion(atlas.findRegion("chest_blue"));
        CHEST_GREEN = new AtlasRegion(atlas.findRegion("chest_green"));
        CHEST_RED = new AtlasRegion(atlas.findRegion("chest_red"));

        SQUARE_BLUE = new AtlasRegion(atlas.findRegion("square_blue"));
        SQUARE_GREEN = new AtlasRegion(atlas.findRegion("square_green"));
        SQUARE_RED = new AtlasRegion(atlas.findRegion("square_red"));

        TRIANGLE_BLUE = new AtlasRegion(atlas.findRegion("triangle_blue"));
        TRIANGLE_GREEN = new AtlasRegion(atlas.findRegion("triangle_green"));
        TRIANGLE_RED = new AtlasRegion(atlas.findRegion("triangle_red"));
    }

}
