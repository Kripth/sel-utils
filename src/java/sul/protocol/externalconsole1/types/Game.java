/*
 * This file was automatically generated by sel-utils and
 * released under the GNU General Public License version 3.
 *
 * License: https://github.com/sel-project/sel-utils/blob/master/LICENSE
 * Repository: https://github.com/sel-project/sel-utils
 * Generated from https://github.com/sel-project/sel-utils/blob/master/xml/protocol/externalconsole1.xml
 */
package sul.protocol.externalconsole1.types;

import sul.utils.*;

public class Game extends Packet {

	// type
	public static final byte POCKET = 1;
	public static final byte MINECRAFT = 2;

	/**
	 * Variant of the game.
	 */
	public byte type;

	/**
	 * List of protocols supported by the server for the indicated game.
	 */
	public int[] protocols;

	public Game() {}

	public Game(byte type, int[] protocols) {
		this.type = type;
		this.protocols = protocols;
	}

	@Override
	public int length() {
		return protocols.length*4 + 3;
	}

	@Override
	public byte[] encode() {
		this._buffer = new byte[this.length()];
		this.writeBigEndianByte(type);
		this.writeBigEndianShort((short)protocols.length); for(int chjvdg9jb2xz:protocols){ this.writeBigEndianInt(chjvdg9jb2xz); }
		return this.getBuffer();
	}

	@Override
	public void decode(byte[] buffer) {
		this._buffer = buffer;
		type=readBigEndianByte();
		int bhbyb3rvy29scw=readBigEndianShort(); protocols=new int[bhbyb3rvy29scw]; for(int chjvdg9jb2xz=0;chjvdg9jb2xz<protocols.length;chjvdg9jb2xz++){ protocols[chjvdg9jb2xz]=readBigEndianInt(); }
	}


}
