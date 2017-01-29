/*
 * This file was automatically generated by sel-utils and
 * released under the GNU General Public License version 3.
 *
 * License: https://github.com/sel-project/sel-utils/blob/master/LICENSE
 * Repository: https://github.com/sel-project/sel-utils
 * Generated from https://github.com/sel-project/sel-utils/blob/master/xml/protocol/pocket100.xml
 */
package sul.protocol.pocket100.play;

import sul.utils.*;

public class UseItem extends Packet {

	public static final byte ID = (byte)35;

	public static final boolean CLIENTBOUND = false;
	public static final boolean SERVERBOUND = true;

	public sul.protocol.pocket100.types.BlockPosition blockPosition;
	public int hotbarSlot;
	public int face;
	public Tuples.FloatXYZ facePosition;
	public Tuples.FloatXYZ position;
	public int slot;
	public sul.protocol.pocket100.types.Slot item;

	public UseItem() {}

	public UseItem(sul.protocol.pocket100.types.BlockPosition blockPosition, int hotbarSlot, int face, Tuples.FloatXYZ facePosition, Tuples.FloatXYZ position, int slot, sul.protocol.pocket100.types.Slot item) {
		this.blockPosition = blockPosition;
		this.hotbarSlot = hotbarSlot;
		this.face = face;
		this.facePosition = facePosition;
		this.position = position;
		this.slot = slot;
		this.item = item;
	}

	@Override
	public int length() {
		return blockPosition.length() + Buffer.varuintLength(hotbarSlot) + Buffer.varintLength(face) + Buffer.varintLength(slot) + item.length() + 25;
	}

	@Override
	public byte[] encode() {
		this._buffer = new byte[this.length()];
		this.writeBigEndianByte(ID);
		this.writeBytes(blockPosition.encode());
		this.writeVaruint(hotbarSlot);
		this.writeVarint(face);
		this.writeLittleEndianFloat(facePosition.x); this.writeLittleEndianFloat(facePosition.y); this.writeLittleEndianFloat(facePosition.z);
		this.writeLittleEndianFloat(position.x); this.writeLittleEndianFloat(position.y); this.writeLittleEndianFloat(position.z);
		this.writeVarint(slot);
		this.writeBytes(item.encode());
		return this.getBuffer();
	}

	@Override
	public void decode(byte[] buffer) {
		this._buffer = buffer;
		readBigEndianByte();
		blockPosition=new sul.protocol.pocket100.types.BlockPosition(); blockPosition._index=this._index; blockPosition.decode(this._buffer); this._index=blockPosition._index;
		hotbarSlot=this.readVaruint();
		face=this.readVarint();
		facePosition.x=readLittleEndianFloat(); facePosition.y=readLittleEndianFloat(); facePosition.z=readLittleEndianFloat();
		position.x=readLittleEndianFloat(); position.y=readLittleEndianFloat(); position.z=readLittleEndianFloat();
		slot=this.readVarint();
		item=new sul.protocol.pocket100.types.Slot(); item._index=this._index; item.decode(this._buffer); this._index=item._index;
	}

	public static UseItem fromBuffer(byte[] buffer) {
		UseItem ret = new UseItem();
		ret.decode(buffer);
		return ret;
	}

}
