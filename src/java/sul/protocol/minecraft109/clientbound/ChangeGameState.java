/*
 * This file was automatically generated by sel-utils and
 * released under the GNU General Public License version 3.
 * 
 * License: https://github.com/sel-project/sel-utils/blob/master/LICENSE
 * Repository: https://github.com/sel-project/sel-utils
 * Generated from https://github.com/sel-project/sel-utils/blob/master/xml/protocol/minecraft109.xml
 */
package sul.protocol.minecraft109.clientbound;

import sul.utils.*;

public class ChangeGameState extends Packet {

	public static final int ID = (int)30;

	public static final boolean CLIENTBOUND = true;
	public static final boolean SERVERBOUND = false;

	@Override
	public int getId() {
		return ID;
	}

	// reason
	public static final byte INVALID_BED = 0;
	public static final byte END_RAINING = 1;
	public static final byte BEGIN_RAINING = 2;
	public static final byte CHANGE_GAMEMODE = 3;
	public static final byte EXIT_END = 4;
	public static final byte DEMO_MESSAGE = 5;
	public static final byte ARROW_HITTING_PLAYER = 6;
	public static final byte FADE_VALUE = 7;
	public static final byte FADE_TIME = 8;
	public static final byte PLAY_ELDER_GUARDIAN_MOB_APPEARANCE = 10;

	// value
	public static final float SURVIVAL = 0;
	public static final float CREATIVE = 1;
	public static final float ADVENTURE = 2;
	public static final float SPECTATOR = 3;
	public static final float RESPAWN_IMMEDIATELY = 0;
	public static final float RESPAWN_AFTER_CREDITS = 1;
	public static final float SHOW_DEMO_SCREEN = 0;
	public static final float TELL_MOVEMENT_CONTROLS = 101;
	public static final float TELL_JUMP_CONTROLS = 102;
	public static final float TELL_INVENTORY_CONTROLS = 103;
	public static final float BRIGHT = 0;
	public static final float DARK = 1;

	public byte reason;
	public float value;

	public ChangeGameState() {}

	public ChangeGameState(byte reason, float value) {
		this.reason = reason;
		this.value = value;
	}

	@Override
	public int length() {
		return Buffer.varuintLength(ID) + 5;
	}

	@Override
	public byte[] encode() {
		this._buffer = new byte[this.length()];
		this.writeVaruint(ID);
		this.writeBigEndianByte(reason);
		this.writeBigEndianFloat(value);
		return this.getBuffer();
	}

	@Override
	public void decode(byte[] buffer) {
		this._buffer = buffer;
		this.readVaruint();
		reason=readBigEndianByte();
		value=readBigEndianFloat();
	}

	public static ChangeGameState fromBuffer(byte[] buffer) {
		ChangeGameState ret = new ChangeGameState();
		ret.decode(buffer);
		return ret;
	}

	@Override
	public String toString() {
		return "ChangeGameState(reason: " + this.reason + ", value: " + this.value + ")";
	}

}
