package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;

public class Bird {
    Texture pictureBird = new Texture("bird1.png");
    Vector2 vectorBird = new Vector2(100, 400);
    float speed = 0.0f;
    float gravity = - 0.6f;

    public void render (SpriteBatch spriteBatch) {
        spriteBatch.draw(pictureBird, vectorBird.x, vectorBird.y);
    }
    public void update () {
        if (Gdx.input.isKeyPressed(Input.Keys.SPACE)) {
            speed = 8;
        }
        speed += gravity;
        vectorBird.y += speed;
    }
}