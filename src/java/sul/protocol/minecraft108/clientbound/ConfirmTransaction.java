/*
 * This file was automatically generated by sel-utils and
 * released under the GNU General Public License version 3.
 *
 * License: https://github.com/sel-project/sel-utils/blob/master/LICENSE
 * Repository: https://github.com/sel-project/sel-utils
 * Generated from https://github.com/sel-project/sel-utils/blob/master/xml/protocol/minecraft108.xml
 */
package sul.protocol.minecraft108.clientbound;

import sul.utils.*;

public class ConfirmTransaction extends Packet {

	public static final int ID = (int)17;

	public static final boolean CLIENTBOUND = true;
	public static final boolean SERVERBOUND = false;

	public byte window;
	public short action;
	public boolean accepted;

	public ConfirmTransaction() {}

	public ConfirmTransaction(byte window, short action, boolean accepted) {
		this.window = window;
		this.action = action;
		this.accepted = accepted;
	}

	@Override
	public int length() {
		return Buffer.varuintLength(ID) + 4;
	}

	@Override
	public byte[] encode() {
		this._buffer = new byte[this.length()];
		this.writeVaruint(ID);
		this.writeBigEndianByte(window);
		this.writeBigEndianShort(action);
		this.writeBool(accepted);
		return this.getBuffer();
	}

	@Override
	public void decode(byte[] buffer) {
		this._buffer = buffer;
		this.readVaruint();
		window=readBigEndianByte();
		action=readBigEndianShort();
		accepted=this.readBool();
	}

	public static ConfirmTransaction fromBuffer(byte[] buffer) {
		ConfirmTransaction ret = new ConfirmTransaction();
		ret.decode(buffer);
		return ret;
	}

}
