/*
 * This file was automatically generated by sel-utils and
 * released under the GNU General Public License version 3.
 * 
 * License: https://github.com/sel-project/sel-utils/blob/master/LICENSE
 * Repository: https://github.com/sel-project/sel-utils
 * Generated from https://github.com/sel-project/sel-utils/blob/master/xml/protocol/pocket100.xml
 */
package sul.protocol.pocket100.play;

import java.nio.charset.StandardCharsets;

import sul.utils.*;

public class ResourcePackChunkRequest extends Packet {

	public static final byte ID = (byte)81;

	public static final boolean CLIENTBOUND = false;
	public static final boolean SERVERBOUND = true;

	@Override
	public int getId() {
		return ID;
	}

	public String id;
	public int index;

	public ResourcePackChunkRequest() {}

	public ResourcePackChunkRequest(String id, int index) {
		this.id = id;
		this.index = index;
	}

	@Override
	public int length() {
		return Buffer.varuintLength(id.getBytes(StandardCharsets.UTF_8).length) + id.getBytes(StandardCharsets.UTF_8).length + 5;
	}

	@Override
	public byte[] encode() {
		this._buffer = new byte[this.length()];
		this.writeBigEndianByte(ID);
		byte[] aq=id.getBytes(StandardCharsets.UTF_8); this.writeVaruint((int)aq.length); this.writeBytes(aq);
		this.writeBigEndianInt(index);
		return this.getBuffer();
	}

	@Override
	public void decode(byte[] buffer) {
		this._buffer = buffer;
		readBigEndianByte();
		int bvaq=this.readVaruint(); id=new String(this.readBytes(bvaq), StandardCharsets.UTF_8);
		index=readBigEndianInt();
	}

	public static ResourcePackChunkRequest fromBuffer(byte[] buffer) {
		ResourcePackChunkRequest ret = new ResourcePackChunkRequest();
		ret.decode(buffer);
		return ret;
	}

	@Override
	public String toString() {
		return "ResourcePackChunkRequest(id: " + this.id + ", index: " + this.index + ")";
	}

}
