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

public class ChunkData extends Packet {

	public static final int ID = (int)32;

	public static final boolean CLIENTBOUND = true;
	public static final boolean SERVERBOUND = false;

	public Tuples.IntXZ position;
	public boolean full;
	public int sections;
	public byte[] data;
	public byte[] tiles;

	public ChunkData() {}

	public ChunkData(Tuples.IntXZ position, boolean full, int sections, byte[] data, byte[] tiles) {
		this.position = position;
		this.full = full;
		this.sections = sections;
		this.data = data;
		this.tiles = tiles;
	}

	@Override
	public int length() {
		return Buffer.varuintLength(ID) + Buffer.varuintLength(sections) + Buffer.varuintLength(data.length) + data.length + tiles.length + 9;
	}

	@Override
	public byte[] encode() {
		this._buffer = new byte[this.length()];
		this.writeVaruint(ID);
		this.writeBigEndianInt(position.x); this.writeBigEndianInt(position.z);
		this.writeBool(full);
		this.writeVaruint(sections);
		this.writeVaruint((int)data.length); this.writeBytes(data);
		this.writeBytes(tiles);
		return this.getBuffer();
	}

	@Override
	public void decode(byte[] buffer) {
		this._buffer = buffer;
		this.readVaruint();
		position.x=readBigEndianInt(); position.z=readBigEndianInt();
		full=this.readBool();
		sections=this.readVaruint();
		int bgrhdge=this.readVaruint(); data=this.readBytes(bgrhdge);
		tiles=this.readBytes(this._buffer.length-this._index);
	}

	public static ChunkData fromBuffer(byte[] buffer) {
		ChunkData ret = new ChunkData();
		ret.decode(buffer);
		return ret;
	}

}
