/*
 * This file was automatically generated by sel-utils and
 * released under the GNU General Public License version 3.
 * 
 * License: https://github.com/sel-project/sel-utils/blob/master/LICENSE
 * Repository: https://github.com/sel-project/sel-utils
 * Generated from https://github.com/sel-project/sel-utils/blob/master/xml/protocol/externalconsole2.xml
 */
/**
 * Packets used during the authentication process and to exhange the initial server's
 * informations.
 */
module sul.protocol.externalconsole2.login;

import std.bitmanip : write, peek;
static import std.conv;
import std.system : Endian;
import std.typetuple : TypeTuple;
import std.typecons : Tuple;
import std.uuid : UUID;

import sul.utils.buffer;
import sul.utils.var;

static import sul.protocol.externalconsole2.types;

alias Packets = TypeTuple!(AuthCredentials, Auth, Welcome);

/**
 * First packet sent by the server when the connection is successfully established.
 * It contains informations about how the external console shall authenticate itself.
 */
class AuthCredentials : Buffer {

	public enum ubyte ID = 0;

	public enum bool CLIENTBOUND = true;
	public enum bool SERVERBOUND = false;

	public enum string[] FIELDS = ["protocol", "hash", "hashAlgorithm", "payload"];

	/**
	 * Protocol used by the server. If the client uses a different one it should close
	 * the connection without trying to perform authentication.
	 */
	public ubyte protocol;

	/**
	 * Whether to perform hashing on the password or not.
	 */
	public bool hash;

	/**
	 * Algorithm used by the server to hash the concatenation of the password and the payload.
	 * The value should be sent in lower case without any separation symbol (for example
	 * `md5` instead of `MD5`, `sha256` instead of `SHA-256`).
	 * See Auth.hash for more details.
	 */
	public string hashAlgorithm;

	/**
	 * Payload to cancatenate to the password before hashing it, as described in the Auth.hash's
	 * field description.
	 */
	public ubyte[] payload;

	public pure nothrow @safe @nogc this() {}

	public pure nothrow @safe @nogc this(ubyte protocol, bool hash=bool.init, string hashAlgorithm=string.init, ubyte[] payload=(ubyte[]).init) {
		this.protocol = protocol;
		this.hash = hash;
		this.hashAlgorithm = hashAlgorithm;
		this.payload = payload;
	}

	public pure nothrow @safe ubyte[] encode(bool writeId=true)() {
		_buffer.length = 0;
		static if(writeId){ writeBigEndianUbyte(ID); }
		writeBigEndianUbyte(protocol);
		writeBigEndianBool(hash);
		if(hash==true){ writeBigEndianUshort(cast(ushort)hashAlgorithm.length); writeString(hashAlgorithm); }
		if(hash==true){ writeBigEndianUshort(cast(ushort)payload.length); writeBytes(payload); }
		return _buffer;
	}

	public pure nothrow @safe void decode(bool readId=true)() {
		static if(readId){ ubyte _id; _id=readBigEndianUbyte(); }
		protocol=readBigEndianUbyte();
		hash=readBigEndianBool();
		if(hash==true){ ushort afafz9ar=readBigEndianUshort(); hashAlgorithm=readString(afafz9ar); }
		if(hash==true){ payload.length=readBigEndianUshort(); if(_buffer.length>=_index+payload.length){ payload=_buffer[_index.._index+payload.length].dup; _index+=payload.length; } }
	}

	public static pure nothrow @safe AuthCredentials fromBuffer(bool readId=true)(ubyte[] buffer) {
		AuthCredentials ret = new AuthCredentials();
		ret._buffer = buffer;
		ret.decode!readId();
		return ret;
	}

	public override string toString() {
		return "AuthCredentials(protocol: " ~ std.conv.to!string(this.protocol) ~ ", hash: " ~ std.conv.to!string(this.hash) ~ ", hashAlgorithm: " ~ std.conv.to!string(this.hashAlgorithm) ~ ", payload: " ~ std.conv.to!string(this.payload) ~ ")";
	}

}

/**
 * Performs authentication following the instruncions given by the AuthCredentials
 * packet.
 */
