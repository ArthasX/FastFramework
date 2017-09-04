Ext.define("HACAClient.model.Device", {
    extend: "Ext.data.Model",
    fields: [{
        name: "id",
        type: "auto"
    }, {
        name: 'deviceId',
        type: 'auto'
    }, {
        name: 'deviceName',
        type: 'auto'
    }, {
        name: 'ipAddress',
        type: 'auto'
    }, {
        name: 'groupId',
        type: 'auto',
    }],

    proxy: {
        type: 'rest',
        // url : URL.getURL("/devices/"),
        api: {
            read: URL.getURL("/devices/"),
            create: URL.getURL("/devices/"),
            update: URL.getURL("/devices/"),
        },
        actionMethods: {
            create: 'POST',
            update: 'PUT',
            read: 'GET',
        },
        reader: {
            type: 'json',
            rootProperty: 'data'
        },
        writer: {
            type: 'json',
        }
    },

    initModel: function (record) {
        debugger;
        this.set('id', record.id);
        this.set('deviceId', record.deviceId);
        this.set('deviceName', record.deviceName);
        this.set('ipAddress', record.ipAddress);
        // var groupId = groupName2Id(record.groupId);
        this.set('groupId', record.groupId);
    }
});
