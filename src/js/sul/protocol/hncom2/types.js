/*
 * This file was automatically generated by sel-utils and
 * released under the GNU General Public License version 3.
 * 
 * License: https://github.com/sel-project/sel-utils/blob/master/LICENSE
 * Repository: https://github.com/sel-project/sel-utils
 * Generated from https://github.com/sel-project/sel-utils/blob/master/xml/protocol/hncom2.xml
 */
/** @module sul/protocol/hncom2/types */

const Types = {

	Address: class extends Buffer {

		/**
		 * @param bytes
		 *        Bytes of the address. The length may be 4 (for ipv4 addresses) or 16 (for ipv6 addresses). The byte
		 *        order is always big-endian (network order).
		 * @param port
		 *        Port of the address.
		 */
		constructor(bytes=[], port=0) {
			super();
			this.bytes = bytes;
			this.port = port;
		}

		/** @return {Uint8Array} */
		encode() {
			this._buffer = [];
			this.writeVaruint(this.bytes.length); this.writeBytes(this.bytes);
			this.writeBigEndianShort(this.port);
			return new Uint8Array(this._buffer);
		}

		/** @param {(Uint8Array|Array)} buffer */
		decode(_buffer) {
			this._buffer = Array.from(_buffer);
			var aramylzm=this.readVaruint(); this.bytes=this.readBytes(aramylzm);
			this.port=this.readBigEndianShort();
			return this;
		}

		/** @param {(Uint8Array|Array)} buffer */
		static fromBuffer(buffer) {
			return new Types.Address().decode(buffer);
		}

		/** @return {string} */
		toString() {
			return "Address(bytes: " + this.bytes + ", port: " + this.port + ")";
		}

	},

	Game: class extends Buffer {

		// type
		static get POCKET(){ return 1; }
		static get MINECRAFT(){ return 2; }
		static get CONSOLE(){ return 3; }

		/**
		 * @param type
		 *        Identifier of the game.
		 * @param protocols
		 *        Protocols accepted by the server for the game. They should be ordered from oldest to newest.
		 */
		constructor(type=0, protocols=[]) {
			super();
			this.type = type;
			this.protocols = protocols;
		}

		/** @return {Uint8Array} */
		encode() {
			this._buffer = [];
			this.writeBigEndianByte(this.type);
			this.writeVaruint(this.protocols.length); for(var dhc5c9bn in this.protocols){ this.writeVaruint(this.protocols[dhc5c9bn]); }
			return new Uint8Array(this._buffer);
		}

		/** @param {(Uint8Array|Array)} buffer */
		decode(_buffer) {
			this._buffer = Array.from(_buffer);
			this.type=this.readBigEndianByte();
			var aramcjd9=this.readVaruint(); this.protocols=[]; for(var dhc5c9bn=0;dhc5c9bn<aramcjd9;dhc5c9bn++){ this.protocols[dhc5c9bn]=this.readVaruint(); }
			return this;
		}

		/** @param {(Uint8Array|Array)} buffer */
		static fromBuffer(buffer) {
			return new Types.Game().decode(buffer);
		}

		/** @return {string} */
		toString() {
			return "Game(type: " + this.type + ", protocols: " + this.protocols + ")";
		}

	},

	GameInfo: class extends Buffer {

		/**
		 * @param game
		 *        Informations about the the game and the protocols used.
		 * @param motd
		 *        "Message of the day" which is displayed in the game's server list. It may contain Minecraft formatting
		 *        codes.
		 * @param port
		 *        Port, or main port if the server allows the connection from multiple ports, where the socket is listening
		 *        for connections.
		 */
		constructor(game=null, motd="", port=0) {
			super();
			this.game = game;
			this.motd = motd;
			this.port = port;
		}

		/** @return {Uint8Array} */
		encode() {
			this._buffer = [];
			this.writeBytes(this.game.encode());
			var dhc5br=this.encodeString(this.motd); this.writeVaruint(dhc5br.length); this.writeBytes(dhc5br);
			this.writeBigEndianShort(this.port);
			return new Uint8Array(this._buffer);
		}

		/** @param {(Uint8Array|Array)} buffer */
		decode(_buffer) {
			this._buffer = Array.from(_buffer);
			this.game=Types.Game.fromBuffer(this._buffer); this._buffer=this.game._buffer;
			this.motd=this.decodeString(this.readBytes(this.readVaruint()));
			this.port=this.readBigEndianShort();
			return this;
		}

		/** @param {(Uint8Array|Array)} buffer */
		static fromBuffer(buffer) {
			return new Types.GameInfo().decode(buffer);
		}

		/** @return {string} */
		toString() {
			return "GameInfo(game: " + this.game + ", motd: " + this.motd + ", port: " + this.port + ")";
		}

	},

	Plugin: class extends Buffer {

		/**
		 * @param name
		 *        Name of the plugin.
		 * @param version
		 *        Version of the plugin, usually in the format `major.minor[.release] [alpha|beta]`.
		 */
		constructor(name="", version="") {
			super();
			this.name = name;
			this.version = version;
		}

		/** @return {Uint8Array} */
		encode() {
			this._buffer = [];
			var dhc5y1=this.encodeString(this.name); this.writeVaruint(dhc5y1.length); this.writeBytes(dhc5y1);
			var dhc5zja9=this.encodeString(this.version); this.writeVaruint(dhc5zja9.length); this.writeBytes(dhc5zja9);
			return new Uint8Array(this._buffer);
		}

		/** @param {(Uint8Array|Array)} buffer */
		decode(_buffer) {
			this._buffer = Array.from(_buffer);
			this.name=this.decodeString(this.readBytes(this.readVaruint()));
			this.version=this.decodeString(this.readBytes(this.readVaruint()));
			return this;
		}

		/** @param {(Uint8Array|Array)} buffer */
		static fromBuffer(buffer) {
			return new Types.Plugin().decode(buffer);
		}

		/** @return {string} */
		toString() {
			return "Plugin(name: " + this.name + ", version: " + this.version + ")";
		}

	},

	Motd: class extends Buffer {

		// type
		static get POCKET(){ return 1; }
		static get MINECRAFT(){ return 2; }
		static get CONSOLE(){ return 3; }

		constructor(type=0, motd="") {
			super();
			this.type = type;
			this.motd = motd;
		}

		/** @return {Uint8Array} */
		encode() {
			this._buffer = [];
			this.writeBigEndianByte(this.type);
			var dhc5br=this.encodeString(this.motd); this.writeVaruint(dhc5br.length); this.writeBytes(dhc5br);
			return new Uint8Array(this._buffer);
		}

		/** @param {(Uint8Array|Array)} buffer */
		decode(_buffer) {
			this._buffer = Array.from(_buffer);
			this.type=this.readBigEndianByte();
			this.motd=this.decodeString(this.readBytes(this.readVaruint()));
			return this;
		}

		/** @param {(Uint8Array|Array)} buffer */
		static fromBuffer(buffer) {
			return new Types.Motd().decode(buffer);
		}

		/** @return {string} */
		toString() {
			return "Motd(type: " + this.type + ", motd: " + this.motd + ")";
		}

	},

	Skin: class extends Buffer {

		/**
		 * @param name
		 *        Name of the skin.
		 * @param data
		 *        RGBA map of the skin colours. Length should be, if the skin is not empty, 8192 (64x32) or 16384 (64x64)
		 *        bytes.
		 */
		constructor(name="", data=[]) {
			super();
			this.name = name;
			this.data = data;
		}

		/** @return {Uint8Array} */
		encode() {
			this._buffer = [];
			var dhc5y1=this.encodeString(this.name); this.writeVaruint(dhc5y1.length); this.writeBytes(dhc5y1);
			this.writeVaruint(this.data.length); this.writeBytes(this.data);
			return new Uint8Array(this._buffer);
		}

		/** @param {(Uint8Array|Array)} buffer */
		decode(_buffer) {
			this._buffer = Array.from(_buffer);
			this.name=this.decodeString(this.readBytes(this.readVaruint()));
			var aramzfy=this.readVaruint(); this.data=this.readBytes(aramzfy);
			return this;
		}

		/** @param {(Uint8Array|Array)} buffer */
		static fromBuffer(buffer) {
			return new Types.Skin().decode(buffer);
		}

		/** @return {string} */
		toString() {
			return "Skin(name: " + this.name + ", data: " + this.data + ")";
		}

	}

}

//export { Types }
