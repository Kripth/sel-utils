/*
 * This file was automatically generated by sel-utils and
 * released under the GNU General Public License version 3.
 *
 * License: https://github.com/sel-project/sel-utils/blob/master/LICENSE
 * Repository: https://github.com/sel-project/sel-utils
 * Generated from https://github.com/sel-project/sel-utils/blob/master/xml/protocol/minecraft108.xml
 */
package sul.protocol.minecraft108.types;

import java.util.UUID;

import sul.utils.*;

public class Modifier extends Packet {

	// operation
	public static final byte ADD_SUBSTRACT_AMOUNT = 0;
	public static final byte ADD_SUBSTRACT_AMOUNT_PERCENTAGE = 1;
	public static final byte MULTIPLY_AMOUNT_PERCENTAGE = 2;

	public UUID uuid;
	public double amount;
	public byte operation;

	public Modifier() {}

	public Modifier(UUID uuid, double amount, byte operation) {
		this.uuid = uuid;
		this.amount = amount;
		this.operation = operation;
	}

	@Override
	public int length() {
		return 25;
	}

	@Override
	public byte[] encode() {
		this._buffer = new byte[this.length()];
		this.writeBigEndianLong(uuid.getLeastSignificantBits()); this.writeBigEndianLong(uuid.getMostSignificantBits());
		this.writeBigEndianDouble(amount);
		this.writeBigEndianByte(operation);
		return this.getBuffer();
	}

	@Override
	public void decode(byte[] buffer) {
		this._buffer = buffer;
		long bxv1awq=readBigEndianLong(); long bhv1awq=readBigEndianLong(); uuid=new UUID(bxv1awq,bhv1awq);
		amount=readBigEndianDouble();
		operation=readBigEndianByte();
	}


}
