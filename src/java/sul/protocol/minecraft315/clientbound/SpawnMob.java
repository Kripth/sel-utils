/*
 * This file was automatically generated by sel-utils and
 * released under the GNU General Public License version 3.
 * 
 * License: https://github.com/sel-project/sel-utils/blob/master/LICENSE
 * Repository: https://github.com/sel-project/sel-utils
 * Generated from https://github.com/sel-project/sel-utils/blob/master/xml/protocol/minecraft315.xml
 */
package sul.protocol.minecraft315.clientbound;

import java.util.UUID;

import sul.utils.*;

public class SpawnMob extends Packet {

	public static final int ID = (int)3;

	public static final boolean CLIENTBOUND = true;
	public static final boolean SERVERBOUND = false;

	@Override
	public int getId() {
		return ID;
	}

	public int entityId;
	public UUID uuid;
	public int type;
	public Tuples.DoubleXYZ position;
	public byte yaw;
	public byte pitch;
	public byte headPitch;
	public Tuples.ShortXYZ velocity;
	public sul.metadata.Minecraft315 metadata;

	public SpawnMob() {}

	public SpawnMob(int entityId, UUID uuid, int type, Tuples.DoubleXYZ position, byte yaw, byte pitch, byte headPitch, Tuples.ShortXYZ velocity, sul.metadata.Minecraft315 metadata) {
		this.entityId = entityId;
		this.uuid = uuid;
		this.type = type;
		this.position = position;
		this.yaw = yaw;
		this.pitch = pitch;
		this.headPitch = headPitch;
		this.velocity = velocity;
		this.metadata = metadata;
	}

	@Override
	public int length() {
		return Buffer.varuintLength(ID) + Buffer.varuintLength(entityId) + Buffer.varuintLength(type) + metadata.length() + 49;
	}

	@Override
	public byte[] encode() {
		this._buffer = new byte[this.length()];
		this.writeVaruint(ID);
		this.writeVaruint(entityId);
		this.writeBigEndianLong(uuid.getLeastSignificantBits()); this.writeBigEndianLong(uuid.getMostSignificantBits());
		this.writeVaruint(type);
		this.writeBigEndianDouble(position.x); this.writeBigEndianDouble(position.y); this.writeBigEndianDouble(position.z);
		this.writeBigEndianByte(yaw);
		this.writeBigEndianByte(pitch);
		this.writeBigEndianByte(headPitch);
		this.writeBigEndianShort(velocity.x); this.writeBigEndianShort(velocity.y); this.writeBigEndianShort(velocity.z);
		this.writeBytes(metadata.encode());
		return this.getBuffer();
	}

	@Override
	public void decode(byte[] buffer) {
		this._buffer = buffer;
		this.readVaruint();
		entityId=this.readVaruint();
		long avaq=readBigEndianLong(); long vaq=readBigEndianLong(); uuid=new UUID(avaq,vaq);
		type=this.readVaruint();
		position=new Tuples.DoubleXYZ(); position.x=readBigEndianDouble(); position.y=readBigEndianDouble(); position.z=readBigEndianDouble();
		yaw=readBigEndianByte();
		pitch=readBigEndianByte();
		headPitch=readBigEndianByte();
		velocity=new Tuples.ShortXYZ(); velocity.x=readBigEndianShort(); velocity.y=readBigEndianShort(); velocity.z=readBigEndianShort();
		metadata=new sul.metadata.Minecraft315(); metadata._index=this._index; metadata.decode(this._buffer); this._index=metadata._index;
	}

	public static SpawnMob fromBuffer(byte[] buffer) {
		SpawnMob ret = new SpawnMob();
		ret.decode(buffer);
		return ret;
	}

	@Override
	public String toString() {
		return "SpawnMob(entityId: " + this.entityId + ", uuid: " + this.uuid.toString() + ", type: " + this.type + ", position: " + this.position.toString() + ", yaw: " + this.yaw + ", pitch: " + this.pitch + ", headPitch: " + this.headPitch + ", velocity: " + this.velocity.toString() + ", metadata: " + this.metadata.toString() + ")";
	}

}
