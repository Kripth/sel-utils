/*
 * This file was automatically generated by sel-utils and
 * released under the GNU General Public License version 3.
 *
 * License: https://github.com/sel-project/sel-utils/blob/master/LICENSE
 * Repository: https://github.com/sel-project/sel-utils
 * Generated from https://github.com/sel-project/sel-utils/blob/master/xml/protocol/minecraft109.xml
 */
package sul.protocol.minecraft109.clientbound;

import sul.utils.*;

public class ChunkData extends Packet {

	public static final int ID = (int)32;

	public static final boolean CLIENTBOUND = true;
	public static final boolean SERVERBOUND = false;

	public Tuples.IntXZ position;
	public boolean full;
	public int sections;
	public byte[] data;

	public ChunkData() {}

	public ChunkData(Tuples.IntXZ position, boolean full, int sections, byte[] data) {
		this.position = position;
		this.full = full;
		this.sections = sections;
		this.data = data;
	}

	@Override
	public int length() {
		return Buffer.varuintLength(ID) + Buffer.varuintLength(sections) + Buffer.varuintLength(data.length) + data.length + 9;
	}

	@Override
	public byte[] encode() {
		this._buffer = new byte[this.length()];
		this.writeVaruint(ID);
		this.writeBigEndianInt(position.x); this.writeBigEndianInt(position.z);
		this.writeBool(full);
		this.writeVaruint(sections);
		this.writeVaruint((int)data.length); this.writeBytes(data);
		return this._buffer;
	}

	@Override
	public void decode(byte[] buffer) {
		this._buffer = buffer;
		this.readVaruint();
		position.x=readBigEndianInt(); position.z=readBigEndianInt();
		full=this.readBool();
		sections=this.readVaruint();
		int bgrhdge=this.readVaruint(); data=this.readBytes(bgrhdge);
	}

	public static ChunkData fromBuffer(byte[] buffer) {
		ChunkData ret = new ChunkData();
		ret.decode(buffer);
		return ret;
	}

}
