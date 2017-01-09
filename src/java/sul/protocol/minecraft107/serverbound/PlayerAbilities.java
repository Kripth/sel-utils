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

class PlayerAbilities extends Packet {

	public final static int ID = (int)18;

	public final static boolean CLIENTBOUND = false;
	public final static boolean SERVERBOUND = true;

	// flags
	public final static byte CREATIVE_MODE = (byte)1;
	public final static byte FLYING = (byte)2;
	public final static byte ALLOW_FLYING = (byte)4;
	public final static byte INVINCIBLE = (byte)8;

	public byte flags;
	public float flyingSpeed;
	public float walkingSpeed;

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
