Ext.define("HACAClient.model.Usermapping", {
    extend: "Ext.data.Model",
    fields: [{
        name: "id",
        type: "auto"
    },  {
        name: "userId",
        type: "auto"
    },{
        name: 'name',
        type: 'auto'
    }, {
        name: 'operator',
        type: 'auto'
    }],

    proxy: {
        type: 'rest',
        // url : URL.getURL("/devices/"),
        api: {
            read: URL.getURL("/usermappings/"),
            create: URL.getURL("/usermappings/"),
            update: URL.getURL("/usermappings/"),
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
        this.set('name',record.name);
        this.set('operator',record.operator);
        this.set('userId',record.userId);
    }
});
