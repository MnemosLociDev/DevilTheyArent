package com.ciel.deviltheyarent.screens;

import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.utils.ScreenUtils;
import com.ciel.deviltheyarent.DevilTheyArent;

public class MenuScreen implements Screen {

    private final DevilTheyArent game;

    public MenuScreen(DevilTheyArent game) {
        this.game = game;
    }

    @Override
    public void show() {}

    @Override
    public void render(float delta) {
        ScreenUtils.clear(Color.BLACK);
        // planning to add a proper menu later
        // For now just switching to the game screen on any key input
        if (
            com.badlogic.gdx.Gdx.input.isTouched() ||
            com.badlogic.gdx.Gdx.input.isKeyJustPressed(
                com.badlogic.gdx.Input.Keys.ENTER
            )
        ) {
            game.setScreen(new GameScreen(game));
        }
    }

    @Override
    public void resize(int w, int h) {}

    @Override
    public void pause() {}

    @Override
    public void resume() {}

    @Override
    public void hide() {}

    @Override
    public void dispose() {}
}
