/*
 * This file was automatically generated by sel-utils and
 * released under the GNU General Public License version 3.
 * 
 * License: https://github.com/sel-project/sel-utils/blob/master/LICENSE
 * Repository: https://github.com/sel-project/sel-utils
 * Generated from https://github.com/sel-project/sel-utils/blob/master/xml/protocol/minecraft109.xml
 */
package sul.protocol.minecraft109.serverbound;

import java.nio.charset.StandardCharsets;

import sul.utils.*;

public class ResourcePackStatus extends Packet {

	public static final int ID = (int)22;

	public static final boolean CLIENTBOUND = false;
	public static final boolean SERVERBOUND = true;

	@Override
	public int getId() {
		return ID;
	}

	// result
	public static final int LOADED = 0;
	public static final int DECLINED = 1;
	public static final int FAILED = 2;
	public static final int ACCEPTED = 3;

	public String hash;
	public int result;

	public ResourcePackStatus() {}

	public ResourcePackStatus(String hash, int result) {
		this.hash = hash;
		this.result = result;
	}

	@Override
	public int length() {
		return Buffer.varuintLength(ID) + Buffer.varuintLength(hash.getBytes(StandardCharsets.UTF_8).length) + hash.getBytes(StandardCharsets.UTF_8).length + Buffer.varuintLength(result);
	}

	@Override
	public byte[] encode() {
		this._buffer = new byte[this.length()];
		this.writeVaruint(ID);
		byte[] afa=hash.getBytes(StandardCharsets.UTF_8); this.writeVaruint((int)afa.length); this.writeBytes(afa);
		this.writeVaruint(result);
		return this.getBuffer();
	}

	@Override
	public void decode(byte[] buffer) {
		this._buffer = buffer;
		this.readVaruint();
		int bvafa=this.readVaruint(); hash=new String(this.readBytes(bvafa), StandardCharsets.UTF_8);
		result=this.readVaruint();
	}

	public static ResourcePackStatus fromBuffer(byte[] buffer) {
		ResourcePackStatus ret = new ResourcePackStatus();
		ret.decode(buffer);
		return ret;
	}

	@Override
	public String toString() {
		return "ResourcePackStatus(hash: " + this.hash + ", result: " + this.result + ")";
	}

}
