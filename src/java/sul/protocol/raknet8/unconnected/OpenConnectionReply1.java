/*
 * This file was automatically generated by sel-utils and
 * released under the GNU General Public License version 3.
 *
 * License: https://github.com/sel-project/sel-utils/blob/master/LICENSE
 * Repository: https://github.com/sel-project/sel-utils
 * Generated from https://github.com/sel-project/sel-utils/blob/master/xml/protocol/raknet8.xml
 */
package sul.protocol.raknet8.unconnected;

import sul.utils.*;

public class OpenConnectionReply1 extends Packet {

	public static final byte ID = (byte)6;

	public static final boolean CLIENTBOUND = true;
	public static final boolean SERVERBOUND = false;

	public byte[] magic = new byte[16];
	public long serverId;
	public boolean security;
	public short mtuLength;

	public OpenConnectionReply1() {}

	public OpenConnectionReply1(byte[] magic, long serverId, boolean security, short mtuLength) {
		this.magic = magic;
		this.serverId = serverId;
		this.security = security;
		this.mtuLength = mtuLength;
	}

	@Override
	public int length() {
		return magic.length + 12;
	}

	@Override
	public byte[] encode() {
		this._buffer = new byte[this.length()];
		this.writeBigEndianByte(ID);
		this.writeBytes(magic);
		this.writeBigEndianLong(serverId);
		this.writeBool(security);
		this.writeBigEndianShort(mtuLength);
		return this._buffer;
	}

	@Override
	public void decode(byte[] buffer) {
		this._buffer = buffer;
		readBigEndianByte();
		final int bg1hz2lj=16; magic=this.readBytes(bg1hz2lj);
		serverId=readBigEndianLong();
		security=this.readBool();
		mtuLength=readBigEndianShort();
	}

	public static OpenConnectionReply1 fromBuffer(byte[] buffer) {
		OpenConnectionReply1 ret = new OpenConnectionReply1();
		ret.decode(buffer);
		return ret;
	}

}
