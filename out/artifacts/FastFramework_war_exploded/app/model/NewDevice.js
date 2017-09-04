Ext.define("HACAClient.model.NewDevice", {
    extend: "HACAClient.model.Device",

    proxy: {
        type: 'rest',
        // url : URL.getURL("/devices/"),
        api: {
            read: URL.getURL("/devices/new"),
            create: URL.getURL("/devices/"),
            // update: URL.getURL("/devices/"),
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
});
