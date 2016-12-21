package com.jbk;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class JbsBugsKiller extends ApplicationAdapter {
	SpriteBatch batch;
	private Background background;
	private Hero hero;
	private final int BUGS_COUNT = 30;
	private Bugs[] bugs;
	private final int BULLETS_COUNT = 100;
	public static Bullet[] bullets;
	private Texture textureBullet;

	@Override
	public void create () {
		batch = new SpriteBatch();
		background = new Background();
		hero = new Hero();
		bugs = new Bugs[BUGS_COUNT];
		for (int i = 0; i < BUGS_COUNT; i++){
			bugs[i] = new Bugs();
		}
		bullets = new Bullet[BULLETS_COUNT];
		for (int i = 0; i < BULLETS_COUNT; i++){
			bullets[i] = new Bullet();
		}
		textureBullet = new Texture("bullet20.png");
	}

	@Override
	public void render () {
		update();
		Gdx.gl.glClearColor(1, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		batch.begin();
		background.render(batch);
		hero.render(batch);
		for(int i = 0; i < BUGS_COUNT; i++){
			bugs[i].render(batch);
		}
		for (int i = 0; i < BULLETS_COUNT; i++) {
			if(bullets[i].isActive())
				batch.draw(textureBullet, bullets[i].getPosition().x, bullets[i].getPosition().y);
		}

		batch.end();
	}

	public void update() {
		background.update();
		hero.update();
		for(int i = 0; i < BUGS_COUNT; i++){
			bugs[i].update();
		}
		for (int i = 0; i < BULLETS_COUNT; i++) {
			if(bullets[i].isActive())
				bullets[i].update();
			for (int j =0; j < BUGS_COUNT; j++){
				if(bugs[j].getRect().contains(bullets[i].getPosition())){
					bugs[j].recreate();
					bullets[i].destroy();
					break;				}
			}
		}
	}



	@Override
	public void dispose () {
		batch.dispose();
	}
}
