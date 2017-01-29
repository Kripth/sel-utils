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

public class EntityProperties extends Packet {

	public static final int ID = (int)75;

	public static final boolean CLIENTBOUND = true;
	public static final boolean SERVERBOUND = false;

	public int entityId;
	public sul.protocol.minecraft107.types.Attribute[] attributes;

	public EntityProperties() {}

	public EntityProperties(int entityId, sul.protocol.minecraft107.types.Attribute[] attributes) {
		this.entityId = entityId;
		this.attributes = attributes;
	}

	@Override
	public int length() {
		int length=Buffer.varuintLength(ID) + Buffer.varuintLength(entityId) + 4; for(sul.protocol.minecraft107.types.Attribute yxr0cmlidxrlcw:attributes){ length+=yxr0cmlidxrlcw.length(); } return length;
	}

	@Override
	public byte[] encode() {
		this._buffer = new byte[this.length()];
		this.writeVaruint(ID);
		this.writeVaruint(entityId);
		this.writeBigEndianInt((int)attributes.length); for(sul.protocol.minecraft107.types.Attribute yxr0cmlidxrlcw:attributes){ this.writeBytes(yxr0cmlidxrlcw.encode()); }
		return this.getBuffer();
	}

	@Override
	public void decode(byte[] buffer) {
		this._buffer = buffer;
		this.readVaruint();
		entityId=this.readVaruint();
		int bgf0dhjpynv0zxm=readBigEndianInt(); attributes=new sul.protocol.minecraft107.types.Attribute[bgf0dhjpynv0zxm]; for(int yxr0cmlidxrlcw=0;yxr0cmlidxrlcw<attributes.length;yxr0cmlidxrlcw++){ attributes[yxr0cmlidxrlcw]=new sul.protocol.minecraft107.types.Attribute(); attributes[yxr0cmlidxrlcw]._index=this._index; attributes[yxr0cmlidxrlcw].decode(this._buffer); this._index=attributes[yxr0cmlidxrlcw]._index; }
	}

	public static EntityProperties fromBuffer(byte[] buffer) {
		EntityProperties ret = new EntityProperties();
		ret.decode(buffer);
		return ret;
	}

}
