/*
 * This file was automatically generated by sel-utils and
 * released under the GNU General Public License version 3.
 *
 * License: https://github.com/sel-project/sel-utils/blob/master/LICENSE
 * Repository: https://github.com/sel-project/sel-utils
 * Generated from https://github.com/sel-project/sel-utils/blob/master/xml/protocol/minecraft210.xml
 */
package sul.protocol.minecraft210.clientbound;

import sul.utils.*;

public class SetSlot extends Packet {

	public static final int ID = (int)22;

	public static final boolean CLIENTBOUND = true;
	public static final boolean SERVERBOUND = false;

	public byte window;
	public short slot;
	public sul.protocol.minecraft210.types.Slot item;

	public SetSlot() {}

	public SetSlot(byte window, short slot, sul.protocol.minecraft210.types.Slot item) {
		this.window = window;
		this.slot = slot;
		this.item = item;
	}

	@Override
	public int length() {
		return Buffer.varuintLength(ID) + item.length() + 3;
	}

	@Override
	public byte[] encode() {
		this._buffer = new byte[this.length()];
		this.writeVaruint(ID);
		this.writeBigEndianByte(window);
		this.writeBigEndianShort(slot);
		this.writeBytes(item.encode());
		return this.getBuffer();
	}

	@Override
	public void decode(byte[] buffer) {
		this._buffer = buffer;
		this.readVaruint();
		window=readBigEndianByte();
		slot=readBigEndianShort();
		item=new sul.protocol.minecraft210.types.Slot(); item._index=this._index; item.decode(this._buffer); this._index=item._index;
	}

	public static SetSlot fromBuffer(byte[] buffer) {
		SetSlot ret = new SetSlot();
		ret.decode(buffer);
		return ret;
	}

}
