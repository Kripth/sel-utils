/*
 * Copyright (c) 2017 SEL
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 * 
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 * 
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 * 
 */
module all;

import std.algorithm : canFind, min, sort;
import std.base64 : Base64URL;
import std.conv : to;
import std.file : dirEntries, SpanMode, read, isFile, _write = write, exists;
import std.json;
import std.path : dirSeparator;
import std.regex : ctRegex, replaceAll;
import std.string;
import std.xml;

static import d;
static import java;
static import js;

static import src;

static import diff;
static import docs;

struct Tuple(E...) if(E.length % 2 == 0) {

	mixin((){
		string data;
		foreach(i, member; E) {
			static if(i % 2 == 0) {
				data ~= "public E[" ~ to!string(i) ~ "] " ~ E[i+1] ~ ";";
			}
		}
		return data;
	}());

}


alias File(T) = Tuple!(string, "software", size_t, "protocol", T, "data");


alias Attribute = Tuple!(string, "name", string, "id", float, "min", float, "max", float, "def", string, "description");

alias Attributes = File!(Attribute[]);


alias ItemC = Tuple!(ushort, "id", ushort, "meta", string, "nbt");

alias Creative = File!(ItemC[]);


alias MetadataType = Tuple!(string, "name", string, "type", ubyte, "id", string, "endianness");

alias MetadataFlag = Tuple!(string, "name", string, "description", size_t, "bit");

alias MetadataData = Tuple!(string, "name", string, "description", string, "type", ubyte, "id", string, "def", bool, "required", MetadataFlag[], "flags");

alias Metadata = Tuple!(string, "prefix", string, "length", string, "suffix", string, "type", string, "id", MetadataType[], "types", MetadataData[], "data");

alias Metadatas = File!Metadata;


alias Constant = Tuple!(string, "name", string, "description", string, "value");

alias Field = Tuple!(string, "name", string, "type", string, "condition", string, "endianness", string, "def", string, "description", Constant[], "constants");

alias Variant = Tuple!(string, "name", string, "value", string, "description", Field[], "fields");

alias Packet = Tuple!(string, "name", size_t, "id", bool, "clientbound", bool, "serverbound", string, "description", Field[], "fields", string, "variantField", Variant[], "variants");

alias Type = Tuple!(string, "name", string, "description", Field[], "fields", string, "length");

alias Section = Tuple!(string, "name", string, "description", Packet[], "packets");

alias Array = Tuple!(string, "base", string, "length", string, "endianness");

alias Protocol = Tuple!(string, "released", string, "from", string, "to", string, "description", string, "id", string, "arrayLength", string[string], "endianness", Section[], "sections", Type[], "types", Array[string], "arrays");

alias Protocols = File!Protocol;


alias BlockData = Tuple!(int, "id", int, "meta", int, "hash");

alias Point = Tuple!(ubyte, "x", ubyte, "y", ubyte, "z");

alias BoundingBox = Tuple!(Point, "min", Point, "max");

alias Block = Tuple!(string, "name", ushort, "id", BlockData, "java", BlockData, "bedrock", bool, "solid", double, "hardness", double, "blastResistance", ubyte, "opacity", ubyte, "luminance", ubyte, "encouragement", ubyte, "flammability", bool, "replaceable", BoundingBox, "boundingBox");


alias ItemData = Tuple!(bool, "exists", ushort, "id", int, "meta", string, "nbt");

alias Item = Tuple!(string, "name", ItemData, "java", ItemData, "bedrock", ubyte, "stack", ushort, "durability");


alias Entity = Tuple!(string, "name", ubyte, "java", ubyte, "bedrock", bool, "object", double, "width", double, "height");


alias Enchantment = Tuple!(string, "name", byte, "java", byte, "bedrock", ubyte, "max");


alias Effect = Tuple!(string, "name", byte, "java", byte, "bedrock", uint, "particles");


alias Biome = Tuple!(string, "name", ubyte, "id", float, "temperature");


private uint n_version;

public @property uint sulVersion() {
	return n_version;
}


