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

class PlayerDigging extends Packet {

	public final static int ID = (int)19;

	public final static boolean CLIENTBOUND = false;
	public final static boolean SERVERBOUND = true;

	// status
	public final static int START_DIGGING = (int)0;
	public final static int CANCEL_DIGGING = (int)1;
	public final static int FINISH_DIGGING = (int)2;
	public final static int DROP_ITEM_STACK = (int)3;
	public final static int DROP_ITEM = (int)4;
	public final static int SHOOT_ARROW = (int)5;
	public final static int FINISH_EATING = (int)5;
	public final static int SWAP_ITEM_IN_HAND = (int)6;

	public int status;
	public long position;
	public byte face;

	@Override
	public int length() {
		return Var.Uint.length(status) + 9;
	}

	@Override
	public byte[] encode() {
	}

	@Override
	public void decode(byte[] buffer) {
	}

}
