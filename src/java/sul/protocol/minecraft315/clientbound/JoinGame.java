/*
 * This file was automatically generated by sel-utils and
 * released under the GNU General Public License version 3.
 *
 * License: https://github.com/sel-project/sel-utils/blob/master/LICENSE
 * Repository: https://github.com/sel-project/sel-utils
 * Generated from https://github.com/sel-project/sel-utils/blob/master/xml/protocol/minecraft315.xml
 */
package sul.protocol.minecraft315.clientbound;

import java.nio.charset.StandardCharsets;

import sul.utils.*;

public class JoinGame extends Packet {

	public static final int ID = (int)35;

	public static final boolean CLIENTBOUND = true;
	public static final boolean SERVERBOUND = false;

	// gamemode
	public static final byte SURVIVAL = 0;
	public static final byte CREATIVE = 1;
	public static final byte ADVENTURE = 2;
	public static final byte SPECTATOR = 3;

	// dimension
	public static final int NETHER = -1;
	public static final int OVERWORLD = 0;
	public static final int END = 1;

	// difficulty
	public static final byte PEACEFUL = 0;
	public static final byte EASY = 1;
	public static final byte NORMAL = 2;
	public static final byte HARD = 3;

	// level type
	public static final String INFINITY = "default";
	public static final String FLAT = "flat";
	public static final String AMPLIFIED = "amplified";
	public static final String LARGE_BIOMES = "largeBiomes";

	public int entityId;
	public byte gamemode;
	public int dimension;
	public byte difficulty;
	public byte maxPlayers;
	public String levelType;
	public boolean reducedDebug;

	public JoinGame() {}

	public JoinGame(int entityId, byte gamemode, int dimension, byte difficulty, byte maxPlayers, String levelType, boolean reducedDebug) {
		this.entityId = entityId;
		this.gamemode = gamemode;
		this.dimension = dimension;
		this.difficulty = difficulty;
		this.maxPlayers = maxPlayers;
		this.levelType = levelType;
		this.reducedDebug = reducedDebug;
	}

	@Override
	public int length() {
		return Buffer.varuintLength(ID) + Buffer.varuintLength(levelType.getBytes(StandardCharsets.UTF_8).length) + levelType.getBytes(StandardCharsets.UTF_8).length + 12;
	}

	@Override
	public byte[] encode() {
		this._buffer = new byte[this.length()];
		this.writeVaruint(ID);
		this.writeBigEndianInt(entityId);
		this.writeBigEndianByte(gamemode);
		this.writeBigEndianInt(dimension);
		this.writeBigEndianByte(difficulty);
		this.writeBigEndianByte(maxPlayers);
		byte[] bgv2zwxuexbl=levelType.getBytes(StandardCharsets.UTF_8); this.writeVaruint((int)bgv2zwxuexbl.length); this.writeBytes(bgv2zwxuexbl);
		this.writeBool(reducedDebug);
		return this._buffer;
	}

	@Override
	public void decode(byte[] buffer) {
		this._buffer = buffer;
		this.readVaruint();
		entityId=readBigEndianInt();
		gamemode=readBigEndianByte();
		dimension=readBigEndianInt();
		difficulty=readBigEndianByte();
		maxPlayers=readBigEndianByte();
		int bgvubgv2zwxuexbl=this.readVaruint(); levelType=new String(this.readBytes(bgvubgv2zwxuexbl), StandardCharsets.UTF_8);
		reducedDebug=this.readBool();
	}

	public static JoinGame fromBuffer(byte[] buffer) {
		JoinGame ret = new JoinGame();
		ret.decode(buffer);
		return ret;
	}

}
