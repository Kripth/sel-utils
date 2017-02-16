/*
 * This file was automatically generated by sel-utils and
 * released under the GNU General Public License version 3.
 * 
 * License: https://github.com/sel-project/sel-utils/blob/master/LICENSE
 * Repository: https://github.com/sel-project/sel-utils
 * Generated from https://github.com/sel-project/sel-utils/blob/master/xml/protocol/minecraft210.xml
 */
package sul.protocol.minecraft210.clientbound;

import sul.utils.*;

public class SpawnExperienceOrb extends Packet {

	public static final int ID = (int)1;

	public static final boolean CLIENTBOUND = true;
	public static final boolean SERVERBOUND = false;

	@Override
	public int getId() {
		return ID;
	}

	public int entityId;
	public Tuples.DoubleXYZ position;
	public short count;

	public SpawnExperienceOrb() {}

	public SpawnExperienceOrb(int entityId, Tuples.DoubleXYZ position, short count) {
		this.entityId = entityId;
		this.position = position;
		this.count = count;
	}

	@Override
	public int length() {
		return Buffer.varuintLength(ID) + Buffer.varuintLength(entityId) + 26;
	}

	@Override
	public byte[] encode() {
		this._buffer = new byte[this.length()];
		this.writeVaruint(ID);
		this.writeVaruint(entityId);
		this.writeBigEndianDouble(position.x); this.writeBigEndianDouble(position.y); this.writeBigEndianDouble(position.z);
		this.writeBigEndianShort(count);
		return this.getBuffer();
	}

	@Override
	public void decode(byte[] buffer) {
		this._buffer = buffer;
		this.readVaruint();
		entityId=this.readVaruint();
		position=new Tuples.DoubleXYZ(); position.x=readBigEndianDouble(); position.y=readBigEndianDouble(); position.z=readBigEndianDouble();
		count=readBigEndianShort();
	}

	public static SpawnExperienceOrb fromBuffer(byte[] buffer) {
		SpawnExperienceOrb ret = new SpawnExperienceOrb();
		ret.decode(buffer);
		return ret;
	}

	@Override
	public String toString() {
		return "SpawnExperienceOrb(entityId: " + this.entityId + ", position: " + this.position.toString() + ", count: " + this.count + ")";
	}

}
