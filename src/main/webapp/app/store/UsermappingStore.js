Ext.define('HACAClient.store.UsermappingStore',{
    alias: 'store.usermappingStore',
    id: 'usermappingStore',
    path: '/usermappings/',
    extend:'Ext.data.Store',
    // extend: 'HACAClient.store.BaseStore',
    model: 'HACAClient.model.Usermapping',
	// proxy: {
 //        type: 'ajax',
 //        // url : 'http://localhost:8081/hacadaptor/devices/',
 //        reader: {
 //            type: 'json',
 //            rootProperty: 'data'
 //        }
 //    },
})