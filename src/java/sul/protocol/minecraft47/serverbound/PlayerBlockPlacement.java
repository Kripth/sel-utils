/*
 * This file was automatically generated by sel-utils and
 * released under the GNU General Public License version 3.
 *
 * License: https://github.com/sel-project/sel-utils/blob/master/LICENSE
 * Repository: https://github.com/sel-project/sel-utils
 * Generated from https://github.com/sel-project/sel-utils/blob/master/xml/protocol/minecraft47.xml
 */
package sul.protocol.minecraft47.serverbound;

import sul.utils.*;

public class PlayerBlockPlacement extends Packet {

	public static final int ID = (int)8;

	public static final boolean CLIENTBOUND = false;
	public static final boolean SERVERBOUND = true;

	public long position;
	public byte face;
	public sul.protocol.minecraft47.types.Slot heldItem;
	public Tuples.ByteXYZ cursorPosition;

	public PlayerBlockPlacement() {}

	public PlayerBlockPlacement(long position, byte face, sul.protocol.minecraft47.types.Slot heldItem, Tuples.ByteXYZ cursorPosition) {
		this.position = position;
		this.face = face;
		this.heldItem = heldItem;
		this.cursorPosition = cursorPosition;
	}

	@Override
	public int length() {
		return Buffer.varuintLength(ID) + heldItem.length() + 12;
	}

	@Override
	public byte[] encode() {
		this._buffer = new byte[this.length()];
		this.writeVaruint(ID);
		this.writeBigEndianLong(position);
		this.writeBigEndianByte(face);
		this.writeBytes(heldItem.encode());
		this.writeBigEndianByte(cursorPosition.x); this.writeBigEndianByte(cursorPosition.y); this.writeBigEndianByte(cursorPosition.z);
		return this.getBuffer();
	}

	@Override
	public void decode(byte[] buffer) {
		this._buffer = buffer;
		this.readVaruint();
		position=readBigEndianLong();
		face=readBigEndianByte();
		heldItem=new sul.protocol.minecraft47.types.Slot(); heldItem._index=this._index; heldItem.decode(this._buffer); this._index=heldItem._index;
		cursorPosition.x=readBigEndianByte(); cursorPosition.y=readBigEndianByte(); cursorPosition.z=readBigEndianByte();
	}

	public static PlayerBlockPlacement fromBuffer(byte[] buffer) {
		PlayerBlockPlacement ret = new PlayerBlockPlacement();
		ret.decode(buffer);
		return ret;
	}

}
