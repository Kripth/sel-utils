/*
 * This file was automatically generated by sel-utils and
 * released under the GNU General Public License version 3.
 *
 * License: https://github.com/sel-project/sel-utils/blob/master/LICENSE
 * Repository: https://github.com/sel-project/sel-utils
 * Generated from https://github.com/sel-project/sel-utils/blob/master/xml/protocol/minecraft315.xml
 */
package sul.protocol.minecraft315.clientbound;

import sul.utils.*;

public class AttachEntity extends Packet {

	public static final int ID = (int)58;

	public static final boolean CLIENTBOUND = true;
	public static final boolean SERVERBOUND = false;

	public int target;
	public int holder;

	public AttachEntity() {}

	public AttachEntity(int target, int holder) {
		this.target = target;
		this.holder = holder;
	}

	@Override
	public int length() {
		return Buffer.varuintLength(ID) + 8;
	}

	@Override
	public byte[] encode() {
		this._buffer = new byte[this.length()];
		this.writeVaruint(ID);
		this.writeBigEndianInt(target);
		this.writeBigEndianInt(holder);
		return this.getBuffer();
	}

	@Override
	public void decode(byte[] buffer) {
		this._buffer = buffer;
		this.readVaruint();
		target=readBigEndianInt();
		holder=readBigEndianInt();
	}

	public static AttachEntity fromBuffer(byte[] buffer) {
		AttachEntity ret = new AttachEntity();
		ret.decode(buffer);
		return ret;
	}

}
