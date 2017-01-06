module js;

import std.ascii : newline;
import std.conv : to;
import std.file : mkdir, mkdirRecurse, exists;
import std.json;
import std.path : dirSeparator;
import std.string;

import all;

void js(Attributes[string] attributes, JSONValue[string] jsons) {
	
	mkdirRecurse("../src/js/sul");
	
	// attributes
	foreach(string game, Attributes attrs; attributes) {
		string data = "const Attributes = {\n\n";
		foreach(attr ; attrs.data) {
			//TODO convert to snake case
			data ~= "\t" ~ toUpper(toSnakeCase(attr.id)) ~ ": {\"name\": \"" ~ attr.name ~ "\", \"min\": " ~ attr.min.to!string ~ ", \"max\": " ~ attr.max.to!string ~ ", \"default\": " ~ attr.def.to!string ~ "},\n\n";
		}
		if(!exists("../src/js/sul/attributes")) mkdir("../src/js/sul/attributes");
		write("../src/js/sul/attributes/" ~ game ~ ".js", data ~ "}", "attributes/" ~ game);
	}
	
}