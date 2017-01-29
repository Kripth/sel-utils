/*
 * This file was automatically generated by sel-utils and
 * released under the GNU General Public License version 3.
 *
 * License: https://github.com/sel-project/sel-utils/blob/master/LICENSE
 * Repository: https://github.com/sel-project/sel-utils
 * Generated from https://github.com/sel-project/sel-utils/blob/master/xml/protocol/externalconsole1.xml
 */
package sul.protocol.externalconsole1.status;

import sul.utils.*;

/**
 * Requests an UpdateStats packet to the server, which should sent it immediately instead
 * of waiting for the next automatic update (if the server does one).
 */
public class RequestStats extends Packet {

	public static final byte ID = (byte)2;

	public static final boolean CLIENTBOUND = false;
	public static final boolean SERVERBOUND = true;

	@Override
	public int length() {
		return 1;
	}

	@Override
	public byte[] encode() {
		this._buffer = new byte[this.length()];
		this.writeBigEndianByte(ID);
		return this.getBuffer();
	}

	@Override
	public void decode(byte[] buffer) {
		this._buffer = buffer;
		readBigEndianByte();
	}

	public static RequestStats fromBuffer(byte[] buffer) {
		RequestStats ret = new RequestStats();
		ret.decode(buffer);
		return ret;
	}

}
