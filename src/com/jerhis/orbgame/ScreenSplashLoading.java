package com.jerhis.orbgame;

import com.jerhis.framework.Game;
import com.jerhis.framework.Screen;

//it loads the splash to display on the actual loading screen

public class ScreenSplashLoading extends Screen {

	public ScreenSplashLoading(Game game) {
		super(game);
	}

	@Override
	public void update(float deltaTime) {
		Assets.loadSplash(game.getGraphics());
		game.setScreen(new ScreenLoading(game));
	}

	@Override
	public void paint(float deltaTime) {

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