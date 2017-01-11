/*
 * This file has been automatically generated by sel-utils and
 * released under the GNU General Public License version 3.
 *
 * License: https://github.com/sel-project/sel-utils/blob/master/LICENSE
 * Repository: https://github.com/sel-project/sel-utils
 * Generator: https://github.com/sel-project/sel-utils/blob/master/xml/protocol/hncom1.xml
 */
package sul.protocol.hncom1.login;

import java.util.UUID;

import sul.protocol.hncom1.types.*;
import sul.utils.*;

class Info extends Packet {

	public final static byte ID = (byte)2;

	public final static boolean CLIENTBOUND = true;
	public final static boolean SERVERBOUND = false;

	public long serverId;
	public String displayName;
	public boolean onlineMode;
	public Game[] games;
	public int online;
	public int max;
	public String language;
	public String[] acceptedLanguages;
	public String[] nodes;
	public long uuidPool;
	public String socialJson;
	public String additionalJson;

	@Override
	public int length() {
	}

	@Override
	public byte[] encode() {
		this.buffer = new byte[this.length()];
		this.index = 0;
		this.writeByteB(ID);
		this.writeLonglittle_endian(serverId);
		byte[] zglzcgxheu5hbwu=displayName.getBytes("UTF-8"); this.writeVaruint((int)zglzcgxheu5hbwu.length); this.writeBytes(zglzcgxheu5hbwu);
		this.writeBoolB(onlineMode);
		this.writeVaruint((int)games.length); for(game z2ftzxm:games){ this.writeBytes(z2ftzxm.encode()); }
		this.writeVaruint(online);
		this.writeVaruint(max);
		byte[] bgfuz3vhz2u=language.getBytes("UTF-8"); this.writeVaruint((int)bgfuz3vhz2u.length); this.writeBytes(bgfuz3vhz2u);
		this.writeVaruint((int)acceptedLanguages.length); for(string ywnjzxb0zwrmyw5n:acceptedLanguages){ byte[] exduanp4yjb6d3jt=ywnjzxb0zwrmyw5n.getBytes("UTF-8"); this.writeVaruint((int)exduanp4yjb6d3jt.length); this.writeBytes(exduanp4yjb6d3jt); }
		this.writeVaruint((int)nodes.length); for(string bm9kzxm:nodes){ byte[] ym05a3p4bq=bm9kzxm.getBytes("UTF-8"); this.writeVaruint((int)ym05a3p4bq.length); this.writeBytes(ym05a3p4bq); }
		this.writeLonglittle_endian(uuidPool);
		byte[] c29jawfssnnvbg=socialJson.getBytes("UTF-8"); this.writeVaruint((int)c29jawfssnnvbg.length); this.writeBytes(c29jawfssnnvbg);
		byte[] ywrkaxrpb25hbepz=additionalJson.getBytes("UTF-8"); this.writeVaruint((int)ywrkaxrpb25hbepz.length); this.writeBytes(ywrkaxrpb25hbepz);
		return this.buffer;
	}

	@Override
	public void decode(byte[] buffer) {
		this.buffer = buffer;
		this.index = 0;
	}

}
