/*
 * This file has been automatically generated by sel-utils and
 * it's released under the GNU General Public License version 3.
 *
 * Repository: https://github.com/sel-project/sel-utils
 * License: https://github.com/sel-project/sel-utils/blob/master/LICENSE
 * From: https://github.com/sel-project/sel-utils/blob/master/xml/attributes/Pocket100.xml
 */
package sul.attributes;

public enum Pocket100 {

	HEALTH("minecraft:health", 0, 20, 20);

	ABSORPTION("minecraft:generic.absorption", 0, 4, 0);

	HUNGER("minecraft:player.hunger", 0, 20, 20);

	SATURATION("minecraft:player.saturation", 0, 20, 5);

	EXPERIENCE("minecraft:player.experience", 0, 1, 0);

	LEVEL("minecraft:player.level", 0, 24791, 0);

	SPEED("minecraft:movement", 0, 24791, 0.1);

	KNOCKBACKRESISTANCE("minecraft:generic.knockback_resistance", 0, 1, 0);

	public final String name;
	public final float min, max, def;

	Pocket100(String name, float min, float max, float def) {
		this.name = name;
		this.min = min;
		this.max = max;
		this.def = def;
	}

}