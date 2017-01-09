/*
 * This file has been automatically generated by sel-utils and
 * released under the GNU General Public License version 3.
 *
 * License: https://github.com/sel-project/sel-utils/blob/master/LICENSE
 * Repository: https://github.com/sel-project/sel-utils
 * Generator: https://github.com/sel-project/sel-utils/blob/master/xml/protocol/minecraft210.xml
 */
package sul.protocol.minecraft210.clientbound;

import java.util.UUID;

import sul.protocol.minecraft210.types.*;
import sul.utils.*;

class ChangeGameState extends Packet {

	public final static int ID = (int)30;

	public final static boolean CLIENTBOUND = true;
	public final static boolean SERVERBOUND = false;

	// reason
	public final static byte INVALID_BED = (byte)0;
	public final static byte END_RAINING = (byte)1;
	public final static byte BEGIN_RAINING = (byte)2;
	public final static byte CHANGE_GAMEMODE = (byte)3;
	public final static byte EXIT_END = (byte)4;
	public final static byte DEMO_MESSAGE = (byte)5;
	public final static byte ARROW_HITTING_PLAYER = (byte)6;
	public final static byte FADE_VALUE = (byte)7;
	public final static byte FADE_TIME = (byte)8;
	public final static byte PLAY_ELDER_GUARDIAN_MOB_APPEARANCE = (byte)10;

	// value
	public final static float SURVIVAL = (float)0;
	public final static float CREATIVE = (float)1;
	public final static float ADVENTURE = (float)2;
	public final static float SPECTATOR = (float)3;
	public final static float RESPAWN_IMMEDIATELY = (float)0;
	public final static float RESPAWN_AFTER_CREDITS = (float)1;
	public final static float SHOW_DEMO_SCREEN = (float)0;
	public final static float TELL_MOVEMENT_CONTROLS = (float)101;
	public final static float TELL_JUMP_CONTROLS = (float)102;
	public final static float TELL_INVENTORY_CONTROLS = (float)103;
	public final static float BRIGHT = (float)0;
	public final static float DARK = (float)1;

	public byte reason;
	public float value;

	@Override
	public int length() {
		return 5;
	}

	@Override
	public byte[] encode() {
	}

	@Override
	public void decode(byte[] buffer) {
	}

}
