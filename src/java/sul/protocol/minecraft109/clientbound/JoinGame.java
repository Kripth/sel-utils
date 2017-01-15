/*
 * This file has been automatically generated by sel-utils and
 * released under the GNU General Public License version 3.
 *
 * License: https://github.com/sel-project/sel-utils/blob/master/LICENSE
 * Repository: https://github.com/sel-project/sel-utils
 * Generator: https://github.com/sel-project/sel-utils/blob/master/xml/protocol/minecraft109.xml
 */
package sul.protocol.minecraft109.clientbound;

import java.util.UUID;

import sul.protocol.minecraft109.types.*;
import sul.utils.*;

class JoinGame extends Packet {

	public final static int ID = (int)35;

	public final static boolean CLIENTBOUND = true;
	public final static boolean SERVERBOUND = false;

	// gamemode
	public static immutable byte SURVIVAL = 0;
	public static immutable byte CREATIVE = 1;
	public static immutable byte ADVENTURE = 2;
	public static immutable byte SPECTATOR = 3;

	// dimension
	public static immutable int NETHER = -1;
	public static immutable int OVERWORLD = 0;
	public static immutable int END = 1;

	// difficulty
	public static immutable byte PEACEFUL = 0;
	public static immutable byte EASY = 1;
	public static immutable byte NORMAL = 2;
	public static immutable byte HARD = 3;

	// level type
	public static immutable String INFINITY = "default";
	public static immutable String FLAT = "flat";
	public static immutable String AMPLIFIED = "amplified";
	public static immutable String LARGE_BIOMES = "largeBiomes";

	public int entityId;
	public byte gamemode;
	public int dimension;
	public byte difficulty;
	public byte maxPlayers;
	public String levelType;
	public boolean reducedDebug;

	@Override
	public int length() {
	}

	@Override
	public byte[] encode() {
		this.buffer = new byte[this.length()];
		this.index = 0;
		this.writeVaruint(ID);
		this.writeIntB(entityId);
		this.writeByteB(gamemode);
		this.writeIntB(dimension);
		this.writeByteB(difficulty);
		this.writeByteB(maxPlayers);
		byte[] bgv2zwxuexbl=levelType.getBytes("UTF-8"); this.writeVaruint((int)bgv2zwxuexbl.length); this.writeBytes(bgv2zwxuexbl);
		this.writeBoolB(reducedDebug);
		return this.buffer;
	}

	@Override
	public void decode(byte[] buffer) {
		this.buffer = buffer;
		this.index = 0;
	}

}
