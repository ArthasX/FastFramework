Ext.define('HACAClient.store.BaseStore', {
    extend: 'Ext.data.Store',
    opt:'update',
    /*
    用于 onEdit中判断是否是insert还是update ，由于使用的是rowediting，record的crudState
    一直是 update 所以 在这里设置变量opt 用于辅助判断
    */
    listeners: {
        'beforeload': function (store, operation, eOpts) {
            this.proxy.url = URL.getURL(this.path);
        }
    }
});

// fields:'',
