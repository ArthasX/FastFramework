Ext.define('HACAClient.view.group.GroupList', {
    extend: 'Ext.grid.Panel',
    xtype: 'groupList',
    id: 'groupList',
    name: 'group',// Ext.widget(name+'Edit') name+'Add'
    requires: ['HACAClient.store.GroupStore'],
    store: Ext.create('HACAClient.store.GroupStore'),
    border: true,
    frame: true,// 渲染
    enableKeyNav: true,// 键盘控制
    columnLines: true,// 竖线
    height: window.screen.height - 200,

    plugins:[{
        ptype: 'rowediting',
        clicksToEdit: 1,
        id: 'groupRowediting',
        listeners: {
            edit: 'onEdit',
            canceledit:'onCancelEdit'
    }
    }],

     tbar: [{
        text: 'Add',
        handler: 'onAddClick'
    }],


    columns: [{
        header: 'id',
        dataIndex: 'id',
        width: '50%',
        
    }, {
        header: '系统名称',
        dataIndex: 'groupName',
        width: '50%',
        editor:{
            allowBlank:false,
        }
    }],

    listeners: {
        // select: 'onItemSelected',
        afterrender: 'afterrender'
    }
});
