Ext.define('HACAClient.store.DeviceStore', {
    alias: 'store.deviceStore',
    id: 'deviceStore',
    path: '/devices/',
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
