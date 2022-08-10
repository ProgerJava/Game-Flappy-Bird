package com.mygdx.game;


import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;

public class Obstacles {
    final int distance = 250;
    private final int speed = 5;
    Texture picturePipe = new Texture("wall.png");
    int random1 =(int) (Math.random()*-150);
    Vector2 vectorPipe1 = new Vector2(800, random1);
    int random2 =(int) (Math.random()*-150);
    Vector2 vectorPipe2 = new Vector2(vectorPipe1.x+distance, random2);
    int random3 =(int) (Math.random()*-150);
    Vector2 vectorPipe3 = new Vector2(vectorPipe2.x+distance, random3);
    int random4 =(int) (Math.random()*-150);
    Vector2 vectorPipe4 = new Vector2(vectorPipe3.x+distance, random4);

    int vectorPipeUpY1 = (int) (600-Math.abs(vectorPipe1.y)-100);
    int vectorPipeUpY2 = (int) (600-Math.abs(vectorPipe2.y)-100);
    int vectorPipeUpY3 = (int) (600-Math.abs(vectorPipe3.y)-100);
    int vectorPipeUpY4 = (int) (600-Math.abs(vectorPipe4.y)-100);
    public void render (SpriteBatch spriteBatch) {
        //Нижние трубы
        spriteBatch.draw(picturePipe, vectorPipe1.x, vectorPipe1.y);
        spriteBatch.draw(picturePipe, vectorPipe2.x, vectorPipe2.y);
        spriteBatch.draw(picturePipe, vectorPipe3.x, vectorPipe3.y);
        spriteBatch.draw(picturePipe, vectorPipe4.x, vectorPipe4.y);
        //Верхние трубы
        spriteBatch.draw(picturePipe, vectorPipe1.x, vectorPipeUpY1);
        spriteBatch.draw(picturePipe, vectorPipe2.x, vectorPipeUpY2);
        spriteBatch.draw(picturePipe, vectorPipe3.x, vectorPipeUpY3);
        spriteBatch.draw(picturePipe, vectorPipe4.x, vectorPipeUpY4);

    }
    public void update () {
        vectorPipe1.x -= speed;
        if (vectorPipe1.x <= -200) {
            vectorPipe1.x = vectorPipe4.x+distance;
            vectorPipe1.y = (int) (Math.random()*-150);
            vectorPipeUpY1 = (int) (600-Math.abs(vectorPipe1.y)-100);
        }
        vectorPipe2.x -= speed;
        if (vectorPipe2.x <= -200) {
            vectorPipe2.x = vectorPipe1.x+distance;
            vectorPipe2.y = (int) (Math.random()*-150);
            vectorPipeUpY2 = (int) (600-Math.abs(vectorPipe2.y)-100);
        }
        vectorPipe3.x -= speed;
        if (vectorPipe3.x <= -200) {
            vectorPipe3.x = vectorPipe2.x+distance;
            vectorPipe3.y = (int) (Math.random()*-150);
            vectorPipeUpY3 = (int) (600-Math.abs(vectorPipe3.y)-100);
        }
        vectorPipe4.x -= speed;
        if (vectorPipe4.x <= -200) {
            vectorPipe4.x = vectorPipe3.x+distance;
            vectorPipe4.y = (int) (Math.random()*-150);
            vectorPipeUpY4 = (int) (600-Math.abs(vectorPipe4.y)-100);
        }
    }
}