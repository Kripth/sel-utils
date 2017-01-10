/*
 * Copyright (c) 2016-2017 SEL
 * 
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Lesser General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 * 
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.
 * See the GNU Lesser General Public License for more details.
 * 
 */
module json;

import std.conv : to;
import std.file : mkdirRecurse, _write = write;
import std.json;

import all;

void json(Attributes[string] attributes, Protocols[string] protocols, Creative[string] creative) {

	// attributes
	mkdirRecurse("../json/attributes");
	foreach(string game, Attributes attrs; attributes) {
		string data = "{\n\n\t\"__software\": " ~ JSONValue(attrs.software).toString() ~ ",\n\t\"__protocol\": " ~ attrs.protocol.to!string ~ ",\n\t\"__website\": \"https://github.com/sel-project/sel-utils\",\n\n\t\"attributes\": {\n\n";
		foreach(i, attr; attrs.data) {
			data ~= "\t\t\"" ~ toSnakeCase(attr.id) ~ "\": {\n\n";
			data ~= "\t\t\t\"name\": \"" ~ attr.name ~ "\",\n";
			data ~= "\t\t\t\"min\": " ~ attr.min.to!string ~ ",\n";
			data ~= "\t\t\t\"max\": " ~ attr.max.to!string ~ ",\n";
			data ~= "\t\t\t\"default\": " ~ attr.def.to!string ~ "\n";
			data ~= "\n\t\t}";
			if(i != attrs.data.length - 1) data ~= ",";
			data ~= "\n\n";
		}
		data ~= "\t}\n\n}\n";
		_write("../json/attributes/" ~ game ~ ".json", data);
	}

	// creative items
	mkdirRecurse("../json/creative");
	foreach(string game, Creative c; creative) {
		string data = "{\n\n\t\"__software\": " ~ JSONValue(c.software).toString() ~ ",\n\t\"__protocol\": " ~ c.protocol.to!string ~ ",\n\t\"__website\": \"https://github.com/sel-project/sel-utils\",\n\n\t\"items\": [\n\n";
		foreach(i, item; c.data) {
			data ~= "\t\t{\n";
			data ~= "\t\t\t\"name\": " ~ JSONValue(item.name).toString() ~ ",\n";
			data ~= "\t\t\t\"id\": " ~ to!string(item.id);
			if(item.meta != 0) data ~= ",\n\t\t\t\"meta\": " ~ to!string(item.meta);
			if(item.enchantments.length) {
				data ~= ",\n\t\t\t\"enchantments\": [\n";
				foreach(j, enchantment; item.enchantments) {
					data ~= "\t\t\t\t{\n";
					data ~= "\t\t\t\t\t\"id\": " ~ to!string(enchantment.id) ~ ",\n";
					data ~= "\t\t\t\t\t\"level\": " ~ to!string(enchantment.level) ~ "\n";
					data ~= "\t\t\t\t}";
					if(j < item.enchantments.length - 1) data ~= ",";
					data ~= "\n";
				}
				data ~= "\t\t\t]";
			}
			data ~= "\n\t\t}";
			if(i != c.data.length - 1) data ~= ",\n";
			else data ~= "\n\n";
		}
		data ~= "\t]\n\n}\n";
		_write("../json/creative/" ~ game ~ ".json", data);
	}

	// protocol
	mkdirRecurse("../json/protocol");
	foreach(string game, Protocols p; protocols) {
		string data = "{\n\n\t\"__software\": " ~ JSONValue(p.software).toString() ~ ",\n\t\"__protocol\": " ~ p.protocol.to!string ~ ",\n\t\"__website\": \"https://github.com/sel-project/sel-utils\",\n\n";
		void writeFields(string space, Field[] fields) {
			foreach(i, field; fields) {
				data ~= space ~ "{\n";
				data ~= space ~ "\t\"name\": " ~ JSONValue(field.name).toString() ~ ",\n";
				data ~= space ~ "\t\"type\": " ~ JSONValue(field.type).toString() ~ (field.condition.length || field.endianness.length ? "," : "") ~ "\n";
				if(field.condition.length) data ~= space ~ "\t\"when\": " ~ JSONValue(field.condition).toString() ~ (field.endianness.length ? "," : "") ~ "\n";
				if(field.endianness.length) data ~= space ~ "\t\"endianness\": \"" ~ field.endianness ~ "\"\n";
				data ~= space ~ "}" ~ (i != fields.length - 1 ? "," : "") ~ "\n";
			}
		}
		// encoding
		data ~= "\t\"encoding\": {\n\n";
		if(p.data.endianness.length) {
			data ~= "\t\t\"endianness\": {\n";
			foreach(string e, string value; p.data.endianness) {
				data ~= "\t\t\t\"" ~ e ~ "\": \"" ~ value ~ "\",\n";
			}
			data = data[0..$-2] ~ "\n"; // remove last comma
			data ~= "\t\t},\n\n";
		}
		data ~= "\t\t\"id\": \"" ~ p.data.id ~ "\",\n\n";
		data ~= "\t\t\"array_length\": \"" ~ p.data.arrayLength ~ "\"" ~ (p.data.types.length || p.data.types.length ? "," : "") ~ "\n\n";
		if(p.data.types.length) {
			data ~= "\t\t\"types\": {\n\n";
			foreach(i, type; p.data.types) {
				data ~= "\t\t\t\"" ~ type.name ~ "\": [\n";
				writeFields("\t\t\t\t", type.fields);
				data ~= "\t\t\t]" ~ (i != p.data.types.length - 1 ? "," : "") ~ "\n\n";
			}
			data ~= "\t\t}" ~ (p.data.arrays.length ? "," : "") ~ "\n\n";
		}
		if(p.data.arrays.length) {
			data ~= "\t\t\"arrays\": {\n\n";
			foreach(string name, array; p.data.arrays) {
				data ~= "\t\t\t\"" ~ name ~ "\": {\n";
				data ~= "\t\t\t\t\"base\": " ~ JSONValue(array.base).toString() ~ ",\n";
				data ~= "\t\t\t\t\"length\": " ~ JSONValue(array.length).toString() ~ (array.endianness.length ? "," : "") ~ "\n";
				if(array.endianness.length) data ~= "\t\t\t\t\"endianness\": \"" ~ array.endianness ~ "\"\n";
				data ~= "\t\t\t},\n\n";
			}
			data = data[0..$-3] ~ "\n\n";
			data ~= "\t\t}\n\n";
		}
		data ~= "\t},\n\n";
		// packets
		data ~= "\t\"packets\": {\n\n";
		foreach(i, section; p.data.sections) {
			data ~= "\t\t" ~ JSONValue(section.name).toString() ~ ": {\n\n";
			foreach(j, packet; section.packets) {
				data ~= "\t\t\t" ~ JSONValue(packet.name).toString() ~ ": {\n";
				data ~= "\t\t\t\t\"id\": " ~ to!string(packet.id) ~ ",\n";
				data ~= "\t\t\t\t\"clientbound\": " ~ to!string(packet.clientbound) ~ ",\n";
				data ~= "\t\t\t\t\"serverbound\": " ~ to!string(packet.serverbound) ~ ",\n";
				if(packet.fields.length) {
					data ~= "\t\t\t\t\"fields\": [\n";
					writeFields("\t\t\t\t\t", packet.fields);
					data ~= "\t\t\t\t]\n";
				} else {
					data ~= "\t\t\t\t\"fields\": []\n";
				}
				if(packet.variantField.length) {
					data = data[0..$-1] ~ ",\n";
					data ~= "\t\t\t\t\"variants\": {\n";
					data ~= "\t\t\t\t\t\"field\": " ~ JSONValue(packet.variantField).toString() ~ ",\n";
					data ~= "\t\t\t\t\t\"values\": {\n";
					foreach(k, variant; packet.variants) {
						data ~= "\t\t\t\t\t\t" ~ JSONValue(variant.name).toString() ~ ": {\n";
						data ~= "\t\t\t\t\t\t\t\"value\": " ~ variant.value ~ ",\n";
						if(variant.fields.length) {
							data ~= "\t\t\t\t\t\t\t\"fields\": [\n";
							writeFields("\t\t\t\t\t\t\t\t", variant.fields);
							data ~= "\t\t\t\t\t\t\t]\n";
						} else {
							data ~= "\t\t\t\t\t\t\t\"fields\": []\n";
						}
						data ~= "\t\t\t\t\t\t}" ~ (k != packet.variants.length - 1 ? "," : "") ~ "\n";
					}
					data ~= "\t\t\t\t\t}\n";
					data ~= "\t\t\t\t}\n";
				}
				data ~= "\t\t\t}" ~ (j != section.packets.length - 1 ? "," : "") ~ "\n\n";
			}
			data ~= "\t\t}" ~ (i != p.data.sections.length - 1 ? "," : "") ~ "\n\n";
		}
		data ~= "\t}\n\n";
		data ~= "}\n";
		_write("../json/protocol/" ~ game ~ ".json", data);
	}

}
