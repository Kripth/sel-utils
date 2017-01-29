/*
 * This file was automatically generated by sel-utils and
 * released under the GNU General Public License version 3.
 *
 * License: https://github.com/sel-project/sel-utils/blob/master/LICENSE
 * Repository: https://github.com/sel-project/sel-utils
 * Generated from https://github.com/sel-project/sel-utils/blob/master/xml/protocol/minecraft315.xml
 */
package sul.protocol.minecraft315.serverbound;

import sul.utils.*;

public class ClickWindow extends Packet {

	public static final int ID = (int)7;

	public static final boolean CLIENTBOUND = false;
	public static final boolean SERVERBOUND = true;

	public byte window;
	public short slot;
	public byte button;
	public short action;
	public int mode;
	public sul.protocol.minecraft315.types.Slot clickedItem;

	public ClickWindow() {}

	public ClickWindow(byte window, short slot, byte button, short action, int mode, sul.protocol.minecraft315.types.Slot clickedItem) {
		this.window = window;
		this.slot = slot;
		this.button = button;
		this.action = action;
		this.mode = mode;
		this.clickedItem = clickedItem;
	}

	@Override
	public int length() {
		return Buffer.varuintLength(ID) + Buffer.varuintLength(mode) + clickedItem.length() + 6;
	}

	@Override
	public byte[] encode() {
		this._buffer = new byte[this.length()];
		this.writeVaruint(ID);
		this.writeBigEndianByte(window);
		this.writeBigEndianShort(slot);
		this.writeBigEndianByte(button);
		this.writeBigEndianShort(action);
		this.writeVaruint(mode);
		this.writeBytes(clickedItem.encode());
		return this.getBuffer();
	}

	@Override
	public void decode(byte[] buffer) {
		this._buffer = buffer;
		this.readVaruint();
		window=readBigEndianByte();
		slot=readBigEndianShort();
		button=readBigEndianByte();
		action=readBigEndianShort();
		mode=this.readVaruint();
		clickedItem=new sul.protocol.minecraft315.types.Slot(); clickedItem._index=this._index; clickedItem.decode(this._buffer); this._index=clickedItem._index;
	}

	public static ClickWindow fromBuffer(byte[] buffer) {
		ClickWindow ret = new ClickWindow();
		ret.decode(buffer);
		return ret;
	}

}
