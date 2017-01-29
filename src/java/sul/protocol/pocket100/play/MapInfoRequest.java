/*
 * This file was automatically generated by sel-utils and
 * released under the GNU General Public License version 3.
 *
 * License: https://github.com/sel-project/sel-utils/blob/master/LICENSE
 * Repository: https://github.com/sel-project/sel-utils
 * Generated from https://github.com/sel-project/sel-utils/blob/master/xml/protocol/pocket100.xml
 */
package sul.protocol.pocket100.play;

import sul.utils.*;

public class MapInfoRequest extends Packet {

	public static final byte ID = (byte)67;

	public static final boolean CLIENTBOUND = false;
	public static final boolean SERVERBOUND = true;

	public long mapId;

	public MapInfoRequest() {}

	public MapInfoRequest(long mapId) {
		this.mapId = mapId;
	}

	@Override
	public int length() {
		return Buffer.varlongLength(mapId) + 1;
	}

	@Override
	public byte[] encode() {
		this._buffer = new byte[this.length()];
		this.writeBigEndianByte(ID);
		this.writeVarlong(mapId);
		return this.getBuffer();
	}

	@Override
	public void decode(byte[] buffer) {
		this._buffer = buffer;
		readBigEndianByte();
		mapId=this.readVarlong();
	}

	public static MapInfoRequest fromBuffer(byte[] buffer) {
		MapInfoRequest ret = new MapInfoRequest();
		ret.decode(buffer);
		return ret;
	}

}
