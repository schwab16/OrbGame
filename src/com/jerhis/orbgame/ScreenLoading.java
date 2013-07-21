package com.jerhis.orbgame;

import com.jerhis.framework.Game;
import com.jerhis.framework.Graphics;
import com.jerhis.framework.Screen;

public class ScreenLoading extends Screen {
	public ScreenLoading(Game game) {
		super(game);
	}

	@Override
	public void update(float deltaTime) {
		Graphics g = game.getGraphics();
        Assets.load(g);
		game.setScreen(new ScreenPackSelect(game));
	}

	@Override
	public void paint(float deltaTime) {
		Graphics g = game.getGraphics();
		g.drawImage(Assets.splash, 0, 0);
	}

	@Override
	public void pause() {

	}

	@Override
	public void resume() {

	}

	@Override
	public void dispose() {

	}

	@Override
	public void backButton() {

	}
}