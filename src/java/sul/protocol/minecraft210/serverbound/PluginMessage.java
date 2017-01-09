/*
 * This file has been automatically generated by sel-utils and
 * released under the GNU General Public License version 3.
 *
 * License: https://github.com/sel-project/sel-utils/blob/master/LICENSE
 * Repository: https://github.com/sel-project/sel-utils
 * Generator: https://github.com/sel-project/sel-utils/blob/master/xml/protocol/minecraft210.xml
 */
package sul.protocol.minecraft210.serverbound;

import java.util.UUID;

import sul.protocol.minecraft210.types.*;
import sul.utils.*;

class PluginMessage extends Packet {

	public final static int ID = (int)9;

	public final static boolean CLIENTBOUND = false;
	public final static boolean SERVERBOUND = true;

	public String channel;
	public byte[] data;

	@Override
	public int length() {
		return Var.Uint.length(channel.getBytes(StandardCharset.UTF_8).length) + channel.getBytes(StandardCharset.UTF_8).length + data.length;
	}

	@Override
	public byte[] encode() {
	}

	@Override
	public void decode(byte[] buffer) {
	}

}
