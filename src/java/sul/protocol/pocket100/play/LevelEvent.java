/*
 * This file has been automatically generated by sel-utils and
 * released under the GNU General Public License version 3.
 *
 * License: https://github.com/sel-project/sel-utils/blob/master/LICENSE
 * Repository: https://github.com/sel-project/sel-utils
 * Generator: https://github.com/sel-project/sel-utils/blob/master/xml/protocol/pocket100.xml
 */
package sul.protocol.pocket100.play;

import java.util.UUID;

import sul.protocol.pocket100.types.*;
import sul.utils.*;

class LevelEvent extends Packet {

	public final static byte ID = (byte)27;

	public final static boolean CLIENTBOUND = true;
	public final static boolean SERVERBOUND = false;

	// event id
	public final static int START_RAIN = (int)3001;
	public final static int START_THUNDER = (int)3002;
	public final static int STOP_RAIN = (int)3003;
	public final static int STOP_THUNDER = (int)3004;
	public final static int SET_DATA = (int)4000;
	public final static int PLAYERS_SLEEPING = (int)9800;

	public int eventId;
	public Tuples.FloatXYZ position;
	public int data;

	@Override
	public int length() {
		return Var.Int.length(event_id) + position.length() + Var.Int.length(data);
	}

	@Override
	public byte[] encode() {
	}

	@Override
	public void decode(byte[] buffer) {
	}

}
