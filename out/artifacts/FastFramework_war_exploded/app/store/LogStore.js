Ext.define('HACAClient.store.LogStore', {
    alias: 'store.logStore',
    id: 'logStore',
    path: '/logs/',
    extend: 'HACAClient.store.BaseStore',
    model: 'HACAClient.model.Device',
    proxy: {
        type: 'ajax',
        // url : 'http://localhost:8081/hacadaptor/devices/',
        reader: {
            type: 'json',
            rootProperty: 'data'
        }
    },
    // autoLoad : true
});

// fields:'',
