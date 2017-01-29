/*
 * This file was automatically generated by sel-utils and
 * released under the GNU General Public License version 3.
 *
 * License: https://github.com/sel-project/sel-utils/blob/master/LICENSE
 * Repository: https://github.com/sel-project/sel-utils
 * Generated from https://github.com/sel-project/sel-utils/blob/master/xml/protocol/minecraft315.xml
 */
package sul.protocol.minecraft315.clientbound;

import sul.utils.*;

public class SetPassengers extends Packet {

	public static final int ID = (int)64;

	public static final boolean CLIENTBOUND = true;
	public static final boolean SERVERBOUND = false;

	public int entityId;
	public int[] passengers;

	public SetPassengers() {}

	public SetPassengers(int entityId, int[] passengers) {
		this.entityId = entityId;
		this.passengers = passengers;
	}

	@Override
	public int length() {
		int length=Buffer.varuintLength(ID) + Buffer.varuintLength(entityId) + Buffer.varuintLength(passengers.length) + 0; for(int cgfzc2vuz2vycw:passengers){ length+=Buffer.varuintLength(cgfzc2vuz2vycw); } return length;
	}

	@Override
	public byte[] encode() {
		this._buffer = new byte[this.length()];
		this.writeVaruint(ID);
		this.writeVaruint(entityId);
		this.writeVaruint((int)passengers.length); for(int cgfzc2vuz2vycw:passengers){ this.writeVaruint(cgfzc2vuz2vycw); }
		return this.getBuffer();
	}

	@Override
	public void decode(byte[] buffer) {
		this._buffer = buffer;
		this.readVaruint();
		entityId=this.readVaruint();
		int bhbhc3nlbmdlcnm=this.readVaruint(); passengers=new int[bhbhc3nlbmdlcnm]; for(int cgfzc2vuz2vycw=0;cgfzc2vuz2vycw<passengers.length;cgfzc2vuz2vycw++){ passengers[cgfzc2vuz2vycw]=this.readVaruint(); }
	}

	public static SetPassengers fromBuffer(byte[] buffer) {
		SetPassengers ret = new SetPassengers();
		ret.decode(buffer);
		return ret;
	}

}
