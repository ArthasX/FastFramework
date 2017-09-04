Ext.define('HACAClient.view.log.LogList', {
    extend: 'Ext.grid.Panel',
    xtype: 'logList',
    id: 'logList',
    name: 'log',// Ext.widget(name+'Edit') name+'Add'
    requires: ['HACAClient.store.LogStore'],
    store: {
        type: 'logStore'
    },
    border: true,
    frame: true,// 渲染
    enableKeyNav: true,// 键盘控制
    columnLines: true,// 竖线
    height: window.screen.height - 200, //网页可见区域高 

    tbar: [{
        text: 'Refresh',
        handler: 'onRefreshClick'
    }],
    columns: [{
        xtype: 'rownumberer'
    }, {
        header: 'HAC工单流水编号',
        dataIndex: 'workNoteId',
        // width : '20%'
    }, {
        header: '工单号',
        dataIndex: 'workNoteNumber',
        // width : '20%'
    }, {
        header: '系统名称',
        dataIndex: 'groupName',
        // width :'20%'
    }, {
        header: 'ip',
        dataIndex: 'ip',
        // width :'20%'
    }, {
        header: '内容',
        dataIndex: 'content',
        // width : '20%'
    }, {
        header: '开始时间',
        dataIndex: 'startTime'
    }, {
        header: '结束时间',
        dataIndex: 'endTime'
    }, {
        header: '状态',
        dataIndex: 'status'
    }, {
        header: '关闭时间',
        dataIndex: 'closeDate'
    }, {
        header: '工单类型',
        dataIndex: 'workNoteType'
    }],

    listeners: {
        afterrender: 'afterrender'
    }
});
