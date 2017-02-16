/*
 * This file was automatically generated by sel-utils and
 * released under the GNU General Public License version 3.
 * 
 * License: https://github.com/sel-project/sel-utils/blob/master/LICENSE
 * Repository: https://github.com/sel-project/sel-utils
 * Generated from https://github.com/sel-project/sel-utils/blob/master/xml/protocol/minecraft110.xml
 */
package sul.protocol.minecraft110.login;

import sul.utils.*;

public class SetCompression extends Packet {

	public static final int ID = (int)3;

	public static final boolean CLIENTBOUND = true;
	public static final boolean SERVERBOUND = false;

	@Override
	public int getId() {
		return ID;
	}

	public int thresold;

	public SetCompression() {}

	public SetCompression(int thresold) {
		this.thresold = thresold;
	}

	@Override
	public int length() {
		return Buffer.varuintLength(ID) + Buffer.varuintLength(thresold);
	}

	@Override
	public byte[] encode() {
		this._buffer = new byte[this.length()];
		this.writeVaruint(ID);
		this.writeVaruint(thresold);
		return this.getBuffer();
	}

	@Override
	public void decode(byte[] buffer) {
		this._buffer = buffer;
		this.readVaruint();
		thresold=this.readVaruint();
	}

	public static SetCompression fromBuffer(byte[] buffer) {
		SetCompression ret = new SetCompression();
		ret.decode(buffer);
		return ret;
	}

	@Override
	public String toString() {
		return "SetCompression(thresold: " + this.thresold + ")";
	}

}
