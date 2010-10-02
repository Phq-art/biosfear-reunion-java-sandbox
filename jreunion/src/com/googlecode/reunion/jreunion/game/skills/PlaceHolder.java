package com.googlecode.reunion.jreunion.game.skills;

import com.googlecode.reunion.jreunion.game.Skill;

public class PlaceHolder extends Skill{

	public PlaceHolder(int id) {
		super(id);
	}

	@Override
	public int getMaxLevel() {
		return 25;
	}

	@Override
	public int getLevelRequirement(int level) {
		return 0;
	}

}
