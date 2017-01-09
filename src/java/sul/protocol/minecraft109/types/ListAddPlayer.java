/*
 * This file has been automatically generated by sel-utils and
 * released under the GNU General Public License version 3.
 *
 * License: https://github.com/sel-project/sel-utils/blob/master/LICENSE
 * Repository: https://github.com/sel-project/sel-utils
 * Generator: https://github.com/sel-project/sel-utils/blob/master/xml/protocol/minecraft109.xml
 */
package sul.protocol.minecraft109.types;

import java.util.UUID;

import sul.utils.Tuples;
import sul.utils.Var;

final class ListAddPlayer {

	// gamemode
	public final static int SURVIVAL = (int)0;
	public final static int CREATIVE = (int)1;
	public final static int ADVENTURE = (int)2;
	public final static int SPECTATOR = (int)3;

	public UUID uuid;
	public String name;
	public Property[] properties;
	public int gamemode;
	public int latency;
	public boolean hasDisplayName;
	public String displayName;

}
