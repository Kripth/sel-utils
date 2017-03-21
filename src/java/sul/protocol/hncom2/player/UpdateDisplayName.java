/*
 * This file was automatically generated by sel-utils and
 * released under the GNU General Public License version 3.
 * 
 * License: https://github.com/sel-project/sel-utils/blob/master/LICENSE
 * Repository: https://github.com/sel-project/sel-utils
 * Generated from https://github.com/sel-project/sel-utils/blob/master/xml/protocol/hncom2.xml
 */
package sul.protocol.hncom2.player;

import java.nio.charset.StandardCharsets;

import sul.utils.*;

/**
 * Updates the player's display name when it changes.
 */
public class UpdateDisplayName extends Packet {

	public static final byte ID = (byte)21;

	public static final boolean CLIENTBOUND = false;
	public static final boolean SERVERBOUND = true;

	@Override
	public int getId() {
		return ID;
	}

	public int hubId;

	/**
	 * Player's display name that can contain formatting codes. Prefixes and suffixes should
	 * be avoided.
	 */
	public String displayName;

	public UpdateDisplayName() {}

	public UpdateDisplayName(int hubId, String displayName) {
		this.hubId = hubId;
		this.displayName = displayName;
	}

	@Override
	public int length() {
		return Buffer.varuintLength(hubId) + Buffer.varuintLength(displayName.getBytes(StandardCharsets.UTF_8).length) + displayName.getBytes(StandardCharsets.UTF_8).length + 1;
	}

	@Override
	public byte[] encode() {
		this._buffer = new byte[this.length()];
		this.writeBigEndianByte(ID);
		this.writeVaruint(hubId);
		byte[] zlcxe5bu=displayName.getBytes(StandardCharsets.UTF_8); this.writeVaruint((int)zlcxe5bu.length); this.writeBytes(zlcxe5bu);
		return this.getBuffer();
	}

	@Override
	public void decode(byte[] buffer) {
		this._buffer = buffer;
		readBigEndianByte();
		hubId=this.readVaruint();
		int bvzlcxe5=this.readVaruint(); displayName=new String(this.readBytes(bvzlcxe5), StandardCharsets.UTF_8);
	}

	public static UpdateDisplayName fromBuffer(byte[] buffer) {
		UpdateDisplayName ret = new UpdateDisplayName();
		ret.decode(buffer);
		return ret;
	}

	@Override
	public String toString() {
		return "UpdateDisplayName(hubId: " + this.hubId + ", displayName: " + this.displayName + ")";
	}

}
