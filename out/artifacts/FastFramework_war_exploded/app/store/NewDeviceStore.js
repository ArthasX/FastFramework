Ext.define('HACAClient.store.NewDeviceStore', {
    alias: 'store.newDeviceStore',
    id: 'newDeviceStore',
    path: '/devices/new',
    extend: 'HACAClient.store.BaseStore',
    model: 'HACAClient.model.NewDevice',
    // proxy : {
    // 	type : 'ajax',
    // 	// url : 'http://localhost:8081/hacadaptor/devices/',
    // 	reader : {
    // 		type : 'json',
    // 		rootProperty : 'data'
    // 	}
    // },

    // autoLoad : true
});

// fields:'',
