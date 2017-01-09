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

class UseItem extends Packet {

	public final static int ID = (int)29;

	public final static boolean CLIENTBOUND = false;
	public final static boolean SERVERBOUND = true;

	// hand
	public final static int MAIN_HAND = (int)0;
	public final static int OFF_HAND = (int)1;

	public int hand;

	@Override
	public int length() {
		return Var.Uint.length(hand);
	}

	@Override
	public byte[] encode() {
	}

	@Override
	public void decode(byte[] buffer) {
	}

}
