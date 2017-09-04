Ext.define('HACAClient.view.device.DeviceList', {
    extend: 'Ext.grid.Panel',
    xtype: 'deviceList',
    id: 'deviceList',
    name: 'device',// Ext.widget(name+'Edit') name+'Add'
    requires: ['HACAClient.store.DeviceStore', 'HACAClient.view.device.DeviceController'],
    store: {
        type: 'deviceStore'
    },
    controller: 'deviceController',
    border: true,
    frame: true,// 渲染
    enableKeyNav: true,// 键盘控制
    columnLines: true,// 竖线
    height: window.screen.height - 200, //网页可见区域高 

 	plugins: [{
        ptype: 'rowediting',
        clicksToMoveEditor: 1,
        autoCancel: false,
         listeners: {
            edit: 'onEdit',
            canceledit:'onCancelEdit'
    }
    }],

    tbar: [{
        text: 'Refresh',
        handler: 'onRefreshClick'
    }],
    columns: [{
        xtype: 'rownumberer',
        width: '3%'
    }, {
        header: 'id',
        dataIndex: 'id',
        width: '20%'
    }, {
        header: '设备id',
        dataIndex: 'deviceId',
        width: '20%'
    }, {
        header: '名称',
        dataIndex: 'deviceName',
        width: '20%'
    }, {
        header: 'ip',
        dataIndex: 'ipAddress',
        width: '20%'
    }, {
        header: '分组',
        dataIndex: 'groupId',
        width: '17%',
        renderer: groupId2Name,
        editor: {
            xtype:'groupComboDisplayId' 
        }
    }],

    listeners: {
        // select: 'onItemSelected',
        afterrender: 'afterrender'
    }
});
