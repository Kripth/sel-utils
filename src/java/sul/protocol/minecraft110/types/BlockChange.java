/*
 * This file was automatically generated by sel-utils and
 * released under the GNU General Public License version 3.
 *
 * License: https://github.com/sel-project/sel-utils/blob/master/LICENSE
 * Repository: https://github.com/sel-project/sel-utils
 * Generated from https://github.com/sel-project/sel-utils/blob/master/xml/protocol/minecraft110.xml
 */
package sul.protocol.minecraft110.types;

import sul.utils.*;

public class BlockChange extends Packet {

	public byte xz;
	public byte y;
	public int block;

	public BlockChange() {}

	public BlockChange(byte xz, byte y, int block) {
		this.xz = xz;
		this.y = y;
		this.block = block;
	}

	@Override
	public int length() {
		return Buffer.varuintLength(block) + 2;
	}

	@Override
	public byte[] encode() {
		this._buffer = new byte[this.length()];
		this.writeBigEndianByte(xz);
		this.writeBigEndianByte(y);
		this.writeVaruint(block);
		return this.getBuffer();
	}

	@Override
	public void decode(byte[] buffer) {
		this._buffer = buffer;
		xz=readBigEndianByte();
		y=readBigEndianByte();
		block=this.readVaruint();
	}


}
