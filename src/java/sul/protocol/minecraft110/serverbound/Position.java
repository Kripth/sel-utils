/*
 * This file has been automatically generated by sel-utils and
 * released under the GNU General Public License version 3.
 *
 * License: https://github.com/sel-project/sel-utils/blob/master/LICENSE
 * Repository: https://github.com/sel-project/sel-utils
 * Generator: https://github.com/sel-project/sel-utils/blob/master/xml/protocol/minecraft110.xml
 */
package sul.protocol.minecraft110.serverbound;

import java.util.UUID;

import sul.protocol.minecraft110.types.*;
import sul.utils.*;

class Position extends Packet {

	public final static int ID = (int)13;

	public final static boolean CLIENTBOUND = false;
	public final static boolean SERVERBOUND = true;

	public Tuples.DoubleXYZ position;
	public float yaw;
	public float pitch;
	public boolean onGround;

	@Override
	public int length() {
		return position.length() + 9;
	}

	@Override
	public byte[] encode() {
	}

	@Override
	public void decode(byte[] buffer) {
	}

}
