/*
 * This file has been automatically generated by sel-utils and
 * released under the GNU General Public License version 3.
 *
 * License: https://github.com/sel-project/sel-utils/blob/master/LICENSE
 * Repository: https://github.com/sel-project/sel-utils
 * Generator: https://github.com/sel-project/sel-utils/blob/master/xml/protocol/minecraft210.xml
 */
package sul.protocol.minecraft210.types;

import java.util.UUID;

import sul.utils.Tuples;
import sul.utils.Var;

final class Icon {

	// direction and type
	public final static byte WHITE_ARROW = (byte)0;
	public final static byte GREEN_ARROW = (byte)1;
	public final static byte RED_ARROW = (byte)2;
	public final static byte BLUE_ARROW = (byte)3;
	public final static byte WHITE_CROSS = (byte)4;
	public final static byte RED_POINTER = (byte)5;
	public final static byte WHITE_CIRCLE = (byte)6;

	public byte directionAndType;
	public Tuples.ByteXZ position;

}
