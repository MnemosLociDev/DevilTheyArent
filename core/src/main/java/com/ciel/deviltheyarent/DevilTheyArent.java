package com.ciel.deviltheyarent;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.ciel.deviltheyarent.screens.MenuScreen;

public class DevilTheyArent extends Game {

    public SpriteBatch batch;

    @Override
    public void create() {
        batch = new SpriteBatch();
        setScreen(new MenuScreen(this));
    }

    @Override
    public void dispose() {
        batch.dispose();
    }
}
