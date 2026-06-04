package com.ciel.deviltheyarent.entities;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

public class Player {

    public float x, y;
    public float width = 32,
        height = 32;

    private float speed = 150f;
    private float velocityY = 0f;
    private float gravity = -500f;
    private boolean onGround = false;
    private float groundY = 50f;

    public Player(float startX, float startY) {
        this.x = startX;
        this.y = startY;
    }

    public void update(float delta) {
        // Horizontal movement
        if (
            Gdx.input.isKeyPressed(Input.Keys.A) ||
            Gdx.input.isKeyPressed(Input.Keys.LEFT)
        ) {
            x -= speed * delta;
        }
        if (
            Gdx.input.isKeyPressed(Input.Keys.D) ||
            Gdx.input.isKeyPressed(Input.Keys.RIGHT)
        ) {
            x += speed * delta;
        }

        // Jump
        if (
            (Gdx.input.isKeyJustPressed(Input.Keys.W) ||
                Gdx.input.isKeyJustPressed(Input.Keys.UP) ||
                Gdx.input.isKeyJustPressed(Input.Keys.SPACE)) &&
            onGround
        ) {
            velocityY = 300f;
            onGround = false;
        }

        // Gravity
        velocityY += gravity * delta;
        y += velocityY * delta;

        // Simple ground check
        if (y <= groundY) {
            y = groundY;
            velocityY = 0;
            onGround = true;
        }
    }

    public void render(ShapeRenderer sr) {
        sr.setColor(Color.PURPLE);
        sr.rect(x, y, width, height);
    }
}
