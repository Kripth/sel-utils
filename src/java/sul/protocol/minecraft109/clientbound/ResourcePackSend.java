/*
 * This file has been automatically generated by sel-utils and
 * released under the GNU General Public License version 3.
 *
 * License: https://github.com/sel-project/sel-utils/blob/master/LICENSE
 * Repository: https://github.com/sel-project/sel-utils
 * Generator: https://github.com/sel-project/sel-utils/blob/master/xml/protocol/minecraft109.xml
 */
package sul.protocol.minecraft109.clientbound;

import java.util.UUID;

import sul.protocol.minecraft109.types.*;
import sul.utils.*;

class ResourcePackSend extends Packet {

	public final static int ID = (int)50;

	public final static boolean CLIENTBOUND = true;
	public final static boolean SERVERBOUND = false;

	public String url;
	public String hash;

	@Override
	public int length() {
		return Var.Uint.length(url.getBytes(StandardCharset.UTF_8).length) + url.getBytes(StandardCharset.UTF_8).length + Var.Uint.length(hash.getBytes(StandardCharset.UTF_8).length) + hash.getBytes(StandardCharset.UTF_8).length;
	}

	@Override
	public byte[] encode() {
	}

	@Override
	public void decode(byte[] buffer) {
	}

}
