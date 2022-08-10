package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;



public class MyGdxGame extends ApplicationAdapter {
	SpriteBatch batch;
	Background bg;
	Bird bird;
	Obstacles obstacles;
	private boolean isPlay;
	Texture restart;
	BitmapFont bitmapFont;
	int count = 0;




	@Override
	public void create () {
		bitmapFont = new BitmapFont();
		batch = new SpriteBatch();
		bg = new Background();
		bird = new Bird();
		obstacles = new Obstacles();
		isPlay = true;
		restart = new Texture("RestartBtn.png");


	}

	@Override
	public void render () {
		batch.begin();
		bg.update();
		bg.render(batch);
		//Проверка птицы на жизнь...
		alive();
		/////////
		if (isPlay) {
			update();
			obstacles.render(batch);
			bird.render(batch);
			//Отрисовка счетчика:
			bitmapFont.getData().setScale(1.5f, 1.5f);
			bitmapFont.draw(batch, "Score: " + getCount(), 30, 580);
		} else {
			bitmapFont.draw(batch, "Score: " + getCount(), 30, 580);
			batch.draw(restart, 200, 100);
		}
		if (Gdx.input.isKeyPressed(Input.Keys.SPACE)) {
			if (!isPlay) {
				bird.vectorBird.y = 400;
				obstacles.vectorPipe1.x = 800;
				obstacles.vectorPipe2.x = 1050;
				obstacles.vectorPipe3.x = 1300;
				obstacles.vectorPipe4.x = 1550;
				count = 0;
				isPlay = true;
			}
		}
		batch.end();
	}

	public void update(){
		obstacles.update();
		bird.update();
	}

	@Override
	public void dispose () {
		batch.dispose();
	}
	public void alive () {
		//Проверка птицы на соприкосновение с границами карты:
		if (bird.vectorBird.y > 600 || bird.vectorBird.y < 0) {
			isPlay = false;
		}
		//Проверка птицы на соприкосновение с нижними препятствиями:
		if ((bird.vectorBird.x+40 >= obstacles.vectorPipe1.x && bird.vectorBird.x+40 <= obstacles.vectorPipe1.x + 50) &&
				(bird.vectorBird.y <= obstacles.vectorPipe1.y+300)) {
			isPlay = false;
		}
		if ((bird.vectorBird.x+40 >= obstacles.vectorPipe2.x && bird.vectorBird.x+40 <= obstacles.vectorPipe2.x + 50) &&
				(bird.vectorBird.y <= obstacles.vectorPipe2.y+300)) {
			isPlay = false;
		}
		if ((bird.vectorBird.x+40 >= obstacles.vectorPipe3.x && bird.vectorBird.x+40 <= obstacles.vectorPipe3.x + 50) &&
				(bird.vectorBird.y <= obstacles.vectorPipe3.y+300)) {
			isPlay = false;
		}
		if ((bird.vectorBird.x+40 >= obstacles.vectorPipe4.x && bird.vectorBird.x+40 <= obstacles.vectorPipe4.x + 50) &&
				(bird.vectorBird.y <= obstacles.vectorPipe4.y+300)) {
			isPlay = false;
		}
		//Проверка птицы на соприкосновение с верхними препятствиями:
		if ((bird.vectorBird.x+40 >= obstacles.vectorPipe1.x && bird.vectorBird.x+40 <= obstacles.vectorPipe1.x + 50) &&
				(bird.vectorBird.y+40 >= obstacles.vectorPipeUpY1)) {
			isPlay = false;
		}
		if ((bird.vectorBird.x+40 >= obstacles.vectorPipe2.x && bird.vectorBird.x+40 <= obstacles.vectorPipe2.x + 50) &&
				(bird.vectorBird.y+40 >= obstacles.vectorPipeUpY2)) {
			isPlay = false;
		}
		if ((bird.vectorBird.x+40 >= obstacles.vectorPipe3.x && bird.vectorBird.x+40 <= obstacles.vectorPipe3.x + 50) &&
				(bird.vectorBird.y+40 >= obstacles.vectorPipeUpY3)) {
			isPlay = false;
		}
		if ((bird.vectorBird.x+40 >= obstacles.vectorPipe4.x && bird.vectorBird.x+40 <= obstacles.vectorPipe4.x + 50) &&
				(bird.vectorBird.y+40 >= obstacles.vectorPipeUpY4)) {
			isPlay = false;
		}
	}
	public Integer getCount () {

		if (bird.vectorBird.x == obstacles.vectorPipe1.x) {
			 count++;
		}
		if (bird.vectorBird.x == obstacles.vectorPipe2.x) {
			count++;
		}
		if (bird.vectorBird.x == obstacles.vectorPipe3.x) {
			count++;
		}
		if (bird.vectorBird.x == obstacles.vectorPipe4.x) {
			count++;
		}
		return count;
	}

}