package com.ciel.deviltheyarent.entities;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.ciel.deviltheyarent.world.Platform;
import java.util.List;

public class Player {

    public float x, y;
    public float width = 32,
        height = 32;
    public int lives = 3;

    private float speed = 150f;
    private float velocityY = 0f;
    private float gravity = -500f;
    private boolean onGround = false;

    // Damage cooldown so player doesnt lose lives every frame
    private float damageCooldown = 0f;
    private float damageCooldownMax = 1.5f;

    public Player(float startX, float startY) {
        this.x = startX;
        this.y = startY;
    }

    public void update(float delta, List<Platform> platforms) {
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

        // Platform collision
        onGround = false;
        for (Platform p : platforms) {
            if (collidesWith(p)) {
                // Landing on top of platform
                if (velocityY < 0 && y + height / 2 > p.y) {
                    y = p.y + p.height;
                    velocityY = 0;
                    onGround = true;
                }
            }
        }

        // Damage cooldown tick
        if (damageCooldown > 0) damageCooldown -= delta;
    }

    public void takeDamage() {
        if (damageCooldown <= 0) {
            lives--;
            damageCooldown = damageCooldownMax;
        }
    }

    public boolean isDead() {
        return lives <= 0;
    }

    public boolean collidesWith(Platform p) {
        return (
            x + width > p.x &&
            x < p.x + p.width &&
            y + height > p.y &&
            y < p.y + p.height
        );
    }

    public void render(ShapeRenderer sr) {
        // Flash when damaged
        if (damageCooldown > 0 && (int) (damageCooldown * 10) % 2 == 0) {
            sr.setColor(Color.WHITE);
        } else {
            sr.setColor(Color.PURPLE);
        }
        sr.rect(x, y, width, height);
    }
}
