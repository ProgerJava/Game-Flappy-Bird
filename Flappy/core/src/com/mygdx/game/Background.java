package com.mygdx.game;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;

public class Background {
    Texture background = new Texture("back.png");
    Vector2 vectorBackground = new Vector2(0, 0);
    Vector2 vectorBackground1 = new Vector2(800, 0);
    private final int speed = 6;


    public void render (SpriteBatch spriteBatch) {
        spriteBatch.draw(background, vectorBackground.x, vectorBackground.y);
        spriteBatch.draw(background, vectorBackground1.x, vectorBackground1.y);
    }
    public void update () {
        vectorBackground.x -= speed;
        vectorBackground1.x -= speed;
        if (vectorBackground.x <= -800) {
            vectorBackground.x = 800;
        }
        if (vectorBackground1.x <= -800) {
            vectorBackground1.x = 800;
        }
    }

}
