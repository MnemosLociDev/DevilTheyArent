package com.ciel.deviltheyarent.entities;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

public class Guard {

    public float x, y;
    public float width = 28,
        height = 40;

    private float speed = 80f;
    private float patrolLeft, patrolRight;
    private float flashlightLength = 120f;
    private float flashlightAngle = 30f;
    private boolean movingRight = true;

    public Guard(
        float startX,
        float startY,
        float patrolLeft,
        float patrolRight
    ) {
        this.x = startX;
        this.y = startY;
        this.patrolLeft = patrolLeft;
        this.patrolRight = patrolRight;
    }

    public void update(float delta) {
        // Making our mob aka stevens, Patrol back and forth
        if (movingRight) {
            x += speed * delta;
            if (x >= patrolRight) movingRight = false;
        } else {
            x -= speed * delta;
            if (x <= patrolLeft) movingRight = true;
        }
    }

    // Checks if player is inside the flashlight cone
    public boolean flashlightHits(Player player) {
        // Flashlight points in the direction guard is facing
        float lightX = movingRight ? x + width : x;
        float lightY = y + height / 2;

        float playerCenterX = player.x + player.width / 2;
        float playerCenterY = player.y + player.height / 2;

        float dx = playerCenterX - lightX;
        float dy = playerCenterY - lightY;
        float dist = (float) Math.sqrt(dx * dx + dy * dy);

        if (dist > flashlightLength) return false;

        // Checks the angle, we want to know is player within the cone?
        float facingX = movingRight ? 1 : -1;
        float dot = (dx / dist) * facingX;
        float angleThreshold = (float) Math.cos(
            Math.toRadians(flashlightAngle)
        );

        return dot >= angleThreshold;
    }

    public void render(ShapeRenderer sr) {
        // stevens body for now since we haven't added assets
        sr.setColor(Color.BLUE);
        sr.rect(x, y, width, height);

        // Flashlight cone for now
        sr.setColor(new Color(1f, 1f, 0.5f, 0.4f));
        float lightStartX = movingRight ? x + width : x;
        float lightStartY = y + height / 2;
        float lightEndX = movingRight
            ? lightStartX + flashlightLength
            : lightStartX - flashlightLength;

        // Draws a triangle for the cone
        sr.triangle(
            lightStartX,
            lightStartY,
            lightEndX,
            lightStartY + 40,
            lightEndX,
            lightStartY - 40
        );
    }
}
