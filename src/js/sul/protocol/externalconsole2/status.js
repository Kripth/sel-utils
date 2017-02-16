/*
 * This file was automatically generated by sel-utils and
 * released under the GNU General Public License version 3.
 * 
 * License: https://github.com/sel-project/sel-utils/blob/master/LICENSE
 * Repository: https://github.com/sel-project/sel-utils
 * Generated from https://github.com/sel-project/sel-utils/blob/master/xml/protocol/externalconsole2.xml
 */
/** @module sul/protocol/externalconsole2/status */

//import Types from 'types';

/**
 * Packets about the informations and the usage of the server.
 */
const Status = {

	/**
	 * Keeps the connection alive and/or calculates the latency. This packet should be
	 * sent at least every 5 seconds to avoid the disconnection caused by timeout and update
	 * the latency. The external console can send this packet whenever it wants it and
	 * the server must reply with the same packet with the same field's value.
	 */
	KeepAlive: class extends Buffer {

		static get ID(){ return 0; }

		static get CLIENTBOUND(){ return true; }
		static get SERVERBOUND(){ return true; }

		/**
		 * @param count
		 *        An identifier chosen by the external console to uniquely identify the packet.
		 */
		constructor(count=0) {
			super();
			this.count = count;
		}

		/** @return {Uint8Array} */
		encode() {
			this._buffer = [];
			this.writeBigEndianByte(0);
			this.writeBigEndianInt(this.count);
			return new Uint8Array(this._buffer);
		}

		/** @param {(Uint8Array|Array)} buffer */
		decode(_buffer) {
			this._buffer = Array.from(_buffer);
			var _id=this.readBigEndianByte();
			this.count=this.readBigEndianInt();
			return this;
		}

		/** @param {(Uint8Array|Array)} buffer */
		static fromBuffer(buffer) {
			return new Status.KeepAlive().decode(buffer);
		}

		/** @return {string} */
		toString() {
			return "KeepAlive(count: " + this.count + ")";
		}

	},

	/**
	 * Updates the list of the nodes connected to the hub, adding or removing one.
	 * If the server isn't built on the hub-node layout this packet is never sent.
	 */
	UpdateNodes: class extends Buffer {

		static get ID(){ return 1; }

		static get CLIENTBOUND(){ return true; }
		static get SERVERBOUND(){ return false; }

		// action
		static get ADD(){ return 0; }
		static get REMOVE(){ return 1; }

		/**
		 * @param action
		 *        Whether the node should be added or removed from the list of connected nodes.
		 * @param node
		 *        Name of the node.
		 */
		constructor(action=0, node="") {
			super();
			this.action = action;
			this.node = node;
		}

		/** @return {Uint8Array} */
		encode() {
			this._buffer = [];
			this.writeBigEndianByte(1);
			this.writeBigEndianByte(this.action);
			var dhc5br=this.encodeString(this.node); this.writeBigEndianShort(dhc5br.length); this.writeBytes(dhc5br);
			return new Uint8Array(this._buffer);
		}

		/** @param {(Uint8Array|Array)} buffer */
		decode(_buffer) {
			this._buffer = Array.from(_buffer);
			var _id=this.readBigEndianByte();
			this.action=this.readBigEndianByte();
			this.node=this.decodeString(this.readBytes(this.readBigEndianShort()));
			return this;
		}

		/** @param {(Uint8Array|Array)} buffer */
		static fromBuffer(buffer) {
			return new Status.UpdateNodes().decode(buffer);
		}

		/** @return {string} */
		toString() {
			return "UpdateNodes(action: " + this.action + ", node: " + this.node + ")";
		}

	},

	/**
	 * Requests an UpdateStats packet to the server, which should sent it immediately instead
	 * of waiting for the next automatic update (if the server does one).
	 */
	RequestStats: class extends Buffer {

		static get ID(){ return 2; }

		static get CLIENTBOUND(){ return false; }
		static get SERVERBOUND(){ return true; }

		constructor() {
			super();
		}

		/** @return {Uint8Array} */
		encode() {
			this._buffer = [];
			this.writeBigEndianByte(2);
			return new Uint8Array(this._buffer);
		}

		/** @param {(Uint8Array|Array)} buffer */
		decode(_buffer) {
			this._buffer = Array.from(_buffer);
			var _id=this.readBigEndianByte();
			return this;
		}

		/** @param {(Uint8Array|Array)} buffer */
		static fromBuffer(buffer) {
			return new Status.RequestStats().decode(buffer);
		}

		/** @return {string} */
		toString() {
			return "RequestStats()";
		}

	},

	/**
	 * Updates the statistics about the usage of the server and, eventually, the connected
	 * nodes.
	 * This packet is sent in response to RequestStats and every time the server retains
	 * that the stats should be updated (usually in a range of 5 to 30 seconds).
	 */
	UpdateStats: class extends Buffer {

		static get ID(){ return 3; }

		static get CLIENTBOUND(){ return true; }
		static get SERVERBOUND(){ return false; }

		/**
		 * @param onlinePlayers
		 *        Number of players currently online on the server. Players that are performing authentication
		 *        are not included in the count.
		 * @param maxPlayers
		 *        Highest number of players that can join the server simultaneously. If 0, there is not maximum number
		 *        of players.
		 * @param uptime
		 *        Milliseconds since the server has started.
		 * @param upload
		 *        Average amount of bytes sent every second.
		 * @param download
		 *        Average amount of bytes sent every second.
		 * @param nodes
		 *        Resources usage of the connected nodes, if the server uses the hub-node layout, or an empty list.
		 */
		constructor(onlinePlayers=0, maxPlayers=0, uptime=0, upload=0, download=0, nodes=[]) {
			super();
			this.onlinePlayers = onlinePlayers;
			this.maxPlayers = maxPlayers;
			this.uptime = uptime;
			this.upload = upload;
			this.download = download;
			this.nodes = nodes;
		}

		/** @return {Uint8Array} */
		encode() {
			this._buffer = [];
			this.writeBigEndianByte(3);
			this.writeBigEndianInt(this.onlinePlayers);
			this.writeBigEndianInt(this.maxPlayers);
			this.writeBigEndianInt(this.uptime);
			this.writeBigEndianInt(this.upload);
			this.writeBigEndianInt(this.download);
			this.writeBigEndianShort(this.nodes.length); for(var dhc5brc in this.nodes){ this.writeBytes(this.nodes[dhc5brc].encode()); }
			return new Uint8Array(this._buffer);
		}

		/** @param {(Uint8Array|Array)} buffer */
		decode(_buffer) {
			this._buffer = Array.from(_buffer);
			var _id=this.readBigEndianByte();
			this.onlinePlayers=this.readBigEndianInt();
			this.maxPlayers=this.readBigEndianInt();
			this.uptime=this.readBigEndianInt();
			this.upload=this.readBigEndianInt();
			this.download=this.readBigEndianInt();
			var aramb9zm=this.readBigEndianShort(); this.nodes=[]; for(var dhc5brc=0;dhc5brc<aramb9zm;dhc5brc++){ this.nodes[dhc5brc]=Types.NodeStats.fromBuffer(this._buffer); this._buffer=this.nodes[dhc5brc]._buffer; }
			return this;
		}

		/** @param {(Uint8Array|Array)} buffer */
		static fromBuffer(buffer) {
			return new Status.UpdateStats().decode(buffer);
		}

		/** @return {string} */
		toString() {
			return "UpdateStats(onlinePlayers: " + this.onlinePlayers + ", maxPlayers: " + this.maxPlayers + ", uptime: " + this.uptime + ", upload: " + this.upload + ", download: " + this.download + ", nodes: " + this.nodes + ")";
		}

	},

}

//export { Status };
