/*
 * This file has been automatically generated by sel-utils and
 * released under the GNU General Public License version 3.
 *
 * License: https://github.com/sel-project/sel-utils/blob/master/LICENSE
 * Repository: https://github.com/sel-project/sel-utils
 * Generator: https://github.com/sel-project/sel-utils/blob/master/xml/protocol/minecraft47.xml
 */
package sul.protocol.minecraft47.serverbound;

import java.util.UUID;

import sul.protocol.minecraft47.types.*;
import sul.utils.*;

class UseEntity extends Packet {

	public final static int ID = (int)2;

	public final static boolean CLIENTBOUND = false;
	public final static boolean SERVERBOUND = true;

	// type
	public static immutable int INTERACT = 0;
	public static immutable int ATTACK = 1;
	public static immutable int INTERACT_AT = 2;

	public int target;
	public int type;
	public Tuples.FloatXYZ targetPosition;

	@Override
	public int length() {
	}

	@Override
	public byte[] encode() {
		this.buffer = new byte[this.length()];
		this.index = 0;
		this.writeVaruint(ID);
		this.writeVaruint(target);
		this.writeVaruint(type);
		if(type==2){ this.writeFloatB(targetPosition.x);this.writeFloatB(targetPosition.y);this.writeFloatB(targetPosition.z); }
		return this.buffer;
	}

	@Override
	public void decode(byte[] buffer) {
		this.buffer = buffer;
		this.index = 0;
	}

}