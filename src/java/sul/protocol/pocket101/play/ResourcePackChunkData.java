/*
 * This file was automatically generated by sel-utils and
 * released under the GNU General Public License version 3.
 * 
 * License: https://github.com/sel-project/sel-utils/blob/master/LICENSE
 * Repository: https://github.com/sel-project/sel-utils
 * Generated from https://github.com/sel-project/sel-utils/blob/master/xml/protocol/pocket101.xml
 */
package sul.protocol.pocket101.play;

import java.nio.charset.StandardCharsets;
import java.util.Arrays;

import sul.utils.*;

public class ResourcePackChunkData extends Packet {

	public static final byte ID = (byte)80;

	public static final boolean CLIENTBOUND = true;
	public static final boolean SERVERBOUND = false;

	@Override
	public int getId() {
		return ID;
	}

	public String id;
	public int unknown1;
	public long unknown2;
	public byte[] data = new byte[0];

	public ResourcePackChunkData() {}

	public ResourcePackChunkData(String id, int unknown1, long unknown2, byte[] data) {
		this.id = id;
		this.unknown1 = unknown1;
		this.unknown2 = unknown2;
		this.data = data;
	}

	@Override
	public int length() {
		return Buffer.varuintLength(id.getBytes(StandardCharsets.UTF_8).length) + id.getBytes(StandardCharsets.UTF_8).length + Buffer.varuintLength(data.length) + data.length + 13;
	}

	@Override
	public byte[] encode() {
		this._buffer = new byte[this.length()];
		this.writeBigEndianByte(ID);
		byte[] aq=id.getBytes(StandardCharsets.UTF_8); this.writeVaruint((int)aq.length); this.writeBytes(aq);
		this.writeLittleEndianInt(unknown1);
		this.writeLittleEndianLong(unknown2);
		this.writeVaruint((int)data.length); this.writeBytes(data);
		return this.getBuffer();
	}

	@Override
	public void decode(byte[] buffer) {
		this._buffer = buffer;
		readBigEndianByte();
		int bvaq=this.readVaruint(); id=new String(this.readBytes(bvaq), StandardCharsets.UTF_8);
		unknown1=readLittleEndianInt();
		unknown2=readLittleEndianLong();
		int brde=this.readVaruint(); data=this.readBytes(brde);
	}

	public static ResourcePackChunkData fromBuffer(byte[] buffer) {
		ResourcePackChunkData ret = new ResourcePackChunkData();
		ret.decode(buffer);
		return ret;
	}

	@Override
	public String toString() {
		return "ResourcePackChunkData(id: " + this.id + ", unknown1: " + this.unknown1 + ", unknown2: " + this.unknown2 + ", data: " + Arrays.toString(this.data) + ")";
	}

}
