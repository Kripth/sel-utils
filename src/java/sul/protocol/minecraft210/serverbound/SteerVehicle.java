/*
 * This file was automatically generated by sel-utils and
 * released under the GNU General Public License version 3.
 *
 * License: https://github.com/sel-project/sel-utils/blob/master/LICENSE
 * Repository: https://github.com/sel-project/sel-utils
 * Generated from https://github.com/sel-project/sel-utils/blob/master/xml/protocol/minecraft210.xml
 */
package sul.protocol.minecraft210.serverbound;

import sul.utils.*;

public class SteerVehicle extends Packet {

	public static final int ID = (int)21;

	public static final boolean CLIENTBOUND = false;
	public static final boolean SERVERBOUND = true;

	// flags
	public static final byte JUMP = 1;
	public static final byte UNMOUNT = 2;

	public float sideways;
	public float forward;
	public byte flags;

	public SteerVehicle() {}

	public SteerVehicle(float sideways, float forward, byte flags) {
		this.sideways = sideways;
		this.forward = forward;
		this.flags = flags;
	}

	@Override
	public int length() {
		return Buffer.varuintLength(ID) + 9;
	}

	@Override
	public byte[] encode() {
		this._buffer = new byte[this.length()];
		this.writeVaruint(ID);
		this.writeBigEndianFloat(sideways);
		this.writeBigEndianFloat(forward);
		this.writeBigEndianByte(flags);
		return this.getBuffer();
	}

	@Override
	public void decode(byte[] buffer) {
		this._buffer = buffer;
		this.readVaruint();
		sideways=readBigEndianFloat();
		forward=readBigEndianFloat();
		flags=readBigEndianByte();
	}

	public static SteerVehicle fromBuffer(byte[] buffer) {
		SteerVehicle ret = new SteerVehicle();
		ret.decode(buffer);
		return ret;
	}

}
