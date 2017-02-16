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

public class ChunkRadiusUpdated extends Packet {

	public static final byte ID = (byte)69;

	public static final boolean CLIENTBOUND = true;
	public static final boolean SERVERBOUND = false;

	@Override
	public int getId() {
		return ID;
	}

	public int radius;

	public ChunkRadiusUpdated() {}

	public ChunkRadiusUpdated(int radius) {
		this.radius = radius;
	}

	@Override
	public int length() {
		return Buffer.varintLength(radius) + 1;
	}

	@Override
	public byte[] encode() {
		this._buffer = new byte[this.length()];
		this.writeBigEndianByte(ID);
		this.writeVarint(radius);
		return this.getBuffer();
	}

	@Override
	public void decode(byte[] buffer) {
		this._buffer = buffer;
		readBigEndianByte();
		radius=this.readVarint();
	}

	public static ChunkRadiusUpdated fromBuffer(byte[] buffer) {
		ChunkRadiusUpdated ret = new ChunkRadiusUpdated();
		ret.decode(buffer);
		return ret;
	}

	@Override
	public String toString() {
		return "ChunkRadiusUpdated(radius: " + this.radius + ")";
	}

}
