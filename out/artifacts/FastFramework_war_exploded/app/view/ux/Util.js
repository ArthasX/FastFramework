var PAGE_SIZE = 1000
var URL = {
    rootURL: 'http://localhost:8081/hacadaptor',
    getURL: function (path) {
        return this.rootURL + path;
    }
}
var groupStoreGlobal;
var groupName2Id = function (value, cellmeta, record, rowIndex, columnIndex, store) {
    var items = groupStoreGlobal.data.items;
    var l = items.length;
    for (var i = 0; i < l; i++) {
        if (value == items[i].data.groupId)
            return items[i].data.groupName;
        else
            continue;
    }
    return -1;
}