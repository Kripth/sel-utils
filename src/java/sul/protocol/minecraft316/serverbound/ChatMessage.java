/*
 * This file was automatically generated by sel-utils and
 * released under the GNU General Public License version 3.
 * 
 * License: https://github.com/sel-project/sel-utils/blob/master/LICENSE
 * Repository: https://github.com/sel-project/sel-utils
 * Generated from https://github.com/sel-project/sel-utils/blob/master/xml/protocol/minecraft316.xml
 */
package sul.protocol.minecraft316.serverbound;

import java.nio.charset.StandardCharsets;

import sul.utils.*;

public class ChatMessage extends Packet {

	public static final int ID = (int)2;

	public static final boolean CLIENTBOUND = false;
	public static final boolean SERVERBOUND = true;

	@Override
	public int getId() {
		return ID;
	}

	public String text;

	public ChatMessage() {}

	public ChatMessage(String text) {
		this.text = text;
	}

	@Override
	public int length() {
		return Buffer.varuintLength(ID) + Buffer.varuintLength(text.getBytes(StandardCharsets.UTF_8).length) + text.getBytes(StandardCharsets.UTF_8).length;
	}

	@Override
	public byte[] encode() {
		this._buffer = new byte[this.length()];
		this.writeVaruint(ID);
		byte[] dvd=text.getBytes(StandardCharsets.UTF_8); this.writeVaruint((int)dvd.length); this.writeBytes(dvd);
		return this.getBuffer();
	}

	@Override
	public void decode(byte[] buffer) {
		this._buffer = buffer;
		this.readVaruint();
		int bvdvd=this.readVaruint(); text=new String(this.readBytes(bvdvd), StandardCharsets.UTF_8);
	}

	public static ChatMessage fromBuffer(byte[] buffer) {
		ChatMessage ret = new ChatMessage();
		ret.decode(buffer);
		return ret;
	}

	@Override
	public String toString() {
		return "ChatMessage(text: " + this.text + ")";
	}

}
