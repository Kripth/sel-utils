/*
 * This file has been automatically generated by sel-utils and
 * released under the GNU General Public License version 3.
 *
 * License: https://github.com/sel-project/sel-utils/blob/master/LICENSE
 * Repository: https://github.com/sel-project/sel-utils
 * Generator: https://github.com/sel-project/sel-utils/blob/master/xml/protocol/minecraft110.xml
 */
package sul.protocol.minecraft110.clientbound;

import java.util.UUID;

import sul.protocol.minecraft110.types.*;
import sul.utils.*;

class JoinGame extends Packet {

	public final static int ID = (int)35;

	public final static boolean CLIENTBOUND = true;
	public final static boolean SERVERBOUND = false;

	// gamemode
	public final static byte SURVIVAL = (byte)0;
	public final static byte CREATIVE = (byte)1;
	public final static byte ADVENTURE = (byte)2;
	public final static byte SPECTATOR = (byte)3;

	// dimension
	public final static int END = (int)-1;
	public final static int OVERWORLD = (int)0;
	public final static int NETHER = (int)1;

	// difficulty
	public final static byte PEACEFUL = (byte)0;
	public final static byte EASY = (byte)1;
	public final static byte NORMAL = (byte)2;
	public final static byte HARD = (byte)3;

	// level type
	public final static String INFINITY = (String)default;
	public final static String FLAT = (String)flat;
	public final static String AMPLIFIED = (String)amplified;
	public final static String LARGE_BIOMES = (String)largeBiomes;

	public int entityId;
	public byte gamemode;
	public int dimension;
	public byte difficulty;
	public byte maxPlayers;
	public String levelType;
	public boolean reducedDebug;

	@Override
	public int length() {
		return Var.Uint.length(levelType.getBytes(StandardCharset.UTF_8).length) + levelType.getBytes(StandardCharset.UTF_8).length + 12;
	}

	@Override
	public byte[] encode() {
	}

	@Override
	public void decode(byte[] buffer) {
	}

}
