/*
 * This file was automatically generated by sel-utils and
 * released under the GNU General Public License version 3.
 * 
 * License: https://github.com/sel-project/sel-utils/blob/master/LICENSE
 * Repository: https://github.com/sel-project/sel-utils
 * Generated from https://github.com/sel-project/sel-utils/blob/master/xml/protocol/hncom1.xml
 */
package sul.protocol.hncom1.player;

import sul.utils.*;

public class UpdateViewDistance extends Packet {

	public static final byte ID = (byte)21;

	public static final boolean CLIENTBOUND = false;
	public static final boolean SERVERBOUND = true;

	@Override
	public int getId() {
		return ID;
	}

	public int hubId;
	public int viewDistance;

	public UpdateViewDistance() {}

	public UpdateViewDistance(int hubId, int viewDistance) {
		this.hubId = hubId;
		this.viewDistance = viewDistance;
	}

	@Override
	public int length() {
		return Buffer.varuintLength(hubId) + Buffer.varuintLength(viewDistance) + 1;
	}

	@Override
	public byte[] encode() {
		this._buffer = new byte[this.length()];
		this.writeBigEndianByte(ID);
		this.writeVaruint(hubId);
		this.writeVaruint(viewDistance);
		return this.getBuffer();
	}

	@Override
	public void decode(byte[] buffer) {
		this._buffer = buffer;
		readBigEndianByte();
		hubId=this.readVaruint();
		viewDistance=this.readVaruint();
	}

	public static UpdateViewDistance fromBuffer(byte[] buffer) {
		UpdateViewDistance ret = new UpdateViewDistance();
		ret.decode(buffer);
		return ret;
	}

	@Override
	public String toString() {
		return "UpdateViewDistance(hubId: " + this.hubId + ", viewDistance: " + this.viewDistance + ")";
	}

}
