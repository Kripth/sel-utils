/*
 * This file was automatically generated by sel-utils and
 * released under the GNU General Public License version 3.
 * 
 * License: https://github.com/sel-project/sel-utils/blob/master/LICENSE
 * Repository: https://github.com/sel-project/sel-utils
 * Generated from https://github.com/sel-project/sel-utils/blob/master/xml/protocol/hncom1.xml
 */
/** @module sul/protocol/hncom1/status */

//import Types from 'types';

/**
 * Node-related packets and updates.
 */
const Status = {

	/**
	 * Notifies the node that another node (that is not itself) has connected to the hub.
	 */
	AddNode: class extends Buffer {

		static get ID(){ return 5; }

		static get CLIENTBOUND(){ return true; }
		static get SERVERBOUND(){ return false; }

		/**
		 * @param hubId
		 *        Identifier given by the hub to uniquey identify the node.
		 * @param name
		 *        Node's name used for displaying and identification purposes.
		 * @param main
		 *        Whether the node is a main node (see {ConnectionRequest.main}).
		 * @param acceptedGames
		 *        Indicates the game accepted by the node.
		 */
		constructor(hubId=0, name="", main=false, acceptedGames=[]) {
			super();
			this.hubId = hubId;
			this.name = name;
			this.main = main;
			this.acceptedGames = acceptedGames;
		}

		/** @return {Uint8Array} */
		encode() {
			this._buffer = [];
			this.writeBigEndianByte(5);
			this.writeVaruint(this.hubId);
			var dhc5y1=this.encodeString(this.name); this.writeVaruint(dhc5y1.length); this.writeBytes(dhc5y1);
			this.writeBigEndianByte(this.main?1:0);
			this.writeVaruint(this.acceptedGames.length); for(var dhc5yncr in this.acceptedGames){ this.writeBytes(this.acceptedGames[dhc5yncr].encode()); }
			return new Uint8Array(this._buffer);
		}

		/** @param {(Uint8Array|Array)} buffer */
		decode(_buffer) {
			this._buffer = Array.from(_buffer);
			var _id=this.readBigEndianByte();
			this.hubId=this.readVaruint();
			this.name=this.decodeString(this.readBytes(this.readVaruint()));
			this.main=this.readBigEndianByte()!==0;
			var aramynzb=this.readVaruint(); this.acceptedGames=[]; for(var dhc5yncr=0;dhc5yncr<aramynzb;dhc5yncr++){ this.acceptedGames[dhc5yncr]=Types.Game.fromBuffer(this._buffer); this._buffer=this.acceptedGames[dhc5yncr]._buffer; }
			return this;
		}

		/** @param {(Uint8Array|Array)} buffer */
		static fromBuffer(buffer) {
			return new Status.AddNode().decode(buffer);
		}

		/** @return {string} */
		toString() {
			return "AddNode(hubId: " + this.hubId + ", name: " + this.name + ", main: " + this.main + ", acceptedGames: " + this.acceptedGames + ")";
		}

	},

	/**
	 * Notifies the node that another node, previously added with AddNode has disconnected
	 * from the hub.
	 */
	RemoveNode: class extends Buffer {

		static get ID(){ return 6; }

		static get CLIENTBOUND(){ return true; }
		static get SERVERBOUND(){ return false; }

		/**
		 * @param hubId
		 *        Node's id given by the hub.
		 */
		constructor(hubId=0) {
			super();
			this.hubId = hubId;
		}

		/** @return {Uint8Array} */
		encode() {
			this._buffer = [];
			this.writeBigEndianByte(6);
			this.writeVaruint(this.hubId);
			return new Uint8Array(this._buffer);
		}

		/** @param {(Uint8Array|Array)} buffer */
		decode(_buffer) {
			this._buffer = Array.from(_buffer);
			var _id=this.readBigEndianByte();
			this.hubId=this.readVaruint();
			return this;
		}

		/** @param {(Uint8Array|Array)} buffer */
		static fromBuffer(buffer) {
			return new Status.RemoveNode().decode(buffer);
		}

		/** @return {string} */
		toString() {
			return "RemoveNode(hubId: " + this.hubId + ")";
		}

	},

	/**
	 * Sends a binary message to some selected nodes or broadcast it.
	 */
	MessageServerbound: class extends Buffer {

		static get ID(){ return 7; }

		static get CLIENTBOUND(){ return false; }
		static get SERVERBOUND(){ return true; }

		/**
		 * @param addressees
		 *        Addressees of the message. If the array is empty the message is broadcasted to every connected node.
		 * @param payload
		 *        Bytes to be sent/broadcasted. It may be a serialised packet of a plugin-defined protocol.
		 */
		constructor(addressees=0, payload=[]) {
			super();
			this.addressees = addressees;
			this.payload = payload;
		}

		/** @return {Uint8Array} */
		encode() {
			this._buffer = [];
			this.writeBigEndianByte(7);
			this.writeVaruint(this.addressees.length); for(var dhc5zrzn in this.addressees){ this.writeVaruint(this.addressees[dhc5zrzn]); }
			this.writeVaruint(this.payload.length); this.writeBytes(this.payload);
			return new Uint8Array(this._buffer);
		}

		/** @param {(Uint8Array|Array)} buffer */
		decode(_buffer) {
			this._buffer = Array.from(_buffer);
			var _id=this.readBigEndianByte();
			var aramyrcv=this.readVaruint(); this.addressees=[]; for(var dhc5zrzn=0;dhc5zrzn<aramyrcv;dhc5zrzn++){ this.addressees[dhc5zrzn]=this.readVaruint(); }
			var aramcfb9=this.readVaruint(); this.payload=this.readBytes(aramcfb9);
			return this;
		}

		/** @param {(Uint8Array|Array)} buffer */
		static fromBuffer(buffer) {
			return new Status.MessageServerbound().decode(buffer);
		}

		/** @return {string} */
		toString() {
			return "MessageServerbound(addressees: " + this.addressees + ", payload: " + this.payload + ")";
		}

	},

	/**
	 * Receives a binary message sent by another node using MessageServerbound.
	 */
	MessageClientbound: class extends Buffer {

		static get ID(){ return 8; }

		static get CLIENTBOUND(){ return true; }
		static get SERVERBOUND(){ return false; }

		/**
		 * @param sender
		 *        Id of the node that has sent the message.
		 * @param payload
		 *        Bytes received. It could be a serialised packet of a plugin-defined packet.
		 */
		constructor(sender=0, payload=[]) {
			super();
			this.sender = sender;
			this.payload = payload;
		}

		/** @return {Uint8Array} */
		encode() {
			this._buffer = [];
			this.writeBigEndianByte(8);
			this.writeVaruint(this.sender);
			this.writeVaruint(this.payload.length); this.writeBytes(this.payload);
			return new Uint8Array(this._buffer);
		}

		/** @param {(Uint8Array|Array)} buffer */
		decode(_buffer) {
			this._buffer = Array.from(_buffer);
			var _id=this.readBigEndianByte();
			this.sender=this.readVaruint();
			var aramcfb9=this.readVaruint(); this.payload=this.readBytes(aramcfb9);
			return this;
		}

		/** @param {(Uint8Array|Array)} buffer */
		static fromBuffer(buffer) {
			return new Status.MessageClientbound().decode(buffer);
		}

		/** @return {string} */
		toString() {
			return "MessageClientbound(sender: " + this.sender + ", payload: " + this.payload + ")";
		}

	},

	/**
	 * Updates the number of players on the server.
	 */
	Players: class extends Buffer {

		static get ID(){ return 9; }

		static get CLIENTBOUND(){ return true; }
		static get SERVERBOUND(){ return false; }

		// max
		static get UNLIMITED(){ return -1; }

		/**
		 * @param online
		 *        Players currently online in the whole server (connected to a node).
		 * @param max
		 *        Maximum number of players that can connect to server.
		 */
		constructor(online=0, max=0) {
			super();
			this.online = online;
			this.max = max;
		}

		/** @return {Uint8Array} */
		encode() {
			this._buffer = [];
			this.writeBigEndianByte(9);
			this.writeVaruint(this.online);
			this.writeVarint(this.max);
			return new Uint8Array(this._buffer);
		}

		/** @param {(Uint8Array|Array)} buffer */
		decode(_buffer) {
			this._buffer = Array.from(_buffer);
			var _id=this.readBigEndianByte();
			this.online=this.readVaruint();
			this.max=this.readVarint();
			return this;
		}

		/** @param {(Uint8Array|Array)} buffer */
		static fromBuffer(buffer) {
			return new Status.Players().decode(buffer);
		}

		/** @return {string} */
		toString() {
			return "Players(online: " + this.online + ", max: " + this.max + ")";
		}

	},

	/**
	 * Updates the usage of the system's resources of the node.
	 */
	ResourcesUsage: class extends Buffer {

		static get ID(){ return 10; }

		static get CLIENTBOUND(){ return false; }
		static get SERVERBOUND(){ return true; }

		/**
		 * @param tps
		 *        Ticks per second of the node, in a range from 0 to 20, where a number lower than 20 indicates lag.
		 * @param ram
		 *        Bytes of RAM used by the node.
		 * @param cpu
		 *        Percentage of CPU used by the node. It may be higher than 100 if the node has more than 1 CPU.
		 */
		constructor(tps=.0, ram=0, cpu=.0) {
			super();
			this.tps = tps;
			this.ram = ram;
			this.cpu = cpu;
		}

		/** @return {Uint8Array} */
		encode() {
			this._buffer = [];
			this.writeBigEndianByte(10);
			this.writeBigEndianFloat(this.tps);
			this.writeVarulong(this.ram);
			this.writeBigEndianFloat(this.cpu);
			return new Uint8Array(this._buffer);
		}

		/** @param {(Uint8Array|Array)} buffer */
		decode(_buffer) {
			this._buffer = Array.from(_buffer);
			var _id=this.readBigEndianByte();
			this.tps=this.readBigEndianFloat();
			this.ram=this.readVarulong();
			this.cpu=this.readBigEndianFloat();
			return this;
		}

		/** @param {(Uint8Array|Array)} buffer */
		static fromBuffer(buffer) {
			return new Status.ResourcesUsage().decode(buffer);
		}

		/** @return {string} */
		toString() {
			return "ResourcesUsage(tps: " + this.tps + ", ram: " + this.ram + ", cpu: " + this.cpu + ")";
		}

	},

	/**
	 * Sends a log to the hub.
	 */
	Log: class extends Buffer {

		static get ID(){ return 11; }

		static get CLIENTBOUND(){ return false; }
		static get SERVERBOUND(){ return true; }

		/**
		 * @param timestamp
		 *        Unix time (in milliseconds) that indicates the exact creation time of the log (for ordering purposes).
		 * @param logger
		 *        Name of the logger (world, plugin or module/packet) thas has generated the log.
		 * @param message
		 *        Logged message. It may contain Minecraft formatting codes.
		 * @param commandId
		 *        Identifier of the command that has generated the output or -1 if the log wasn't generated by a command.
		 */
		constructor(timestamp=0, logger="", message="", commandId=0) {
			super();
			this.timestamp = timestamp;
			this.logger = logger;
			this.message = message;
			this.commandId = commandId;
		}

		/** @return {Uint8Array} */
		encode() {
			this._buffer = [];
			this.writeBigEndianByte(11);
			this.writeVarulong(this.timestamp);
			var dhc5bdzi=this.encodeString(this.logger); this.writeVaruint(dhc5bdzi.length); this.writeBytes(dhc5bdzi);
			var dhc5znyd=this.encodeString(this.message); this.writeVaruint(dhc5znyd.length); this.writeBytes(dhc5znyd);
			this.writeVarint(this.commandId);
			return new Uint8Array(this._buffer);
		}

		/** @param {(Uint8Array|Array)} buffer */
		decode(_buffer) {
			this._buffer = Array.from(_buffer);
			var _id=this.readBigEndianByte();
			this.timestamp=this.readVarulong();
			this.logger=this.decodeString(this.readBytes(this.readVaruint()));
			this.message=this.decodeString(this.readBytes(this.readVaruint()));
			this.commandId=this.readVarint();
			return this;
		}

		/** @param {(Uint8Array|Array)} buffer */
		static fromBuffer(buffer) {
			return new Status.Log().decode(buffer);
		}

		/** @return {string} */
		toString() {
			return "Log(timestamp: " + this.timestamp + ", logger: " + this.logger + ", message: " + this.message + ", commandId: " + this.commandId + ")";
		}

	},

	/**
	 * Executes a command on the node.
	 */
	RemoteCommand: class extends Buffer {

		static get ID(){ return 12; }

		static get CLIENTBOUND(){ return true; }
		static get SERVERBOUND(){ return false; }

		// origin
		static get HUB(){ return 0; }
		static get EXTERNAL_CONSOLE(){ return 1; }
		static get RCON(){ return 2; }

		/**
		 * @param origin
		 *        Origin of the command. It could be the hub itself or an external source.
		 * @param sender
		 *        Address of the sender if the command has been sent from an external source and not the hub.
		 * @param command
		 *        Commands and arguments that should be executed on the node. For example `say hello world` or `transfer
		 *        steve lobby12`.
		 * @param commandId
		 *        Identifier of the command. It's sent in {Log.commandId} if the command generates an output.
		 */
		constructor(origin=0, sender=null, command="", commandId=0) {
			super();
			this.origin = origin;
			this.sender = sender;
			this.command = command;
			this.commandId = commandId;
		}

		/** @return {Uint8Array} */
		encode() {
			this._buffer = [];
			this.writeBigEndianByte(12);
			this.writeBigEndianByte(this.origin);
			if(origin!=0){ this.writeBytes(this.sender.encode()); }
			var dhc5b1y5=this.encodeString(this.command); this.writeVaruint(dhc5b1y5.length); this.writeBytes(dhc5b1y5);
			this.writeVarint(this.commandId);
			return new Uint8Array(this._buffer);
		}

		/** @param {(Uint8Array|Array)} buffer */
		decode(_buffer) {
			this._buffer = Array.from(_buffer);
			var _id=this.readBigEndianByte();
			this.origin=this.readBigEndianByte();
			if(origin!=0){ this.sender=Types.Address.fromBuffer(this._buffer); this._buffer=this.sender._buffer; }
			this.command=this.decodeString(this.readBytes(this.readVaruint()));
			this.commandId=this.readVarint();
			return this;
		}

		/** @param {(Uint8Array|Array)} buffer */
		static fromBuffer(buffer) {
			return new Status.RemoteCommand().decode(buffer);
		}

		/** @return {string} */
		toString() {
			return "RemoteCommand(origin: " + this.origin + ", sender: " + this.sender + ", command: " + this.command + ", commandId: " + this.commandId + ")";
		}

	},

	/**
	 * Updates a list.
	 */
	UpdateList: class extends Buffer {

		static get ID(){ return 13; }

		static get CLIENTBOUND(){ return false; }
		static get SERVERBOUND(){ return true; }

		// list
		static get WHITELIST(){ return 0; }
		static get BLACKLIST(){ return 1; }

		// action
		static get ADD(){ return 0; }
		static get REMOVE(){ return 1; }

		// type (variant)
		static get BY_HUB_ID(){ return 0; }
		static get BY_NAME(){ return 1; }
		static get BY_UUID(){ return 2; }

		/**
		 * @param list
		 *        Type of the list to update.
		 * @param action
		 *        Whether to add or removed the player from the list.
		 */
		constructor(list=0, action=0, type=0) {
			super();
			this.list = list;
			this.action = action;
			this.type = type;
		}

		/** @return {Uint8Array} */
		encode() {
			this._buffer = [];
			this.writeBigEndianByte(13);
			this.writeBigEndianByte(this.list);
			this.writeBigEndianByte(this.action);
			this.writeBigEndianByte(this.type);
	switch(this.type) {
		case 0:
			this.writeBigEndianByte(this.list);
			this.writeBigEndianByte(this.action);
			this.writeBigEndianByte(this.type);
			break;
		case 1:
			this.writeBigEndianByte(this.list);
			this.writeBigEndianByte(this.action);
			this.writeBigEndianByte(this.type);
			break;
		case 2:
			this.writeBigEndianByte(this.list);
			this.writeBigEndianByte(this.action);
			this.writeBigEndianByte(this.type);
			break;
		default: break;
	}
			return new Uint8Array(this._buffer);
		}

		/** @param {(Uint8Array|Array)} buffer */
		decode(_buffer) {
			this._buffer = Array.from(_buffer);
			var _id=this.readBigEndianByte();
			this.list=this.readBigEndianByte();
			this.action=this.readBigEndianByte();
			this.type=this.readBigEndianByte();
			switch(this.type) {
				case 0:
					this.hubId=this.readVaruint();
					break;
				case 1:
					this.username=this.decodeString(this.readBytes(this.readVaruint()));
					break;
				case 2:
					this.game=this.readBigEndianByte();
					this.uuid=this.readBytes(16);
					break;
				default: break;
			}
			return this;
		}

		/** @param {(Uint8Array|Array)} buffer */
		static fromBuffer(buffer) {
			return new Status.UpdateList().decode(buffer);
		}

		/** @return {string} */
		toString() {
			return "UpdateList(list: " + this.list + ", action: " + this.action + ", type: " + this.type + ")";
		}

	},

	/**
	 * Notifies the node that the hub's reloadeable settings have been reloaded and that
	 * the node should also reload its resources (for example plugin's settings).
	 */
	Reload: class extends Buffer {

		static get ID(){ return 14; }

		static get CLIENTBOUND(){ return true; }
		static get SERVERBOUND(){ return false; }

		constructor() {
			super();
		}

		/** @return {Uint8Array} */
		encode() {
			this._buffer = [];
			this.writeBigEndianByte(14);
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
			return new Status.Reload().decode(buffer);
		}

		/** @return {string} */
		toString() {
			return "Reload()";
		}

	},

}

//export { Status };
