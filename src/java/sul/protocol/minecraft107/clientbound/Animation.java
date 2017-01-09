/*
 * This file has been automatically generated by sel-utils and
 * released under the GNU General Public License version 3.
 *
 * License: https://github.com/sel-project/sel-utils/blob/master/LICENSE
 * Repository: https://github.com/sel-project/sel-utils
 * Generator: https://github.com/sel-project/sel-utils/blob/master/xml/protocol/minecraft107.xml
 */
package sul.protocol.minecraft107.clientbound;

import java.util.UUID;

import sul.protocol.minecraft107.types.*;
import sul.utils.*;

class Animation extends Packet {

	public final static int ID = (int)6;

	public final static boolean CLIENTBOUND = true;
	public final static boolean SERVERBOUND = false;

	// animation
	public final static byte SWING_ARM = (byte)0;
	public final static byte TAKE_DAMAGE = (byte)1;
	public final static byte LEAVE_BED = (byte)2;
	public final static byte EAT_FOOD = (byte)3;
	public final static byte CRITICAL_EFFECT = (byte)4;
	public final static byte MAGICAL_CRITICAL_EFFECT = (byte)5;

	public int entityId;
	public byte animation;

	@Override
	public int length() {
		return Var.Uint.length(entityId) + 1;
	}

	@Override
	public byte[] encode() {
	}

	@Override
	public void decode(byte[] buffer) {
	}

}
