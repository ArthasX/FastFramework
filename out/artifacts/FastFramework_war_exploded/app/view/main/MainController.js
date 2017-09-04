/**
 * This class is the controller for the main view for the application. It is specified as
 * the "controller" of the Main view class.
 *
 * TODO - Replace this content of this view to suite the needs of your application.
 */
Ext.define('HACAClient.view.main.MainController', {
    extend: 'Ext.app.ViewController',

    alias: 'controller.main',

    onItemSelected: function (sender, record) {
        // debugger;
        console.log(record);
        Ext.Msg.confirm('Confirm1111', 'Are you sure?', 'onConfirm', this);
    },

    onConfirm: function (choice) {
        if (choice === 'yes') {
            //
        }
    },

    afterrender: function (panel, eOpts) {
        console.log(panel);
        panel.store.load();
        return true;
    },

    updateGroupIdByDevice: function (sender, record) {
        console.log("updateGroupIdByDevice");
    },

    onAddClick:function(sender,e){
        // debugger;
        var btn=sender;
        var view=btn.ownerCt.ownerCt;
        var store=view.store;
        var model = store.model;
        var rec;console.log(store);
        var id=store.data.items[store.data.length-1].data.id+1;
        if(view.id=='usermappingList'){
            rec= model.create({
                id:id,
                userId:'',
                name:'',
                operator:''
            });
        }
        else if(view.id=='groupList'){
            store.data.sort();
            rec= model.create({
                id:id,
                groupName:''
            });
        }
        rec.crudState='C';
        store.insert(0,rec);
        console.log('set store opt to insert')
        store.opt='insert';
        view.findPlugin('rowediting').startEdit(rec,0);
    },

    onEdit:function(editor,e){
        console.log('======rowediting======')
        console.log(editor);
        console.log(e);
        debugger;
        var store=editor.grid.store;
        var model;
        if(store.opt=='insert'){
            model=store.model.create();
            model.initModel(e.record.data)
        }
        else{
            model=store.model.create(e.record);
            model.initModel(e.record.data)
        }
        // model.set('userId',e.record.data.userId);
        // var model=editor.grid.store.model.create({
        //     id:'141',
        //     groupName:'12345'
        // });
        model.save({
            failure: function (record, operation) {
                // do something if the save failed
                console.log('----failure function-start---')
                Ext.toast(Ext.JSON.decode(operation.getResponse().responseText).errorMessage
                    , "Message");
                console.log('----failure function-end---')
            },
            success:function(record,operation){
                // Ext.JSON.decode(operation.getResponse().responseText).message
                console.log('----success function-start---')
                Ext.toast("更新成功           "
                    , "Message");
                console.log('----success function-end---')
            },
            callback: function (record, operation, success) {
                // do something whether the save succeeded or failed
                console.log('----callback function-start---')
                store.reload();
                console.log('set store opt back to update')
                store.opt='update';    
                console.log('----callback function-end---')            
            }
        });

    },

    onCancelEdit:function(editor,context,eOpts){
        console.log('set store opt back to update')
        var store=editor.grid.store;
        store.opt='update';
    },

    onRefreshClick: function (view, recIndex, cellIndex, item, e, record) {
        console.log("===onRefreshClick===refresh");
        var view = this.getView();
        view.store.reload();
    },
});
