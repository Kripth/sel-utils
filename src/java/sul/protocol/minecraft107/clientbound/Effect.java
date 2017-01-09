/*
 * This file has been automatically generated by sel-utils and
 * released under the GNU General Public License version 3.
 *
 * License: https://github.com/sel-project/sel-utils/blob/master/LICENSE
 * Repository: https://github.com/sel-project/sel-utils
 * Generator: https://github.com/sel-project/sel-utils/blob/master/xml/protocol/minecraft107.xml
 */
package sul.protocol.minecraft107.clientbound;

import java.util.UUID;

import sul.protocol.minecraft107.types.*;
import sul.utils.*;

class Effect extends Packet {

	public final static int ID = (int)33;

	public final static boolean CLIENTBOUND = true;
	public final static boolean SERVERBOUND = false;

	// effect id
	public final static int DISPENSER_DISPENSE = (int)1000;
	public final static int DISPENSER_FAIL_DISPENSE = (int)1001;
	public final static int DISPENSER_SHOOT = (int)1002;
	public final static int DOOR_OPEN_OR_CLOSE = (int)1003;
	public final static int FIREWORK_SHOT = (int)1004;
	public final static int PLAY_DISC = (int)1005;
	public final static int GHAST_WARN = (int)1007;
	public final static int GHAST_SHOOT = (int)1008;
	public final static int ZOMBIE_ATTACK_WOOD_DOOR = (int)1010;
	public final static int ZOMBIE_ATTACK_IRON_DOOR = (int)1011;
	public final static int ZOMBIE_BREAK_WOOD_DOOR = (int)1012;
	public final static int WITHER_SPAWN = (int)1013;
	public final static int WITHER_SHOOT = (int)1014;
	public final static int BAT_TAKE_OFF = (int)1015;
	public final static int ZOMBIE_INFECT_VILLAGER = (int)1016;
	public final static int ZOMBIE_VILLAGER_CONVERT = (int)1017;
	public final static int ANVIL_BREAK = (int)1019;
	public final static int ANVIL_USE = (int)1020;
	public final static int ANVIL_LAND = (int)1021;
	public final static int SPAWN_10_SMOKE_PARTICLES = (int)2000;
	public final static int BREAK_BREAK_PARTICLES = (int)2001;
	public final static int SPLASH_POTION_PARTICLES_AND_SOUND = (int)2002;
	public final static int ENDER_EYE_BREAK_PARTICLES_AND_SOUND = (int)2003;
	public final static int MOB_SPAWN_PARTICLES = (int)2004;
	public final static int BONEMEAL_PARTICLES = (int)2005;

	public int effectId;
	public long position;
	public int data;
	public boolean disableVolume;

	@Override
	public int length() {
		return 17;
	}

	@Override
	public byte[] encode() {
	}

	@Override
	public void decode(byte[] buffer) {
	}

}
