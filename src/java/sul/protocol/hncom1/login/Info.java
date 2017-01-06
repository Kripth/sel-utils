/*
 * This file has been automatically generated by sel-utils and
 * it's released under the GNU General Public License version 3.
 *
 * Repository: https://github.com/sel-project/sel-utils
 * License: https://github.com/sel-project/sel-utils/blob/master/LICENSE
 * From: https://github.com/sel-project/sel-utils/blob/master/xml/protocol/hncom1.xml
 */
package sul.protocol.hncom1.login;

import java.util.UUID;

import sul.protocol.hncom1.types.*;
import sul.utils.Packet;

class Info : Packet {

	public final static byte ID = (byte)2;

	public final static boolean CLIENTBOUND = true;
	public final static boolean SERVERBOUND = false;

	public long serverId;
	public boolean onlineMode;
	public String displayName;
	public Game[] games;
	public int online;
	public int max;
	public String language;
	public String[] acceptedLanguages;
	public String[] nodes;
	public String socialJson;
	public String additionalJson;

	@Override
	public byte[] encode() {
	}

	@Override
	public void decode(byte[] buffer) {
	}

}
