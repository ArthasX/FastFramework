Ext.define('HACAClient.view.device.DeviceController', {
    extend: 'HACAClient.view.main.MainController',
    alias: 'controller.deviceController',

    // afterrender:function(panel,eOpts){
    //        console.log(panel);
    //        panel.store.load();
    //        return true;
    //    },


    onUpdateClick: function (view, recIndex, cellIndex, item, e, record) {
        console.log("===onUpdateClick===")
        console.log(view);
        console.log(recIndex);
        console.log(cellIndex);
        console.log(item);
        console.log(e);
        console.log(record);
        console.log("===onUpdateClick===")
        var device = Ext.create('HACAClient.model.NewDevice');
        var groupName = record.get('groupId');
        record.data.groupId=groupName2Id(groupName);
        device.initModel(record.data)
        var groupId = device.get('groupId')
        if (groupId < 0 || groupId == null) {
            Ext.toast("系统分组groupId有误", "ERROR");
            return
        }
        device.save({
            failure: function (record, operation) {
                // do something if the save failed
                console.log(record)
                console.log('failure')
            },
            success: function (record, operation) {
                // do something if the save succeeded
                view.store.load();
                Ext.toast('设备名:' + record.data.deviceName + '-设置组：' + groupName, 'Data saved');
                console.log('success')
            },
            callback: function (record, operation, success) {
                // do something whether the save succeeded or failed
                console.log('callback')
            }
        });
    }
})