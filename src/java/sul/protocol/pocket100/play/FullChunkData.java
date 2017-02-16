/*
 * This file was automatically generated by sel-utils and
 * released under the GNU General Public License version 3.
 * 
 * License: https://github.com/sel-project/sel-utils/blob/master/LICENSE
 * Repository: https://github.com/sel-project/sel-utils
 * Generated from https://github.com/sel-project/sel-utils/blob/master/xml/protocol/pocket100.xml
 */
package sul.protocol.pocket100.play;

import java.util.Arrays;

import sul.utils.*;

public class FullChunkData extends Packet {

	public static final byte ID = (byte)58;

	public static final boolean CLIENTBOUND = true;
	public static final boolean SERVERBOUND = false;

	@Override
	public int getId() {
		return ID;
	}

	public Tuples.IntXZ position;
	public sul.protocol.pocket100.types.ChunkData data;
	public byte[] tiles;

	public FullChunkData() {}

	public FullChunkData(Tuples.IntXZ position, sul.protocol.pocket100.types.ChunkData data, byte[] tiles) {
		this.position = position;
		this.data = data;
		this.tiles = tiles;
	}

	@Override
	public int length() {
		return Buffer.varintLength(position.x) + Buffer.varintLength(position.z) + data.length() + tiles.length + 1;
	}

	@Override
	public byte[] encode() {
		this._buffer = new byte[this.length()];
		this.writeBigEndianByte(ID);
		this.writeVarint(position.x); this.writeVarint(position.z);
		this.writeBytes(data.encode());
		this.writeBytes(tiles);
		return this.getBuffer();
	}

	@Override
	public void decode(byte[] buffer) {
		this._buffer = buffer;
		readBigEndianByte();
		position=new Tuples.IntXZ(); position.x=this.readVarint(); position.z=this.readVarint();
		data=new sul.protocol.pocket100.types.ChunkData(); data._index=this._index; data.decode(this._buffer); this._index=data._index;
		tiles=this.readBytes(this._buffer.length-this._index);
	}

	public static FullChunkData fromBuffer(byte[] buffer) {
		FullChunkData ret = new FullChunkData();
		ret.decode(buffer);
		return ret;
	}

	@Override
	public String toString() {
		return "FullChunkData(position: " + this.position.toString() + ", data: " + this.data.toString() + ", tiles: " + Arrays.toString(this.tiles) + ")";
	}

}
