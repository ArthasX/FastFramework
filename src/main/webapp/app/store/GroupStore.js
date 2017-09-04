Ext.define('HACAClient.store.GroupStore', {
    alias: 'store.groupStore',
    id: 'groupStore',
    path: '/groups/',
    extend: 'HACAClient.store.BaseStore',
    model: 'HACAClient.model.Group',
    proxy: {
        type: 'ajax',
        reader: {
            type: 'json',
            rootProperty: 'data'
        }
    },
    // autoLoad : true
});

// fields:'',
