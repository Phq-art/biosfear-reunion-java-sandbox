package org.reunionemu.jreunion.game.items.etc;

import org.reunionemu.jcommon.ParsedItem;
import org.reunionemu.jreunion.game.Player.Race;
import org.reunionemu.jreunion.game.PlayerItem;
import org.reunionemu.jreunion.server.Reference;

public class EtcItem extends PlayerItem {
	private Race race; // -1 - Common; 0 - Bulkan; 1 - Kailipton; 2 - Aidia;

	// 3 - Human; 4 - Pet

	private int skillLevel;

	public EtcItem(int id) {
		super(id);
	}

	public Race getRace() {
		return race;
	}

	public int getSkillLevel() {
		return skillLevel;
	}

	@Override
	public void loadFromReference(int id) {
		super.loadFromReference(id);

		ParsedItem item = Reference.getInstance().getItemReference()
				.getItemById(id);

		if (item == null) {
			// cant find Item in the reference continue to load defaults:		
			setSkillLevel(0);
			setReqStr(0);
			setReqInt(0);
			setReqDex(0);
			setRace(Race.UNDEFINED);
		} else {
			
			if (item.checkMembers(new String[] { "SkillLevel" })) {
				// use member from file
				setSkillLevel(Integer.parseInt(item
						.getMemberValue("SkillLevel")));
			} else {
				// use default
				setSkillLevel(0);
			}
			if (item.checkMembers(new String[] { "ReqStr" })) {
				// use member from file
				setReqStr(Integer.parseInt(item.getMemberValue("ReqStr")));
			} else {
				// use default
				setReqStr(0);
			}
			if (item.checkMembers(new String[] { "ReqInt" })) {
				// use member from file
				setReqInt(Integer.parseInt(item.getMemberValue("ReqInt")));
			} else {
				// use default
				setReqInt(0);
			}
			if (item.checkMembers(new String[] { "ReqDex" })) {
				// use member from file
				setReqDex(Integer.parseInt(item.getMemberValue("ReqDex")));
			} else {
				// use default
				setReqDex(0);
			}
			if (item.checkMembers(new String[] { "Race" })) {
				// use member from file
				setRace(Race.values()[Integer.parseInt(item.getMemberValue("Race"))]);
			} else {
				// use default
				setRace(Race.UNDEFINED);
			}
		}
	}

	public void setRace(Race race) {
		this.race = race;
	}

	public void setSkillLevel(int skillLevel) {
		this.skillLevel = skillLevel;
	}
}