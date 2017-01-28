/*
 * This file was automatically generated by sel-utils and
 * released under the GNU General Public License version 3.
 *
 * License: https://github.com/sel-project/sel-utils/blob/master/LICENSE
 * Repository: https://github.com/sel-project/sel-utils
 * Generated from https://github.com/sel-project/sel-utils/blob/master/xml/protocol/pocket100.xml
 */
package sul.protocol.pocket100.types;

import sul.utils.*;

public class Slot extends Packet {

	public int id;
	public int metaAndCount;
	public byte[] nbt;

	public Slot() {}

	public Slot(int id, int metaAndCount, byte[] nbt) {
		this.id = id;
		this.metaAndCount = metaAndCount;
		this.nbt = nbt;
	}

	@Override
	public int length() {
		return Buffer.varintLength(id) + Buffer.varintLength(metaAndCount) + nbt.length + 2;
	}

	@Override
	public byte[] encode() {
		this._buffer = new byte[this.length()];
		this.writeVarint(id);
		if(id>0){ this.writeVarint(metaAndCount); }
		if(id>0){ this.writeLittleEndianShort((short)nbt.length); this.writeBytes(nbt); }
		return this._buffer;
	}

	@Override
	public void decode(byte[] buffer) {
		this._buffer = buffer;
		id=this.readVarint();
		if(id>0){ metaAndCount=this.readVarint(); }
		if(id>0){ int bg5ida=readLittleEndianShort(); nbt=this.readBytes(bg5ida); }
	}


}
