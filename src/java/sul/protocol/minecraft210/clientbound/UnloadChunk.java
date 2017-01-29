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

public class UnloadChunk extends Packet {

	public static final int ID = (int)29;

	public static final boolean CLIENTBOUND = true;
	public static final boolean SERVERBOUND = false;

	public Tuples.IntXZ position;

	public UnloadChunk() {}

	public UnloadChunk(Tuples.IntXZ position) {
		this.position = position;
	}

	@Override
	public int length() {
		return Buffer.varuintLength(ID) + 8;
	}

	@Override
	public byte[] encode() {
		this._buffer = new byte[this.length()];
		this.writeVaruint(ID);
		this.writeBigEndianInt(position.x); this.writeBigEndianInt(position.z);
		return this.getBuffer();
	}

	@Override
	public void decode(byte[] buffer) {
		this._buffer = buffer;
		this.readVaruint();
		position.x=readBigEndianInt(); position.z=readBigEndianInt();
	}

	public static UnloadChunk fromBuffer(byte[] buffer) {
		UnloadChunk ret = new UnloadChunk();
		ret.decode(buffer);
		return ret;
	}

}