void main(string[] args) {

	args = args[1..$];

	// update generation version
	if(exists("version.txt")) {
		n_version = to!uint(strip(cast(string)read("version.txt")));
	} else {
		n_version = 1;
	}

	// attributes
	Attributes[string] attributes;
	foreach(string file ; dirEntries("../xml/attributes", SpanMode.breadth)) {
		if(file.isFile && file.endsWith(".xml")) {
			Attributes curr;
			foreach(element ; new Document(cast(string)read(file)).elements) {
				switch(element.tag.name) {
					case "software":
						curr.software = element.text.strip;
						break;
					case "protocol":
						curr.protocol = element.text.strip.to!size_t;
						break;
					case "attribute":
						with(element.tag) curr.data ~= Attribute(attr["name"].replace("-", "_"), attr["id"], attr["min"].to!float, attr["max"].to!float, attr["default"].to!float, text(element));
						break;
					default:
						break;
				}
			}
			attributes[file.name!"xml"] = curr;
		}
	}

	// creative items
	Creative[string] creative;
	foreach(string file ; dirEntries("../xml/creative", SpanMode.breadth)) {
		if(file.isFile && file.endsWith(".xml")) {
			Creative c;
			foreach(element ; new Document(cast(string)read(file)).elements) {
				switch(element.tag.name) {
					case "software":
						c.software = element.text.strip;
						break;
					case "protocol":
						c.protocol = element.text.strip.to!size_t;
						break;
					case "category":
						foreach(i ; element.elements) {
							if(i.tag.name == "item") {
								ItemC item;
								item.id = i.tag.attr["id"].to!ushort;
								if("meta" in i.tag.attr) item.meta = i.tag.attr["meta"].to!ushort;
								if("nbt" in i.tag.attr) item.nbt = i.tag.attr["nbt"];
								c.data ~= item;
							}
						}
						break;
					default:
						break;
				}
			}
			creative[file.name!"xml"] = c;
		}
	}

	// metadata
	Metadatas[string] metadata;
	foreach(string file ; dirEntries("../xml/metadata", SpanMode.breadth)) {
		if(file.isFile && file.endsWith(".xml")) {
			Metadatas m;
			foreach(element ; new Document(cast(string)read(file)).elements) {
				switch(element.tag.name) {
					case "software":
						m.software = element.text.strip;
						break;
					case "protocol":
						m.protocol = element.text.strip.to!size_t;
						break;
					case "encoding":
						if("prefix" in element.tag.attr) m.data.prefix = element.tag.attr["prefix"];
						if("length" in element.tag.attr) m.data.length = element.tag.attr["length"];
						if("suffix" in element.tag.attr) m.data.suffix = element.tag.attr["suffix"];
						m.data.type = element.tag.attr["types"];
						m.data.id = element.tag.attr["ids"];
						foreach(t ; element.elements) {
							if(t.tag.name == "type") {
								auto e = "endianness" in t.tag.attr;
								m.data.types ~= MetadataType(t.tag.attr["name"].replace("-", "_"), t.tag.attr["type"].replace("-", "_"), t.tag.attr["id"].to!ubyte, e ? replace(*e, "-", "_") : "");
							}
						}
						break;
					case "metadatas":
						foreach(md ; element.elements) {
							if(md.tag.name == "type") {
								MetadataData data;
								data.name = md.tag.attr["name"].replace("-", "_");
								data.description = text(md);
								data.type = md.tag.attr["type"].replace("-", "_");
								data.id = md.tag.attr["id"].to!ubyte;
								if("default" in md.tag.attr) data.def = md.tag.attr["default"];
								if("required" in md.tag.attr) data.required = md.tag.attr["required"].to!bool;
								foreach(f ; md.elements) {
									if(f.tag.name == "flag") {
										data.flags ~= MetadataFlag(f.tag.attr["name"].replace("-", "_"), text(f), to!size_t(f.tag.attr["bit"]));

									}
								}
								m.data.data ~= data;
							}
						}
						break;
					default:
						break;
				}
			}
			metadata[file.name!"xml"] = m;
		}
	}

	// protocol
	Protocols[string] protocols;
	foreach(string file ; dirEntries("../xml/protocol", SpanMode.breadth)) {
		if(file.isFile && file.endsWith(".xml")) {
			Protocols protocol;
			string[string] aliases;
			@property string convert(string type) {
				auto end = min(cast(size_t)type.lastIndexOf("["), cast(size_t)type.lastIndexOf("<"), type.length);
				auto t = type[0..end];
				auto a = t in aliases;
				if(a) t = *a;
				return t ~ type[end..$];
			}
			foreach(element ; new Document(cast(string)read(file)).elements) {
				switch(element.tag.name) {
					case "software":
						protocol.software = text(element);
						break;
					case "protocol":
						protocol.protocol = to!size_t(text(element));
						break;
					case "released":
						protocol.data.released = text(element);
						break;
					case "from":
						protocol.data.from = text(element);
						break;
					case "to":
						protocol.data.to = text(element);
						break;
					case "description":
						protocol.data.description = text(element);
						break;
					case "encoding":
						protocol.data.id = element.tag.attr["id"];
						protocol.data.arrayLength = element.tag.attr["arraylength"];
						foreach(e ; element.elements) {
							switch(e.tag.name) {
								case "endianness":
									with(e.tag) protocol.data.endianness[attr["type"].replace("-", "_")] = attr["value"].replace("-", "_");
									break;
								case "alias":
									with(e.tag) aliases[attr["name"].replace("-", "_")] = attr["type"].replace("-", "_");
									break;
								case "type":
									Type type;
									type.name = e.tag.attr["name"].replace("-", "_");
									type.description = text(e);
									if("length" in e.tag.attr) type.length = e.tag.attr["length"].length ? convert(e.tag.attr["length"].replace("-", "_")) : protocol.data.arrayLength;
									foreach(f ; e.elements) {
										if(f.tag.name == "field") {
											Field field;
											with(f.tag) {
												field.name = attr["name"].replace("-", "_");
												field.type = convert(attr["type"].replace("-", "_"));
												field.description = text(f);
												if("endianness" in attr) field.endianness = attr["endianness"].replace("-", "_");
												if("when" in attr) field.condition = attr["when"].replace("-", "_");
												if("default" in attr) field.def = attr["default"];
											}
											foreach(c ; f.elements) {
												if(c.tag.name == "constant") {
													field.constants ~= Constant(c.tag.attr["name"].replace("-", "_"), text(c), c.tag.attr["value"]);
												}
											}
											type.fields ~= field;
										}
									}
									protocol.data.types ~= type;
									break;
								case "array":
									with(e.tag) protocol.data.arrays[attr["name"].replace("-", "_")] = Array(convert(attr["base"].replace("-", "_")), convert(attr["length"].replace("-", "_")), ("endianness" in attr ? attr["endianness"].replace("-", "_") : ""));
									break;
								default:
									break;
							}
						}
						break;
					case "packets":
						foreach(s ; element.elements) {
							if(s.tag.name == "section") {
								Section section;
								section.name = s.tag.attr["name"].replace("-", "_");
								section.description = text(s);
								foreach(pk ; s.elements) {
									if(pk.tag.name == "packet") {
										Packet packet;
										packet.name = pk.tag.attr["name"].replace("-", "_");
										packet.id = pk.tag.attr["id"].to!size_t;
										packet.clientbound = pk.tag.attr["clientbound"].to!bool;
										packet.serverbound = pk.tag.attr["serverbound"].to!bool;
										packet.description = text(pk);
										foreach(fv ; pk.elements) {
											if(fv.tag.name == "field") {
												Field field;
												field.name = fv.tag.attr["name"].replace("-", "_");
												field.type = convert(fv.tag.attr["type"].replace("-", "_"));
												field.description = text(fv);
												if("endianness" in fv.tag.attr) field.endianness = fv.tag.attr["endianness"].replace("-", "_");
												if("when" in fv.tag.attr) field.condition = fv.tag.attr["when"].replace("-", "_");
												if("default" in fv.tag.attr) field.def = fv.tag.attr["default"];
												foreach(c ; fv.elements) {
													if(c.tag.name == "constant") {
														field.constants ~= Constant(c.tag.attr["name"].replace("-", "_"), text(c), c.tag.attr["value"]);
													}
												}
												packet.fields ~= field;
											} else if(fv.tag.name == "variants") {
												packet.variantField = fv.tag.attr["field"].replace("-", "_");
												foreach(v ; fv.elements) {
													if(v.tag.name == "variant") {
														Variant variant;
														variant.name = v.tag.attr["name"].replace("-", "_");
														variant.value = v.tag.attr["value"].replace("-", "_");
														variant.description = text(v);
														foreach(f ; v.elements) {
															if(f.tag.name == "field") {
																Field field;
																field.name = f.tag.attr["name"].replace("-", "_");
																field.type = convert(f.tag.attr["type"].replace("-", "_"));
																field.description = text(f);
																if("endianness" in f.tag.attr) field.endianness = f.tag.attr["endianness"].replace("-", "_");
																if("when" in f.tag.attr) field.condition = f.tag.attr["when"].replace("-", "_");
																if("default" in f.tag.attr) field.def = f.tag.attr["default"];
																foreach(c ; f.elements) {
																	if(c.tag.name == "constant") {
																		field.constants ~= Constant(c.tag.attr["name"].replace("-", "_"), text(c), c.tag.attr["value"]);
																	}
																}
																variant.fields ~= field;
															}
														}
														packet.variants ~= variant;
													}
												}
											}
										}
										section.packets ~= packet;
									}
								}
								protocol.data.sections ~= section;
							}
						}
						break;
					default:
						break;
				}
			}
			protocols[file.name!"xml"] = protocol;
		}
	}

	// blocks
	Block[] blocks;
	{
		BlockData blockData(string data) {
			auto ret = BlockData(0, -1, -1);
			auto spl = data.split(":");
			ret.id = to!ubyte(spl[0]);
			ret.hash = ret.id << 4;
			if(spl.length == 2) {
				ret.meta = to!ubyte(spl[1]);
				ret.hash |= ret.meta;
			}
			return ret;
		}
		BoundingBox boundingBox(string data) {
			if(data == "none") return BoundingBox.init;
			Point point(string data) {
				auto xyz = data.split(",");
				return Point(to!ubyte(xyz[0]), to!ubyte(xyz[1]), to!ubyte(xyz[2]));
			}
			auto spl = data.split("-");
			return BoundingBox(point(spl[0]), point(spl[1]));
		}
		Block createBlock(Block block, Element element) {
			auto name = "name" in element.tag.attr;
			auto id = "id" in element.tag.attr;
			auto java = "java" in element.tag.attr;
			auto bedrock = "bedrock" in element.tag.attr;
			auto solid = "solid" in element.tag.attr;
			auto hardness = "hardness" in element.tag.attr;
			auto blastResistance = "blastresistance" in element.tag.attr;
			auto opacity = "opacity" in element.tag.attr;
			auto luminance = "luminance" in element.tag.attr;
			auto encouragement = "encouragement" in element.tag.attr;
			auto flammability = "flammability" in element.tag.attr;
			auto replaceable = "replaceable" in element.tag.attr;
			auto bb = "boundingbox" in element.tag.attr;
			if(name) block.name = replace(*name, "-", "_");
			if(id) block.id = to!ushort(*id);
			if(java) block.java = blockData(*java);
			if(bedrock) block.bedrock = blockData(*bedrock);
			if(solid) block.solid = to!bool(*solid);
			if(bb && *bb == "none") block.solid = false;
			if(hardness) block.hardness = to!double(*hardness);
			if(blastResistance) block.blastResistance = to!double(*blastResistance);
			if(opacity) block.opacity = to!ubyte(*opacity) & 15;
			if(luminance) block.luminance = to!ubyte(*luminance) & 15;
			if(encouragement) block.encouragement = to!ubyte(*encouragement);
			if(flammability) block.flammability = to!ubyte(*flammability);
			if(replaceable) block.replaceable = to!bool(*replaceable);
			if(bb) block.boundingBox = boundingBox(*bb);
			return block;
		}
		void group(Block current, Element[] elements) {
			foreach(element ; elements) {
				switch(element.tag.name) {
					case "block":
						blocks ~= createBlock(current, element);
						break;
					case "group":
						group(createBlock(current, element), element.elements);
						break;
					default:
						break;
				}
			}
		}
		group(Block("", 0, BlockData(0, 0, -1), BlockData(0, 0, -1), true, 0, 0, 15, 0, 0, 0, false, BoundingBox(Point(0,0,0), Point(16,16,16))), new Document(cast(string)read("../xml/blocks.xml")).elements);
	}
	sort!"a.id < b.id"(blocks);

	foreach(i, block; blocks) assert(i == block.id, to!string(i));

	// items
	Item[] items;
	foreach(element ; new Document(cast(string)read("../xml/items.xml")).elements) {
		with(element.tag) {
			if(name == "item") {
				Item item;
				item.name = attr["name"].replace("-", "_");
				void setData(ref ItemData id, string str) {
					auto s = str.split(":");
					if(s.length) {
						id.exists = true;
						id.id = to!ushort(s[0]);
						id.meta = -1;
						if(s.length >= 2) {
							try id.meta = to!ushort(s[1]);
							catch(Exception) id.nbt = s[1..$].join(":").replace("'", "\"");
						}
					}
				}
				auto data = "data" in attr;
				auto java = "java" in attr;
				auto bedrock = "bedrock" in attr;
				auto stack = "stack" in attr;
				auto durability = "durability" in attr;
				if(data) {
					setData(item.java, *data);
					setData(item.bedrock, *data);
				} else {
					if(java) setData(item.java, *java);
					if(bedrock) setData(item.bedrock, *bedrock);
				}
				item.stack = stack ? to!ubyte(*stack) : 64;
				item.durability = durability ? to!ushort(*durability) : 0;
				items ~= item;
			}
		}
	}

	// entities
	Entity[] entities;
	foreach(element ; new Document(cast(string)read("../xml/entities.xml")).elements) {
		with(element.tag) {
			if(name == "object" || name == "entity") {
				Entity entity;
				entity.name = attr["name"].replace("-", "_");
				entity.object = name == "object";
				auto java = "java" in attr;
				auto bedrock = "bedrock" in attr;
				auto width = "width" in attr;
				auto height = "height" in attr;
				if(java) entity.java = to!ubyte(*java);
				if(bedrock) entity.bedrock = to!ubyte(*bedrock);
				if(width) entity.width = to!double(*width);
				if(height) entity.height = to!double(*height);
				entities ~= entity;
			}
		}
	}

	// enchantments
	Enchantment[] enchantments;
	foreach(element ; new Document(cast(string)read("../xml/enchantments.xml")).elements) {
		with(element.tag) {
			if(name == "enchantment") {
				auto java = "java" in attr;
				auto bedrock = "bedrock" in attr;
				enchantments ~= Enchantment(attr["name"].replace("-", "_"), java ? to!ubyte(*java) : -1, bedrock ? to!ubyte(*bedrock) : -1, to!ubyte(attr["max"]));
			}
		}
	}
	
	// effects
	Effect[] effects;
	foreach(element ; new Document(cast(string)read("../xml/effects.xml")).elements) {
		with(element.tag) {
			if(name == "effect") {
				auto java = "java" in attr;
				auto bedrock = "bedrock" in attr;
				effects ~= Effect(attr["name"].replace("-", "_"), java ? to!ubyte(*java) : -1, bedrock ? to!ubyte(*bedrock) : -1, to!uint(attr["particles"], 16));
			}
		}
	}
	
	// biomes
	Biome[] biomes;
	foreach(element ; new Document(cast(string)read("../xml/biomes.xml")).elements) {
		with(element.tag) {
			if(name == "biome") {
				biomes ~= Biome(attr["name"].replace("-", "_"), to!ubyte(attr["id"]), to!float(attr["temperature"]));
			}
		}
	}

	if(!args.length || args.canFind("d")) d.d(attributes, protocols, metadata, creative, blocks, items, entities, enchantments, effects);
	if(!args.length || args.canFind("java")) java.java(attributes, protocols, metadata, creative, blocks, items, entities, enchantments, effects);
	if(!args.length || args.canFind("js")) js.js(attributes, protocols, metadata, creative, blocks, items, entities);

	src.src(args, attributes, protocols, metadata, creative, blocks, items, entities, enchantments, effects, biomes);

	//if(!args.length || args.canFind("diff")) diff.diff(attributes, protocols, metadata);
	if(!args.length || args.canFind("docs")) docs.docs(attributes, protocols, metadata);

	// minify json
	if(!args.length || args.canFind("json")) {
		foreach(string file ; dirEntries("../src/json", SpanMode.breadth)) {
			if(file.isFile && !file.endsWith(".min.json")) {
				// ` +(?=[^"]*(?:"[^"]*"[^"]*)*$)` // <-- this causes an infinite loop in the program
				bool inString = false;
				string min = "";
				foreach(char c ; (cast(string)read(file)).replaceAll(ctRegex!`"__[a-z0-9_]*": ["]{0,1}[a-zA-Z0-9 :\/\-.]*["]{0,1}\,|\t|\n`, "")) {
					if(c == '"') {
						// there are no escaped characters
						inString ^= true;
					}
					if(c != ' ' || inString) {
						min ~= c;
					}
				}
				_write(file[0..$-4] ~ "min.json", min);
			}
		}
	}

}

