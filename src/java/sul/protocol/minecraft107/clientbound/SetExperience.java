/*
 * This file was automatically generated by sel-utils and
 * released under the GNU General Public License version 3.
 * 
 * License: https://github.com/sel-project/sel-utils/blob/master/LICENSE
 * Repository: https://github.com/sel-project/sel-utils
 * Generated from https://github.com/sel-project/sel-utils/blob/master/xml/protocol/minecraft107.xml
 */
package sul.protocol.minecraft107.clientbound;

import sul.utils.*;

public class SetExperience extends Packet {

	public static final int ID = (int)61;

	public static final boolean CLIENTBOUND = true;
	public static final boolean SERVERBOUND = false;

	@Override
	public int getId() {
		return ID;
	}

	public float experience;
	public int level;
	public int totalExperience;

	public SetExperience() {}

	public SetExperience(float experience, int level, int totalExperience) {
		this.experience = experience;
		this.level = level;
		this.totalExperience = totalExperience;
	}

	@Override
	public int length() {
		return Buffer.varuintLength(ID) + Buffer.varuintLength(level) + Buffer.varuintLength(totalExperience) + 4;
	}

	@Override
	public byte[] encode() {
		this._buffer = new byte[this.length()];
		this.writeVaruint(ID);
		this.writeBigEndianFloat(experience);
		this.writeVaruint(level);
		this.writeVaruint(totalExperience);
		return this.getBuffer();
	}

	@Override
	public void decode(byte[] buffer) {
		this._buffer = buffer;
		this.readVaruint();
		experience=readBigEndianFloat();
		level=this.readVaruint();
		totalExperience=this.readVaruint();
	}

	public static SetExperience fromBuffer(byte[] buffer) {
		SetExperience ret = new SetExperience();
		ret.decode(buffer);
		return ret;
	}

	@Override
	public String toString() {
		return "SetExperience(experience: " + this.experience + ", level: " + this.level + ", totalExperience: " + this.totalExperience + ")";
	}

}
