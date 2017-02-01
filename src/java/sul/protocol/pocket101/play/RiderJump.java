/*
 * This file was automatically generated by sel-utils and
 * released under the GNU General Public License version 3.
 *
 * License: https://github.com/sel-project/sel-utils/blob/master/LICENSE
 * Repository: https://github.com/sel-project/sel-utils
 * Generated from https://github.com/sel-project/sel-utils/blob/master/xml/protocol/pocket101.xml
 */
package sul.protocol.pocket101.play;

import sul.utils.*;

public class RiderJump extends Packet {

	public static final byte ID = (byte)21;

	public static final boolean CLIENTBOUND = true;
	public static final boolean SERVERBOUND = true;

	public long rider;

	public RiderJump() {}

	public RiderJump(long rider) {
		this.rider = rider;
	}

	@Override
	public int length() {
		return Buffer.varlongLength(rider) + 1;
	}

	@Override
	public byte[] encode() {
		this._buffer = new byte[this.length()];
		this.writeBigEndianByte(ID);
		this.writeVarlong(rider);
		return this.getBuffer();
	}

	@Override
	public void decode(byte[] buffer) {
		this._buffer = buffer;
		readBigEndianByte();
		rider=this.readVarlong();
	}

	public static RiderJump fromBuffer(byte[] buffer) {
		RiderJump ret = new RiderJump();
		ret.decode(buffer);
		return ret;
	}

}