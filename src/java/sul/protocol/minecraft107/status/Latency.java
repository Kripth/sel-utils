/*
 * This file was automatically generated by sel-utils and
 * released under the GNU General Public License version 3.
 *
 * License: https://github.com/sel-project/sel-utils/blob/master/LICENSE
 * Repository: https://github.com/sel-project/sel-utils
 * Generated from https://github.com/sel-project/sel-utils/blob/master/xml/protocol/minecraft107.xml
 */
package sul.protocol.minecraft107.status;

import sul.utils.*;

public class Latency extends Packet {

	public static final int ID = (int)1;

	public static final boolean CLIENTBOUND = true;
	public static final boolean SERVERBOUND = true;

	public long id;

	public Latency() {}

	public Latency(long id) {
		this.id = id;
	}

	@Override
	public int length() {
		return Buffer.varuintLength(ID) + 8;
	}

	@Override
	public byte[] encode() {
		this._buffer = new byte[this.length()];
		this.writeVaruint(ID);
		this.writeBigEndianLong(id);
		return this.getBuffer();
	}

	@Override
	public void decode(byte[] buffer) {
		this._buffer = buffer;
		this.readVaruint();
		id=readBigEndianLong();
	}

	public static Latency fromBuffer(byte[] buffer) {
		Latency ret = new Latency();
		ret.decode(buffer);
		return ret;
	}

}
