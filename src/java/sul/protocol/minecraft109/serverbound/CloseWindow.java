/*
 * This file was automatically generated by sel-utils and
 * released under the GNU General Public License version 3.
 *
 * License: https://github.com/sel-project/sel-utils/blob/master/LICENSE
 * Repository: https://github.com/sel-project/sel-utils
 * Generated from https://github.com/sel-project/sel-utils/blob/master/xml/protocol/minecraft109.xml
 */
package sul.protocol.minecraft109.serverbound;

import sul.utils.*;

public class CloseWindow extends Packet {

	public static final int ID = (int)8;

	public static final boolean CLIENTBOUND = false;
	public static final boolean SERVERBOUND = true;

	public byte window;

	public CloseWindow() {}

	public CloseWindow(byte window) {
		this.window = window;
	}

	@Override
	public int length() {
		return Buffer.varuintLength(ID) + 1;
	}

	@Override
	public byte[] encode() {
		this._buffer = new byte[this.length()];
		this.writeVaruint(ID);
		this.writeBigEndianByte(window);
		return this.getBuffer();
	}

	@Override
	public void decode(byte[] buffer) {
		this._buffer = buffer;
		this.readVaruint();
		window=readBigEndianByte();
	}

	public static CloseWindow fromBuffer(byte[] buffer) {
		CloseWindow ret = new CloseWindow();
		ret.decode(buffer);
		return ret;
	}

}
