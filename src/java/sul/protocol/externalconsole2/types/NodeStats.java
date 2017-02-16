/*
 * This file was automatically generated by sel-utils and
 * released under the GNU General Public License version 3.
 * 
 * License: https://github.com/sel-project/sel-utils/blob/master/LICENSE
 * Repository: https://github.com/sel-project/sel-utils
 * Generated from https://github.com/sel-project/sel-utils/blob/master/xml/protocol/externalconsole2.xml
 */
package sul.protocol.externalconsole2.types;

import java.nio.charset.StandardCharsets;

import sul.utils.*;

/**
 * Resources usage of a node.
 */
public class NodeStats extends Stream {

	/**
	 * Name of the node. Should match one of the names given in [Welcome.Accepted.connectedNodes](#login_welcome_accepted_connected-nodes)
	 * or one added using the UpdateNodes packet.
	 * If the server isn't built on the hub-node layout the name is an empty string and
	 * the following values are for the whole server and not for a node.
	 */
	public String name;

	/**
	 * Ticks per second of the node in range 0 to 20. If the value is less than 20, the
	 * server is lagging.
	 */
	public float tps;

	/**
	 * RAM allocated by the node in bytes.
	 * If the value is 0 the node couldn't retrieve the amount of memory allocated by its
	 * process.
	 */
	public long ram;

	/**
	 * Percentage of CPU used by the node. The value can be higher than 100 when the machine
	 * where the node is running has more than one CPU.
	 * If the value is `not a number` the node couldn't retrieve the amount of CPU used
	 * by its process.
	 */
	public float cpu;

	public NodeStats() {}

	public NodeStats(String name, float tps, long ram, float cpu) {
		this.name = name;
		this.tps = tps;
		this.ram = ram;
		this.cpu = cpu;
	}

	@Override
	public int length() {
		return name.getBytes(StandardCharsets.UTF_8).length + 18;
	}

	@Override
	public byte[] encode() {
		this._buffer = new byte[this.length()];
		byte[] bfz=name.getBytes(StandardCharsets.UTF_8); this.writeBigEndianShort((short)bfz.length); this.writeBytes(bfz);
		this.writeBigEndianFloat(tps);
		this.writeBigEndianLong(ram);
		this.writeBigEndianFloat(cpu);
		return this.getBuffer();
	}

	@Override
	public void decode(byte[] buffer) {
		this._buffer = buffer;
		short bvbfz=readBigEndianShort(); name=new String(this.readBytes(bvbfz), StandardCharsets.UTF_8);
		tps=readBigEndianFloat();
		ram=readBigEndianLong();
		cpu=readBigEndianFloat();
	}

	@Override
	public String toString() {
		return "NodeStats(name: " + this.name + ", tps: " + this.tps + ", ram: " + this.ram + ", cpu: " + this.cpu + ")";
	}


}
