/*
 * This file has been automatically generated by sel-utils and
 * released under the GNU General Public License version 3.
 *
 * License: https://github.com/sel-project/sel-utils/blob/master/LICENSE
 * Repository: https://github.com/sel-project/sel-utils
 * Generator: https://github.com/sel-project/sel-utils/blob/master/xml/protocol/minecraft107.xml
 */
package sul.protocol.minecraft107.serverbound;

import java.util.UUID;

import sul.protocol.minecraft107.types.*;
import sul.utils.*;

class PlayerLook extends Packet {

	public final static int ID = (int)14;

	public final static boolean CLIENTBOUND = false;
	public final static boolean SERVERBOUND = true;

	public float yaw;
	public float pitch;
	public boolean onGround;

	@Override
	public int length() {
		return 9;
	}

	@Override
	public byte[] encode() {
	}

	@Override
	public void decode(byte[] buffer) {
	}

}
