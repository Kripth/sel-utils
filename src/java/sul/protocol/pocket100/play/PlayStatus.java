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

class PlayStatus extends Packet {

	public final static byte ID = (byte)2;

	public final static boolean CLIENTBOUND = true;
	public final static boolean SERVERBOUND = false;

	// status
	public final static int OK = (int)0;
	public final static int OUTDATED_CLIENT = (int)1;
	public final static int OUTDATED_SERVER = (int)2;
	public final static int SPAWNED = (int)3;
	public final static int INVALID_TENANT = (int)4;
	public final static int EDITION_MISMATCH = (int)5;

	public int status;

	@Override
	public int length() {
		return 4;
	}

	@Override
	public byte[] encode() {
	}

	@Override
	public void decode(byte[] buffer) {
	}

}
