/*
 * This file was automatically generated by sel-utils and
 * released under the GNU General Public License version 3.
 *
 * License: https://github.com/sel-project/sel-utils/blob/master/LICENSE
 * Repository: https://github.com/sel-project/sel-utils
 * Generated from https://github.com/sel-project/sel-utils/blob/master/xml/protocol/minecraft47.xml
 */
package sul.protocol.minecraft47.clientbound;

import sul.utils.*;

public class UpdateBlockEntity extends Packet {

	public static final int ID = (int)53;

	public static final boolean CLIENTBOUND = true;
	public static final boolean SERVERBOUND = false;

	// action
	public static final byte MOB_SPAWNER_DATA = 1;
	public static final byte COMMAND_BLOCK_TEXT = 2;
	public static final byte BEACON_POWERS = 3;
	public static final byte MOB_HEAD_DATA = 4;
	public static final byte FLOWER_POT_FLOWER = 5;
	public static final byte BANNER_DATA = 6;

	public long position;
	public byte action;
	public byte[] nbt;

	public UpdateBlockEntity() {}

	public UpdateBlockEntity(long position, byte action, byte[] nbt) {
		this.position = position;
		this.action = action;
		this.nbt = nbt;
	}

	@Override
	public int length() {
		return Buffer.varuintLength(ID) + nbt.length + 9;
	}

	@Override
	public byte[] encode() {
		this._buffer = new byte[this.length()];
		this.writeVaruint(ID);
		this.writeBigEndianLong(position);
		this.writeBigEndianByte(action);
		this.writeBytes(nbt);
		return this.getBuffer();
	}

	@Override
	public void decode(byte[] buffer) {
		this._buffer = buffer;
		this.readVaruint();
		position=readBigEndianLong();
		action=readBigEndianByte();
		nbt=this.readBytes(this._buffer.length-this._index);
	}

	public static UpdateBlockEntity fromBuffer(byte[] buffer) {
		UpdateBlockEntity ret = new UpdateBlockEntity();
		ret.decode(buffer);
		return ret;
	}

}
