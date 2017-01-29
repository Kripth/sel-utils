/*
 * This file was automatically generated by sel-utils and
 * released under the GNU General Public License version 3.
 *
 * License: https://github.com/sel-project/sel-utils/blob/master/LICENSE
 * Repository: https://github.com/sel-project/sel-utils
 * Generated from https://github.com/sel-project/sel-utils/blob/master/xml/protocol/minecraft107.xml
 */
package sul.protocol.minecraft107.serverbound;

import sul.utils.*;

public class PlayerDigging extends Packet {

	public static final int ID = (int)19;

	public static final boolean CLIENTBOUND = false;
	public static final boolean SERVERBOUND = true;

	// status
	public static final int START_DIGGING = 0;
	public static final int CANCEL_DIGGING = 1;
	public static final int FINISH_DIGGING = 2;
	public static final int DROP_ITEM_STACK = 3;
	public static final int DROP_ITEM = 4;
	public static final int SHOOT_ARROW = 5;
	public static final int FINISH_EATING = 5;
	public static final int SWAP_ITEM_IN_HAND = 6;

	public int status;
	public long position;
	public byte face;

	public PlayerDigging() {}

	public PlayerDigging(int status, long position, byte face) {
		this.status = status;
		this.position = position;
		this.face = face;
	}

	@Override
	public int length() {
		return Buffer.varuintLength(ID) + Buffer.varuintLength(status) + 9;
	}

	@Override
	public byte[] encode() {
		this._buffer = new byte[this.length()];
		this.writeVaruint(ID);
		this.writeVaruint(status);
		this.writeBigEndianLong(position);
		this.writeBigEndianByte(face);
		return this.getBuffer();
	}

	@Override
	public void decode(byte[] buffer) {
		this._buffer = buffer;
		this.readVaruint();
		status=this.readVaruint();
		position=readBigEndianLong();
		face=readBigEndianByte();
	}

	public static PlayerDigging fromBuffer(byte[] buffer) {
		PlayerDigging ret = new PlayerDigging();
		ret.decode(buffer);
		return ret;
	}

}
