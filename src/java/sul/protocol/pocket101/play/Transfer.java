/*
 * This file was automatically generated by sel-utils and
 * released under the GNU General Public License version 3.
 * 
 * License: https://github.com/sel-project/sel-utils/blob/master/LICENSE
 * Repository: https://github.com/sel-project/sel-utils
 * Generated from https://github.com/sel-project/sel-utils/blob/master/xml/protocol/pocket101.xml
 */
package sul.protocol.pocket101.play;

import java.nio.charset.StandardCharsets;

import sul.utils.*;

/**
 * Transfers the player to another server. Once transferred the player will immediately
 * close the connection with the transferring server, try to resolve the ip and join
 * the new server starting a new raknet session.
 */
public class Transfer extends Packet {

	public static final byte ID = (byte)82;

	public static final boolean CLIENTBOUND = true;
	public static final boolean SERVERBOUND = false;

	@Override
	public int getId() {
		return ID;
	}

	/**
	 * Address of the new server. It can be an dotted ip (for example `127.0.0.1`) or an
	 * URI (for example `localhost` or `play.example.com`). Only IP of version 4 are currently
	 * allowed.
	 */
	public String ip;

	/**
	 * Port of the new server. If 0 the server will try to connect to the default port.
	 */
	public short port = 19132;

	public Transfer() {}

	public Transfer(String ip, short port) {
		this.ip = ip;
		this.port = port;
	}

	@Override
	public int length() {
		return Buffer.varuintLength(ip.getBytes(StandardCharsets.UTF_8).length) + ip.getBytes(StandardCharsets.UTF_8).length + 3;
	}

	@Override
	public byte[] encode() {
		this._buffer = new byte[this.length()];
		this.writeBigEndianByte(ID);
		byte[] aa=ip.getBytes(StandardCharsets.UTF_8); this.writeVaruint((int)aa.length); this.writeBytes(aa);
		this.writeLittleEndianShort(port);
		return this.getBuffer();
	}

	@Override
	public void decode(byte[] buffer) {
		this._buffer = buffer;
		readBigEndianByte();
		int bvaa=this.readVaruint(); ip=new String(this.readBytes(bvaa), StandardCharsets.UTF_8);
		port=readLittleEndianShort();
	}

	public static Transfer fromBuffer(byte[] buffer) {
		Transfer ret = new Transfer();
		ret.decode(buffer);
		return ret;
	}

	@Override
	public String toString() {
		return "Transfer(ip: " + this.ip + ", port: " + this.port + ")";
	}

}
