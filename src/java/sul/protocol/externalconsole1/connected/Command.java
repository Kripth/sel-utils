/*
 * This file was automatically generated by sel-utils and
 * released under the GNU General Public License version 3.
 *
 * License: https://github.com/sel-project/sel-utils/blob/master/LICENSE
 * Repository: https://github.com/sel-project/sel-utils
 * Generated from https://github.com/sel-project/sel-utils/blob/master/xml/protocol/externalconsole1.xml
 */
package sul.protocol.externalconsole1.connected;

import java.nio.charset.StandardCharsets;

import sul.utils.*;

/**
 * Executes a command remotely if the server allows it. If not a Permission Denied
 * is sent back. A good implementation of the external console client should never
 * send this packet if remoteCommands field in Welcome.Accepted is not true.
 */
public class Command extends Packet {

	public static final byte ID = (byte)5;

	public static final boolean CLIENTBOUND = false;
	public static final boolean SERVERBOUND = true;

	/**
	 * Command to execute on the server.
	 */
	public String command;

	public Command() {}

	public Command(String command) {
		this.command = command;
	}

	@Override
	public int length() {
		return command.getBytes(StandardCharsets.UTF_8).length + 3;
	}

	@Override
	public byte[] encode() {
		this._buffer = new byte[this.length()];
		this.writeBigEndianByte(ID);
		byte[] y29tbwfuza=command.getBytes(StandardCharsets.UTF_8); this.writeBigEndianShort((short)y29tbwfuza.length); this.writeBytes(y29tbwfuza);
		return this.getBuffer();
	}

	@Override
	public void decode(byte[] buffer) {
		this._buffer = buffer;
		readBigEndianByte();
		short bgvuy29tbwfuza=readBigEndianShort(); command=new String(this.readBytes(bgvuy29tbwfuza), StandardCharsets.UTF_8);
	}

	public static Command fromBuffer(byte[] buffer) {
		Command ret = new Command();
		ret.decode(buffer);
		return ret;
	}

}
