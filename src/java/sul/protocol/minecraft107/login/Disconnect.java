/*
 * This file was automatically generated by sel-utils and
 * released under the GNU General Public License version 3.
 *
 * License: https://github.com/sel-project/sel-utils/blob/master/LICENSE
 * Repository: https://github.com/sel-project/sel-utils
 * Generated from https://github.com/sel-project/sel-utils/blob/master/xml/protocol/minecraft107.xml
 */
package sul.protocol.minecraft107.login;

import java.nio.charset.StandardCharsets;

import sul.utils.*;

public class Disconnect extends Packet {

	public static final int ID = (int)0;

	public static final boolean CLIENTBOUND = true;
	public static final boolean SERVERBOUND = false;

	public String reason;

	public Disconnect() {}

	public Disconnect(String reason) {
		this.reason = reason;
	}

	@Override
	public int length() {
		return Buffer.varuintLength(ID) + Buffer.varuintLength(reason.getBytes(StandardCharsets.UTF_8).length) + reason.getBytes(StandardCharsets.UTF_8).length;
	}

	@Override
	public byte[] encode() {
		this._buffer = new byte[this.length()];
		this.writeVaruint(ID);
		byte[] cmvhc29u=reason.getBytes(StandardCharsets.UTF_8); this.writeVaruint((int)cmvhc29u.length); this.writeBytes(cmvhc29u);
		return this.getBuffer();
	}

	@Override
	public void decode(byte[] buffer) {
		this._buffer = buffer;
		this.readVaruint();
		int bgvucmvhc29u=this.readVaruint(); reason=new String(this.readBytes(bgvucmvhc29u), StandardCharsets.UTF_8);
	}

	public static Disconnect fromBuffer(byte[] buffer) {
		Disconnect ret = new Disconnect();
		ret.decode(buffer);
		return ret;
	}

}
