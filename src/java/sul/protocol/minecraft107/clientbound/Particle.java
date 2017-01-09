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

class Particle extends Packet {

	public final static int ID = (int)34;

	public final static boolean CLIENTBOUND = true;
	public final static boolean SERVERBOUND = false;

	// particle id
	public final static int EXPLODE = (int)0;
	public final static int LARGE_EXPLOSION = (int)1;
	public final static int HUGE_EXPLOSION = (int)2;
	public final static int FIREWORK_SPARK = (int)3;
	public final static int BUBBLE = (int)4;
	public final static int SPLASH = (int)5;
	public final static int WAKE = (int)6;
	public final static int SUSPENDED = (int)7;
	public final static int DEPTH_SUSPEND = (int)8;
	public final static int CRIT = (int)9;
	public final static int MAGIC_CRIT = (int)10;
	public final static int SMOKE = (int)11;
	public final static int LARGE_SMOKE = (int)12;
	public final static int SPELL = (int)13;
	public final static int INSTANT_SPELL = (int)14;
	public final static int MOB_SPELL = (int)15;
	public final static int MOB_SPELL_AMBIENT = (int)16;
	public final static int WITCH_MAGIC = (int)17;
	public final static int DRIP_WATER = (int)18;
	public final static int DRIP_LAVA = (int)19;
	public final static int ANGRY_VILLAGER = (int)20;
	public final static int HAPPY_VILLAGER = (int)21;
	public final static int TOWN_AURA = (int)22;
	public final static int NOTE = (int)23;
	public final static int PORTAL = (int)24;
	public final static int ENCHANTMENT_TABLE = (int)25;
	public final static int FLAME = (int)26;
	public final static int LAVA = (int)27;
	public final static int FOOTSTEP = (int)28;
	public final static int CLOUD = (int)29;
	public final static int RED_DUST = (int)30;
	public final static int SNOWBALL_POOF = (int)31;
	public final static int SNOW_SHOVEL = (int)32;
	public final static int SLIME = (int)33;
	public final static int HEART = (int)34;
	public final static int BARRIER = (int)35;
	public final static int ITEM_CRACK = (int)36;
	public final static int BLOCK_CRACK = (int)37;
	public final static int BLOCK_DUST = (int)38;
	public final static int DROPLET = (int)39;
	public final static int TAKE = (int)40;
	public final static int MOB_APPEARANCE = (int)41;
	public final static int DRAGON_BREATH = (int)42;
	public final static int ENDROD = (int)43;
	public final static int DAMAGE_INDICATOR = (int)44;
	public final static int SWEEP_ATTACK = (int)45;

	public int particleId;
	public boolean longDistance;
	public Tuples.FloatXYZ position;
	public Tuples.FloatXYZ offset;
	public float data;
	public int count;
	public int[2] additionalData;

	@Override
	public int length() {
		return position.length() + offset.length() + Var.Uint.length(additionalData.length) + additionalData.length() + 13;
	}

	@Override
	public byte[] encode() {
	}

	@Override
	public void decode(byte[] buffer) {
	}

}
