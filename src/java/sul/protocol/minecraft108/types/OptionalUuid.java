/*
 * This file was automatically generated by sel-utils and
 * released under the GNU General Public License version 3.
 * 
 * License: https://github.com/sel-project/sel-utils/blob/master/LICENSE
 * Repository: https://github.com/sel-project/sel-utils
 * Generated from https://github.com/sel-project/sel-utils/blob/master/xml/protocol/minecraft108.xml
 */
package sul.protocol.minecraft108.types;

import java.util.UUID;

import sul.utils.*;

public class OptionalUuid extends Stream {

	public boolean hasUuid;
	public UUID uuid;

	public OptionalUuid() {}

	public OptionalUuid(boolean hasUuid, UUID uuid) {
		this.hasUuid = hasUuid;
		this.uuid = uuid;
	}

	@Override
	public int length() {
		return 17;
	}

	@Override
	public byte[] encode() {
		this._buffer = new byte[this.length()];
		this.writeBool(hasUuid);
		this.writeBigEndianLong(uuid.getLeastSignificantBits()); this.writeBigEndianLong(uuid.getMostSignificantBits());
		return this.getBuffer();
	}

	@Override
	public void decode(byte[] buffer) {
		this._buffer = buffer;
		hasUuid=this.readBool();
		long avaq=readBigEndianLong(); long vaq=readBigEndianLong(); uuid=new UUID(avaq,vaq);
	}

	@Override
	public String toString() {
		return "OptionalUuid(hasUuid: " + this.hasUuid + ", uuid: " + this.uuid.toString() + ")";
	}


}
