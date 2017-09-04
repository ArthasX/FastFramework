Ext.define('HACAClient.view.usermapping.UsermappingList', {
    extend: 'Ext.grid.Panel',
    xtype: 'usermappingList',
    id: 'usermappingList',
    name: 'usermapping',// Ext.widget(name+'Edit') name+'Add'
    requires: ['HACAClient.store.UsermappingStore'],
    store: {
        type: 'usermappingStore'
    },
    border: true,
    frame: true,// 渲染
    enableKeyNav: true,// 键盘控制
    columnLines: true,// 竖线
    height: window.screen.height - 200, //网页可见区域高 

    plugins:[{
        ptype: 'rowediting',
        clicksToEdit: 1,
        id: 'usermappingRowediting',
        listeners:{
            edit:'onEdit',
            canceledit:'onCancelEdit'
        }
    }],

    tbar:[{
        text: 'Add',
        handler: 'onAddClick'
    }],
    columns: [ {
        header: 'id',
        dataIndex: 'id',
        width : '10%',
    },{
        header: '工号',
        dataIndex: 'userId',
        width : '30%',
        editor:{
            allowBlank:false,
        }
    }, {
        header: '姓名',
        dataIndex: 'name',
        width : '30%',
        editor:{
            allowBlank:false,
        }
    }, {
        header: '操作账号',
        dataIndex: 'operator',
        width :'30%',
        editor:{
            allowBlank:false,
        }
    }],

    listeners: {
        afterrender: 'afterrender'
    }
});