class Auth : Buffer {

	public enum ubyte ID = 1;

	public enum bool CLIENTBOUND = false;
	public enum bool SERVERBOUND = true;

	public enum string[] FIELDS = ["hash"];

	/**
	 * Pasword encoded as UTF-8 if AuthCredentials.hash is `false` or the hash (specified
	 * in AuthCredentials.hashAlgorithm) of the password encoded as UTF-8 concatenated
	 * with the bytes from AuthCredentials.payload if `true`.
	 * The hash can be done with a function (if hashAlgorithm is `sha1`) in D:
	 * ---
	 * sha1Of(cast(ubyte[])password ~ authCredentials.payload);
	 * ---
	 * Or using `MessageDigest` in Java:
	 * ---
	 * MessageDigest md = MessageDigest.getInstance(authCredentials.hashAlgorithm);
	 * md.update(password.getBytes(StandardCharsets.UTF_8));
	 * md.update(authCredentials.payload);
	 * byte[] hash = md.digest();
	 * ---
	 */
	public ubyte[] hash;

	public pure nothrow @safe @nogc this() {}

	public pure nothrow @safe @nogc this(ubyte[] hash) {
		this.hash = hash;
	}

	public pure nothrow @safe ubyte[] encode(bool writeId=true)() {
		_buffer.length = 0;
		static if(writeId){ writeBigEndianUbyte(ID); }
		writeBigEndianUshort(cast(ushort)hash.length); writeBytes(hash);
		return _buffer;
	}

	public pure nothrow @safe void decode(bool readId=true)() {
		static if(readId){ ubyte _id; _id=readBigEndianUbyte(); }
		hash.length=readBigEndianUshort(); if(_buffer.length>=_index+hash.length){ hash=_buffer[_index.._index+hash.length].dup; _index+=hash.length; }
	}

	public static pure nothrow @safe Auth fromBuffer(bool readId=true)(ubyte[] buffer) {
		Auth ret = new Auth();
		ret._buffer = buffer;
		ret.decode!readId();
		return ret;
	}

	public override string toString() {
		return "Auth(hash: " ~ std.conv.to!string(this.hash) ~ ")";
	}

}

/**
 * Indicates the status of the authentication process.
 */
class Welcome : Buffer {

	public enum ubyte ID = 2;

	public enum bool CLIENTBOUND = true;
	public enum bool SERVERBOUND = false;

	public enum string[] FIELDS = ["status"];

	public ubyte status;

	public pure nothrow @safe @nogc this() {}

	public pure nothrow @safe @nogc this(ubyte status) {
		this.status = status;
	}

	public pure nothrow @safe ubyte[] encode(bool writeId=true)() {
		_buffer.length = 0;
		static if(writeId){ writeBigEndianUbyte(ID); }
		writeBigEndianUbyte(status);
		return _buffer;
	}

	public pure nothrow @safe void decode(bool readId=true)() {
		static if(readId){ ubyte _id; _id=readBigEndianUbyte(); }
		status=readBigEndianUbyte();
	}

	public static pure nothrow @safe Welcome fromBuffer(bool readId=true)(ubyte[] buffer) {
		Welcome ret = new Welcome();
		ret._buffer = buffer;
		ret.decode!readId();
		return ret;
	}

	public override string toString() {
		return "Welcome(status: " ~ std.conv.to!string(this.status) ~ ")";
	}

	alias _encode = encode;

	enum string variantField = "status";

	alias Variants = TypeTuple!(Accepted, WrongHash, TimedOut);

	/**
	 * Sent when the hash sent in Auth matches the server's.
	 */
	public class Accepted {

		public enum typeof(status) STATUS = 0;

		public enum string[] FIELDS = ["remoteCommands", "software", "versions", "displayName", "games", "connectedNodes"];

		/**
		 * Indicates whether the external console can execute command remotely through the
		 * Command packet.
		 */
		public bool remoteCommands;

		/**
		 * The server's software as a formatted string (without the version).
		 */
		public string software;

		/**
		 * Versions of the server in a 3-btyes array readed as `[major, minor, release]`.
		 */
		public ubyte[3] versions;

