/*
 * This file was automatically generated by sel-utils and
 * released under the GNU General Public License version 3.
 *
 * License: https://github.com/sel-project/sel-utils/blob/master/LICENSE
 * Repository: https://github.com/sel-project/sel-utils
 * Generated from https://github.com/sel-project/sel-utils/blob/master/xml/protocol/minecraft108.xml
 */
package sul.protocol.minecraft108.serverbound;

import sul.utils.*;

public class PlayerPositionAndLook extends Packet {

	public static final int ID = (int)13;

	public static final boolean CLIENTBOUND = false;
	public static final boolean SERVERBOUND = true;

	public Tuples.DoubleXYZ position;
	public float yaw;
	public float pitch;
	public boolean onGround;

	public PlayerPositionAndLook() {}

	public PlayerPositionAndLook(Tuples.DoubleXYZ position, float yaw, float pitch, boolean onGround) {
		this.position = position;
		this.yaw = yaw;
		this.pitch = pitch;
		this.onGround = onGround;
	}

	@Override
	public int length() {
		return Buffer.varuintLength(ID) + 33;
	}

	@Override
	public byte[] encode() {
		this._buffer = new byte[this.length()];
		this.writeVaruint(ID);
		this.writeBigEndianDouble(position.x); this.writeBigEndianDouble(position.y); this.writeBigEndianDouble(position.z);
		this.writeBigEndianFloat(yaw);
		this.writeBigEndianFloat(pitch);
		this.writeBool(onGround);
		return this.getBuffer();
	}

	@Override
	public void decode(byte[] buffer) {
		this._buffer = buffer;
		this.readVaruint();
		position.x=readBigEndianDouble(); position.y=readBigEndianDouble(); position.z=readBigEndianDouble();
		yaw=readBigEndianFloat();
		pitch=readBigEndianFloat();
		onGround=this.readBool();
	}

	public static PlayerPositionAndLook fromBuffer(byte[] buffer) {
		PlayerPositionAndLook ret = new PlayerPositionAndLook();
		ret.decode(buffer);
		return ret;
	}

}
