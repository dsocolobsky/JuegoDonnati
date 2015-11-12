package com.dysoco.donnati;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureAtlas.AtlasRegion;

public class Assets {

    public static Texture FONDO_TEXTURE;
    public static Texture CHESTS_BACKGROUND;

    private static TextureAtlas atlas;
    public static AtlasRegion PLAYER_TEXTURE;
    public static AtlasRegion EDIT_BUTTON;
    public static AtlasRegion LEFT_BUTTON;
    public static AtlasRegion RIGHT_BUTTON;

    public static AtlasRegion GAME_ONE;
    public static AtlasRegion GAME_TWO;
    public static AtlasRegion GAME_THREE;
    public static AtlasRegion GAME_FOUR;

    public static AtlasRegion CHEST_RED_CLOSED;
    public static AtlasRegion CHEST_RED_OPEN;
    public static AtlasRegion SHADOW_LEFT_CLOSED;
    public static AtlasRegion SHADOW_LEFT_OPEN;

    public static AtlasRegion CHEST_GREEN_CLOSED;
    public static AtlasRegion CHEST_GREEN_OPEN;
    public static AtlasRegion SHADOW_MIDDLE_CLOSED;
    public static AtlasRegion SHADOW_MIDDLE_OPEN;

    public static AtlasRegion CHEST_BLUE_CLOSED;
    public static AtlasRegion CHEST_BLUE_OPEN;
    public static AtlasRegion SHADOW_RIGHT_CLOSED;
    public static AtlasRegion SHADOW_RIGHT_OPEN;

    public static AtlasRegion SQUARE_BLUE;
    public static AtlasRegion SQUARE_GREEN;
    public static AtlasRegion SQUARE_RED;

    public static AtlasRegion TRIANGLE_RED;
    public static AtlasRegion TRIANGLE_GREEN;
    public static AtlasRegion TRIANGLE_BLUE;

    public static AtlasRegion MEMOCARD_BACK;

    public static Sound SOUND_CHEST_OPEN;
    public static Sound SOUND_CHEST_CLOSE;

    public static void load() {
        atlas = new TextureAtlas(Gdx.files.internal("textures/atlas.atlas"));

        FONDO_TEXTURE = new Texture(Gdx.files.internal("textures/background.png"));
        CHESTS_BACKGROUND = new Texture(Gdx.files.internal("textures/chests_background.png"));

        PLAYER_TEXTURE = new AtlasRegion(atlas.findRegion("character"));
        EDIT_BUTTON = new AtlasRegion(atlas.findRegion("button_config"));
        LEFT_BUTTON = new AtlasRegion(atlas.findRegion("button_right"));
        RIGHT_BUTTON = new AtlasRegion(atlas.findRegion("button_left"));

        GAME_ONE = new AtlasRegion(atlas.findRegion("game_one"));
        GAME_TWO = new AtlasRegion(atlas.findRegion("game_two"));
        GAME_THREE = new AtlasRegion(atlas.findRegion("game_three"));
        GAME_FOUR = new AtlasRegion(atlas.findRegion("game_four"));

        //CHEST_BLUE = new AtlasRegion(atlas.findRegion("chest_blue"));
        //CHEST_GREEN = new AtlasRegion(atlas.findRegion("chest_green"));
        //CHEST_RED = new AtlasRegion(atlas.findRegion("chest_red"));

        CHEST_RED_CLOSED = new AtlasRegion(atlas.findRegion("chest_red_closed"));
        CHEST_RED_OPEN = new AtlasRegion(atlas.findRegion("chest_red_open"));
        SHADOW_LEFT_CLOSED = new AtlasRegion(atlas.findRegion("shadow_left_closed"));
        SHADOW_LEFT_OPEN = new AtlasRegion(atlas.findRegion("shadow_left_open"));

        CHEST_GREEN_CLOSED = new AtlasRegion(atlas.findRegion("chest_green_closed"));
        CHEST_GREEN_OPEN = new AtlasRegion(atlas.findRegion("chest_green_open"));
        SHADOW_MIDDLE_CLOSED = new AtlasRegion(atlas.findRegion("shadow_middle_closed"));
        SHADOW_MIDDLE_OPEN = new AtlasRegion(atlas.findRegion("shadow_middle_open"));

        CHEST_BLUE_CLOSED = new AtlasRegion(atlas.findRegion("chest_blue_closed"));
        CHEST_BLUE_OPEN = new AtlasRegion(atlas.findRegion("chest_blue_open"));
        SHADOW_RIGHT_CLOSED = new AtlasRegion(atlas.findRegion("shadow_right_closed"));
        SHADOW_RIGHT_OPEN = new AtlasRegion(atlas.findRegion("shadow_right_open"));

        SQUARE_BLUE = new AtlasRegion(atlas.findRegion("square_blue"));
        SQUARE_GREEN = new AtlasRegion(atlas.findRegion("square_green"));
        SQUARE_RED = new AtlasRegion(atlas.findRegion("square_red"));

        TRIANGLE_BLUE = new AtlasRegion(atlas.findRegion("triangle_blue"));
        TRIANGLE_GREEN = new AtlasRegion(atlas.findRegion("triangle_green"));
        TRIANGLE_RED = new AtlasRegion(atlas.findRegion("triangle_red"));

        MEMOCARD_BACK = new AtlasRegion(atlas.findRegion("memocard_back"));

        SOUND_CHEST_OPEN = Gdx.audio.newSound(Gdx.files.internal("sounds/chest_open.ogg"));
        SOUND_CHEST_OPEN = Gdx.audio.newSound(Gdx.files.internal("sounds/chest_close.ogg"));
    }

}
