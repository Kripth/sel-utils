/*
 * This file has been automatically generated by sel-utils and
 * released under the GNU General Public License version 3.
 *
 * License: https://github.com/sel-project/sel-utils/blob/master/LICENSE
 * Repository: https://github.com/sel-project/sel-utils
 * Generator: https://github.com/sel-project/sel-utils/blob/master/xml/protocol/minecraft315.xml
 */
package sul.protocol.minecraft315.clientbound;

import java.util.UUID;

import sul.protocol.minecraft315.types.*;
import sul.utils.*;

class Teams extends Packet {

	public final static int ID = (int)65;

	public final static boolean CLIENTBOUND = true;
	public final static boolean SERVERBOUND = false;

	public String name;
	public byte mode;

	@Override
	public int length() {
		return Var.Uint.length(name.getBytes(StandardCharset.UTF_8).length) + name.getBytes(StandardCharset.UTF_8).length + 1;
	}

	@Override
	public byte[] encode() {
	}

	@Override
	public void decode(byte[] buffer) {
	}

	public static class CreateTeam extends Teams {

	}

	public static class RemoveTeam extends Teams {

	}

	public static class UpdateTeamInfo extends Teams {

	}

	public static class AddPlayers extends Teams {

	}

	public static class RemovePlayers extends Teams {

	}

}
