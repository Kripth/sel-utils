/*
 * This file was automatically generated by sel-utils and
 * released under the GNU General Public License version 3.
 * 
 * License: https://github.com/sel-project/sel-utils/blob/master/LICENSE
 * Repository: https://github.com/sel-project/sel-utils
 * Generated from https://github.com/sel-project/sel-utils/blob/master/xml/protocol/pocket101.xml
 */
package sul.protocol.pocket101.play;

import java.util.Arrays;

import sul.utils.*;

/**
 * Updates client's game rules. This packet is ignored if the game is not launched
 * as Education Edition and should be avoid in favour of AdventureSettings, with which
 * the same result can be obtained with less data.
 */
public class GameRulesChanged extends Packet {

	public static final byte ID = (byte)72;

	public static final boolean CLIENTBOUND = true;
	public static final boolean SERVERBOUND = false;

	@Override
	public int getId() {
		return ID;
	}

	public sul.protocol.pocket101.types.Rule[] rules;

	public GameRulesChanged() {}

	public GameRulesChanged(sul.protocol.pocket101.types.Rule[] rules) {
		this.rules = rules;
	}

	@Override
	public int length() {
		int length=5; for(sul.protocol.pocket101.types.Rule cvzm:rules){ length+=cvzm.length(); } return length;
	}

	@Override
	public byte[] encode() {
		this._buffer = new byte[this.length()];
		this.writeBigEndianByte(ID);
		this.writeBigEndianInt((int)rules.length); for(sul.protocol.pocket101.types.Rule cvzm:rules){ this.writeBytes(cvzm.encode()); }
		return this.getBuffer();
	}

	@Override
	public void decode(byte[] buffer) {
		this._buffer = buffer;
		readBigEndianByte();
		int bjbv=readBigEndianInt(); rules=new sul.protocol.pocket101.types.Rule[bjbv]; for(int cvzm=0;cvzm<rules.length;cvzm++){ rules[cvzm]=new sul.protocol.pocket101.types.Rule(); rules[cvzm]._index=this._index; rules[cvzm].decode(this._buffer); this._index=rules[cvzm]._index; }
	}

	public static GameRulesChanged fromBuffer(byte[] buffer) {
		GameRulesChanged ret = new GameRulesChanged();
		ret.decode(buffer);
		return ret;
	}

	@Override
	public String toString() {
		return "GameRulesChanged(rules: " + Arrays.deepToString(this.rules) + ")";
	}

}
