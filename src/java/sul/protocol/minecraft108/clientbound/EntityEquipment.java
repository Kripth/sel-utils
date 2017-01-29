/*
 * This file was automatically generated by sel-utils and
 * released under the GNU General Public License version 3.
 *
 * License: https://github.com/sel-project/sel-utils/blob/master/LICENSE
 * Repository: https://github.com/sel-project/sel-utils
 * Generated from https://github.com/sel-project/sel-utils/blob/master/xml/protocol/minecraft108.xml
 */
package sul.protocol.minecraft108.clientbound;

import sul.utils.*;

public class EntityEquipment extends Packet {

	public static final int ID = (int)60;

	public static final boolean CLIENTBOUND = true;
	public static final boolean SERVERBOUND = false;

	public int entityId;
	public int slot;
	public sul.protocol.minecraft108.types.Slot item;

	public EntityEquipment() {}

	public EntityEquipment(int entityId, int slot, sul.protocol.minecraft108.types.Slot item) {
		this.entityId = entityId;
		this.slot = slot;
		this.item = item;
	}

	@Override
	public int length() {
		return Buffer.varuintLength(ID) + Buffer.varuintLength(entityId) + Buffer.varuintLength(slot) + item.length();
	}

	@Override
	public byte[] encode() {
		this._buffer = new byte[this.length()];
		this.writeVaruint(ID);
		this.writeVaruint(entityId);
		this.writeVaruint(slot);
		this.writeBytes(item.encode());
		return this.getBuffer();
	}

	@Override
	public void decode(byte[] buffer) {
		this._buffer = buffer;
		this.readVaruint();
		entityId=this.readVaruint();
		slot=this.readVaruint();
		item=new sul.protocol.minecraft108.types.Slot(); item._index=this._index; item.decode(this._buffer); this._index=item._index;
	}

	public static EntityEquipment fromBuffer(byte[] buffer) {
		EntityEquipment ret = new EntityEquipment();
		ret.decode(buffer);
		return ret;
	}

}
