Ext.define("HACAClient.model.Group", {
    extend: "Ext.data.Model",
    fields: [{
        name: "id",
        type: "auto"
    }, {
        name: 'groupName',
        type: 'auto'
    }],

    proxy: {
        type: 'rest',
        // url : URL.getURL("/devices/"),
        api: {
            read: URL.getURL("/groups/"),
            create: URL.getURL("/groups/"),
            update: URL.getURL("/groups/"),
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

    initModel:function(record){
        this.set('id',record.id);
        this.set('groupName',record.groupName);
    }
});
