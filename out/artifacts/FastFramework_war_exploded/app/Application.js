/**
 * The main application class. An instance of this class is created by app.js when it
 * calls Ext.application(). This is the ideal place to handle application launch and
 * initialization details.
 */
var PAGE_SIZE = 1000
var URL = {
    rootURL: 'http://192.168.88.234:8080/hacadaptor',
    getURL: function (path) {
        return this.rootURL + path;
    }
}
var groupStoreGlobal;
var groupId2Name = function (value, cellmeta, record, rowIndex, columnIndex, store) {
    console.log(store)
    var items = groupStoreGlobal.data.items;
    var l = items.length;
    for (var i = 0; i < l; i++) {
        if (value == items[i].data.id)
            return items[i].data.groupName;
        else
            continue;
    }
    return '数据有误';
}
var groupName2Id = function (value, cellmeta, record, rowIndex, columnIndex, store) {
    // debugger;
    console.log(store)
    var items = groupStoreGlobal.data.items;
    var l = items.length;
    for (var i = 0; i < l; i++) {
        if (value == items[i].data.groupName)
            return items[i].data.id;
        else
            continue;
    }
    return -1;
}
Ext.define('HACAClient.Application', {
    extend: 'Ext.app.Application',

    name: 'HACAClient',

    quickTips: false,
    platformConfig: {
        desktop: {
            quickTips: true
        }
    },

    stores: [
        // TODO: add global / shared stores here
    ],

    launch: function () {
        console.log('loading global group store...')
        groupStoreGlobal = Ext.create('HACAClient.store.GroupStore');
        groupStoreGlobal.load();
        console.log('loading global group store end...')
        // Ext.Ajax.request({
        //     url: "http://localhost:8081/hacadaptor/devices/",
        //     cors:true,
        //     success: function (response) {
        //         var text = response.responseText;
        //         console.log(text);  
        //         var msg = Ext.JSON.decode(text);
        //          console.log(msg);
        //         if (msg.success) {

        //             Ext.Msg.alert('成功', msg.data[0].deviceName);
        //         } else
        //         Ext.Msg.alert('失败', msg.errorMessage);
        //     },
        //     failure: function (response) {
        //         Ext.Msg.alert('状态', response.statusText + "\n timedout:"
        //             + response.timedout + "\n 请联系管理员");

        //     }
        // });
    },

    onAppUpdate: function () {
        Ext.Msg.confirm('Application Update', 'This application has an update, reload?',
            function (choice) {
                if (choice === 'yes') {
                    window.location.reload();
                }
            }
        );
    }
});
