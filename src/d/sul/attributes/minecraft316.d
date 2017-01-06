/*
 * This file has been automatically generated by sel-utils and
 * it's released under the GNU General Public License version 3.
 *
 * Repository: https://github.com/sel-project/sel-utils
 * License: https://github.com/sel-project/sel-utils/blob/master/LICENSE
 * From: https://github.com/sel-project/sel-utils/blob/master/xml/attributes/minecraft316.xml
 */
module sul.attributes.minecraft316;

import std.typecons : Tuple;

alias Attribute = Tuple!(string, "name", float, "min", float, "max", float, "def");

struct Attributes {

	@disable this();

	enum maxHealth = Attribute("generic.maxHealth", 0, 1024, 20);

	enum absorption = Attribute("generic.absorption", 0, 4, 0);

	enum speed = Attribute("generic.movementSpeed", 0, 24791, 0.1);

	enum knockbackResistance = Attribute("generic.knockbackResistance", 0, 1, 0);

}