@property string name(string ext)(string file) {
	return file[file.lastIndexOf(dirSeparator)+1..$-ext.length-1];
}

@property string text(Element element) {
	auto ret = split(strip((){
		if(element.texts.length) {
			return element.texts[0].to!string;
		} else {
			try {
				return element.text;
			} catch(DecodeException) {
				return "";
			}
		}
	}()), "\n");
	foreach(ref str ; ret) str = decode(str.replaceAll(ctRegex!"[\r\t]", ""));
	return ret.join("\n");
}

@property string toCamelCase(string str) {
	string ret = "";
	bool next_up = false;
	foreach(c ; str.dup) {
		if(c == '_' || c == '-') {
			next_up = true;
		} else if(next_up) {
			ret ~= toUpper(c);
			next_up = false;
		} else {
			ret ~= c;
		}
	}
	return ret;
}

@property string toPascalCase(string str) {
	string camel = toCamelCase(str);
	return camel.length > 0 ? toUpper(camel[0..1]) ~ camel[1..$] : "";
}

@property string toSnakeCase(string str) {
	string snaked;
	foreach(c ; str.dup) {
		if(c >= 'A' && c <= 'Z') snaked ~= '_';
		snaked ~= c;
	}
	return snaked.toLower;
}

string hash(string name) {
	string ret;
	foreach(i, c; Base64URL.encode(cast(ubyte[])name).toLower.replaceAll(ctRegex!`[_\-=]`, "")) {
		if((i & 1) == 0) ret ~= c;
	}
	while("0123456789".canFind(ret[0])) ret = ret[1..$];
	return ret.toLower[0..min($, 8)];
}

string constOf(string value) {
	if(value == "true" || value == "false") return value;
	try {
		to!real(value);
		return value;
	} catch(Exception) {
		return JSONValue(value).toString();
	}
}

void write(string file, string data, string from="", string open="/*", string line=" * ", string close=" */") {
	_write(file, createHeader(from, open, line, close) ~ data);
}

string createHeader(string from, string open, string line, string close) {
	return open ~ "\n" ~
		line ~ "This file was automatically generated by sel-utils and\n" ~
		line ~ "released under the MIT License.\n" ~
		line ~ "\n" ~
		line ~ "License: https://github.com/sel-project/sel-utils/blob/master/LICENSE\n" ~
		line ~ "Repository: https://github.com/sel-project/sel-utils\n" ~
		(from.length ? line ~ "Generated from https://github.com/sel-project/sel-utils/blob/master/xml/" ~ from ~ ".xml\n" : "") ~
		close ~ "\n";
}
