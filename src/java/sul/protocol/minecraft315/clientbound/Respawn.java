/*
 * This file has been automatically generated by sel-utils and
 * released under the GNU General Public License version 3.
 *
 * License: https://github.com/sel-project/sel-utils/blob/master/LICENSE
 * Repository: https://github.com/sel-project/sel-utils
 * Generator: https://github.com/sel-project/sel-utils/blob/master/xml/protocol/minecraft315.xml
 */
package sul.protocol.minecraft315.clientbound;

import java.util.UUID;

import sul.protocol.minecraft315.types.*;
import sul.utils.*;

class Respawn extends Packet {

	public final static int ID = (int)51;

	public final static boolean CLIENTBOUND = true;
	public final static boolean SERVERBOUND = false;

	// dimension
	public static immutable int NETHER = -1;
	public static immutable int OVERWORLD = 0;
	public static immutable int END = 1;

	// difficulty
	public static immutable byte PEACEFUL = 0;
	public static immutable byte EASY = 1;
	public static immutable byte NORMAL = 2;
	public static immutable byte HARD = 3;

	// gamemode
	public static immutable byte SURVIVAL = 0;
	public static immutable byte CREATIVE = 1;
	public static immutable byte ADVENTURE = 2;
	public static immutable byte SPECTATOR = 3;

	// level type
	public static immutable String INFINITY = "default";
	public static immutable String FLAT = "flat";
	public static immutable String AMPLIFIED = "amplified";
	public static immutable String LARGE_BIOMES = "largeBiomes";

	public int dimension;
	public byte difficulty;
	public byte gamemode;
	public String levelType;

	@Override
	public int length() {
	}

	@Override
	public byte[] encode() {
		this.buffer = new byte[this.length()];
		this.index = 0;
		this.writeVaruint(ID);
		this.writeIntB(dimension);
		this.writeByteB(difficulty);
		this.writeByteB(gamemode);
		byte[] bgv2zwxuexbl=levelType.getBytes("UTF-8"); this.writeVaruint((int)bgv2zwxuexbl.length); this.writeBytes(bgv2zwxuexbl);
		return this.buffer;
	}

	@Override
	public void decode(byte[] buffer) {
		this.buffer = buffer;
		this.index = 0;
	}

}
