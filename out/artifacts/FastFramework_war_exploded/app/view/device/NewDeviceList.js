Ext.define('HACAClient.view.device.NewDeviceList', {
    extend: 'Ext.grid.Panel',
    xtype: 'newDeviceList',
    id: 'newDeviceList',
    name: 'newDevice',// Ext.widget(name+'Edit') name+'Add'
    requires: ['HACAClient.store.NewDeviceStore', 'HACAClient.view.device.DeviceController'],
    store: {
        type: 'newDeviceStore'
    },
    controller: 'deviceController',
    //可编辑grid
    plugins: {
        ptype: 'cellediting',
        clicksToEdit: 1
    },
    tbar: [{
        text: 'Refresh',
        handler: 'onRefreshClick'
    }],
    border: true,
    frame: true,// 渲染
    enableKeyNav: true,// 键盘控制
    columnLines: true,// 竖线
    height: window.screen.height - 200, //网页可见区域高 
    columns: [{
        header: 'id',
        dataIndex: 'id',
        width: '20%'
    }, {
        header: '设备id',
        dataIndex: 'deviceId',
        width: '10%'
    }, {
        header: '名称',
        dataIndex: 'deviceName',
        width: '28%'
    }, {
        header: 'ip',
        dataIndex: 'ipAddress',
        width: '18%'
    }, {
        header: '分组',
        dataIndex: 'groupId',
        width: '20%',
        editor: {
            xtype:'groupCombo' 
        }
    }, {
        xtype: 'actioncolumn',
        width: 30,
        sortable: false,
        menuDisabled: true,
        items: [{
            iconCls: 'x-fa fa-refresh',
            tooltip: 'update group',
            handler: 'onUpdateClick'
        }]
    }
    ],

    listeners: {
        // select: 'onItemSelected',

        afterrender: 'afterrender'
    }
});
