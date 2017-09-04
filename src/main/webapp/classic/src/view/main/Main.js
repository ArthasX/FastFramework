/**
 * This class is the main view for the application. It is specified in app.js as the
 * "mainView" property. That setting automatically applies the "viewport"
 * plugin causing this view to become the body element (i.e., the viewport).
 *
 * TODO - Replace this content of this view to suite the needs of your application.
 */
Ext.define('HACAClient.view.main.Main', {
    extend: 'Ext.tab.Panel',
    xtype: 'app-main',
    
    requires: [
        'Ext.plugin.Viewport',
        'Ext.window.MessageBox',

        'HACAClient.view.main.MainController',
        'HACAClient.view.main.MainModel',
        'HACAClient.view.main.List' ,


        'HACAClient.view.device.DeviceList',
        'HACAClient.view.device.NewDeviceList',
        
        
        'HACAClient.model.Group',
        'HACAClient.view.group.GroupList',


        'HACAClient.model.Log',
        'HACAClient.view.log.LogList'


    ],

    controller: 'main',
    viewModel: 'main',

    ui: 'navigation',

    tabBarHeaderPosition: 1,
    titleRotation: 0,
    tabRotation: 0,

    header: {
        layout: {
            align: 'stretchmax'
        },
        title: {
            bind: {
                text: '{name}'
            },
            flex: 0
        },
        iconCls: 'fa-th-list'
    },

    tabBar: {
        flex: 1,
        layout: {
            align: 'stretch',
            overflowHandler: 'none'
        }
    },

    responsiveConfig: {
        tall: {
            headerPosition: 'top'
        },
        wide: {
            headerPosition: 'left'
        }
    },

    defaults: {
        bodyPadding: 20,
        tabConfig: {
            plugins: 'responsive',
            responsiveConfig: {
                wide: {
                    iconAlign: 'left',
                    textAlign: 'left'
                },
                tall: {
                    iconAlign: 'top',
                    textAlign: 'center',
                    width: 120
                }
            }
        }
    },

    items: [
        {   
        title: 'Logs',
        iconCls: 'fa-cog',
        items:[{
            xtype:'logList'
    }]}, {
        title: 'Devices',
        iconCls: 'fa-home',
        // The following grid shares a store with the classic version's grid as well!
        items: [{
            xtype: 'deviceList'
        }]
    }, {
        title: 'Users',
        iconCls: 'fa-user',
        items:[
        {
            xtype:'usermappingList',
            reference:'usermappingList'
        }]
    }, {
        title: 'NewDevice',
        iconCls: 'fa-cog',
        items: [
        {
             xtype: 'newDeviceList'
        }]
    }, {
        title: 'Groups',
        iconCls: 'fa-cog',
        items:[{
            xtype:'groupList'
        }]
    }]
});