		/**
		 * Name of the server (not the game's MOTD!). It shouldn't contain Minecraft formatting
		 * codes.
		 */
		public string displayName;

		/**
		 * Informations about the games and their protocols supported by the server.
		 */
		public sul.protocol.externalconsole2.types.Game[] games;

		/**
		 * List of names of the nodes connected to the server, if it uses the hub-node layout,
		 * or an empty list.
		 */
		public string[] connectedNodes;

		public pure nothrow @safe @nogc this() {}

		public pure nothrow @safe @nogc this(bool remoteCommands, string software=string.init, ubyte[3] versions=(ubyte[3]).init, string displayName=string.init, sul.protocol.externalconsole2.types.Game[] games=(sul.protocol.externalconsole2.types.Game[]).init, string[] connectedNodes=(string[]).init) {
			this.remoteCommands = remoteCommands;
			this.software = software;
			this.versions = versions;
			this.displayName = displayName;
			this.games = games;
			this.connectedNodes = connectedNodes;
		}

		public pure nothrow @safe ubyte[] encode(bool writeId=true)() {
			status = 0;
			_encode!writeId();
			writeBigEndianBool(remoteCommands);
			writeBigEndianUshort(cast(ushort)software.length); writeString(software);
			writeBytes(versions);
			writeBigEndianUshort(cast(ushort)displayName.length); writeString(displayName);
			writeBigEndianUshort(cast(ushort)games.length); foreach(zfzm;games){ zfzm.encode(bufferInstance); }
			writeBigEndianUshort(cast(ushort)connectedNodes.length); foreach(y9bvdvt9;connectedNodes){ writeBigEndianUshort(cast(ushort)y9bvdvt9.length); writeString(y9bvdvt9); }
			return _buffer;
		}

		public pure nothrow @safe void decode() {
			remoteCommands=readBigEndianBool();
			ushort c9ddcu=readBigEndianUshort(); software=readString(c9ddcu);
			if(_buffer.length>=_index+versions.length){ versions=_buffer[_index.._index+versions.length].dup; _index+=versions.length; }
			ushort zlcxe5bu=readBigEndianUshort(); displayName=readString(zlcxe5bu);
			games.length=readBigEndianUshort(); foreach(ref zfzm;games){ zfzm.decode(bufferInstance); }
			connectedNodes.length=readBigEndianUshort(); foreach(ref y9bvdvt9;connectedNodes){ ushort eldrdk=readBigEndianUshort(); y9bvdvt9=readString(eldrdk); }
		}

		public override string toString() {
			return "Welcome.Accepted(remoteCommands: " ~ std.conv.to!string(this.remoteCommands) ~ ", software: " ~ std.conv.to!string(this.software) ~ ", versions: " ~ std.conv.to!string(this.versions) ~ ", displayName: " ~ std.conv.to!string(this.displayName) ~ ", games: " ~ std.conv.to!string(this.games) ~ ", connectedNodes: " ~ std.conv.to!string(this.connectedNodes) ~ ")";
		}

	}

	/**
	 * Sent when Auth is received but the given password or hash doesn't match the server's
	 * one.
	 */
	public class WrongHash {

		public enum typeof(status) STATUS = 1;

		public enum string[] FIELDS = [];

		public pure nothrow @safe ubyte[] encode(bool writeId=true)() {
			status = 1;
			_encode!writeId();
			return _buffer;
		}

		public pure nothrow @safe void decode() {
		}

		public override string toString() {
			return "Welcome.WrongHash()";
		}

	}

	/**
	 * Sent when Auth is not received and the server decides to close the connection because
	 * too much time has elapsed since the creation of the socket.
	 */
	public class TimedOut {

		public enum typeof(status) STATUS = 2;

		public enum string[] FIELDS = [];

		public pure nothrow @safe ubyte[] encode(bool writeId=true)() {
			status = 2;
			_encode!writeId();
			return _buffer;
		}

		public pure nothrow @safe void decode() {
		}

		public override string toString() {
			return "Welcome.TimedOut()";
		}

	}

}
